import React, { useEffect, useState } from "react";
import { Button, Form} from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import TestAxios from "../../apis/TestAxios";

const PolaznikAdd = () => {
  //potrebno je zbog create-a
  const emptyPolaznik = {
    ime: "",
    prezime: "",
    godinaRodjenja: "",
    mesto: "",
    autoSkolaId: -1
  }
  const [polaznik, setPolaznik] = useState(emptyPolaznik)
  const [autoSkole, setAutoSkole] = useState([])
  const navigate = useNavigate()

  useEffect(()=>{
    getData();
  }, [])

  const getData = () => {
    getAutoSkole();
  }

  const getAutoSkole = () => {
    TestAxios.get("/autoskole").then((result) => {
      setAutoSkole(result.data)
    }).catch(()=>{
      alert("Nije uspelo dobavljanje.");
    })
  }

  const doAdd = () => {
    TestAxios.post("/polaznici/", polaznik)
    .then(()=>{
      //bitno je da bi "resetovali" polja za kreiranje nakon kreiranja
      let polaznik = {
        ime: "",
        prezime: "",
        godinaRodjenja: "",
        mesto: "",
        autoSkolaId: -1
      };
      setPolaznik(polaznik)
      navigate("/polaznici");
    }).catch(() =>{
      alert("Nije uspelo dodavanje.");
    })
  }

  const addValueInputChange = (event) => {
    let noviPolaznik = {...polaznik}

    const name = event.target.name;
    const value = event.target.value;

    noviPolaznik[name] = value
    setPolaznik(noviPolaznik);
  }

  const canCreatePolaznik = () => {
    return polaznik.ime!="" && polaznik.prezime!="" && polaznik.godinaRodjenja && polaznik.mesto && polaznik.autoSkolaId != -1
  }

  return (
    <div>
      {/*Deo za ADD*/}
      <Form>
        <Form.Group>
          <Form.Label>Ime</Form.Label>
          <Form.Control
            onChange={(event) => addValueInputChange(event)}
            placeholder="Ime"
            name="ime"
            value={polaznik.ime}
            as="input"
          ></Form.Control>
        </Form.Group>
        <Form.Group>
          <Form.Label>Prezime</Form.Label>
          <Form.Control
            onChange={(event) => addValueInputChange(event)}
            placeholder="Prezime"
            name="prezime"
            value={polaznik.prezime}
            as="input"
          ></Form.Control>
        </Form.Group>
        <Form.Group>
          <Form.Label>Godina rodjenja</Form.Label>
          <Form.Control
            onChange={(event) => addValueInputChange(event)}
            placeholder="Godina rodjenja"
            name="godinaRodjenja"
            value={polaznik.godinaRodjenja}
            as="input"
            type="number"
            min = "0"
            step = "1"
          ></Form.Control>
        </Form.Group>
        <Form.Group>
          <Form.Label>Mesto</Form.Label>
          <Form.Control
            onChange={(event) => addValueInputChange(event)}
            placeholder="Mesto"
            name="mesto"
            value={polaznik.mesto}
            as="input"
          ></Form.Control>
        </Form.Group>
        <Form.Group>
          <Form.Label>Auto skola</Form.Label>
          <Form.Control
            onChange={(event) => addValueInputChange(event)}
            name="autoSkolaId"
            value={polaznik.autoSkolaId}
            as="select">
            <option value={-1}>Izaberi auto skolu</option>
            {autoSkole.map((autoSkola) => {
              return (
                <option value={autoSkola.id} key={autoSkola.id}>
                  {autoSkola.naziv}
                </option>
              );
            })}
          </Form.Control>
        </Form.Group>
        <Button disabled = {!canCreatePolaznik()} variant="primary" onClick={() => doAdd()}>
          Kreiraj polaznika
        </Button>
      </Form>
    </div>
  );
}

export default PolaznikAdd
