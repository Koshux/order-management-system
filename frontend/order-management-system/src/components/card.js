import React from 'react'

export default class Card extends React.Component {
  constructor (props) {
    super(props)
    console.log('props in card', props)
  }

  render () {
    return <div>hi from card!</div>
  }
}
