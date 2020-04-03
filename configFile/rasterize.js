"use strict";
var page = require('webpage').create(),
    system = require('system'),
    address, output, size;

    address = system.args[1];
    output = system.args[2];
    page.viewportSize = { width: 1280, height: 800 };
    
   
    page.open(address, function (status) {
        if (status == 'success') {
			
			 // 通过在JS获取页面的渲染高度
                var rect = page.evaluate(function () {
                    //截取div
                  return document.getElementById('divChildren').getBoundingClientRect();
                  //   return   document.getElementsByTagName("body")[0].getBoundingClientRect();
                });
                // 按照实际页面的高度，设定渲染的宽高
                page.clipRect = {
                  top:    rect.top,
                  left:   rect.left,
                  width:  rect.width,
                  height: rect.height
                };
			
			 window.setTimeout(function () {
				
                page.render(output);
				page.close();
                phantom.exit();
            }, 500);
        } else {
           console.log('Unable to load the address!');
            phantom.exit(1);
        }
    });

