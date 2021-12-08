import {useHistory} from "react-router-dom";
import {format} from "date-fns";

function Horario(props) {
    const history = useHistory();
    function hora(e){
        sessionStorage.setItem("idHorario", props.id)
        sessionStorage.setItem("dataHorario", props.dataHora)
        history.push("/pagamento")
    }
    return(
        <>
            <button onClick={hora}>
                {format(new Date(props.dataHora), 'hh:mm dd/MM')}
            </button>
        </>
    )
}

export default Horario;
