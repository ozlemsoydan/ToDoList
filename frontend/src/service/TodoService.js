import axios from "axios";

const todoURL = "http://localhost:8080/todolist/";

class TodoService {


    //add
    createTodo(item) {

        return axios.post(todoURL + "add", item);
    }

    //find
    getItemById(id) {
        return axios.get(todoURL + id);
    }

    //list
    getAllTodo() {
        return axios.get(todoURL + "list")
    }

    //update
    updateTodo(item) {
        return axios.put(todoURL+ "update", item);
    }

    //delete
    deleteTodo(id) {
        return axios.delete(todoURL + id);
    }

    deleteAll() {

        return axios.delete(todoURL+ "-1");
    }


}
export default new TodoService();