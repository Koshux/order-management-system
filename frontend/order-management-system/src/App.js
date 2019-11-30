import React from 'react'
import AppBar from './components/app-bar'

class App extends React.PureComponent {
  ref = React.createRef()

  render () {
    return (
      <div className="app">
        <AppBar materialTableRef={this.ref} />
      </div>
    )
  }
}

export default App
