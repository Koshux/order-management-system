import React from 'react'
import Note from '../old_components/note'
import Send from '../old_components/send'
import DataTable from '../old_components/notes-datatable'
import Grid from '@material-ui/core/Grid'

export default function IndexPage (props) {
  const [data, setData] = React.useState()

  return (
    <>
      <Grid container spacing={3}>
        <Grid item xs={12}></Grid>

        <Grid item xs={10}>
          <Note
            note={data}
            setNote={setData}
          />
        </Grid>

        <Grid item xs={2}>
          <Send
            note={data}
            materialTableRef={props.materialTableRef}
          />
        </Grid>

        <Grid item xs={12}>
          <DataTable
            materialTableRef={props.materialTableRef}
          />
        </Grid>
      </Grid>
    </>
  )
}
