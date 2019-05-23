var productChart = {
	

	getvisualizationData : function(jsonData){
	
	 var   count, dataArray = [],
	 
		   data = new google.visualization.DataTable();
		   
		   data.addColumn('string', 'Product Name');
		   data.addColumn('number', 'Count');
	      

	      $.each(jsonData, function(i,obj){
	    	  
	    	  count ="Count : "+ obj.quantity +"";
	    	  	    	  
	    	  dataArray.push([obj.name,parseInt(obj.quantity)]);
	      });
	      
	     data.addRows(dataArray);
	     
	     return data;
	},

	getOptionForBarchart : function(){
		
		  var options = {
					
					title: 'Available Product Report',
		  			animation:{
	       					 duration: 2000,
	       					 easing: 'out'
	     			  },
		  				
			          hAxis: {
			              baselineColor: '#ccc',
						  title: 'Product Name'
			          },
			          vAxis: {
						  title: 'Count',
			              baselineColor: '#ccc',
			              gridlineColor: '#fff'
			          },
			
			         // isStacked: true,
			          height: 400,
			          backgroundColor: '#fff',
			          colors: ["#68130E", "#c65533"],
			          fontName: 'roboto',
			          fontSize: 12,
			          legend: {
			              position: 'top',
			              alignment: 'end',
			              textStyle: {
			                  color: '#b3b8bc',
			                  fontName: 'roboto',
			                  fontSize: 12
			              }
			          },
			          tooltip: {
			              isHtml: true,
			              showColorCode: true,
			              isStacked: true
			          }
	     		 };
		return   options;		 
		},

	drawBarChart : function (inputdata) {

		 var  barOptions = productChart.getOptionForBarchart(),
		
			  data = productChart.getvisualizationData(inputdata),
			  
			  chart = new google.visualization.ColumnChart(document.getElementById('product-bar-chart'));
			  
			  chart.draw(data, barOptions);

		    $(window).resize(function () {
		    	
		        chart.draw(data, barOptions);
		    });
	 },
	/* Returns a custom HTML tooltip for Visualization chart*/
	 returnTooltip : function(dataPoint1){
	   
		 return "<div style='height:30px;width:150px;font:12px,roboto;padding:15px 5px 5px 5px;border-radius:3px;'>"+
				 "<span style='color:#68130E;font:12px,roboto;padding-right:20px;'>"+dataPoint1+"</span>"+
				 //"<span style='color:#c65533;font:12px,roboto;'>"+dataPoint2+"</span>"+
				 "</div>";
	 },
	/*Makes ajax call to servlet and download data */
	getProductData : function(){
			$.ajax({
				url: "DataVisualization",
				
				dataType: "JSON",
				
				success: function(data){
	
					productChart.drawBarChart(data);
				}
			});
	}
};	

google.load("visualization", "1", {packages:["corechart"]});
	
$(document).ready(function(){
	productChart.getProductData();
});
