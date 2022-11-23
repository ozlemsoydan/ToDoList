import { useState, useRef, useEffect } from "react";
import TodoService from "../service/TodoService";
import TodoList from "./TodoList";
import toast from 'react-hot-toast';


function TodoInput() {
    const [text, setText] = useState();
    const [todos, setTodo] = useState([]);
    const input = useRef();
    



    //list
    useEffect(() => {
        getAll();
    }, []);

    const getAll = () => {
        TodoService.getAllTodo()
            .then(response => {
                setTodo(response.data);
                console.log(response.data);
            })
            .catch(e => {
                console.log(e);
            });
    };


    //add
    const handleInput = () => {
        if (text.length < 3) {
            toast.error('En az 3 harf olmalı!')
        } else {

            const obj = {
                id: null,
                description: text
            };

            TodoService.createTodo(obj).then(response => {
                toast.success("Kayıt eklendi");
                setText("");
                refreshList();
            })
                .catch(e => {
                    console.log(e);
                });
        }
    };


    //refresh
    const refreshList = () => {
        getAll();

    };

    //deleteAll
    const deleteAllTodo = () => {
        TodoService.deleteAll()
            .then(response => {
                toast.success('Kayıtlar Silindi')
                refreshList();

            })
            .catch(e => {
                toast.error('Hata oluştu!')
            });
    };


    //delete
    const removeById = (todo) => {
        TodoService.deleteTodo(todo.id).then(response => {
            console.log(response.data);
            refreshList();
            toast.success('Kayıt silindi')
        })
            .catch(e => {
                toast.error('Hata oluştu!')
            });


        setTodo(todos.filter((a) => a.id !== todo.id));
    };

 


    return (
        <>
            <div className="card-body">

                <h1 className="card-title">ToDo List</h1>

                <form className="form-group m-5"
                    onSubmit={(e) => e.preventDefault()}>

                    <input className="todo-form w-75" placeholder="Yapılacaklar..." type="text" name="search" value={text} ref={input}
                        onChange={(e) => setText(e.target.value)} />

                    <button className="btn btn-primary"
                        onClick={() => handleInput()}>Ekle</button>
                </form>


                <div className="container">
                    <ul className="list-group ">
                        {todos.map((todo) => (
                            <li className="list-group-item mt-1" key={todo.id}>

                                <TodoList
                                    todo={todo}
                                    removeById={removeById}
                                    refreshList={refreshList}/>
                            </li>
                        ))}

                    </ul>

                </div>


                {todos.length > 0 && (
                    <div className="counter m-3" style={{ color: "silver" }}>
                        {todos.length} adet kayıt var.
                    </div>

                )}

                {todos.length > 0 && (
                    <button
                        className="m-3 btn btn-sm btn-danger"
                        onClick={deleteAllTodo}
                    >Hepsini sil
                    </button>
                )}

            </div>
        </>
    );
}

export default TodoInput;
