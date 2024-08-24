import axios from "axios";
import { toast } from 'react-toastify';

// from: https://javascript.plainenglish.io/handling-unexpected-errors-in-react-with-react-toastify-a56003b01e74
axios.interceptors.response.use(null, error => {
    const expectedError =
        error.response &&
        error.response >= 400 &&
        error.response < 500;

    if(!expectedError){
        //console.log('Logging the error', error);
        toast.error("An unexpected error occurred!", {
            position: "top-right",
            autoClose: 2500,
            hideProgressBar: false,
            closeOnClick: true,
            pauseOnHover: true,
            draggable: true,
            progress: undefined,
            theme: "light",
        })
    }

    return Promise.reject(error)
})

export default {
    get: axios.get,
    put: axios.put,
    post: axios.post,
    delete: axios.delete
}