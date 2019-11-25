import React from 'react'
import AppBar from './components/app-bar'

// import {
//   Link,
//   Route,
//   Switch,
//   BrowserRouter as Router
// } from 'react-router-dom'

class App extends React.PureComponent {
  ref = React.createRef()

  render () {
    return (
      <div className="app">
        <AppBar materialTableRef={this.ref} />

        {/* <Navbar /> */}
        {/* <Route path="/" component={IndexPage}>
          <IndexPage materialTableRef={this.ref} />
        </Route> */}
      </div>
    )
  }
}

export default App
