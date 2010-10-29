// document.addEvent('domready', Knead_Hue_Demo1);
CCS.Desktop.addEvent('desktopReady', Knead_Hue_Demo1);

function log(message){
	CCS.Desktop.flashMessage('' + Array.prototype.slice.call(arguments))
}



/*
function Knead_Hue_Demo0(){

	var textbox=document.getElementById('textbox');
	var BACKSPACE=8;
	var END=35;
	var LEFT_ARROW=37;
	var SHIFT=16;
	doh.register("doh.robot",[
	{
		name:"dojorobot1",
		timeout:6900,
		setUp:function(){
			textbox.value="hi";
		},
		runTest:function(){
			var d=new doh.Deferred();
			doh.robot.mouseMove(30, 30, 500);
			doh.robot.mouseClick({left:true}, 500);
			doh.robot.typeKeys(" again", 500, 2500);
			doh.robot.sequence(function(){
				if(textbox.value=="hi again"){
					textbox.value += ": passed";
					d.callback(true);
				}else{
					textbox.value += ": failed";
					d.errback(new Error("Expected value 'hi again', got "+textbox.value));
				}
			}, 900);
			return d;
		}
	},
	{
		name:"shiftarrow",
		timeout:10000,
		setUp:function(){
			textbox.value="hi again";
		},
		runTest:function(){
			var d=new doh.Deferred();
			doh.robot.keyPress(END,500);
			// test shift+arrow with keyPress
			for(var i=0; i<3; i++){
				doh.robot.keyPress(LEFT_ARROW,500,{shift:true});
			}
			// test shift+arrow with keyDown then keyUp
			doh.robot.keyDown(SHIFT,500);
			for(var i=0; i<3; i++){
				doh.robot.keyDown(LEFT_ARROW,500);
				doh.robot.keyUp(LEFT_ARROW,20);
			}
			doh.robot.keyUp(SHIFT,500);
			doh.robot.keyPress(BACKSPACE,500);
			doh.robot.sequence(function(){
				if(textbox.value=="hi"){
					textbox.value += ": passed";
					d.callback(true);
				}else{
					textbox.value += ": failed";
					d.errback(new Error("Expected value 'hi', got "+textbox.value));
				}
			}, 900);
			return d;
		}
	}
	]);
	doh.run();

}
*/

function sg_click(el){
	doh.robot.sequence(function(){
		if (typeof el == 'function') el = el();
		el = $(el);
		var pos = el.getPosition();
		var size = el.getSize();
		var x = pos.x + Math.round(size.x / 2)
		var y = pos.y + Math.round(size.y / 2)
		doh.robot._mouseMove(x, y, null, 500);
	}, 250);
	doh.robot.mouseClick({left:true}, 10);
	doh.robot.sequence(function(){ log('click') });
}


function sg_drag(el, relative_x, relative_y, keepMouseWhereItIs){
	
	doh.robot.sequence(function(){ log('Drag Start...') });
	
	// Move the mouse to the start
	if (!keepMouseWhereItIs)
	doh.robot.sequence(function(){
		if (typeof el == 'function') el = el();
		
		var pos = el.getPosition();
		if (el.hasClass('art-window')){
			pos.x += 100
			pos.y += 10
		}
		// log(pos.x, pos.y)
		doh.robot._mouseMove(pos.x, pos.y, null, 1000);
		
	}, 250);
	
	// Begin dragging
	doh.robot.mousePress({left:true}, 250);
	
	// Drag mouse
	doh.robot.sequence(function(){
		if (typeof el == 'function') el = el();
		
		var pos = el.getPosition();
		if (el.hasClass('art-window')){
			pos.x += 100
			pos.y += 10
		}
		pos.x += relative_x
		pos.y += relative_y
		
		// log('sg_drag end', pos.x, pos.y)
		doh.robot._mouseMove(pos.x, pos.y, null, 1000);
		
	}, 250);
	
	// Release Mouse
	doh.robot.mouseRelease({left:true}, 250);
	
	doh.robot.sequence(function(){ log('...Drag End') },1500);
}

function sg_closeArtWindow(el){
	el.retrieve('art-window').hide();
}

function getTopArtWindow(){
	return $$('.art-window')[0];
}

function waitUntil(){
	
}


function Knead_Hue_Demo1(){

	// var textbox=document.getElementById('textbox');
	// var BACKSPACE=8;
	// var END=35;
	// var LEFT_ARROW=37;
	// var SHIFT=16;
	
	
	
	doh.register("doh.robot",[
	{
		name:"move window 1",
		timeout:6900,
		setUp:function(){
		},
		runTest:function(){
			var d=new doh.Deferred();
			
			doh.robot.sequence(function(){
				$$('.art-window').each(sg_closeArtWindow);
			})
			
			sg_click('ccs-jframegallery-menu');
			
			;(function(){
				CCS.Desktop.addEvent('afterLaunch', next)
				function next(){
					CCS.Desktop.removeEvent('afterLaunch', next)
					
					sg_drag( getTopArtWindow, 500, 100 );
					sg_drag( getTopArtWindow, -500, -100, true );
					
					
					doh.robot.sequence(function(){
						$$('.art-window-content')[0].scrollTo(0,9999);
					}, 500)
					
					;(function(){
						CCS.Desktop.addEvent('afterLaunch', next)
						function next(){
							CCS.Desktop.removeEvent('afterLaunch', next)
							var el = $$('.art-splitview-splitter')[0];
							doh.robot.sequence(function(){},1000);
							sg_drag( el, -50, 0 );
							sg_drag( el, 100, 0, true );
						}
					}())
					
					sg_click(function(){return $$('a[href*=splitview.html]')[0]})
				}
			}())
			
			doh.robot.sequence(function(){
				d.callback(true);
			});
			
			// doh.robot.mouseClick({left:true}, 500);
			// doh.robot.typeKeys(" again", 500, 2500);
			// doh.robot.sequence(function(){
			// 	if(textbox.value=="hi again"){
			// 		textbox.value += ": passed";
			// 		d.callback(true);
			// 	}else{
			// 		textbox.value += ": failed";
			// 		d.errback(new Error("Expected value 'hi again', got "+textbox.value));
			// 	}
			// }, 900);
			
			return d;
		}
	}
	]);
	doh.run();

}
