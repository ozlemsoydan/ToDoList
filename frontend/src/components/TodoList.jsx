import { useState } from "react";

export default function TodoList({ todo, removeById, handleChangeTodo, handleCheck }) {



    let [isEditing, setIsEditing] = useState(false);

    let todoContent;

    if (isEditing) {
        todoContent = (
            <>
             
                <input type="text" className="update-input " value={todo.description} disabled={!isEditing}
                    onChange={(e) => {
                        handleChangeTodo({
                            ...todo,
                            description: e.target.value,
                        });
                    }}
                />
                <button className="save-btn"
                    onClick={(todo) => {
                        setIsEditing((isEditing = !isEditing));
                    }}> Kaydet
                </button>
            </>
        );
    } else {
        todoContent = (
            <>
                <span>{todo.description}</span>
                <button className="btn btn-warning"
                    onClick={() => {
                        setIsEditing(true);
                    }} > <i className="fa-solid fa-pen-to-square"></i></button>
            </>
        );
    }

    return (
        <>
            <div className="flex justify-between items-center w-full">
                <input className="" type="checkbox" onChange={handleCheck} />

                <span className="justify-end">{todoContent}</span>
                <button className="btn btn-danger"
                    onClick={() => removeById(todo)}
                ><i className="fa-solid fa-trash"></i></button>
            </div>
        </>

    );
}
