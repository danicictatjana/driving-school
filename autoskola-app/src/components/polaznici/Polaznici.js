import React, { useEffect, useState } from "react";
import { Table, Button, Form, ButtonGroup} from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import TestAxios from "../../apis/TestAxios";

const Polaznici = () => {
  
  const [polaznici, setPolaznici] = useState([])
  const [autoSkole, setAutoSkole] = useState([])
  const [search, setSearch] = useState({ autoSkolaId: -1, ime: ""})
  const [pageNo, setPageNo] = useState(0)
  const [totalPages, setTotalPages] = useState(1)
  const navigate = useNavigate()

  useEffect(()=>{
    getData();
  }, [])

  const getData = () => {
    getAutoSkole();
    getPolaznici(0);
  }

  const getPolaznici = (page) => {
    let config = { params: {
      pageNo: page
    } };

    //Sledeca 2 if-a su tu zbog search-a
    if (search.ime != "") {
      config.params.ime = search.ime;
    }

    if (search.autoSkolaId != -1) {
      config.params.autoSkolaId = search.autoSkolaId;
    }

    TestAxios.get("/polaznici", config)
    .then((result)=>{
      setPageNo(page)
      setPolaznici(result.data)
      setTotalPages(result.headers["total-pages"])
    }).catch(()=>{
      alert("Nije uspelo dobavljanje.");
    })
  }

  const getAutoSkole = () => {
    TestAxios.get("/autoskole").then((result) => {
      setAutoSkole(result.data)
    }).catch(()=>{
      alert("Nije uspelo dobavljanje.");
    })
  }

  const goToAdd = () => {
    navigate("/polaznici/add");
  }

  const doDelete = (polaznikId) => {
      TestAxios.delete("/polaznici/" + polaznikId)
      .then(()=>{
        var nextPage
        if(pageNo==totalPages-1 && polaznici.length==1){
          nextPage = pageNo-1
        }else{
          nextPage = pageNo
        }
        getPolaznici(nextPage);
      }).catch((error) => {
        alert("Nije uspelo brisanje.");
      })
  }

  const doPrijava = (autoSkolaId, polaznikId) => {
    navigate("/polaznici/prijava/" + autoSkolaId + "/" + polaznikId);
}

const odslusaoTeoriju = (id) => {
  TestAxios.get("/polaznici/" + id + "/teorija")
  .then((result) => {
    getPolaznici(pageNo);
  }).catch(()=>{
    alert("Nije uspelo dobavljanje.");
  })
}

const odradioVoznju = (id) => {
  TestAxios.get("/polaznici/" + id + "/voznja")
  .then((result) => {
    getPolaznici(pageNo);
  }).catch(()=>{
    alert("Nije uspelo dobavljanje.");
  })
}

const polozio = (id) => {
  TestAxios.get("/polaznici/" + id + "/polaganje")
  .then((result) => {
    getPolaznici(pageNo);
  }).catch(()=>{
    alert("Nije uspelo dobavljanje.");
  })
}

  const searchValueInputChange = (event) => {
    let newSearch = {...search}

    const name = event.target.name;
    const value = event.target.value;

    newSearch[name] = value
    setSearch(newSearch);
  }

  const doSearch = () => {
    getPolaznici(0);
  }

  const renderHeader = () => {
    const admin = window.localStorage['role']=="ROLE_ADMIN";
    return  <tr>
    <th>Ime</th>
    <th>Prezime</th>
    <th>Godina rodjenja</th>
    <th>Mesto</th>
    <th>Naziv auto skole</th>
    <th>Polozio</th>
    <th hidden={!admin}></th>
    <th hidden={admin}></th>
    <th></th>
  </tr>;
  }

  const renderBody = () => {
    const admin = window.localStorage['role']=="ROLE_ADMIN";
    return polaznici.map((polaznik) => {
    return <tr key={polaznik.id}>
        <td>{polaznik.ime}</td>
        <td>{polaznik.prezime}</td>
        <td>{polaznik.godinaRodjenja}</td>
        <td>{polaznik.mesto}</td>
        <td>{polaznik.autoSkolaNaziv}</td>
        <td>{polaznik.polozio ? "Da" : "Ne"}</td>
        <td hidden={!admin}> 
          <Button
            variant="danger"
            onClick={() => doDelete(polaznik.id)}
            style={{ marginLeft: 5 }}>
            Obrisi
          </Button>
        </td>
        <td> 
          <Button
           hidden={polaznik.odslusaoTeoriju}
            variant="danger"
            onClick={() => odslusaoTeoriju(polaznik.id)}
            style={{ marginLeft: 5 }}>
            Odslusao teoriju
          </Button>
          <Button
           hidden={polaznik.odradioVoznju || (!polaznik.odslusaoTeoriju && !polaznik.odradioVoznju)}
            variant="danger"
            onClick={() => odradioVoznju(polaznik.id)}
            style={{ marginLeft: 5 }}>
            Odradio voznju
          </Button>
          <Button
           hidden={polaznik.prijavljen || (!polaznik.prijavljen && !polaznik.odradioVoznju) }
            variant="danger"
            onClick={() => doPrijava(polaznik.autoSkolaId, polaznik.id)}
            style={{ marginLeft: 5 }}>
            Prijava za polaganje
          </Button>
          <Button
           hidden={polaznik.polozio || (!polaznik.polozio && !polaznik.prijavljen)}
            variant="danger"
            onClick={() => polozio(polaznik.id)}
            style={{ marginLeft: 5 }}>
            Polozio
          </Button>
        </td>
      </tr>
  })}
 

  return (
    <div>
      <h1>Polaznici</h1>
      {/*Deo za Search*/}
      <Form style={{marginTop:10}}>
      <Form.Group>
          <Form.Label>Auto skola</Form.Label>
          <Form.Control
            onChange={(event) => searchValueInputChange(event)}
            name="autoSkolaId"
            value={search.autoSkolaId}
            as="select">
            <option value={-1}>Odaberite auto skolu</option>
            {autoSkole.map((autoSkola) => {
              return (
                <option value={autoSkola.id} key={autoSkola.id}>
                  {autoSkola.naziv}
                </option>
              );
            })}
          </Form.Control>
        </Form.Group>
        <Form.Group>
          <Form.Label>Ime polaznika</Form.Label>
          <Form.Control
            value={search.ime}
            placeholder="Ime polaznika"
            name="ime"
            as="input"
            onChange={(e) => searchValueInputChange(e)}
          ></Form.Control>
        </Form.Group>
        <Button onClick={() => doSearch()}>Pretraga</Button>
      </Form>
      
      {/*Deo za ADD dugme*/}
      {window.localStorage['role']=="ROLE_ADMIN"?
      <ButtonGroup style={{ marginTop: 25, float:"left"}}>
        <Button variant="info" onClick={() => goToAdd()}>
          Kreiraj polaznika
        </Button>
      </ButtonGroup>
      :null} 
        {/*Deo za prikaz Polaznici*/}
      <ButtonGroup style={{ marginTop: 25, float:"right"}}>
        <Button 
          style={{ margin: 3, width: 90}}
          disabled={pageNo==0} onClick={()=>getPolaznici(pageNo-1)}>
          Prethodna
        </Button>
        <Button
          style={{ margin: 3, width: 90}}
          disabled={pageNo==totalPages-1} onClick={()=>getPolaznici(pageNo+1)}>
          Sledeca
        </Button>
      </ButtonGroup>
      {/* Tabela za prikaz polaznici */}
      <Table bordered striped style={{ marginTop: 5 }}>
        <thead className="thead-dark">
          {renderHeader()}
        </thead>
        <tbody>
          {renderBody()} 
        </tbody>
      </Table>
    </div>
  );
}

export default Polaznici
