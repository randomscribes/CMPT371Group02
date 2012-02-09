var softedges = new Array();
this.softedge = function(){
	
    // CONFIG
			
    // css class of images that you want to apply this script to
    // if you want to apply this script to all content images, leave this string blank
    var imageClass = "";
	
    // integer defining the soft edge depth 
    // the larger the number the softer the edges :)
    var step = 80;
	
    // define directions wher you want gradient to appear 
    // set top, right, bottom and left to true or false to turn it on or off
    // setting all 4 directions to true will give you soft edge effect
    // while setting one of the 
    var dirTop = true;	
    var dirRight = true;	
    var dirBottom = true;	
    var dirLeft = true;	
	
    // integer defining each step's width in pixels
    var stepWidth = 1;	
	
    // END CONFIG

    // functions
	
    var w,h,t,l;
	
    this.set = function(obj,i){
        var o = i;
        i *= stepWidth;		
        dt = (dirTop) ? i : 0;		
        dr = (dirRight) ? w-i : w;
        db = (dirBottom) ? h-i : h; 
        dl = (dirLeft) ? i : 0;		
        with(obj.style){
            position = "absolute";
            top = t+"px";
            left = l+"px";
            clip = "rect("+dt+"px,"+dr+"px,"+db+"px,"+dl+"px)";
            };	
        setOpacity(obj,((o*100)/step));
    };
    this.setOpacity = function(obj,o){
        if (o > 100) o = 100;
        if (o < 0) o = 0;
        obj = obj.style;
        obj.opacity = (o/100);
        obj.MozOpacity = (o/100);
        obj.KhtmlOpacity = (o/100);
        obj.filter = "alpha(opacity="+ o +")";
    };
    this.deleteEdges = function(){
        for(var i=0;i<softedges.length;i++){
            var parent = softedges[i].parentNode;
            parent.removeChild(softedges[i]);
        };	
        softedges.splice(0,softedges.length);
    };
	
    this.init = function(){
        deleteEdges();			
        var img = document.getElementsByTagName("img");	
        var images = new Array();
        for (var i=0;i<img.length;i++){	
            if(img[i].className == imageClass || imageClass == ""){		
                images.push(img[i]);
            };
        };
        for (var i=0;i<images.length;i++){	
            var image = images[i];
            var parent = image.parentNode;
            w = image.offsetWidth;
            h = image.offsetHeight;
            t = image.offsetTop;
            l = image.offsetLeft;
            setOpacity(image,0);
            for (var j=1;j<step;j++){
                var edge = image.cloneNode(true);
                softedges.push(edge);
                set(edge,j);
                parent.appendChild(edge);	
            };		
        };
    };
	
    this.init();
	
};

// script initiates on page load. 

this.addEvent = function(obj,type,fn){
    if(obj.attachEvent){
        obj['e'+type+fn] = fn;
        obj[type+fn] = function(){
            obj['e'+type+fn](window.event );
        }
        obj.attachEvent('on'+type, obj[type+fn]);
    } else {
        obj.addEventListener(type,fn,false);
    };
};
addEvent(window,"load",softedge);
addEvent(window,"resize",softedge);