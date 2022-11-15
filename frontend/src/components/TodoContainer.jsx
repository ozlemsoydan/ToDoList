import React from 'react'

function TodoContainer(inputText, setInputText, todos, setTodos) {


    const inputTextHandle = (e) => {
        setInputText(e.target.value)
    }

    const handleTodo = (e) => {
        e.preventDefault();
        setTodos([...todos,
        {
            text: inputText,
            completed: false,
            id: Math.random()
        }
        ]);
        setInputText("");

    }




    return (
        <form className='form'>
            <div className="search">
                <input value={inputText} type="text" className="todo-input" placeholder="Ekle..." onChange={inputTextHandle} />
                <button className="todo-button" type="submit" onClick={handleTodo} >
                    <i className="fas fa-plus-circle"></i>
                </button>
            </div>

            <div className="alert-wrapper">
                <div className="alert-warning">
                    <div>Input alanı boş geçilemez!</div>
                </div>
                <div className="alert-success">
                    <div>Ekleme Başarılı.</div>
                </div>
            </div>
        </form>
    )
}
export default TodoContainer;
