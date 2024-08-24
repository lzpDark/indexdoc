import httpService from "./httpService"

const BASE_URL = 'http://localhost:8080/resources';

export const loadResources = async () => {
    try {
        return await httpService.get(`${BASE_URL}`);
    } catch (error) {
        console.error('load resources error!', error);
        throw error;
    }
};

export const newResources = async (resourceUrl) => {
    try {
        return await httpService.post(
            `${BASE_URL}`,
            {
                url: resourceUrl,
                language: 'en'
            },
            {
                headers: {
                    'Content-Type': 'application/json'
                }
            });
    } catch (error) {
        console.error('add resource error!', error);
        throw error
    }
};

export const removeUrl = async (id) => {
    try {
        return await httpService.delete(`${BASE_URL}/${id}`);
    } catch (error) {
        console.error('delete resource error!', error);
        throw error;
    }
};