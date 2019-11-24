import React from 'react'
import IndexPage from './pages/index'
import Navbar from './old_components/navbar'
import {
  Route,
  BrowserRouter as Router
} from 'react-router-dom'

class App extends React.PureComponent {
  ref = React.createRef()

  render () {
    return (
      <Router>
        <div className="app">
          <Navbar />
          <Route path="/" component={IndexPage}>
            <IndexPage materialTableRef={this.ref} />
          </Route>
        </div>
      </Router>
    )
  }
}

export default App
