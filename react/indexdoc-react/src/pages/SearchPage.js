import React, {useEffect, useState} from 'react';
import * as searchService from "../data/searchService"
import {Link} from "react-router-dom";

function SearchPage() {
    const [searchTerm, setSearchTerm] = useState('');
    const [results, setResults] = useState([]);

    useEffect(() => {
        handleSearch();
    }, []);

    const handleSearch = () => {
        searchService.searchResource(searchTerm,
            (data)=>{
                setResults(data);
            },
            (error)=>{});
    };

    return (
        <div style={{padding: 20}}>
            <h3>Search Page</h3>
            <p>输入关键词，搜索包含关键词的文档。到<a href='/manage'>manage</a>添加需要索引的url</p>
            <div>
                <input
                    type="text"
                    value={searchTerm}
                    onChange={(e) => setSearchTerm(e.target.value)}
                />
                <button onClick={handleSearch}>Search</button>
            </div>
            <div style={{display: 'grid', gridTemplateColumns: 'repeat(3, 1fr)', gap: '10px'}}>
                {results.map((item, index) => (
                    <div key={index} style={{border: '1px solid #ccc', padding: '10px'}}>
                        <a href={item.url} target="_blank">
                            <img src={item.image || 'https://via.placeholder.com/150'} alt={item.image}
                                 style={{width: '100%'}}/>
                        </a>
                        <p>{item.url}</p>
                    </div>
                ))}
            </div>
        </div>
    );
}

export default SearchPage;