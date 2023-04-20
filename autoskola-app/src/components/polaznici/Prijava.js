import React, { useEffect, useState } from "react";
import { Button, Form} from "react-bootstrap";
import { useNavigate, useParams} from "react-router-dom";
import TestAxios from "../../apis/TestAxios";

const PrijavaAdd = () => {
  //potrebno je zbog create-a
  const emptyPrijava = {
    polaganjeId: -1,
    polaznikId: -1
  }
  const [prijava, setPrijava] = useState(emptyPrijava)
  const [polaganja, setPolaganja] = useState([])
  const navigate = useNavigate()
  const routeParams = useParams()

  useEffect(()=>{
    getData();
  }, [])

  const getData = () => {
    getPolaganja();
  }

  const getPolaganja = () => {
    TestAxios.get("/autoskole/" + routeParams.autoSkolaId + "/polaganja")
    .then((result) => {
      setPolaganja(result.data)
    }).catch(()=>{
      alert("Nije uspelo dobavljanje.");
    })
  }

  const prijavi = () => {
    TestAxios.get("/polaganja/" + prijava.polaganjeId + "/" + prijava.polaznikId)
    .then(()=>{
      //bitno je da bi "resetovali" polja za kreiranje nakon kreiranja
      let prijava = {
        polaganjeId: -1,
        polaznikId: -1
      };
      setPrijava(prijava)
      navigate("/polaznici");
    }).catch(() =>{
      alert("Nije uspelo dodavanje.");
    })
  }

  const addValueInputChange = (event) => {
    let noviPolaznik = {...prijava}

    const name = event.target.name;
    const value = event.target.value;

    noviPolaznik[name] = value
    noviPolaznik["polaznikId"] = routeParams.polaznikId
    setPrijava(noviPolaznik);
  }

  const canCreatePrijava = () => {
    return prijava.polaganjeId != -1
  }

  return (
    <div>
      {/*Deo za ADD*/}
      <Form>
        <Form.Group>
          <Form.Label>Termin za polaganje</Form.Label>
          <Form.Control
            onChange={(event) => addValueInputChange(event)}
            name="polaganjeId"
            value={prijava.polaganjeId}
            as="select">
            <option value={-1}>Izaberi termin za polaganje</option>
            {polaganja.map((polaganje) => {
              return (
                <option value={polaganje.id} key={polaganje.id}>
                  {polaganje.datum}
                </option>
              );
            })}
          </Form.Control>
        </Form.Group>
        <Button disabled = {!canCreatePrijava()} variant="primary" onClick={() => prijavi()}>
          Kreiraj prijavu
        </Button>
      </Form>
    </div>
  );
}

export default PrijavaAdd
