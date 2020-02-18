import React, {useState} from "react";

import './styles.css';
import api from "../../services/api";

function EventForm({history}) {

    const [user, setUser] = useState('');

    const [userName, setUserName] = useState('');
    const [eventType, setEventType] = useState('');
    const [date, setDate] = useState('');
    const [title, seTitle] = useState('');
    const [comment, setComment] = useState('');

    async function insertUser() {
        const response = await api.post('/users', {
            userName
        });

        setUser(response.data);

    }

    async function handleSubmit(e) {
        e.preventDefault();

        const response = await api.post(`/users/${user.id}/events`, {
            eventType,
            date,
            title,
            comment
        });

        setUserName('');
        setEventType('');
        setDate('');
        seTitle('');
        setComment('');
        history.push('/');

        alert('Evento cadastrado com sucesso');
    }

    return (
        <div className="event-form">
            <form onSubmit={handleSubmit}>

                <strong>Cadastrar</strong>
                <div className="input-block">
                    <label htmlFor="userName">Usuário do Github</label>
                    <input name="userName"
                           id="userName"
                           required
                           value={userName}
                           onChange={e => setUserName(e.target.value)}
                           onBlur={insertUser}
                    />
                </div>

                <div className="input-block">
                    <label htmlFor="eventType">Tipo do Evento</label>
                    <select name="eventType" id="eventType" required onChange={e => setEventType(e.target.value)}>
                        <option defaultValue value="">Selecione um tipo</option>
                        <option value="MEETING_PARTICIPATION">Participação de encontro</option>
                        <option value="DOJO_PARTICIPATION">Participação em dojo coding</option>
                        <option value="LECTURE_PRESENTATION">Apresentação de palestra</option>
                        <option value="OPEN_SOURCE_PR">"PR em projeto open source</option>
                    </select>
                </div>

                <div className="input-block">
                    <label htmlFor="title">Nome do Evento</label>
                    <input name="title"
                           id="title"
                           required
                           value={title}
                           onChange={e => seTitle(e.target.value)}
                    />
                </div>

                <div className="input-block">
                    <label htmlFor="date">Data</label>
                    <input name="date"
                           id="date"
                           required
                           value={date}
                           onChange={e => setDate(e.target.value)}
                    />
                </div>

                <div className="input-block">
                    <label htmlFor="comment">Comentário</label>
                    <input name="comment"
                           id="comment"
                           value={comment}
                           onChange={e => setComment(e.target.value)}
                    />
                </div>


                <button type="submit">Salvar</button>
            </form>
        </div>
    );
}

export default EventForm;