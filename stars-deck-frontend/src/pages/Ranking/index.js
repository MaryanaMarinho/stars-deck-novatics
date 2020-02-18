import React, {useEffect, useState} from "react";

import './styles.css';
import api from "../../services/api";
import {Link} from "react-router-dom";

function Ranking() {
    const [users, setUsers] = useState([]);

    useEffect(() => {
        async function loadUsers() {
            const response = await api.get('/users');

            setUsers(response.data);
        }

        loadUsers();
    }, []);

    return (
        <div>
            <div className="register">
                <Link to={`/event`} className="register-button">Cadastrar</Link>
            </div>

            <div className="container">
                {users.length > 0 ? (
                    <ul>
                        {users.map(user => (
                            <li className="dev-item" key={user.id}>
                                <Link to={`/profile/${user.id}`}>
                                    <header>
                                        <img src={user.avatarUrl}
                                             alt={user.name}/>
                                        <div className="user-info">
                                            <strong>{user.name}</strong>
                                            <p>{user.bio}</p>
                                            <a href={`https://github.com/${user.userName}`}>Acessar perfil no Github</a>
                                        </div>
                                        <div className="user-points">
                                            <span>{user.points}</span>
                                        </div>
                                    </header>
                                </Link>
                            </li>

                        ))}

                    </ul>
                ) : (
                    <div className="empty">Fim da lista :( </div>
                )}
            </div>
        </div>
    );
}

export default Ranking;