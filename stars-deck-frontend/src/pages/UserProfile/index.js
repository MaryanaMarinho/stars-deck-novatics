import React, {useEffect, useState} from "react";

import './styles.css';
import api from "../../services/api";

function UserProfile({match}) {
    const [user, setUser] = useState('');
    const [events, setEvents] = useState([]);

    useEffect(() => {
        api.get(`/users/${match.params.id}`).then(response => {
            setUser(response.data);
            setEvents(response.data.events);
        });
    }, []);

    return (
        <div>

            <div className="container-event">

                <ul>

                    <li className="dev-item" key={user.id}>
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
                    </li>
                </ul>
                {events.map((event, index) => (
                    <ul className="events">

                        <li className="event-item" key={index}>
                            <header>
                                <div className="user-info">
                                    <strong>{event.eventType}</strong>
                                    <p>{event.title}</p>
                                    <p>{event.date}</p>

                                </div>
                            </header>

                        </li>
                    </ul>
                ))}

            </div>
        </div>
    );
}

export default UserProfile;