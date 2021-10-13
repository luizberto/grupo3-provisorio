import React from "react";
import Footer from "../components/Footer";

function Servicos(){
    return(
        <>
          <section class="servicos">

<h1>NOSSOS SERVIÇOS</h1>


<a href=""><div class="serv">
    <img src="../img/fluent_sport-soccer-16-regular.png" width="100px" alt=""/>
    <p>
        It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. 
    </p>
</div></a>

<a href="">  <div class="serv">
    <img src="../img/mdi_whistle-outline.png" width="100px" alt=""/>
    <p>
        It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. 
    </p>
</div> </a>

<a href=""> <div class="serv">
    <img src="../img/Group.png" width="100px" alt=""/>
    <p>
        It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. 
    </p>
</div></a>

</section>

<Footer/>

        </>
    );
}

export default Servicos;