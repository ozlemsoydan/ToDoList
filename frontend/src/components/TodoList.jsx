import { useState } from "react";

export default function TodoList({ todo, removeById, handleChangeTodo, updateTodo, handleCheck }) {



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
                <button className="btn btn-primary"
                    onClick={(todo) => {
                        setIsEditing((isEditing = !isEditing));
                    }}
                    onChange={updateTodo} >
                    <i className="fa-solid fa-floppy-disk"></i>
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

            <div className="d-flex mb-3">
                <div className="input-group d-flex align-items-center">

                    <div class="form-check d-flex align-items-center ">
                        <input class="form-check-input me-3 " type="checkbox" value="" id="Check" onChange={handleCheck} />
                        <label class="form-check-label d-flex align-items-center text-start" for="Check">
                            {todoContent}
                        </label>
                    </div>

                </div>
                <button className="btn btn-outline-danger float-right"
                    onClick={() => removeById(todo)}
                ><i className="fa-solid fa-trash"></i></button>
            </div>


        </>

    );
}
