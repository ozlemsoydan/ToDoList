import './App.css'
import { useState } from 'react';
import TodoContainer from './components/TodoContainer';
import TodoList from './components/TodoList';

function App() {

  const [inputText, setInputText]= useState("");
  const [todos, setTodos]=useState([]);

  return (
    <div className="App">
      <header>
        <h1>ToDo List</h1>
      </header>
      
      <TodoContainer
      inputText={inputText}
      setInputText={setInputText}
      todos={todos}
      setTodos={setTodos}
      />

      <TodoList/>
      
    </div>
  );
}

export default App;
