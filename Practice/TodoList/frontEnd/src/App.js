import React from 'react';
import './App.css';
import List from './Component/TodoList/List';

function App() {
  return (
    <div className="Todo">
      <header className="container">
        <h1 className="header">Todo list</h1>
        <List></List>
      </header>
    </div>
  );
}

export default App;
