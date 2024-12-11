import { useState } from 'react';
import {
  Icon2fa,
  IconBellRinging,
  IconFingerprint,
  IconLogout,
  IconReceipt2,
  IconFirstAidKit,
  IconSettings,
  IconSwitchHorizontal,
} from '@tabler/icons-react';
import { Code, Group } from '@mantine/core';
import classes from './Styles/NavbarNested.module.css';
import { Link } from '@tanstack/react-router';

const data = [
  { link: '', label: 'Dashboards', icon: IconBellRinging },
  { link: '', label: 'Billings', icon: IconReceipt2 },
  { link: '', label: 'Appointments', icon: IconFingerprint },
  { link: '', label: 'Patients', icon: IconFirstAidKit },
  { link: '', label: 'Doctors', icon: IconFirstAidKit },
  { link: '', label: 'Departments', icon: Icon2fa },
  { link: '', label: 'Account', icon: IconSettings },
];

export default function NavbarSimpleColored() {
  const [active, setActive] = useState('Billing');

  const links = data.map((item) => (
    <Link
      className={classes.link}
      data-active={item.label === active || undefined}
      href={item.link}
      key={item.label}
      onClick={(event) => {
        event.preventDefault();
        setActive(item.label);
      }}
    >
      <item.icon className={classes.linkIcon} stroke={1.5} />
      <span>{item.label}</span>
    </Link>
  ));

  return (
    <nav className={classes.navbar}>
      <div className={classes.navbarMain}>
        <Group className={classes.header}>
          <h1 className={classes.appName}>Wellify</h1>
          <Code fw={700} className={classes.version}>
            v1.0.0
          </Code>
        </Group>
        {links}
      </div>

      <div className={classes.footer}>
        <a href="#" className={classes.link} onClick={(event) => event.preventDefault()}>
          <IconSwitchHorizontal className={classes.linkIcon} stroke={1.5} />
          <span>Change account</span>
        </a>

        <a href="#" className={classes.link} onClick={(event) => event.preventDefault()}>
          <IconLogout className={classes.linkIcon} stroke={1.5} />
          <span>Logout</span>
        </a>
      </div>
    </nav>
  );
}