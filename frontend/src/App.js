import './App.css';
import TodoInput from "./components/TodoInput";
import { Toaster } from 'react-hot-toast';

function App() {
    return (
        <div className="App">
            <div className="container">
                <TodoInput

                />
                <Toaster
                    position="top-right"
                    reverseOrder={true}
                    toastOptions={{
                        // Define default options
                        duration: 3000,
                        style: {
                            background: '#333',
                            color: '#fff',
                            padding: '16px',
                            width: '275px',
                            height: '75px',
                            borderRadius: '10px',
                            fontSize: '18px'
                        }
                    }}
                />
            </div>
        </div>
    );
}

export default App;
