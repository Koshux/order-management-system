import React from 'react'
import AppBar from '../components/app-bar'

export default function IndexPage (props) {
  return (
    <>
      <AppBar materialTableRef={props.materialTableRef} />
    </>
  )
}
