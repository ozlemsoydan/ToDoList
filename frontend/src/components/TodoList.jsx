import { useState } from "react";
import TodoService from "../service/TodoService";
import toast from 'react-hot-toast';

export default function TodoList({ todo, removeById, refreshList }) {

    let [isEditing, setIsEditing] = useState(false);


    const update = () => {

        TodoService.updateTodo(todo).then(response => {
            
            refreshList();
            setIsEditing(false);
            toast.success('Kayıt Güncellendi')
        })
            .catch(e => {
                toast.error('Hata oluştu!')
            });
    };

    const updateIsDone =(newIsDone)=>{

        todo.done = newIsDone;
        update();
    }


    const objSetDescription = (newDescricptionValue) => {
        todo.description = newDescricptionValue;
    }

    const cancel = () => {
        refreshList();
        setIsEditing(false);

    }



    return (


        <>
            <div className="row d-flex  h-100">
                <div className="row">


                    {!isEditing && (

                        <>
                            <div className="col-10" style={{textAlign:'left'}}>

                                <input className="form-check-input me-3 ms-auto" type="checkbox" defaultChecked={todo.done} id="Check" onChange={(e) => updateIsDone(e.target.checked)} />

                                <span>{todo.done ? <span style={{ textDecoration: 'line-through' }}> {todo.description} </span> : <span> {todo.description} </span>}

                                </span>
                            </div>

                            <div className="col-1">
                                <button className={(todo.done ? 'btn btn-outline-secondary' : 'btn btn-outline-warning')} disabled={todo.done} onClick={() => {
                                    setIsEditing(true);
                                }} title={todo.done ? "" : "Düzenle"}>
                                    <i className="fa-solid fa-pen-to-square"></i>
                                </button>
                            </div>

                        </>
                    )}

                    {isEditing && (
                        <>
                            <div className="col-8">
                                <input type="text" className="form-control" defaultValue={todo.description}
                                    onChange={(e) => objSetDescription(e.target.value)} />

                            </div>

                            <div className="col-3">

                                <button className="btn btn-primary" title="Kaydet"
                                    onClick={update}>
                                    <i className="fa-solid fa-floppy-disk"></i>
                                </button>

                                <button className="btn btn-secondary" title="İptal"
                                    onClick={cancel}>
                                    <i className="fa-solid fa-xmark" ></i></button>
                            </div>

                        </>

                    )}

                    <div className="col-1">

                        <button className="btn btn-outline-danger float-right" title="Sil"
                            onClick={() => removeById(todo)}
                        ><i className="fa-solid fa-trash"></i></button>
                    </div>


                </div>
            </div>


        </>

    );
}
