function G($) {
	return document.getElementById($)
}
function C($) {
	return document.createElement($)
}
function GN($) {
	return document.getElementsByName($)
}
function Ci(_, A) {
	var $ = C("input");
	$.name = _;
	$.value = A;
	$.type = "hidden";
	return $
}
function setStyle(A, $) {
	var _ = document.styleSheets[0];
	if (_.addRule) {
		A = A.split(",");
		for (var C = 0, B = A.length; C < B; C++) _.addRule(A[C], $)
	} else if (_.insertRule) _.insertRule(A + " { " + $ + " }", _.cssRules.length)
}
var on = function($, B, D) {
		var _ = [],
			B = B.replace(/^on/, "").toLowerCase();
		_.push($);
		for (var C = 3, A = arguments.length; C < A; C++) _.push(arguments[C]);
		if ($.attachEvent) {
			$[B + D] = function() {
				D.apply(window.event, _)
			};
			$.attachEvent("on" + B, $[B + D])
		} else {
			$[B + D] = function($) {
				D.apply($, _)
			};
			$.addEventListener(B, $[B + D], false)
		}
	};

function trim($) {
	$ = $.replace(/(^\u3000+)|(\u3000+$)/g, "");
	$ = $.replace(/(^ +)|( +$)/g, "");
	return $
}
function byteSlice(A, B) {
	var $ = 0,
		_ = "";
	for (var C = 0; C < A.length; C++) {
		if (A.charCodeAt(C) > 128) $ += 2;
		else $++;
		_ += A.charAt(C);
		if ($ >= B) return _
	}
	return _
}
var format = function(_, B) {
		if (arguments.length > 1) {
			var F = format,
				H = /([.*+?^=!:${}()|[\]\/\\])/g,
				C = (F.left_delimiter || "{").replace(H, "\\$1"),
				A = (F.right_delimiter || "}").replace(H, "\\$1"),
				E = F._r1 || (F._r1 = new RegExp("#" + C + "([^" + C + A + "]+)" + A, "g")),
				G = F._r2 || (F._r2 = new RegExp("#" + C + "(\\d+)" + A, "g"));
			if (typeof(B) == "object") return _.replace(E, function(_, A) {
				var $ = B[A];
				if (typeof $ == "function") $ = $(A);
				return typeof($) == "undefined" ? "" : $
			});
			else if (typeof(B) != "undefined") {
				var D = Array.prototype.slice.call(arguments, 1),
					$ = D.length;
				return _.replace(G, function(A, _) {
					_ = parseInt(_, 10);
					return (_ >= $) ? A : D[_]
				})
			}
		}
		return _
	},
	isType = {
		types: ["Array", "RegExp", "Date", "Number", "String", "Object"]
	};
for (var i = 0, c; c = isType.types[i++];) isType[c] = (function($) {
	return function(_) {
		return Object.prototype.toString.call(_) == "[object " + $ + "]"
	}
})(c);
var cache = (function() {
	var $ = {};

	function B(_) {
		if ($[_]) return $[_];
		return null
	}
	function A(_) {
		delete $[_]
	}
	function _($) {
		return (B($) == null) ? false : true
	}
	return {
		get: B,
		set: C,
		is: _,
		remove: A
	}
})(),
	Browser = (function() {
		var H = navigator.userAgent,
			F = 0,
			E = 0,
			I = 0,
			D = 0,
			A = 0,
			_ = 0,
			C = 0,
			B;
		if (H.indexOf("Chrome") > -1 && /Chrome\/(\d+(\.d+)?)/.test(H)) C = RegExp.$1;
		if (H.indexOf("Safari") > -1 && /Version\/(\d+(\.\d+)?)/.test(H)) F = RegExp.$1;
		if (window.opera && /Opera(\s|\/)(\d+(\.\d+)?)/.test(H)) I = RegExp.$2;
		if (H.indexOf("Gecko") > -1 && H.indexOf("KHTML") == -1 && /rv\:(\d+(\.\d+)?)/.test(H)) A = RegExp.$1;
		if (/MSIE (\d+(\.\d+)?)/.test(H)) D = RegExp.$1;
		if (/Firefox(\s|\/)(\d+(\.\d+)?)/.test(H)) _ = RegExp.$2;
		if (H.indexOf("KHTML") > -1 && /AppleWebKit\/([^\s]*)/.test(H)) E = RegExp.$1;
		try {
			B = !! external.max_version
		} catch ($) {}
		function G() {
			var _ = false;
			if (navigator.plugins) for (var B = 0; B < navigator.plugins.length; B++) if (navigator.plugins[B].name.toLowerCase().indexOf("shockwave flash") >= 0) _ = true;
			if (!_) {
				try {
					var $ = new ActiveXObject("ShockwaveFlash.ShockwaveFlash");
					if ($) _ = true
				} catch (A) {
					_ = false
				}
			}
			return _
		}
		return ({
			isStrict: document.compatMode == "CSS1Compat",
			isChrome: C,
			isSafari: F,
			isWebkit: E,
			isOpera: I,
			isGecko: A,
			isIE: D,
			isFF: _,
			isMaxthon: B,
			isFlash: G(),
			isCookie: (navigator.cookieEnabled) ? true : false
		})
	})();

function getHost(A) {
	var _ = A || location.host,
		$ = _.indexOf(":");
	return ($ == -1) ? _ : _.substring(0, $)
}
window.baidu = window.baidu || {
	version: "1-0-0"
};
baidu.sio = baidu.sio || {};
baidu.url = baidu.url || {};
baidu.string = baidu.string || {};
baidu.sio.get = function(E, D) {
	if (!E || !baidu.isString(E)) return null;
	var D = D ||
	function() {}, B = baidu.url.parseQuery(E, "callback"), _ = document.createElement("SCRIPT");
	if (!B) {
		var $ = false;
		_.onreadystatechange = _.onload = function() {
			if ($) return false;
			if (typeof _.readyState === "undefined" || _.readyState == "loaded" || _.readyState == "complete") {
				$ = true;
				try {
					D()
				} finally {
					if (_ && _.parentNode) _.parentNode.removeChild(_);
					_.onreadystatechange = null;
					_.onload = null;
					_ = null
				}
			}
		}
	} else {
		var A = "CB" + Math.floor(Math.random() * 2147483648).toString(36);
		E = E.replace(/(&|\?)callback=([^&]*)/, "$1callback=" + A);
		window[A] = function() {
			try {
				var $ = (D || window[B]);
				$.apply(null, arguments)
			} finally {
				if (_ && _.parentNode) _.parentNode.removeChild(_);
				_ = null;
				window[A] = null
			}
		}
	}
	_.src = E;
	_.type = "text/javascript";
	var C = document.getElementsByTagName("HEAD")[0];
	C.insertBefore(_, C.firstChild)
};

function json2Query(_) {
	var $ = [];
	if (!_) return "";
	for (var A in _) $.push(A + "=" + encodeURIComponent(_[A]));
	return $.join("&")
}
baidu.json = baidu.json || {}; -
function() {
	var $ = new(function() {
		var D = {}.hasOwnProperty ? true : false,
			_ = function($) {
				return $ < 10 ? "0" + $ : $
			},
			C = {
				"\b": "\\b",
				"\t": "\\t",
				"\n": "\\n",
				"\f": "\\f",
				"\r": "\\r",
				'"': '\\"',
				"\\": "\\\\"
			},
			B = function($) {
				if (/["\\\x00-\x1f]/.test($)) return '"' + $.replace(/([\x00-\x1f\\"])/g, function(A, $) {
					var _ = C[$];
					if (_) return _;
					_ = $.charCodeAt();
					return "\\u00" + Math.floor(_ / 16).toString(16) + (_ % 16).toString(16)
				}) + '"';
				return '"' + $ + '"'
			},
			E = function(C) {
				var B = ["["],
					A, E, D = C.length,
					_;
				for (E = 0; E < D; E += 1) {
					_ = C[E];
					switch (typeof _) {
					case "undefined":
					case "function":
					case "unknown":
						break;
					default:
						if (A) B.push(",");
						B.push(_ === null ? "null" : $.encode(_));
						A = true
					}
				}
				B.push("]");
				return B.join("")
			},
			A = function($) {
				return '"' + $.getFullYear() + "-" + _($.getMonth() + 1) + "-" + _($.getDate()) + "T" + _($.getHours()) + ":" + _($.getMinutes()) + ":" + _($.getSeconds()) + '"'
			};
		this.encode = function(F) {
			if (typeof F == "undefined") return "undefined";
			else if (F === null) return "null";
			else if (F instanceof Array) return E(F);
			else if (F instanceof Date) return A(F);
			else if (typeof F == "string") return B(F);
			else if (typeof F == "number") return isFinite(F) ? String(F) : "null";
			else if (typeof F == "boolean") return String(F);
			else {
				var C = ["{"],
					_, G, $;
				for (G in F) if (!D || F.hasOwnProperty(G)) {
					$ = F[G];
					switch (typeof $) {
					case "undefined":
					case "function":
					case "unknown":
						break;
					default:
						if (_) C.push(",");
						C.push(this.encode(G), ":", $ === null ? "null" : this.encode($));
						_ = true
					}
				}
				C.push("}");
				return C.join("")
			}
		}
	})();
	baidu.json.encode = $.encode
}();
var Config = {
	FormConfig: {},
	UserTrackConfig: {}
};
var ieUserData = {
	init: function() {
		this.defaultExps = 365;
		this.input = C("input");
		this.input.type = "hidden";
		this.input.id = "ieuserdata";
		this.input.addBehavior("#default#userData");
		document.body.appendChild(this.input);
		return this
	},
	set: function($, A, _) {
		this.input.load($);
		var B = new Date();
		_ = _ || this.defaultExps;
		B.setDate(B.getDate() + _);
		this.input.load($);
		this.input.expires = B.toUTCString();
		this.input.setAttribute("code", A);
		this.input.save($)
	},
	change: function(_) {
		var $ = Config.MailConfig[_.selectedIndex];
		if ($.type == "link") {
			UserTrack.send({
				level: "1",
				page: "index",
				type: "mail",
				index: _.selectedIndex
			});
			window.open($.action);
			_.selectedIndex = 16
		}
	}
},
	DynamicForm = (function() {
		var $ = "web";

		function D($) {
			for (var A = 0, _ = $.length; A < _; A++) document.f.removeChild($[A]);
			return []
		}
		var J = {},
			B = [],
			A = null,
			I = [],
			E = null;

		function F(_, A) {
			var D = C("input"),
				B = C("input"),
				$ = C("input");
			D.type = B.type = $.type = "hidden";
			D.name = "oq", B.name = "rsp", $.name = "f";
			D.value = A;
			B.value = _ - 1;
			if (document.f.action == "http://zhidao.baidu.com/q") $.value = "sug";
			else $.value = "3";
			I.push(D);
			I.push(B);
			I.push($);
			document.f.appendChild(D);
			document.f.appendChild(B);
			document.f.appendChild($)
		}
		function _() {
			if (DynamicForm.sugCurIndex != null) F(DynamicForm.sugCurIndex, DynamicForm.oq);
			if (DynamicForm.sugCurIndex == null && I.length != 0) I = D(I);
			var C = cache.get("CURRENT_TAB_SCOURCE"),
				_ = G("q").value;
			if (B[0]) B[0].value = _;
			document.f.submit();
			try {
				bdRecord.searchPolicy(_, $);
				bdRecord.printSearchRecord("hao_search_content", $)
			} catch (A) {
				if (byId("content").offsetWidth == 990) UserTrack.send({
					level: 1,
					page: "index",
					type: "form"
				});
				else UserTrack.send({
					level: 1,
					page: "indexk",
					type: "form"
				})
			}
			DynamicForm.sugCurIndex = null;
			I = D(I)
		}
		function H(I, K, _) {
			var K = K,
				H = cache.set("CURRENT_TAB_SCOURCE", K),
				F = Config.FormConfig;
			$ = K;
			G("q").value = "";
			G("q").focus();

			function E() {
				var $ = G("hao_img_logo");
				$.href = F[K].url;
				$.childNodes[0].src = F[K].imgLogo;
				$.childNodes[0].alt = F[K].imgAlt
			}
			function L() {
				if (J.key) J.key.className = "tab_item";
				else G("wegTab").className = "tab_item";
				I.className = "tab_cur";
				J.key = I
			}
			function C() {
				var $ = document.f;
				$.action = F[K].action;
				if (B.length != 0) B = D(B);
				for (var A in F[K].params) {
					var _ = Ci(A, F[K].params[A]);
					B.push(_);
					$.appendChild(_)
				}
			}
			function A() {
				var $ = G("hao_search_content");
				$.innerHTML = F[K].content
			}
			if (!_) L();
			C();
			E();
			A()
		}
		return {
			tab: H,
			submit: _,
			sugCurIndex: A,
			oq: E
		}
	})();

function bottomForm() {
	var $ = document.bf.key.value;
	if (document.bf.sto[0].checked) if (byId("content").offsetWidth == 990) window.open("http://www.baidu.com/s?tn=hao123&word=" + $, "mspg6");
	else window.open("http://www.baidu.com/s?tn=sitehao123_1_pg&word=" + $, "mspg6");
	if (document.bf.sto[1].checked) window.open("http://www.google.cn/search?hl=zh-CN&q=" + $, "mspg4");
	if (document.bf.sto[2].checked) window.open("http://www.gougou.com/search?id=1&search=" + $, "mspg1");
	if (document.bf.sto[3].checked) window.open("http://map.baidu.com/m?word=" + $, "mspg14");
	if (document.bf.sto[4].checked) window.open("http://bk.baidu.com/?kw=" + $ + "&submit=search", "mspg13");
	if (document.bf.sto[5].checked) window.open("http://search.hao123.com/search.php?query=" + $, "mspg12");
	return false
}
function morePopup(_, A) {
	var _ = _ || window.event,
		B = _.target || _.srcElement,
		C = G("hao_more_event"),
		$ = G("hao_more_popup");
	switch (A) {
	case "down":
		if ($.style.display == "") {
			C.border = "1px solid #fff";
			$.style.display = "none"
		} else {
			C.style.border = "1px dotted #B0BEC7";
			$.style.display = ""
		}
		if (_.stopPropagation) _.stopPropagation();
		else _.cancelBubble = true;
		break;
	case "over":
		C.style.border = "1px solid #B0BEC7";
		break;
	case "out":
		C.style.border = "1px solid #fff";
		break;
	case "click":
		setTimeout(function() {
			if ($.style.display == "") {
				C.border = "1px solid #fff";
				$.style.display = "none"
			}
		}, 200);
		break
	}
}
on(document.body, "mousedown", morePopup, "click");
var indexWeather = {
	init: function($, _) {
		loadXSAjax({
			t: 1,
			onerror: function() {
				indexWeather.error()
			}
		})
	},
	error: function() {
		var $ = '<a href="javascript:void(0)" onclick="indexWeather.init(); return false" style="color:#999;">\u7531\u4e8e\u7f51\u7edc\u539f\u56e0\uff0c\u5929\u6c14\u52a0\u8f7d\u5931\u8d25...<b>\u70b9\u6b64\u91cd\u8bd5</b></a>';
		G("Forecast").innerHTML = $
	}
};

function byId($) {
	return document.getElementById($)
}
function byTag($) {
	return document.getElementsByTagName($)
};
(function() {
	var A = 1,
		S = G("sug"),
		B = G("q"),
		N, Z = null,
		V = -1,
		E = false,
		Q = false,
		$ = false,
		F = true,
		R = null,
		H = null,
		Y = 0;

	function I() {
		B.setAttribute("autocomplete", "on")
	}
	function c() {
		if (Browser.isIE) G("sugif").style.display = "none";
		S.style.display = "none";
		Y = 0;
		F = true
	}
	function b() {
		var $ = H.rows;
		for (var _ = 0; _ < $.length; _++) $[_].className = "ml"
	}
	var O = {},
		f = true;

	function e(_) {
		return function() {
			if (Browser.isGecko) B.blur();
			clearTimeout(Y);
			O.startTime = new Date();
			var A = this,
				_ = 0;
			while (A && A.tagName == "TR") {
				A = A.previousSibling;
				_++
			}
			DynamicForm.sugCurIndex = _;
			DynamicForm.oq = N.q;
			B.value = N.s[_ - 1];
			L = B.value;
			B.focus();
			$ = true
		}
	}
	function P($) {
		var $ = window.event || $,
			_ = $.target || $.srcElement;
		if ((new Date() - O.startTime) / 1000 > 0.5 && L != _.innerHTML) return;
		else {
			DynamicForm.submit();
			B.value = L;
			c()
		}
	}
	function K() {
		if (typeof(N) != "object" || typeof(N.s) == "undefined") return;
		F = false;
		var tab = C("table");
		with(tab) {
			id = "sug_t";
			style.width = "100%";
			style.backgroundColor = "#fff";
			cellSpacing = 0;
			cellPadding = 2;
			style.cursor = "default"
		}
		var _ = C("tbody");
		tab.appendChild(_);
		for (var I = 0; I < N.s.length; I++) {
			var A = _.insertRow(-1);
			A.onmouseover = function() {
				b();
				this.className = "mo";
				Q = true
			};
			A.onmouseout = b;
			A.onmousedown = e(I);
			A.onmouseup = P;
			var D = A.insertCell(-1),
				$ = "";
			D.innerHTML = N.s[I];
			if (Browser.isOpera) {
				D.style.lineHeight = "20px";
				D.style.width = B.clientWidth + "px"
			}
		}
		S.innerHTML = "";
		S.appendChild(tab);
		S.style.width = (((!Browser.isStrict) && Browser.isIE) ? B.offsetWidth : B.offsetWidth - 2) + "px";
		S.style.top = (Browser.isIE) ? (Browser.isGecko ? B.offsetHeight - 1 : B.offsetHeight) + "px" : (Browser.isGecko ? B.offsetHeight - 1 : B.offsetHeight) + "px";
		S.style.display = "block";
		if (Browser.isIE) {
			var E = G("sugif");
			with(E.style) {
				display = "";
				position = "absolute";
				width = S.offsetWidth + "px";
				height = tab.offsetHeight + "px"
			}
		}
		if (G("sug_t")) H = G("sug_t");
		V = -1;
		L = ""
	}
	function J(A) {
		A = A || window.event;
		E = false;
		var D = null;
		if (A.keyCode == 9) {
			c();
			return
		}
		if (A.keyCode == 13) {
			c();
			return
		}
		if (A.keyCode == 38 || A.keyCode == 40) {
			Q = false;
			if (S.style.display != "none") {
				var $ = H.rows,
					C = $.length;
				for (var G = 0; G < C; G++) if ($[G].className == "mo") {
					V = G;
					break
				}
				b();
				if (A.keyCode == 38) if (V == 0) {
					B.value = N.q;
					V = -1;
					E = true;
					DynamicForm.sugCurIndex = null;
					DynamicForm.oq = ""
				} else {
					if (V == -1) V = C;
					D = $[--V];
					D.className = "mo";
					var F = D,
						_ = 0;
					while (F && F.tagName.toUpperCase() == "TR") {
						F = F.previousSibling;
						_++
					}
					DynamicForm.sugCurIndex = _;
					DynamicForm.oq = N.q;
					B.value = N.s[_ - 1];
					L = B.value
				}
				if (A.keyCode == 40) if (V == C - 1) {
					DynamicForm.sugCurIndex = null;
					DynamicForm.oq = null;
					B.value = N.q;
					V = -1;
					E = true
				} else {
					D = $[++V];
					D.className = "mo";
					F = D, _ = 0;
					while (F && F.tagName.toUpperCase() == "TR") {
						F = F.previousSibling;
						_++
					}
					DynamicForm.sugCurIndex = _;
					DynamicForm.oq = N.q;
					B.value = N.s[_ - 1];
					L = B.value
				}
				if (!Browser.isIE) A.preventDefault()
			}
		}
	}
	window.baidu.sug = function($) {
		if (typeof($) == "object" && typeof($.s) != "undefined" && typeof($.s[0]) != "undefined") {
			N = $;
			K()
		} else {
			c();
			N = {}
		}
	};
	var T = "",
		L = B.value,
		W = 0;

	function _() {
		if (A == 0) return;
		B.onbeforedeactivate = function() {
			if (F) return;
			window.event.cancelBubble = true;
			window.event.returnValue = false;
			$ = false;
			return false
		};
		var J = true,
			K = B.value;
		if (typeof(H) != "undefined" && H != null) {
			var _ = H.rows;
			for (var L = 0; L < _.length; L++) if (_[L].className == "mo") if (K == _[L].cells[0].innerHTML && !Q) J = false
		}
		if (J && !E) {
			var D = encodeURIComponent(B.value),
				I = (new Date()).getTime(),
				G = "";
			(function() {
				var $ = cache.get("CURRENT_TAB_SCOURCE");
				if ($ == null) $ = "web";
				switch ($) {
				case "mp3":
					G = "http://nssug.baidu.com/su?wd=" + D + "&prod=mp3&sc=hao123&t=" + I;
					break;
				case "image":
					G = "http://nssug.baidu.com/su?wd=" + D + "&prod=image&sc=hao123&t=" + I;
					break;
				case "video":
					G = "http://nssug.baidu.com/su?wd=" + D + "&prod=video&sc=hao123&t=" + I;
					break;
				case "zhidao":
					G = "http://nssug.baidu.com/su?wd=" + D + "&prod=zhidao&sc=hao123&t=" + I;
					break;
				default:
				case "web":
					G = "http://suggestion.baidu.com/su?wd=" + D + "&sc=hao123&t=" + I;
					break;
				case "tieba":
				case "news":
					G = null;
					break
				}
			})();
			if (G == null) return false;
			if (Z) document.body.removeChild(Z);
			Z = C("script");
			Z.src = G;
			document.body.appendChild(Z)
		}
	}
	function M() {
		var $ = B.value;
		if ($ == T && $ != "" && $ != L) {
			if (W == 0) W = setTimeout(_, 100)
		} else {
			clearTimeout(W);
			W = 0;
			T = $;
			if ($ == "") c();
			if (L != B.value) L = ""
		}
	}
	var U = setInterval(M, 10),
		a = 0;
	B.oncontextmenu = function() {
		E = false
	};
	if (A == 1) B.onkeydown = J;
	f = false;
	window.onblur = function() {
		c()
	};
	B.onblur = function() {
		if (f) if (Y == 0) {
			Y = setTimeout(c, 200);
			c()
		}
		f = false
	};
	document.onmousedown = function(_) {
		if ($) {
			$ = false;
			return false
		}
		B.onbeforedeactivate = function() {};
		_ = _ || window.event;
		var A = _.target || _.srcElement;
		if (A == B) return;
		while (A == A.parentNode) if (A == S || A == B) {
			f = true;
			return
		}
		if (Y == 0) Y = setTimeout(c, 200)
	};

	function d() {
		if (typeof(Y) != "undefined" && Y != 0) clearTimeout(Y);
		X()
	}
	on(window, "resize", d);
	S.style.zIndex = 200;
	if (Browser.isIE) {
		var g = C("IFRAME");
		g.src = "javascript:void(0)";
		g.id = "sugif";
		g.style.zIndex = "20";
		with(g.style) {
			display = "none";
			position = "absolute"
		}
		S.parentNode.insertBefore(g, S)
	}
	function X() {
		if (S.style.display != "none") setTimeout(function() {
			c();
			if (N != null) {
				K(N);
				B.focus()
			}
		}, 100)
	}
	function D($) {
		if (Browser.isGecko) {
			$ = $ || window.event;
			if ($.ctrlKey) if ($.keyCode == 61 || $.keyCode == 107 || $.keyCode == 109 || $.keyCode == 96 || $.keyCode == 48) X()
		}
	}
	on(document, "keydown", D);
	window.onunload = function() {}
})()
