import React, {useEffect, useState, useRef} from 'react';
import { ToastContainer, toast, Slide, Zoom, Flip, Bounce } from 'react-toastify';
import * as manageService from "../data/manageService";
import {Link} from "react-router-dom";

function ManagePage() {
    const [urls, setUrls] = useState([]);
    const [newUrl, setNewUrl] = useState('');
    const [showDialog, setShowDialog] = useState(false);
    const inputRef = useRef();

    const loadData = ()=>{
        manageService.loadResources()
            .then(res=>{
                setUrls(res.data);
            })
            .catch(error => {});
    }

    useEffect(() => {
        loadData();
    }, []);


    const addUrl = () => {
        manageService.newResources(inputRef.current.value)
            .then((res)=>{
                setUrls([...urls, { url: newUrl, id: res.data.id }]);
                setNewUrl('');
                setShowDialog(false);
            })
            .catch(error => {})
    };

    const removeUrl = (id) => {
        //setUrls(urls.filter((_, i) => i !== index));
        console.log("TODO: removeUrl, id=" + id)
        manageService.removeUrl(id)
            .then(res=>{
                console.log(res.data)
                setUrls(urls.filter(item => item.id !== id))
            })
            .catch(error => {})
    };
    const notify = () => {

        toast.success("Success Notification !", {
            position: "top-center"
        });

        toast.error("Error Notification !", {
            position: "top-right"
        });

    };

    return (
        <div style={{padding: 20}}>
            <h3>Manage Page</h3>
            <p>添加网页url，将自动索引。到<a href='/search'>search</a>搜索</p>
            <button onClick={() => setShowDialog(true)}>Add URL</button>
            {showDialog && (
                <div>
                    <input
                        type="text"
                        ref={inputRef}
                        value={newUrl}
                        onChange={(e) => setNewUrl(e.target.value)}
                    />
                    <button onClick={addUrl}>OK</button>
                </div>
            )}
            <ul>
                {urls.map((item, index) => (
                    <li key={index}>
                        {item.url}
                        <button onClick={() => removeUrl(item.id)}>Remove</button>
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default ManagePage;