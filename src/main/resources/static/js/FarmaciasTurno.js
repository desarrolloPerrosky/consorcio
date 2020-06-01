$(document).ready(function() {
	
	var data = new FormData();
	data.append("reg_id", "7");
	
    $.ajax({
        url: "https://midastest.minsal.cl/farmacias/maps/index.php/utilidades/maps_obtener_comunas_por_regiones",
        data: data,
        method: 'POST',
        type: 'POST',
        processData: false,
        contentType: false   
    }).then(function(data) {
       $('.comunas').append(data);
       $('.locales').hide();
       $('.buscar').hide();
       $('.farmacias').hide();
    });
    
    $('.comunas').on('change', function(){
    	
    	data = new FormData();
    	data.append("comuna", $('.comunas').val());
    	$('.locales').empty();
    	$('.locales').hide();
    	$('.buscar').hide();
    	$('.farmacias').hide();
    	
    	$.ajax({
            url: "http://localhost:8080/localesComunas",
            data: data,
            method: 'POST',
            type: 'POST',
            processData: false,
            contentType: false   
        }).then(function(data) {
           $('.locales').append('<option value="">Elija Local</option>');
           data.forEach(function(element){
        	   $('.locales').append('<option value="'+element+'">'+element+'</option>');
    		   $('.locales').show();
    		   $('.buscar').show();
           });
        });
    });
    
    $('.buscar').click(function(){
    	data = new FormData();
    	data.append("comuna", $('.comunas').val());
    	data.append("local", $('.locales').val());
    	$('.farmacias').empty();
    	
    	$.ajax({
            url: "http://localhost:8080/farmaciasTurno",
            data: data,
            method: 'POST',
            type: 'POST',
            processData: false,
            contentType: false   
        }).then(function(data) {
           $('.farmacias').append('<tr>' +
       			'<th>NOMBRE</th>' +
    			'<th>DIRECCION</th>' +
    			'<th>TELEFONO</th>' +
    			'<th>LATITUD</th>' +
    			'<th>LONGITUD</th>' +
    		'</tr>');
           data.forEach(function(element){
        	   $('.farmacias').append('<tr><td>' + element.nombre +'</td>' +
        			   '<td>' + element.direccion +'</td>' +
        			   '<td>' + element.telefono +'</td>' +
        			   '<td>' + element.latitud +'</td>' +
        			   '<td>' + element.longitud +'</td></tr>');
        	   $('.farmacias').show();
           });
        });
    });
});