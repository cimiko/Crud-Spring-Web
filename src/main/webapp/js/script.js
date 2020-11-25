/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


navigator.geolocation.getCurrentPosition(showMap);

    function showMap(position) {
        lat = position.coords.latitude;
        lon = position.coords.longitude;

        var mapOptions = {
            center: [lat, lon],
            zoom: 14
        }

        var map = new L.map('mapid', mapOptions);

        var layer = new L.TileLayer('http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png');
        map.addLayer(layer);

        var marker = L.marker([lat, lon]).addTo(map);
        marker.setLatLng([lat, lon]);
        marker.bindPopup('<b>Lapangan "Pancasila" Simpang Lima</b><br>Jl. Simpang Lima, Pleburan, Semarang Sel., Kota Semarang, Jawa Tengah 50241.');

    }