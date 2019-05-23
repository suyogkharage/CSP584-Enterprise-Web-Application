var productChart = {
	
	getvisualizationData : function(jsonData){
	
	 var   totalSales, dataArray = [],
	 
		   data = new google.visualization.DataTable();
		   
		   data.addColumn('string', 'Product Name');
		   data.addColumn('number', 'Total Sales of every Product');
	      
	      $.each(jsonData, function(i,obj){
	    	  
	    	  totalSales ="Quantity : "+ obj.totalSales +"";
	    	  
	    	  dataArray.push([obj.productName,parseInt(obj.totalSales)]);
	      });
	      
	     data.addRows(dataArray);
	     
	     return data;
	},

	getOptionForBarchart : function(){
		
		  var options = {
					
					title: 'Product Sales Report',
		  			animation:{
	       					 duration: 2000,
	       					 easing: 'out'
	     			  },
		  				
			          hAxis: {
			              baselineColor: '#ccc',
						  title: 'Product Name'
			          },
			          vAxis: {
						  title: 'Total Quantity Sold',
			              baselineColor: '#ccc',
			              gridlineColor: '#fff'
			          },
			
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
			  
			  chart = new google.visualization.ColumnChart(document.getElementById('sales-bar-chart'));
			  
			  chart.draw(data, barOptions);
		    $(window).resize(function () {
		    	
		        chart.draw(data, barOptions);
		    });
	 },
	
	 returnTooltip : function(dataPoint){
	   
		 return "<div style='height:30px;width:150px;font:12px,roboto;padding:15px 5px 5px 5px;border-radius:3px;'>"+
				 "<span style='color:#68130E;font:12px,roboto;padding-right:20px;'>"+dataPoint+"</span>"+
				 "</div>";
	 },
	getProductData : function(){
			$.ajax({
				type: "POST",
				
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
