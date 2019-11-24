// react/utils
import clsx from 'clsx'
import React from 'react'
import PropTypes from 'prop-types'
import {
  Link as RouterLink,
  BrowserRouter as Router
} from 'react-router-dom'

// mine
import Note from '../old_components/note'
import Send from '../old_components/send'
import DataTable from '../old_components/notes-datatable'

// mui-icons
import MenuIcon from '@material-ui/icons/Menu'
import HomeIcon from '@material-ui/icons/Home'
import PeopleIcon from '@material-ui/icons/People'
import ListAltIcon from '@material-ui/icons/ListAlt'
import ChevronLeftIcon from '@material-ui/icons/ChevronLeft'
import PermContactCalendarIcon from '@material-ui/icons/PermContactCalendar'

// mui-core
import List from '@material-ui/core/List'
import Grid from '@material-ui/core/Grid'
import Paper from '@material-ui/core/Paper'
import Drawer from '@material-ui/core/Drawer'
import AppBar from '@material-ui/core/AppBar'
import Toolbar from '@material-ui/core/Toolbar'
import Divider from '@material-ui/core/Divider'
import ListItem from '@material-ui/core/ListItem'
import Typography from '@material-ui/core/Typography'
import IconButton from '@material-ui/core/IconButton'
import CssBaseline from '@material-ui/core/CssBaseline'
import ListItemIcon from '@material-ui/core/ListItemIcon'
import ListItemText from '@material-ui/core/ListItemText'
import { makeStyles } from '@material-ui/core/styles'

const drawerWidth = 240
const useStyles = makeStyles(theme => ({
  root: {
    display: 'flex',
  },
  appBar: {
    transition: theme.transitions.create(['margin', 'width'], {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.leavingScreen,
    }),
  },
  appBarShift: {
    width: `calc(100% - ${drawerWidth}px)`,
    marginLeft: drawerWidth,
    transition: theme.transitions.create(['margin', 'width'], {
      easing: theme.transitions.easing.easeOut,
      duration: theme.transitions.duration.enteringScreen,
    }),
  },
  menuButton: {
    marginRight: theme.spacing(2),
  },
  hide: {
    display: 'none',
  },
  drawer: {
    width: drawerWidth,
    flexShrink: 0,
  },
  drawerPaper: {
    width: drawerWidth,
  },
  drawerHeader: {
    display: 'flex',
    alignItems: 'center',
    padding: theme.spacing(0, 1),
    ...theme.mixins.toolbar,
    justifyContent: 'flex-end',
  },
  content: {
    flexGrow: 1,
    padding: theme.spacing(3),
    transition: theme.transitions.create('margin', {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.leavingScreen,
    }),
    marginLeft: -drawerWidth,
  },
  contentShift: {
    transition: theme.transitions.create('margin', {
      easing: theme.transitions.easing.easeOut,
      duration: theme.transitions.duration.enteringScreen,
    }),
    marginLeft: 0,
  },
}))

function ListItemLink (props) {
  const { icon, primary, to } = props

  const renderLink = React.useMemo(
    () => React.forwardRef((itemProps, ref) => (
      <RouterLink to={to} {...itemProps} innerRef={ref} />
    )),
    [to]
  )

  return (
    <li>
      <ListItem button component={renderLink}>
        <ListItemIcon>{icon}</ListItemIcon>
        <ListItemText primary={primary} />
      </ListItem>
    </li>
  )
}

ListItemLink.propTypes = {
  icon: PropTypes.element,
  to: PropTypes.string.isRequired,
  primary: PropTypes.string.isRequired
}

export default function LeftDrawerRouter(props) {
  const classes = useStyles()
  const [data, setData] = React.useState()
  const [open, setOpen] = React.useState(false)

  const handleDrawerOpen = () => {
    setOpen(true)
  }

  const handleDrawerClose = () => {
    setOpen(false)
  }


  return (
    <div className={classes.root}>
      <CssBaseline />
      <AppBar
        position="fixed"
        className={clsx(classes.appBar, {
          [classes.appBarShift]: open,
        })}
      >
        <Toolbar>
          <IconButton
            color="inherit"
            aria-label="open drawer"
            onClick={handleDrawerOpen}
            edge="start"
            className={clsx(classes.menuButton, open && classes.hide)}
          >
            <MenuIcon />
          </IconButton>
          <Typography variant="h6" noWrap>
            DogBox Management System
          </Typography>
        </Toolbar>
      </AppBar>
      <Drawer
        className={classes.drawer}
        variant="persistent"
        anchor="left"
        open={open}
        classes={{
          paper: classes.drawerPaper,
        }}
      >
        <Router initialEntries={['/']} initialIndex={0}>
          <div className={classes.drawerHeader}>
            <List aria-label="All pages for DogBox management system">
              <ListItemLink to="/" primary="Home" icon={<HomeIcon />} />
            </List>

            <IconButton onClick={handleDrawerClose}>
              <ChevronLeftIcon />
            </IconButton>
          </div>

          <Divider />

          <div className={classes.root}>

            <Paper elevation={0}>
              <List aria-label="All pages for DogBox management system">
                <ListItemLink to="/orders" primary="Orders" icon={<ListAltIcon />} />
                <ListItemLink to="/suppliers" primary="Suppliers" icon={<PermContactCalendarIcon />} />
                <ListItemLink to="/customers" primary="Customers" icon={<PeopleIcon />} />
              </List>
            </Paper>
          </div>
        </Router>
      </Drawer>
      <main
        className={clsx(classes.content, {
          [classes.contentShift]: open,
        })}
      >
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
      </main>
    </div>
  )
}
