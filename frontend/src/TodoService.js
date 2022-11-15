import axios from "axios";

const todoURL = "/todolist/add";

class TodoService {


    //add
    createTodo(item) {
        return axios.post(todoURL, item);
    }

    //find
    getItemById(id) {
        return axios.get(todoURL + "/" + id);
    }

    //list
    getAllTodo() {
        return axios.get(todoURL);
    }

    //update
    updateTodo(item) {
        return axios.put(todoURL + "/" + id, item);
    }

    //delete
    deleteTodo(id) {
        return axios.delete(todoURL + "/" + id);
    }

}
export default new TodoService();