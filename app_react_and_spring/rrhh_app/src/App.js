import { BrowserRouter, Route, Routes } from "react-router-dom";
import ListEmployees from "./employee/ListEmployees";
import Navigator from "./templates/Navigator";
import AddEmployee from "./employee/AddEmployee";
import EditEmployee from "./employee/EditEmployee";


function App() {
  return (
    <div className="container">
      <BrowserRouter>
        <Navigator/>
        <Routes>
          <Route exact path="/" element={<ListEmployees/>} />
          <Route exact path="/add" element={<AddEmployee/>} />
          <Route exact path="/edit/:id" element={<EditEmployee/>} />
        </Routes>
      </BrowserRouter>
    </div>

  );
}

export default App;
