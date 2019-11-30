import React from 'react'

export default class Product extends React.Component {
  constructor (props) {
    super(props)
    console.log('props in product', props)
  }

  render () {
    return <div>hi from product!</div>
  }
}
