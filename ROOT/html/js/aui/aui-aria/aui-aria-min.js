AUI.add("aui-aria",function(p){var e=p.Lang,k=e.isBoolean,a=e.isFunction,l=e.isObject,m=e.isString,c="attributeValueFormat",o="attributes",n="aria",q="aria-",b="attributeNode",v="boundingBox",u="host",f="role",r="roleName",g="roleNode",d="validateW3C",j="Change",w="",i=/([^a-z])/ig,t="aria:processAttribute",s=p.cached(function(x){return x.replace(i,function(){return w;}).toLowerCase();});var h=p.Component.create({NAME:n,NS:n,ATTRS:{attributes:{value:{},validator:l},attributeValueFormat:{value:function(x){return x;},validator:a},attributeNode:{writeOnce:true,setter:p.one,valueFn:function(){return this.get(u).get(v);}},roleName:{valueFn:function(){var y=this;var z=y.get(u);var x=s(z.constructor.NAME||w);return(y.isValidRole(x)?x:w);},validator:m},roleNode:{writeOnce:true,setter:p.one,valueFn:function(){return this.get(u).get(v);}},validateW3C:{value:true,validator:k}},EXTENDS:p.Plugin.Base,prototype:{initializer:function(){var x=this;x.publish(t,{defaultFn:x._defProcessFn,queuable:false,emitFacade:true,bubbles:true,prefix:n});x._uiSetRoleName(x.get(r));x.after("roleNameChange",x._afterRoleNameChange);x._bindHostAttributes();},isValidAttribute:function(y){var x=this;return(x.get(d)?p.Plugin.Aria.W3C_ATTRIBUTES[y]:true);},isValidRole:function(y){var x=this;return(x.get(d)?p.Plugin.Aria.W3C_ROLES[y]:true);},setAttribute:function(y,A,z){var x=this;if(x.isValidAttribute(y)){(z||x.get(b)).set(q+y,A);return true;}return false;},setAttributes:function(y){var x=this;p.Array.each(y,function(B,A,z){x.setAttribute(B.name,B.value,B.node);});},setRole:function(y,z){var x=this;if(x.isValidRole(y)){(z||x.get(g)).set(f,y);return true;}return false;},setRoles:function(y){var x=this;p.Array.each(y,function(B,z,A){x.setRole(B.name,B.node);});},_afterHostAttributeChange:function(y){var x=this;x._handleProcessAttribute(y);},_afterRoleNameChange:function(y){var x=this;x._uiSetRoleName(y.newVal);},_bindHostAttributes:function(){var x=this;var y=x.get(o);p.each(y,function(A,B){var z=x._getAriaAttribute(A,B);x._handleProcessAttribute({aria:z});x.afterHostEvent(B+j,function(C){C.aria=z;x._afterHostAttributeChange(C);});});},_defProcessFn:function(y){var x=this;x._setAttribute(y.aria);},_getAriaAttribute:function(y,z){var x=this;var A=x.get(c);var B={};if(m(y)){B=p.merge(B,{ariaName:y,attrName:z,format:A,node:null});}else{if(l(y)){B=p.mix(y,{ariaName:w,attrName:z,format:A,node:null});}}return B;},_handleProcessAttribute:function(y){var x=this;x.fire(t,{aria:y.aria});},_setAttribute:function(y){var x=this;var z=x.get(u);var B=z.get(y.attrName);var A=y.node;if(a(A)){A=A.apply(x,[y]);}x.setAttribute(y.ariaName,y.format.apply(x,[B,y]),A);},_uiSetRoleName:function(y){var x=this;x.setRole(y);}}});p.Plugin.Aria=h;p.Plugin.Aria.W3C_ROLES={"alert":1,"alertdialog":1,"application":1,"article":1,"banner":1,"button":1,"checkbox":1,"columnheader":1,"combobox":1,"command":1,"complementary":1,"composite":1,"contentinfo":1,"definition":1,"dialog":1,"directory":1,"document":1,"form":1,"grid":1,"gridcell":1,"group":1,"heading":1,"img":1,"input":1,"landmark":1,"link":1,"list":1,"listbox":1,"listitem":1,"log":1,"main":1,"marquee":1,"math":1,"menu":1,"menubar":1,"menuitem":1,"menuitemcheckbox":1,"menuitemradio":1,"navigation":1,"note":1,"option":1,"presentation":1,"progressbar":1,"radio":1,"radiogroup":1,"range":1,"region":1,"roletype":1,"row":1,"rowheader":1,"scrollbar":1,"search":1,"section":1,"sectionhead":1,"select":1,"separator":1,"slider":1,"spinbutton":1,"status":1,"structure":1,"tab":1,"tablist":1,"tabpanel":1,"textbox":1,"timer":1,"toolbar":1,"tooltip":1,"tree":1,"treegrid":1,"treeitem":1,"widget":1,"window":1};p.Plugin.Aria.W3C_ATTRIBUTES={"activedescendant":1,"atomic":1,"autocomplete":1,"busy":1,"checked":1,"controls":1,"describedby":1,"disabled":1,"dropeffect":1,"expanded":1,"flowto":1,"grabbed":1,"haspopup":1,"hidden":1,"invalid":1,"label":1,"labelledby":1,"level":1,"live":1,"multiline":1,"multiselectable":1,"orientation":1,"owns":1,"posinset":1,"pressed":1,"readonly":1,"relevant":1,"required":1,"selected":1,"setsize":1,"sort":1,"valuemax":1,"valuemin":1,"valuenow":1,"valuetext":1};},"1.5.0",{requires:["aui-base","plugin"],skinnable:false});