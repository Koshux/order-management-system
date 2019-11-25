// react/utils
import clsx from 'clsx'
import React from 'react'

// mine
import ListItemLink from './list-item-link'
import IndexPage from '../pages/index'
import Orders from '../pages/orders'
import Suppliers from '../pages/suppliers'
import Customers from '../pages/customers'

// mui-icons
import MenuIcon from '@material-ui/icons/Menu'
import HomeIcon from '@material-ui/icons/Home'
import PeopleIcon from '@material-ui/icons/People'
import ListAltIcon from '@material-ui/icons/ListAlt'
import ChevronLeftIcon from '@material-ui/icons/ChevronLeft'
import PermContactCalendarIcon from '@material-ui/icons/PermContactCalendar'

// mui-core
import List from '@material-ui/core/List'
import Paper from '@material-ui/core/Paper'
import Drawer from '@material-ui/core/Drawer'
import AppBar from '@material-ui/core/AppBar'
import Toolbar from '@material-ui/core/Toolbar'
import Divider from '@material-ui/core/Divider'
import Typography from '@material-ui/core/Typography'
import IconButton from '@material-ui/core/IconButton'
import CssBaseline from '@material-ui/core/CssBaseline'
import { makeStyles } from '@material-ui/core/styles'

import {
  Route,
  Switch,
  BrowserRouter as Router
} from 'react-router-dom'

const drawerWidth = 240
const useStyles = makeStyles(theme => ({
  root: {
    display: 'flex',
  },
  appBar: {
    zIndex: theme.zIndex.drawer + 1,
    transition: theme.transitions.create(['margin', 'width'], {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.leavingScreen,
    })
  },
  appBarShift: {
    marginLeft: drawerWidth,
    width: `calc(100% - ${drawerWidth}px)`,
    transition: theme.transitions.create(['margin', 'width'], {
      easing: theme.transitions.easing.easeOut,
      duration: theme.transitions.duration.enteringScreen,
    }),
  },
  menuButton: {
    marginRight: 36,
  },
  hide: {
    display: 'none',
  },
  drawer: {
    width: drawerWidth,
    flexShrink: 0,
    whiteSpace: 'nowrap'
  },
  drawerOpen: {
    width: drawerWidth,
    transition: theme.transitions.create('width', {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.enteringScreen
    })
  },
  drawerClose: {
    overflowX: 'hidden',
    width: theme.spacing(7) + 1,
    [theme.breakpoints.up('sm')]: {
      width: theme.spacing(9) + 1
    },
    transition: theme.transitions.create('width', {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.leavingScreen
    })
  },
  toolbar: {
    display: 'flex',
    alignItems: 'center',
    justifyContet: 'flex-end',
    padding: theme.spacing(0, 1),
    ...theme.mixins.toolbar
  },
  content: {
    flexGrow: 1,
    padding: theme.spacing(3),
  }
}))

export default function LeftDrawerRouter(props) {
  const classes = useStyles()
  const [open, setOpen] = React.useState(false)

  const handleDrawerOpen = () => {
    setOpen(true)
  }

  const handleDrawerClose = () => {
    setOpen(false)
  }

  return (
    <Router>
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
              className={clsx(classes.menuButton, {
                [classes.hide]: open
              })}
            >
              <MenuIcon />
            </IconButton>
            <Typography variant="h6" noWrap>
              DogBox Management System
            </Typography>
          </Toolbar>
        </AppBar>

        <Drawer
          variant="permanent"
          className={clsx(classes.drawer, {
            [classes.drawerOpen]: open,
            [classes.drawerClose]: !open
          })}
          classes={{
            paper: clsx({
              [classes.drawerOpen]: open,
              [classes.drawerClose]: !open
            })
          }}
          open={open}
        >
          <div className={classes.toolbar}>
            <IconButton onClick={handleDrawerClose}>
              <ChevronLeftIcon />
            </IconButton>
          </div>

          <Divider />

          <div className={classes.root}>
            <Paper elevation={0}>
              <List aria-label="All pages for DogBox management system">
                <ListItemLink to="/" primary="Home" icon={<HomeIcon />} />
                <ListItemLink to="/orders" primary="Orders" icon={<ListAltIcon />} />
                <ListItemLink to="/suppliers" primary="Suppliers" icon={<PermContactCalendarIcon />} />
                <ListItemLink to="/customers" primary="Customers" icon={<PeopleIcon />} />
              </List>
            </Paper>
          </div>
        </Drawer>

        <main className={classes.content}>
          <div className={classes.toolbar} />
          <Switch>
            <Route path="/orders">
              <Orders />
            </Route>
            <Route path="/suppliers">
              <Suppliers />
            </Route>
            <Route path="/customers">
              <Customers />
            </Route>
            <Route path="/">
              <IndexPage materialTableRef={props.ref} />
            </Route>
          </Switch>
        </main>
      </div>
    </Router>
  )
}
