var datos = null;
var chart = null;
(function ($) {
    $.post('/informe/stock/getMovimientoStock', {id: $('#idInsumo').val()}, function (response) {
        datos = response;
        graficar(datos[0]);
        AmCharts.checkEmptyData(chart);
        chart.validateData();
    });
    $('#movimiento').on('change', function () {
        switch ($(this).val()) {
            case '-1':
                graficar(datos[0]);
                break;
            case 'Venta':
                graficar(datos[1]);
                break;
            case 'Reposicion':
                graficar(datos[2]);
                break;
            case 'Ajuste':
                graficar(datos[3]);
                break;
            case 'Confeccion':
                graficar(datos[4]);
                break;
        }
        AmCharts.checkEmptyData(chart);
        chart.validateData();
    });
})(jQuery);

function graficar(data) {

    chart = AmCharts.makeChart("grafico", {
        "language": "es",
        "type": "serial",
        "theme": "light",
        "marginRight": 40,
        "marginLeft": 40,
        "autoMarginOffset": 20,
        "mouseWheelZoomEnabled": true,
        "dataDateFormat": "DD-MM-YYYY",
        "valueAxes": [{
                "id": "v1",
                "axisAlpha": 0,
                "position": "left",
                "ignoreAxisWidth": true
            }],
        "balloon": {
            "borderThickness": 1,
            "shadowAlpha": 0
        },
        "graphs": [{
                "id": "g1",
                "balloon": {
                    "drop": true,
                    "adjustBorderColor": false,
                    "color": "#ffffff"
                },
                "bullet": "round",
                "bulletBorderAlpha": 1,
                "bulletColor": "#FFFFFF",
                "bulletSize": 5,
                "hideBulletsCount": 50,
                "lineThickness": 2,
                "title": "red line",
                "useLineColorForBulletBorder": true,
                "valueField": "value",
                "balloonText": "<span style='font-size:18px;'>[[value]]</span>"
            }],
        "chartScrollbar": {
            "graph": "g1",
            "oppositeAxis": false,
            "offset": 30,
            "scrollbarHeight": 80,
            "backgroundAlpha": 0,
            "selectedBackgroundAlpha": 0.1,
            "selectedBackgroundColor": "#888888",
            "graphFillAlpha": 0,
            "graphLineAlpha": 0.5,
            "selectedGraphFillAlpha": 0,
            "selectedGraphLineAlpha": 1,
            "autoGridCount": true,
            "color": "#AAAAAA"
        },
        "chartCursor": {
            "pan": true,
            "valueLineEnabled": true,
            "valueLineBalloonEnabled": true,
            "cursorAlpha": 1,
            "cursorColor": "#258cbb",
            "limitToGraph": "g1",
            "valueLineAlpha": 0.2,
            "valueZoomable": true
        },
        "valueScrollbar": {
            "oppositeAxis": false,
            "offset": 50,
            "scrollbarHeight": 10
        },
        "categoryField": "date",
        "categoryAxis": {
            "parseDates": true,
            "dashLength": 1,
            "minorGridEnabled": true
        },
        "export": {
            "enabled": true
        },
        "categoryAxesSettings": {
            minPeriod: "hh", //(at least that is not grouped)
            groupToPeriods: ["DD", "MM", "YYYY"]//(Data will be grouped by day,week and month)
        },
        "dataProvider": data
    });

    chart.addListener("rendered", zoomChart);

    zoomChart();


    function zoomChart() {
        chart.zoomToIndexes(chart.dataProvider.length - 40, chart.dataProvider.length - 1);
    }
}
