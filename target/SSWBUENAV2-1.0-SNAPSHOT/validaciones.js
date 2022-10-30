/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("formularioAnadir").addEventListener('submit', validarFormulario); 
  });
  
  function validarFormulario(evento) {
    evento.preventDefault();
    var nombre = document.getElementById('nombreEjer').value;
    const parrafo = document.getElementById("warnings");
    parrafo.innerHTML = ""
    
    if (nombre.length < 1) {
      parrafo.innerHTML='introduce un nombre por favor'
      return;
    }
    this.submit();
  }
  
  document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("formularioDuracion").addEventListener('submit', validarFormulario1); 
  });
  
  function validarFormulario1(evento) {
    evento.preventDefault();
    var numero = document.getElementById('numero').value;
    const parrafo = document.getElementById("warnings1");
    parrafo.innerHTML = ""
    
    if (numero >1000) {
      parrafo.innerHTML='duracion demasiada larga'
      return;
    }
    if (numero <5) {
      parrafo.innerHTML='duracion demasiada corta'
      return;
    }
    this.submit();
  }
  
  
function validarFormulario4() {
   
      var x=document.datos2.nombre.value;
       var y=document.datos2.descripcion.value;
      const parrafo = document.getElementById("warnings3");
    parrafo.innerHTML = ""
      if(x.length<1){
          parrafo.innerHTML='introduce un nombre'
          return false;
      }
      
       if(y.length<1){
          parrafo.innerHTML='introduce una descripcion'
          return false;
      }
      
      
      }
  
  
      function validarFormulario5() {
   
      var x=document.datos1.descripcion.value;
      const parrafo = document.getElementById("warnings4");
    parrafo.innerHTML = ""
      if(x.length<1){
          
    
          parrafo.innerHTML='introduce un comentario'
         
          return false;
      }else{
          alert("valoracion guardada con exito")
      }
      
      
      }
      
        function validarFormulario6() {
   
      var inicio=document.datos3.inicio.value;
      var fin=document.datos3.fin.value;
      const parrafo = document.getElementById("warningsHist");
    parrafo.innerHTML = ""
      if(inicio>fin){
          
          parrafo.innerHTML='la fecha de inicio no puede ser mayor que la final'
          return false;
      }
      
      
      }


function mostrarExito(){
    var x = document.getElementById("mostrarValoracionExito");
    
        x.style.display = "block";
     
}

