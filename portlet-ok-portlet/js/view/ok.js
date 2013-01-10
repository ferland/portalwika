Ext.require('Ext.chart.*');
//Ext.require(['Ext.Window', 'Ext.layout.container.Fit', 'Ext.fx.target.Sprite', 'Ext.window.MessageBox']);

Ext.onReady(function () {
var store = Ext.create('Ext.data.JsonStore', {
    fields: ['name', 'data'],
    data: [
        { 'name': 'WP1',   'data': 10 },
        { 'name': 'WP2',   'data':  7 },
        { 'name': 'WP3', 'data':  5 },
        { 'name': 'WP4',  'data':  2 },
        { 'name': 'WP5',  'data': 27 }
    ]
});
var chart=Ext.create('Ext.chart.Chart', {
		renderTo: Ext.getBody(),
		width: 335,
	    height: 240,
		animate: true,
		store: store,
		theme: 'Base:gradients',
		legend: {
                position: 'right'
            },
		series: [{
			type: 'pie',
			angleField: 'data',
			showInLegend: true,
			tips: {
				trackMouse: true,
				width: 140,
				height: 28,
				renderer: function(storeItem, item) {
					// calculate and display percentage on hover
					var total = 0;
					store.each(function(rec) {
						total += rec.get('data');
					});
					this.setTitle(storeItem.get('name') + ': ' + Math.round(storeItem.get('data') / total * 100) + '%');
				}
			},
			highlight: {
				segment: {
					margin: 20
				}
			},
			label: {
				field: 'name',
				display: 'rotate',
				contrast: true,
				font: '10px Arial'
			}
		}]
	});
	var graph=Ext.create('Ext.chart.Chart', {
    width: 335,
    height: 240,
    animate: true,
    store: store,
    axes: [
        {
            type: 'Numeric',
            position: 'left',
            fields: ['data'],
            label: {
                renderer: Ext.util.Format.numberRenderer('0,0')
            },
            minimum: 0
        },
        {
            type: 'Category',
            position: 'bottom',
            fields: ['name'],
            title: 'WP1'
        }
    ],
    series: [
        {
            type: 'column',
            axis: 'left',
            highlight: true,
            tips: {
              trackMouse: true,
              width: 140,
              height: 28,
              renderer: function(storeItem, item) {
                this.setTitle(storeItem.get('name') + ': ' + storeItem.get('data') + ' $');
              }
            },
            label: {
              display: 'insideEnd',
              'text-anchor': 'middle',
                field: 'data',
                renderer: Ext.util.Format.numberRenderer('0'),
                orientation: 'vertical',
                color: '#333',
    			font: '8px Arial'
            },
            xField: 'name',
            yField: 'data'
        }
    ]});
	
	var mainPanel=Ext.create('Ext.panel.Panel',{
				renderTo: 'myport',
                region:'center',
                margins:'5 5 5 5',
				width:675,
                layout:'column',
				border:false,
                autoScroll:true,
                defaults: {
                    layout: 'anchor',
                    defaults: {
                        anchor: '100%'
                    }
                },
                items: [{
                    columnWidth: 1/1,
                    baseCls:'x-plain',
                    bodyStyle:'padding:5px 0 5px 5px',
					border:false,
                    items:[{                        
                        html: '<font size=100>Rp.10,000,000,000</font>'
                    }]
                },{
                    columnWidth: 1/2,
                    border:false,
					baseCls:'x-plain',
                    bodyStyle:'padding:0 0 5px 5px',
                    items:[{
						xtype:'panel',
						items:chart						
                    }]
                },{
                    columnWidth: 1/2,
                    baseCls:'x-plain',
					border:false,
                    items:[{
						xtype:'panel',							
						items: graph
                    }]
                }]
				});

});