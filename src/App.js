import Headerr from "./components/Headerr.js";
import Footerr from "./components/Footerr.js";

// import Trial from "./components/Trial.js";
import HomePage from "./components/HomePage";

function App() {
  return (
    <div className="App">
      <Headerr />
      <HomePage />
      {/* <Trial /> */}
      <Footerr />
    </div>
  );
}

export default App;
