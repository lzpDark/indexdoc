import httpService from "./httpService";

export const searchResource = (keyword, callback, errorCallback)=>{
    httpService.get("http://localhost:8080/searches?q=" + keyword)
        .then(response=>{
            console.log(response.data)
            callback(response.data);
        })
        .catch(error => {
            console.error(error)
            errorCallback(error);
        })
}