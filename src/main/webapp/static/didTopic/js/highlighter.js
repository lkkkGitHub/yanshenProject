define("//static.nowcoder.com/nc/plugin/1.0.14/release/highlighter/highlighter", ["./shCore", "./style/shCoreDefault.css"], function (a, e, r) {
    a("./shCore"), a("./style/shCoreDefault.css"), r.exports = {
        init: function i(e) {
            var h = window.$;
            if (!h) return;
            var r, s = this, e = h(e || "pre.prettyprint"), a = 0, t = [];
            window.SyntaxHighlighter && (window.SyntaxHighlighter.stripBrs = !0);

            function n() {
                a++, t.length === a && s.forEach(t, function (e) {
                    var r = (e = e.get(0)) ? e.parentNode : null;
                    if (r) {
                        var s = 0 <= e.innerHTML.indexOf("‌");
                        if (window.SyntaxHighlighter.vars.discoveredBrushes = null, window.SyntaxHighlighter.highlight(null, e), s) {
                            var a = h(r).find(".syntaxhighlighter").get(0), t = a.innerHTML, n = 0,
                                i = t.replace(/\u200c/gi, function () {
                                    return '<span class="blank-num" style="padding-top:1px;padding-bottom:1px;font-size:14px;">' + ++n + "</span>"
                                });
                            i !== t && (a.innerHTML = i)
                        }
                    }
                })
            }

            s.forEach(e, function (e) {
                e = h(e), s.formatContent(e), r = s.language(e), e.removeClass("brush: " + r + "; " + r), e.addClass("brush: " + r + ";"), t.push(e), s.loadBrush(r, n)
            })
        }, loadBrush: function t(e, r) {
            var s = {
                js: "./shBrushJScript",
                html: "./shBrushXml",
                css: "./shBrushCss",
                php: "./shBrushPhp",
                pl: "./shBrushPerl",
                py: "./shBrushPython",
                rb: "./shBrushRuby",
                java: "./shBrushJava",
                vb: "./shBrushVb",
                cpp: "./shBrushCpp",
                cs: "./shBrushCSharp",
                csharp: "./shBrushCSharp",
                xml: "./shBrushXml",
                bsh: "./shBrushBash",
                bash: "./shBrushBash"
            }[e = e || "java"] || "./shBrushJava";
            a.async(s, r)
        }, language: function h(e) {
            for (var r, s = ["js", "html", "css", "php", "pl", "py", "rb", "java", "vb", "cpp", "cs", "csharp", "xml", "bsh", "bash"], a = e.hasClass("brush:"), t = 0, n = s.length; t < n; t++) if (r = s[t], a && (e.hasClass(r) || e.hasClass(r + ";")) || e.hasClass("lang-" + r)) return "cs" === r ? "csharp" : "bsh" === r ? "bash" : r;
            return "java"
        }, formatContent: function n(e) {
            var r = e.html();
            if (!r) return "";
            if (!/<.*?>/.test(r)) return;
            r = (r = (r = r.replace(/\u200c/gi, "")).replace(/<span\s+class="blank-num".*?>\d+<\/span>/gi, "‌")).replace(/<p.*?>/gi, "").replace(/<div.*?>/gi, "").replace(/<span.*?>/gi, "").replace(/<br.*?>/gi, "\n").replace(/<\/p>/gi, "\n").replace(/<\/div>/gi, "\n").replace(/\n{2,}/gi, "\n\n").replace(/<(.*?)>/gi, function (e, r) {
                var s = (r || "").replace(/^\s+|\s+$/g, "");
                return s = s.replace(/^\//g, ""), -1 !== ",isindex,fieldset,input,button,select,textarea,label,a,iframe,hr,ul,menu,div,blockquote,noscript,table,center,address,dir,pre,h5,dl,h4,noframes,h6,ol,h1,h3,h2,ins,del,script,style,b,acronym,bdo,var,#,abbr,code,br,i,cite,kbd,u,strike,s,tt,strong,q,samp,em,dfn,span,p,iframe,img,embed,noscript,br,kbd,center,button,basefont,h5,h4,samp,h6,ol,h1,h3,h2,form,font,#,select,menu,ins,abbr,label,code,table,script,cite,input,iframe,strong,textarea,noframes,big,small,span,hr,sub,bdo,var,div,object,sup,strike,dir,map,dl,applet,del,isindex,fieldset,ul,b,acronym,a,blockquote,i,u,s,tt,address,q,pre,p,em,dfn,tr,#,param,form,li,ol,ul,style,script,base,link,meta,title,head,body,html,address,blockquote,center,dir,div,dl,fieldset,form,h1,h2,h3,h4,h5,h6,hr,isindex,menu,noframes,ol,p,pre,table,ul,area,base,basefont,br,col,command,dialog,embed,hr,img,input,isindex,keygen,link,meta,param,source,track,wbr,".indexOf("," + s + ",") ? "" : "<" + r + ">"
            });
            var s = this.ie();
            !s || 9 <= s ? e.html(r) : (r = r.replace(/&nbsp;/gi, " ").replace(/&lt;/gi, "<").replace(/&gt;/gi, ">").replace(/&amp;/gi, "&").replace(/&quot;/gi, '"').replace(/&apos;/gi, "'"), e.text(r))
        }, forEach: function l(e, r) {
            for (var s = 0, a = (e = e || []).length; s < a; s++) r && r(e[s], s)
        }, ie: function s() {
            var e, r = window.navigator.userAgent || "";
            if ((e = r.match(/MSIE ([^;]*)|Trident.*; rv(?:\s|:)?([0-9.]+)/)) && (e[1] || e[2])) return e[1] || e[2];
            if ((e = r.match(/Edge\/(\d+).(\d+)$/)) && (e[1] || e[2])) return e[2] || e[1]
        }
    }
});
var XRegExp;
if (XRegExp) throw Error("can't load XRegExp twice in the same frame");
!function () {
    function o(e, t) {
        if (!XRegExp.isRegExp(e)) throw TypeError("type RegExp expected");
        var n = e._xregexp;
        return e = XRegExp(e.source, i(e) + (t || "")), n && (e._xregexp = {
            source: n.source,
            captureNames: n.captureNames ? n.captureNames.slice(0) : null
        }), e
    }

    function i(e) {
        return (e.global ? "g" : "") + (e.ignoreCase ? "i" : "") + (e.multiline ? "m" : "") + (e.extended ? "x" : "") + (e.sticky ? "y" : "")
    }

    function s(e, t, n, r) {
        var i, l, a, s = h.length;
        c = !0;
        try {
            for (; s--;) if (n & (a = h[s]).scope && (!a.trigger || a.trigger.call(r)) && (a.pattern.lastIndex = t, (l = a.pattern.exec(e)) && l.index === t)) {
                i = {output: a.handler.call(r, l, n), match: l};
                break
            }
        } catch (o) {
            throw o
        } finally {
            c = !1
        }
        return i
    }

    function l(e, t, n) {
        if (Array.prototype.indexOf) return e.indexOf(t, n);
        for (n = n || 0; n < e.length; n++) if (e[n] === t) return n;
        return -1
    }

    (XRegExp = function (e, t) {
        var n, r, i = [], l = XRegExp.OUTSIDE_CLASS, a = 0;
        if (XRegExp.isRegExp(e)) {
            if (t !== undefined) throw TypeError("can't supply flags when constructing one RegExp from another");
            return o(e)
        }
        if (c) throw Error("can't call the XRegExp constructor within token definition functions");
        for (t = t || "", n = {
            hasNamedCapture: !1, captureNames: [], hasFlag: function (e) {
                return -1 < t.indexOf(e)
            }, setFlag: function (e) {
                t += e
            }
        }; a < e.length;) (r = s(e, a, l, n)) ? (i.push(r.output), a += r.match[0].length || 1) : (r = p.exec.call(m[l], e.slice(a))) ? (i.push(r[0]), a += r[0].length) : ("[" === (r = e.charAt(a)) ? l = XRegExp.INSIDE_CLASS : "]" === r && (l = XRegExp.OUTSIDE_CLASS), i.push(r), a++);
        return (i = RegExp(i.join(""), p.replace.call(t, u, "")))._xregexp = {
            source: e,
            captureNames: n.hasNamedCapture ? n.captureNames : null
        }, i
    }).version = "1.5.0", XRegExp.INSIDE_CLASS = 1, XRegExp.OUTSIDE_CLASS = 2;
    var e, t, a, g = /\$(?:(\d\d?|[$&`'])|{([$\w]+)})/g, u = /[^gimy]+|([\s\S])(?=[\s\S]*\1)/g,
        n = /^(?:[?*+]|{\d+(?:,\d*)?})\??/, c = !1, h = [], p = {
            exec: RegExp.prototype.exec,
            test: RegExp.prototype.test,
            match: String.prototype.match,
            replace: String.prototype.replace,
            split: String.prototype.split
        }, f = p.exec.call(/()??/, "")[1] === undefined, d = (t = /^/g, p.test.call(t, ""), !t.lastIndex),
        x = (e = /x/g, p.replace.call("x", e, ""), !e.lastIndex), m = {};
    try {
        a = RegExp.prototype.sticky !== undefined
    } catch (r) {
    }
    m[XRegExp.INSIDE_CLASS] = /^(?:\\(?:[0-3][0-7]{0,2}|[4-7][0-7]?|x[\dA-Fa-f]{2}|u[\dA-Fa-f]{4}|c[A-Za-z]|[\s\S]))/, m[XRegExp.OUTSIDE_CLASS] = /^(?:\\(?:0(?:[0-3][0-7]{0,2}|[4-7][0-7]?)?|[1-9]\d*|x[\dA-Fa-f]{2}|u[\dA-Fa-f]{4}|c[A-Za-z]|[\s\S])|\(\?[:=!]|[?*+]\?|{\d+(?:,\d*)?}\??)/, XRegExp.addToken = function (e, t, n, r) {
        h.push({pattern: o(e, "g" + (a ? "y" : "")), handler: t, scope: n || XRegExp.OUTSIDE_CLASS, trigger: r || null})
    }, XRegExp.cache = function (e, t) {
        var n = e + "/" + (t || "");
        return XRegExp.cache[n] || (XRegExp.cache[n] = XRegExp(e, t))
    }, XRegExp.copyAsGlobal = function (e) {
        return o(e, "g")
    }, XRegExp.escape = function (e) {
        return e.replace(/[-[\]{}()*+?.,\\^$|#\s]/g, "\\$&")
    }, XRegExp.execAt = function (e, t, n, r) {
        return (t = o(t, "g" + (r && a ? "y" : ""))).lastIndex = n = n || 0, e = t.exec(e), r ? e && e.index === n ? e : null : e
    }, XRegExp.freezeTokens = function () {
        XRegExp.addToken = function () {
            throw Error("can't run addToken after freezeTokens")
        }
    }, XRegExp.isRegExp = function (e) {
        return "[object RegExp]" === Object.prototype.toString.call(e)
    }, XRegExp.iterate = function (e, t, n, r) {
        for (var i, l = o(t, "g"), a = -1; i = l.exec(e);) n.call(r, i, ++a, e, l), l.lastIndex === i.index && l.lastIndex++;
        t.global && (t.lastIndex = 0)
    }, XRegExp.matchChain = function (e, a) {
        return function s(e, t) {
            var n, r = a[t].regex ? a[t] : {regex: a[t]}, i = o(r.regex, "g"), l = [];
            for (n = 0; n < e.length; n++) XRegExp.iterate(e[n], i, function (e) {
                l.push(r.backref ? e[r.backref] || "" : e[0])
            });
            return t !== a.length - 1 && l.length ? s(l, t + 1) : l
        }([e], 0)
    }, RegExp.prototype.apply = function (e, t) {
        return this.exec(t[0])
    }, RegExp.prototype.call = function (e, t) {
        return this.exec(t)
    }, RegExp.prototype.exec = function (e) {
        var t, n = p.exec.apply(this, arguments);
        try {
            if (n) {
                if (!f && 1 < n.length && -1 < l(n, "") && (t = RegExp(this.source, p.replace.call(i(this), "g", "")), p.replace.call(e.slice(n.index), t, function () {
                    for (var e = 1; e < arguments.length - 2; e++) arguments[e] === undefined && (n[e] = undefined)
                })), this._xregexp && this._xregexp.captureNames) for (var r = 1; r < n.length; r++) (t = this._xregexp.captureNames[r - 1]) && (n[t] = n[r]);
                !d && this.global && !n[0].length && this.lastIndex > n.index && this.lastIndex--
            }
        } catch (n) {
        }
        return n
    }, d || (RegExp.prototype.test = function (e) {
        return (e = p.exec.call(this, e)) && this.global && !e[0].length && this.lastIndex > e.index && this.lastIndex--, !!e
    }), String.prototype.match = function (e) {
        if (XRegExp.isRegExp(e) || (e = RegExp(e)), e.global) {
            var t = p.match.apply(this, arguments);
            return e.lastIndex = 0, t
        }
        return e.exec(this)
    }, String.prototype.replace = function (t, n) {
        var i, e, r = XRegExp.isRegExp(t);
        return r && "string" == typeof n.valueOf() && -1 === n.indexOf("${") && x ? p.replace.apply(this, arguments) : (r ? t._xregexp && (i = t._xregexp.captureNames) : t += "", e = "function" == typeof n ? p.replace.call(this, t, function () {
            if (i) {
                arguments[0] = new String(arguments[0]);
                for (var e = 0; e < i.length; e++) i[e] && (arguments[0][i[e]] = arguments[e + 1])
            }
            return r && t.global && (t.lastIndex = arguments[arguments.length - 2] + arguments[0].length), n.apply(null, arguments)
        }) : (e = this + "", p.replace.call(e, t, function () {
            var r = arguments;
            return p.replace.call(n, g, function (e, t, n) {
                if (!t) return (t = +n) <= r.length - 3 ? r[t] : -1 < (t = i ? l(i, n) : -1) ? r[t + 1] : e;
                switch (t) {
                    case"$":
                        return "$";
                    case"&":
                        return r[0];
                    case"`":
                        return r[r.length - 1].slice(0, r[r.length - 2]);
                    case"'":
                        return r[r.length - 1].slice(r[r.length - 2] + r[0].length);
                    default:
                        if (n = "", !(t = +t)) return e;
                        for (; t > r.length - 3;) n = String.prototype.slice.call(t, -1) + n, t = Math.floor(t / 10);
                        return (t ? r[t] || "" : "$") + n
                }
            })
        })), r && t.global && (t.lastIndex = 0), e)
    }, String.prototype.split = function (e, t) {
        if (!XRegExp.isRegExp(e)) return p.split.apply(this, arguments);
        var n, r, i = this + "", l = [], a = 0;
        if (t === undefined || +t < 0) t = Infinity; else if (!(t = Math.floor(+t))) return [];
        for (e = XRegExp.copyAsGlobal(e); (n = e.exec(i)) && !(e.lastIndex > a && (l.push(i.slice(a, n.index)), 1 < n.length && n.index < i.length && Array.prototype.push.apply(l, n.slice(1)), r = n[0].length, a = e.lastIndex, l.length >= t));) e.lastIndex === n.index && e.lastIndex++;
        return a === i.length ? p.test.call(e, "") && !r || l.push("") : l.push(i.slice(a)), l.length > t ? l.slice(0, t) : l
    }, XRegExp.addToken(/\(\?#[^)]*\)/, function (e) {
        return p.test.call(n, e.input.slice(e.index + e[0].length)) ? "" : "(?:)"
    }), XRegExp.addToken(/\((?!\?)/, function () {
        return this.captureNames.push(null), "("
    }), XRegExp.addToken(/\(\?<([$\w]+)>/, function (e) {
        return this.captureNames.push(e[1]), this.hasNamedCapture = !0, "("
    }), XRegExp.addToken(/\\k<([\w$]+)>/, function (e) {
        var t = l(this.captureNames, e[1]);
        return -1 < t ? "\\" + (t + 1) + (isNaN(e.input.charAt(e.index + e[0].length)) ? "" : "(?:)") : e[0]
    }), XRegExp.addToken(/\[\^?]/, function (e) {
        return "[]" === e[0] ? "\\b\\B" : "[\\s\\S]"
    }), XRegExp.addToken(/^\(\?([imsx]+)\)/, function (e) {
        return this.setFlag(e[1]), ""
    }), XRegExp.addToken(/(?:\s+|#.*)+/, function (e) {
        return p.test.call(n, e.input.slice(e.index + e[0].length)) ? "" : "(?:)"
    }, XRegExp.OUTSIDE_CLASS, function () {
        return this.hasFlag("x")
    }), XRegExp.addToken(/\./, function () {
        return "[\\s\\S]"
    }, XRegExp.OUTSIDE_CLASS, function () {
        return this.hasFlag("s")
    })
}(), "undefined" != typeof exports && (exports.XRegExp = XRegExp);
var SyntaxHighlighter = function () {
    function u(e) {
        return 0 == e.indexOf("highlighter_") ? e : "highlighter_" + e
    }

    function l(e) {
        return x.vars.highlighters[u(e)]
    }

    function s(e, t, n) {
        if (null == e) return null;
        var r, i, l = 1 != n ? e.childNodes : [e.parentNode],
            a = {"#": "id", ".": "className"}[t.substr(0, 1)] || "nodeName";
        if (r = "nodeName" != a ? t.substr(1) : t.toUpperCase(), -1 != (e[a] || "").indexOf(r)) return e;
        for (e = 0; l && e < l.length && null == i; e++) i = s(l[e], t, n);
        return i
    }

    function f(e, t) {
        var n, r = {};
        for (n in e) r[n] = e[n];
        for (n in t) r[n] = t[n];
        return r
    }

    function n(e, t, n, r) {
        function i(e) {
            (e = e || window.event).target || (e.target = e.srcElement, e.preventDefault = function () {
                this.returnValue = !1
            }), n.call(r || window, e)
        }

        e.attachEvent ? e.attachEvent("on" + t, i) : e.addEventListener(t, i, !1)
    }

    function p(e, t) {
        var n = x.vars.discoveredBrushes, r = null;
        if (null == n) {
            for (var i in n = {}, x.brushes) {
                var l = x.brushes[i];
                if (null != (r = l.aliases)) for (l.brushName = i.toLowerCase(), l = 0; l < r.length; l++) n[r[l]] = i
            }
            x.vars.discoveredBrushes = n
        }
        return r = x.brushes[n[e]]
    }

    function c(e, t) {
        for (var n = e.split("\n"), r = 0; r < n.length; r++) n[r] = t(n[r], r);
        return n.join("\n")
    }

    function g(e, n) {
        return null == e || 0 == e.length || "\n" == e || (e = (e = e.replace(/</g, "&lt;")).replace(/ {2,}/g, function (e) {
            for (var t = "", n = 0; n < e.length - 1; n++) t += x.config.space;
            return t + " "
        }), null != n && (e = c(e, function (e) {
            if (0 == e.length) return "";
            var t = "";
            return 0 == (e = e.replace(/^(&nbsp;| )+/, function (e) {
                return t = e, ""
            })).length ? t : t + '<code class="' + n + '">' + e + "</code>"
        }))), e
    }

    function d(e) {
        return e.replace(/^\s+|\s+$/g, "")
    }

    function i(e, t) {
        return e.index < t.index ? -1 : e.index > t.index ? 1 : e.length < t.length ? -1 : e.length > t.length ? 1 : 0
    }

    function h(e, t) {
        for (var n = null, r = [], i = t.func ? t.func : function a(e) {
            return e[0]
        }; null != (n = t.regex.exec(e));) {
            var l = i(n, t);
            "string" == typeof l && (l = [new x.Match(l, n.index, t.css)]), r = r.concat(l)
        }
        return r
    }

    "undefined" != typeof require && void 0 === XRegExp && (XRegExp = require("XRegExp").XRegExp);
    var x = {
        defaults: {
            "class-name": "",
            "first-line": 1,
            "pad-line-numbers": !1,
            highlight: null,
            title: null,
            "smart-tabs": !0,
            "tab-size": 4,
            gutter: !0,
            toolbar: !0,
            "quick-code": !0,
            collapse: !1,
            "auto-links": !0,
            light: !1,
            "html-script": !1
        },
        config: {
            space: "&nbsp;",
            useScriptTags: !0,
            bloggerMode: !1,
            stripBrs: !1,
            tagName: "pre",
            strings: {
                expandSource: "expand source",
                help: "?",
                alert: "SyntaxHighlighter\n\n",
                noBrush: "Can't find brush for: ",
                brushNotHtmlScript: "Brush wasn't configured for html-script option: ",
                aboutDialog: '<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"><html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><title>About SyntaxHighlighter</title></head><body style="font-family:Geneva,Arial,Helvetica,sans-serif;background-color:#fff;color:#000;font-size:1em;text-align:center;"><div style="text-align:center;margin-top:1.5em;"><div style="font-size:xx-large;">SyntaxHighlighter</div><div style="font-size:.75em;margin-bottom:3em;"><div>version 3.0.83 (July 02 2010)</div><div><a href="http://alexgorbatchev.com/SyntaxHighlighter" target="_blank" style="color:#005896">http://alexgorbatchev.com/SyntaxHighlighter</a></div><div>JavaScript code syntax highlighter.</div><div>Copyright 2004-2010 Alex Gorbatchev.</div></div><div>If you like this script, please <a href="https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=2930402" style="color:#005896">donate</a> to <br/>keep development active!</div></div></body></html>'
            }
        },
        vars: {discoveredBrushes: null, highlighters: {}},
        brushes: {},
        regexLib: {
            multiLineCComments: /\/\*[\s\S]*?\*\//gm,
            singleLineCComments: /\/\/.*$/gm,
            singleLinePerlComments: /#.*$/gm,
            doubleQuotedString: /"([^\\"\n]|\\.)*"/g,
            singleQuotedString: /'([^\\'\n]|\\.)*'/g,
            multiLineDoubleQuotedString: new XRegExp('"([^\\\\"]|\\\\.)*"', "gs"),
            multiLineSingleQuotedString: new XRegExp("'([^\\\\']|\\\\.)*'", "gs"),
            xmlComments: /(&lt;|<)!--[\s\S]*?--(&gt;|>)/gm,
            url: /\w+:\/\/[\w-.\/?%&=:@;]*/g,
            phpScriptTags: {left: /(&lt;|<)\?=?/g, right: /\?(&gt;|>)/g},
            aspScriptTags: {left: /(&lt;|<)%=?/g, right: /%(&gt;|>)/g},
            scriptScriptTags: {left: /(&lt;|<)\s*script.*?(&gt;|>)/gi, right: /(&lt;|<)\/\s*script\s*(&gt;|>)/gi}
        },
        toolbar: {
            getHtml: function (e) {
                function t(e, t) {
                    return x.toolbar.getButtonHtml(e, t, x.config.strings[t])
                }

                for (var n = '<div class="toolbar" style="display:none;">', r = x.toolbar.items, i = r.list, l = 0; l < i.length; l++) n += (r[i[l]].getHtml || t)(e, i[l]);
                return n += "</div>"
            }, getButtonHtml: function (e, t, n) {
                return ""
            }, handler: function (e) {
                var t = e.target, n = t.className || "";
                t = l(s(t, ".syntaxhighlighter", !0).id);
                var r, i = (r = "command", (r = RegExp(r + "_(\\w+)").exec(n)) ? r[1] : null);
                t && i && x.toolbar.items[i].execute(t), e.preventDefault()
            }, items: {
                list: ["expandSource", "help"], expandSource: {
                    getHtml: function (e) {
                        if (1 != e.getParam("collapse")) return "";
                        var t = e.getParam("title");
                        return x.toolbar.getButtonHtml(e, "expandSource", t || x.config.strings.expandSource)
                    }, execute: function (e) {
                        (e = document.getElementById(u(e.id))).className = e.className.replace("collapsed", "")
                    }
                }, help: {
                    execute: function () {
                        var e = "scrollbars=0";
                        e = (e += ", left=" + (screen.width - 500) / 2 + ", top=" + (screen.height - 250) / 2 + ", width=500, height=250").replace(/^,/, ""), (e = window.open("", "_blank", e)).focus();
                        var t = e.document;
                        t.write(x.config.strings.aboutDialog), t.close(), e.focus()
                    }
                }
            }
        },
        findElements: function (e, t) {
            var n;
            if (t) n = [t]; else {
                n = document.getElementsByTagName(x.config.tagName);
                for (var r = [], i = 0; i < n.length; i++) r.push(n[i]);
                n = r
            }
            if (n = n, r = [], x.config.useScriptTags && (n = n.concat(function p() {
                for (var e = document.getElementsByTagName("script"), t = [], n = 0; n < e.length; n++) "syntaxhighlighter" == e[n].type && t.push(e[n]);
                return t
            }())), 0 === n.length) return r;
            for (i = 0; i < n.length; i++) {
                for (var l = n[i], a = e, s = n[i].className, o = void 0, g = {}, u = new XRegExp("^\\[(?<values>(.*?))\\]$"), c = new XRegExp("(?<name>[\\w-]+)\\s*:\\s*(?<value>[\\w-%#]+|\\[.*?\\]|\".*?\"|'.*?')\\s*;?", "g"); null != (o = c.exec(s));) {
                    var h = o.value.replace(/^['"]|['"]$/g, "");
                    null != h && u.test(h) && (h = 0 < (h = u.exec(h)).values.length ? h.values.split(/\s*,\s*/) : []), g[o.name] = h
                }
                null != (l = {target: l, params: f(a, g)}).params.brush && r.push(l)
            }
            return r
        },
        highlight: function (e, t) {
            var n = this.findElements(e, t), r = null, i = x.config;
            if (0 !== n.length) for (var l = 0; l < n.length; l++) {
                var a, s = (t = n[l]).target, o = t.params, g = o.brush;
                if (null != g) {
                    if ("true" == o["html-script"] || 1 == x.defaults["html-script"]) r = new x.HtmlScript(g), g = "htmlscript"; else {
                        if (!(r = p(g))) continue;
                        r = new r
                    }
                    if (a = s.innerHTML, i.useScriptTags) {
                        var u = d(a = a), c = !1;
                        0 == u.indexOf("<![CDATA[") && (u = u.substring(9), c = !0);
                        var h = u.length;
                        u.indexOf("]]>") == h - 3 && (u = u.substring(0, h - 3), c = !0), a = c ? u : a
                    }
                    "" != (s.title || "") && (o.title = s.title), o.brush = g, r.init(o), t = r.getDiv(a), "" != (s.id || "") && (t.id = s.id), s.parentNode.replaceChild(t, s)
                }
            }
        },
        all: function (e) {
            n(window, "load", function () {
                x.highlight(e)
            })
        }
    };
    return x.all = x.all, x.highlight = x.highlight, x.Match = function (e, t, n) {
        this.value = e, this.index = t, this.length = e.length, this.css = n, this.brushName = null
    }, x.Match.prototype.toString = function () {
        return this.value
    }, x.HtmlScript = function (e) {
        function o(e, t) {
            for (var n = 0; n < e.length; n++) e[n].index += t
        }

        var g, u = p(e), t = new x.brushes.Xml, n = this, r = "getDiv getHtml init".split(" ");
        if (null != u) {
            g = new u;
            for (var i = 0; i < r.length; i++) !function () {
                var e = r[i];
                n[e] = function () {
                    return t[e].apply(t, arguments)
                }
            }();
            null != g.htmlScript && t.regexList.push({
                regex: g.htmlScript.code, func: function (e) {
                    for (var t, n = e.code, r = [], i = g.regexList, l = e.index + e.left.length, a = g.htmlScript, s = 0; s < i.length; s++) o(t = h(n, i[s]), l), r = r.concat(t);
                    for (null != a.left && null != e.left && (o(t = h(e.left, a.left), e.index), r = r.concat(t)), null != a.right && null != e.right && (o(t = h(e.right, a.right), e.index + e[0].lastIndexOf(e.right)), r = r.concat(t)), e = 0; e < r.length; e++) r[e].brushName = u.brushName;
                    return r
                }
            })
        }
    }, x.Highlighter = function () {
    }, x.Highlighter.prototype = {
        getParam: function (e, t) {
            var n = this.params[e], r = {"true": !0, "false": !1}[n = null == n ? t : n];
            return null == r ? n : r
        }, create: function (e) {
            return document.createElement(e)
        }, findMatches: function (e, t) {
            var n = [];
            if (null != e) for (var r = 0; r < e.length; r++) "object" == typeof e[r] && (n = n.concat(h(t, e[r])));
            return this.removeNestedMatches(n.sort(i))
        }, removeNestedMatches: function (e) {
            for (var t = 0; t < e.length; t++) if (null !== e[t]) for (var n = e[t], r = n.index + n.length, i = t + 1; i < e.length && null !== e[t]; i++) {
                var l = e[i];
                if (null !== l) {
                    if (l.index > r) break;
                    l.index == n.index && l.length > n.length ? e[t] = null : l.index >= n.index && l.index < r && (e[i] = null)
                }
            }
            return e
        }, figureOutLineNumbers: function (e) {
            var n = [], r = parseInt(this.getParam("first-line"));
            return c(e, function (e, t) {
                n.push(t + r)
            }), n
        }, isLineHighlighted: function (e) {
            var t = this.getParam("highlight", []);
            "object" != typeof t && null == t.push && (t = [t]);
            e:{
                e = e.toString();
                var n = void 0;
                for (n = n = Math.max(n || 0, 0); n < t.length; n++) if (t[n] == e) {
                    t = n;
                    break e
                }
                t = -1
            }
            return -1 != t
        }, getLineHtml: function (e, t, n) {
            return e = ["line", "number" + t, "index" + e, "alt" + (t % 2 == 0 ? 1 : 2).toString()], this.isLineHighlighted(t) && e.push("highlighted"), 0 == t && e.push("break"), '<div class="' + e.join(" ") + '">' + n + "</div>"
        }, getLineNumbersHtml: function (e, t) {
            var n = "", r = e.split("\n").length, i = parseInt(this.getParam("first-line")),
                l = this.getParam("pad-line-numbers");
            1 == l ? l = (i + r - 1).toString().length : 1 == isNaN(l) && (l = 0);
            for (var a = 0; a < r; a++) {
                var s, o = t ? t[a] : i + a;
                if (0 == o) s = x.config.space; else {
                    s = l;
                    for (var g = o.toString(); g.length < s;) g = "0" + g;
                    s = g
                }
                e = s, n += this.getLineHtml(a, o, e)
            }
            return n
        }, getCodeLinesHtml: function (e, t) {
            var n = (e = d(e)).split("\n");
            this.getParam("pad-line-numbers");
            var r = parseInt(this.getParam("first-line"));
            e = "";
            for (var i = this.getParam("brush"), l = 0; l < n.length; l++) {
                var a = n[l], s = /^(&nbsp;|\s)+/.exec(a), o = null, g = t ? t[l] : r + l;
                null != s && (o = s[0].toString(), a = a.substr(o.length), o = o.replace(" ", x.config.space)), 0 == (a = d(a)).length && (a = x.config.space), e += this.getLineHtml(l, g, (null != o ? '<code class="' + i + ' spaces">' + o + "</code>" : "") + a)
            }
            return e
        }, getTitleHtml: function (e) {
            return e ? "<caption>" + e + "</caption>" : ""
        }, getMatchesHtml: function (e, t) {
            function n(e) {
                return (e = e && e.brushName || l) ? e + " " : ""
            }

            for (var r = 0, i = "", l = this.getParam("brush", ""), a = 0; a < t.length; a++) {
                var s, o = t[a];
                null !== o && 0 !== o.length && (s = n(o), i += g(e.substr(r, o.index - r), s + "plain") + g(o.value, s + o.css), r = o.index + o.length + (o.offset || 0))
            }
            return i += g(e.substr(r), n() + "plain")
        }, getHtml: function (e) {
            var t, n = "", r = ["syntaxhighlighter"];
            if (1 == this.getParam("light") && (this.params.toolbar = this.params.gutter = !1), className = "syntaxhighlighter", 1 == this.getParam("collapse") && r.push("collapsed"), 0 == (gutter = this.getParam("gutter")) && r.push("nogutter"), r.push(this.getParam("class-name")), r.push(this.getParam("brush")), e = e.replace(/^[ ]*[\n]+|[\n]*[ ]*$/g, "").replace(/\r/g, " "), n = this.getParam("tab-size"), 1 == this.getParam("smart-tabs")) e = function o(e, n) {
                e.split("\n");
                for (var r = "", t = 0; t < 50; t++) r += "                    ";
                return c(e, function (e) {
                    if (-1 == e.indexOf("\t")) return e;
                    for (var t = 0; -1 != (t = e.indexOf("\t"));) e = e.substr(0, t) + r.substr(0, n - t % n) + e.substr(t + 1, e.length);
                    return e
                })
            }(e, n); else {
                for (var i = "", l = 0; l < n; l++) i += " ";
                e = e.replace(/\t/g, i)
            }
            e:{
                n = e = e = e, i = /<br\s*\/?>|&lt;br\s*\/?&gt;/gi, 1 == x.config.bloggerMode && (n = n.replace(i, "\n")), 1 == x.config.stripBrs && (n = n.replace(i, "")), n = n.split("\n"), i = /^\s*/, l = 1e3;
                for (var a = 0; a < n.length && 0 < l; a++) {
                    var s = n[a];
                    if (0 != d(s).length) {
                        if (null == (s = i.exec(s))) {
                            e = e;
                            break e
                        }
                        l = Math.min(s[0].length, l)
                    }
                }
                if (0 < l) for (a = 0; a < n.length; a++) n[a] = n[a].substr(l);
                e = n.join("\n")
            }
            return gutter && (t = this.figureOutLineNumbers(e)), n = this.findMatches(this.regexList, e), n = this.getMatchesHtml(e, n), n = this.getCodeLinesHtml(n, t), this.getParam("auto-links") && (n = function g(e) {
                var r = /(.*)((&gt;|&lt;).*)/;
                return e.replace(x.regexLib.url, function (e) {
                    var t, n = "";
                    return (t = r.exec(e)) && (e = t[1], n = t[2]), '<a href="' + e + '">' + e + "</a>" + n
                })
            }(n)), "undefined" != typeof navigator && navigator.userAgent && navigator.userAgent.match(/MSIE/) && r.push("ie"), '<div id="' + u(this.id) + '" class="' + r.join(" ") + '">' + (this.getParam("toolbar") ? x.toolbar.getHtml(this) : "") + '<table border="0" cellpadding="0" cellspacing="0">' + this.getTitleHtml(this.getParam("title")) + "<tbody><tr>" + (gutter ? '<td class="gutter">' + this.getLineNumbersHtml(e) + "</td>" : "") + '<td class="code"><div class="container">' + n + "</div></td></tr></tbody></table></div>"
        }, getDiv: function (e) {
            null === e && (e = ""), this.code = e;
            var t = this.create("div");
            return t.innerHTML = this.getHtml(e), this.getParam("toolbar") && n(s(t, ".toolbar"), "click", x.toolbar.handler), t
        }, init: function (e) {
            this.id = "" + Math.round(1e6 * Math.random()).toString(), (x.vars.highlighters[u(this.id)] = this).params = f(x.defaults, e || {}), 1 == this.getParam("light") && (this.params.toolbar = this.params.gutter = !1)
        }, getKeywords: function (e) {
            return "\\b(?:" + (e = e.replace(/^\s+|\s+$/g, "").replace(/\s+/g, "|")) + ")\\b"
        }, forHtmlScript: function (e) {
            this.htmlScript = {
                left: {regex: e.left, css: "script"},
                right: {regex: e.right, css: "script"},
                code: new XRegExp("(?<left>" + e.left.source + ")(?<code>.*?)(?<right>" + e.right.source + ")", "sgi")
            }
        }
    }, x
}();
"function" == typeof define && define("//static.nowcoder.com/nc/plugin/1.0.14/release/highlighter/shCore", [], function (e, t, n) {
    n.exports = SyntaxHighlighter
});
define("//static.nowcoder.com/nc/plugin/1.0.14/release/highlighter/shBrushJScript", [], function (e, t, i) {
    function s() {
        var e = SyntaxHighlighter.regexLib;
        this.regexList = [{regex: e.multiLineDoubleQuotedString, css: "string"}, {
            regex: e.multiLineSingleQuotedString,
            css: "string"
        }, {regex: e.singleLineCComments, css: "comments"}, {
            regex: e.multiLineCComments,
            css: "comments"
        }, {
            regex: /\s*#.*/gm,
            css: "preprocessor"
        }, {
            regex: new RegExp(this.getKeywords("break case catch continue default delete do else false  for function if in instanceof new null return super switch this throw true try typeof var while with"), "gm"),
            css: "keyword"
        }], this.forHtmlScript(e.scriptScriptTags)
    }

    s.prototype = new SyntaxHighlighter.Highlighter, s.aliases = ["js", "jscript", "javascript"], SyntaxHighlighter.brushes.JScript = s, void 0 !== t && (t.Brush = s)
});
define("//static.nowcoder.com/nc/plugin/1.0.14/release/highlighter/shBrushXml", [], function (e, n, t) {
    function i() {
        this.regexList = [{
            regex: new XRegExp("(\\&lt;|<)\\!\\[[\\w\\s]*?\\[(.|\\s)*?\\]\\](\\&gt;|>)", "gm"),
            css: "color2"
        }, {
            regex: SyntaxHighlighter.regexLib.xmlComments,
            css: "comments"
        }, {
            regex: new XRegExp("(&lt;|<)[\\s\\/\\?]*(\\w+)(?<attributes>.*?)[\\s\\/\\?]*(&gt;|>)", "sg"),
            func: function x(e, n) {
                var t = SyntaxHighlighter.Match, i = e[0],
                    s = new XRegExp("(&lt;|<)[\\s\\/\\?]*(?<name>[:\\w-\\.]+)", "xg").exec(i), l = [];
                if (null != e.attributes) for (var g, r = new XRegExp("(?<name> [\\w:\\-\\.]+)\\s*=\\s*(?<value> \".*?\"|'.*?'|\\w+)", "xg"); null != (g = r.exec(i));) l.push(new t(g.name, e.index + g.index, "color1")), l.push(new t(g.value, e.index + g.index + g[0].indexOf(g.value), "string"));
                return null != s && l.push(new t(s.name, e.index + s[0].indexOf(s.name), "keyword")), l
            }
        }]
    }

    i.prototype = new SyntaxHighlighter.Highlighter, i.aliases = ["xml", "xhtml", "xslt", "html"], SyntaxHighlighter.brushes.Xml = i, void 0 !== n && (n.Brush = i)
});
define("//static.nowcoder.com/nc/plugin/1.0.14/release/highlighter/shBrushCss", [], function (e, t, r) {
    function o() {
        this.regexList = [{
            regex: SyntaxHighlighter.regexLib.multiLineCComments,
            css: "comments"
        }, {
            regex: SyntaxHighlighter.regexLib.doubleQuotedString,
            css: "string"
        }, {regex: SyntaxHighlighter.regexLib.singleQuotedString, css: "string"}, {
            regex: /\#[a-fA-F0-9]{3,6}/g,
            css: "value"
        }, {regex: /(-?\d+)(\.\d+)?(px|em|pt|\:|\%|)/g, css: "value"}, {
            regex: /!important/g,
            css: "color3"
        }, {
            regex: new RegExp(function t(e) {
                return "\\b([a-z_]|)" + e.replace(/ /g, "(?=:)\\b|\\b([a-z_\\*]|\\*|)") + "(?=:)\\b"
            }("ascent azimuth background-attachment background-color background-image background-position background-repeat background baseline bbox border-collapse border-color border-spacing border-style border-top border-right border-bottom border-left border-top-color border-right-color border-bottom-color border-left-color border-top-style border-right-style border-bottom-style border-left-style border-top-width border-right-width border-bottom-width border-left-width border-width border bottom cap-height caption-side centerline clear clip color content counter-increment counter-reset cue-after cue-before cue cursor definition-src descent direction display elevation empty-cells float font-size-adjust font-family font-size font-stretch font-style font-variant font-weight font height left letter-spacing line-height list-style-image list-style-position list-style-type list-style margin-top margin-right margin-bottom margin-left margin marker-offset marks mathline max-height max-width min-height min-width orphans outline-color outline-style outline-width outline overflow padding-top padding-right padding-bottom padding-left padding page page-break-after page-break-before page-break-inside pause pause-after pause-before pitch pitch-range play-during position quotes right richness size slope src speak-header speak-numeral speak-punctuation speak speech-rate stemh stemv stress table-layout text-align top text-decoration text-indent text-shadow text-transform unicode-bidi unicode-range units-per-em vertical-align visibility voice-family volume white-space widows width widths word-spacing x-height z-index"), "gm"),
            css: "keyword"
        }, {
            regex: new RegExp(function r(e) {
                return "\\b" + e.replace(/ /g, "(?!-)(?!:)\\b|\\b()") + ":\\b"
            }("above absolute all always aqua armenian attr aural auto avoid baseline behind below bidi-override black blink block blue bold bolder both bottom braille capitalize caption center center-left center-right circle close-quote code collapse compact condensed continuous counter counters crop cross crosshair cursive dashed decimal decimal-leading-zero default digits disc dotted double embed embossed e-resize expanded extra-condensed extra-expanded fantasy far-left far-right fast faster fixed format fuchsia gray green groove handheld hebrew help hidden hide high higher icon inline-table inline inset inside invert italic justify landscape large larger left-side left leftwards level lighter lime line-through list-item local loud lower-alpha lowercase lower-greek lower-latin lower-roman lower low ltr marker maroon medium message-box middle mix move narrower navy ne-resize no-close-quote none no-open-quote no-repeat normal nowrap n-resize nw-resize oblique olive once open-quote outset outside overline pointer portrait pre print projection purple red relative repeat repeat-x repeat-y rgb ridge right right-side rightwards rtl run-in screen scroll semi-condensed semi-expanded separate se-resize show silent silver slower slow small small-caps small-caption smaller soft solid speech spell-out square s-resize static status-bar sub super sw-resize table-caption table-cell table-column table-column-group table-footer-group table-header-group table-row table-row-group teal text-bottom text-top thick thin top transparent tty tv ultra-condensed ultra-expanded underline upper-alpha uppercase upper-latin upper-roman url visible wait white wider w-resize x-fast x-high x-large x-loud x-low x-slow x-small x-soft xx-large xx-small yellow"), "g"),
            css: "value"
        }, {
            regex: new RegExp(this.getKeywords("[mM]onospace [tT]ahoma [vV]erdana [aA]rial [hH]elvetica [sS]ans-serif [sS]erif [cC]ourier mono sans serif"), "g"),
            css: "color1"
        }], this.forHtmlScript({left: /(&lt;|<)\s*style.*?(&gt;|>)/gi, right: /(&lt;|<)\/\s*style\s*(&gt;|>)/gi})
    }

    o.prototype = new SyntaxHighlighter.Highlighter, o.aliases = ["css"], SyntaxHighlighter.brushes.CSS = o, void 0 !== t && (t.Brush = o)
});
define("//static.nowcoder.com/nc/plugin/1.0.14/release/highlighter/shBrushPhp", [], function (e, r, s) {
    function t() {
        this.regexList = [{
            regex: SyntaxHighlighter.regexLib.singleLineCComments,
            css: "comments"
        }, {
            regex: SyntaxHighlighter.regexLib.multiLineCComments,
            css: "comments"
        }, {
            regex: SyntaxHighlighter.regexLib.doubleQuotedString,
            css: "string"
        }, {regex: SyntaxHighlighter.regexLib.singleQuotedString, css: "string"}, {
            regex: /\$\w+/g,
            css: "variable"
        }, {
            regex: new RegExp(this.getKeywords("abs acos acosh addcslashes addslashes array_change_key_case array_chunk array_combine array_count_values array_diff array_diff_assoc array_diff_key array_diff_uassoc array_diff_ukey array_fill array_filter array_flip array_intersect array_intersect_assoc array_intersect_key array_intersect_uassoc array_intersect_ukey array_key_exists array_keys array_map array_merge array_merge_recursive array_multisort array_pad array_pop array_product array_push array_rand array_reduce array_reverse array_search array_shift array_slice array_splice array_sum array_udiff array_udiff_assoc array_udiff_uassoc array_uintersect array_uintersect_assoc array_uintersect_uassoc array_unique array_unshift array_values array_walk array_walk_recursive atan atan2 atanh base64_decode base64_encode base_convert basename bcadd bccomp bcdiv bcmod bcmul bindec bindtextdomain bzclose bzcompress bzdecompress bzerrno bzerror bzerrstr bzflush bzopen bzread bzwrite ceil chdir checkdate checkdnsrr chgrp chmod chop chown chr chroot chunk_split class_exists closedir closelog copy cos cosh count count_chars date decbin dechex decoct deg2rad delete ebcdic2ascii echo empty end ereg ereg_replace eregi eregi_replace error_log error_reporting escapeshellarg escapeshellcmd eval exec exit exp explode extension_loaded feof fflush fgetc fgetcsv fgets fgetss file_exists file_get_contents file_put_contents fileatime filectime filegroup fileinode filemtime fileowner fileperms filesize filetype floatval flock floor flush fmod fnmatch fopen fpassthru fprintf fputcsv fputs fread fscanf fseek fsockopen fstat ftell ftok getallheaders getcwd getdate getenv gethostbyaddr gethostbyname gethostbynamel getimagesize getlastmod getmxrr getmygid getmyinode getmypid getmyuid getopt getprotobyname getprotobynumber getrandmax getrusage getservbyname getservbyport gettext gettimeofday gettype glob gmdate gmmktime ini_alter ini_get ini_get_all ini_restore ini_set interface_exists intval ip2long is_a is_array is_bool is_callable is_dir is_double is_executable is_file is_finite is_float is_infinite is_int is_integer is_link is_long is_nan is_null is_numeric is_object is_readable is_real is_resource is_scalar is_soap_fault is_string is_subclass_of is_uploaded_file is_writable is_writeable mkdir mktime nl2br parse_ini_file parse_str parse_url passthru pathinfo print readlink realpath rewind rewinddir rmdir round str_ireplace str_pad str_repeat str_replace str_rot13 str_shuffle str_split str_word_count strcasecmp strchr strcmp strcoll strcspn strftime strip_tags stripcslashes stripos stripslashes stristr strlen strnatcasecmp strnatcmp strncasecmp strncmp strpbrk strpos strptime strrchr strrev strripos strrpos strspn strstr strtok strtolower strtotime strtoupper strtr strval substr substr_compare"), "gmi"),
            css: "functions"
        }, {
            regex: new RegExp(this.getKeywords("__FILE__ __LINE__ __METHOD__ __FUNCTION__ __CLASS__"), "gmi"),
            css: "constants"
        }, {
            regex: new RegExp(this.getKeywords("abstract and array as break case catch cfunction class clone const continue declare default die do else elseif enddeclare endfor endforeach endif endswitch endwhile extends final for foreach function include include_once global goto if implements interface instanceof namespace new old_function or private protected public return require require_once static switch throw try use var while xor "), "gm"),
            css: "keyword"
        }], this.forHtmlScript(SyntaxHighlighter.regexLib.phpScriptTags)
    }

    t.prototype = new SyntaxHighlighter.Highlighter, t.aliases = ["php"], SyntaxHighlighter.brushes.Php = t, void 0 !== r && (r.Brush = t)
});
define("//static.nowcoder.com/nc/plugin/1.0.14/release/highlighter/shBrushPerl", [], function (e, t, s) {
    function r() {
        this.regexList = [{
            regex: new RegExp("#[^!].*$", "gm"),
            css: "comments"
        }, {
            regex: new RegExp("^\\s*#!.*$", "gm"),
            css: "preprocessor"
        }, {
            regex: SyntaxHighlighter.regexLib.doubleQuotedString,
            css: "string"
        }, {
            regex: SyntaxHighlighter.regexLib.singleQuotedString,
            css: "string"
        }, {
            regex: new RegExp("(\\$|@|%)\\w+", "g"),
            css: "variable"
        }, {
            regex: new RegExp(this.getKeywords("abs accept alarm atan2 bind binmode chdir chmod chomp chop chown chr chroot close closedir connect cos crypt defined delete each endgrent endhostent endnetent endprotoent endpwent endservent eof exec exists exp fcntl fileno flock fork format formline getc getgrent getgrgid getgrnam gethostbyaddr gethostbyname gethostent getlogin getnetbyaddr getnetbyname getnetent getpeername getpgrp getppid getpriority getprotobyname getprotobynumber getprotoent getpwent getpwnam getpwuid getservbyname getservbyport getservent getsockname getsockopt glob gmtime grep hex index int ioctl join keys kill lc lcfirst length link listen localtime lock log lstat map mkdir msgctl msgget msgrcv msgsnd oct open opendir ord pack pipe pop pos print printf prototype push quotemeta rand read readdir readline readlink readpipe recv rename reset reverse rewinddir rindex rmdir scalar seek seekdir select semctl semget semop send setgrent sethostent setnetent setpgrp setpriority setprotoent setpwent setservent setsockopt shift shmctl shmget shmread shmwrite shutdown sin sleep socket socketpair sort splice split sprintf sqrt srand stat study substr symlink syscall sysopen sysread sysseek system syswrite tell telldir time times tr truncate uc ucfirst umask undef unlink unpack unshift utime values vec wait waitpid warn write"), "gmi"),
            css: "functions"
        }, {
            regex: new RegExp(this.getKeywords("bless caller continue dbmclose dbmopen die do dump else elsif eval exit for foreach goto if import last local my next no our package redo ref require return sub tie tied unless untie until use wantarray while"), "gm"),
            css: "keyword"
        }], this.forHtmlScript(SyntaxHighlighter.regexLib.phpScriptTags)
    }

    r.prototype = new SyntaxHighlighter.Highlighter, r.aliases = ["perl", "Perl", "pl"], SyntaxHighlighter.brushes.Perl = r, void 0 !== t && (t.Brush = r)
});
define("//static.nowcoder.com/nc/plugin/1.0.14/release/highlighter/shBrushPython", [], function (e, s, r) {
    function t() {
        this.regexList = [{
            regex: SyntaxHighlighter.regexLib.singleLinePerlComments,
            css: "comments"
        }, {regex: /^\s*@\w+/gm, css: "decorator"}, {
            regex: /(['\"]{3})([^\1])*?\1/gm,
            css: "comments"
        }, {regex: /"(?!")(?:\.|\\\"|[^\""\n])*"/gm, css: "string"}, {
            regex: /'(?!')(?:\.|(\\\')|[^\''\n])*'/gm,
            css: "string"
        }, {regex: /\+|\-|\*|\/|\%|=|==/gm, css: "keyword"}, {
            regex: /\b\d+\.?\w*/g,
            css: "value"
        }, {
            regex: new RegExp(this.getKeywords("__import__ abs all any apply basestring bin bool buffer callable chr classmethod cmp coerce compile complex delattr dict dir divmod enumerate eval execfile file filter float format frozenset getattr globals hasattr hash help hex id input int intern isinstance issubclass iter len list locals long map max min next object oct open ord pow print property range raw_input reduce reload repr reversed round set setattr slice sorted staticmethod str sum super tuple type type unichr unicode vars xrange zip"), "gmi"),
            css: "functions"
        }, {
            regex: new RegExp(this.getKeywords("and assert break class continue def del elif else except exec finally for from global if import in is lambda not or pass print raise return try yield while"), "gm"),
            css: "keyword"
        }, {
            regex: new RegExp(this.getKeywords("None True False self cls class_"), "gm"),
            css: "color1"
        }], this.forHtmlScript(SyntaxHighlighter.regexLib.aspScriptTags)
    }

    t.prototype = new SyntaxHighlighter.Highlighter, t.aliases = ["py", "python"], SyntaxHighlighter.brushes.Python = t, void 0 !== s && (s.Brush = t)
});
define("//static.nowcoder.com/nc/plugin/1.0.14/release/highlighter/shBrushRuby", [], function (e, r, i) {
    function s() {
        this.regexList = [{
            regex: SyntaxHighlighter.regexLib.singleLinePerlComments,
            css: "comments"
        }, {
            regex: SyntaxHighlighter.regexLib.doubleQuotedString,
            css: "string"
        }, {regex: SyntaxHighlighter.regexLib.singleQuotedString, css: "string"}, {
            regex: /\b[A-Z0-9_]+\b/g,
            css: "constants"
        }, {regex: /:[a-z][A-Za-z0-9_]*/g, css: "color2"}, {
            regex: /(\$|@@|@)\w+/g,
            css: "variable bold"
        }, {
            regex: new RegExp(this.getKeywords("alias and BEGIN begin break case class def define_method defined do each else elsif END end ensure false for if in module new next nil not or raise redo rescue retry return self super then throw true undef unless until when while yield"), "gm"),
            css: "keyword"
        }, {
            regex: new RegExp(this.getKeywords("Array Bignum Binding Class Continuation Dir Exception FalseClass File::Stat File Fixnum Fload Hash Integer IO MatchData Method Module NilClass Numeric Object Proc Range Regexp String Struct::TMS Symbol ThreadGroup Thread Time TrueClass"), "gm"),
            css: "color1"
        }], this.forHtmlScript(SyntaxHighlighter.regexLib.aspScriptTags)
    }

    s.prototype = new SyntaxHighlighter.Highlighter, s.aliases = ["ruby", "rails", "ror", "rb"], SyntaxHighlighter.brushes.Ruby = s, void 0 !== r && (r.Brush = s)
});
define("//static.nowcoder.com/nc/plugin/1.0.14/release/highlighter/shBrushJava", [], function (e, t, s) {
    function r() {
        this.regexList = [{
            regex: SyntaxHighlighter.regexLib.singleLineCComments,
            css: "comments"
        }, {regex: /\/\*([^\*][\s\S]*)?\*\//gm, css: "comments"}, {
            regex: /\/\*(?!\*\/)\*[\s\S]*?\*\//gm,
            css: "preprocessor"
        }, {
            regex: SyntaxHighlighter.regexLib.doubleQuotedString,
            css: "string"
        }, {
            regex: SyntaxHighlighter.regexLib.singleQuotedString,
            css: "string"
        }, {regex: /\b([\d]+(\.[\d]+)?|0x[a-f0-9]+)\b/gi, css: "value"}, {
            regex: /(?!\@interface\b)\@[\$\w]+\b/g,
            css: "color1"
        }, {
            regex: /\@interface\b/g,
            css: "color2"
        }, {
            regex: new RegExp(this.getKeywords("abstract assert boolean break byte case catch char class const continue default do double else enum extends false final finally float for goto if implements import instanceof int interface long native new null package private protected public return short static strictfp super switch synchronized this throw throws true transient try void volatile while"), "gm"),
            css: "keyword"
        }], this.forHtmlScript({left: /(&lt;|<)%[@!=]?/g, right: /%(&gt;|>)/g})
    }

    r.prototype = new SyntaxHighlighter.Highlighter, r.aliases = ["java"], SyntaxHighlighter.brushes.Java = r, void 0 !== t && (t.Brush = r)
});
define("//static.nowcoder.com/nc/plugin/1.0.14/release/highlighter/shBrushVb", [], function (e, t, r) {
    function s() {
        this.regexList = [{regex: /'.*$/gm, css: "comments"}, {
            regex: SyntaxHighlighter.regexLib.doubleQuotedString,
            css: "string"
        }, {
            regex: /^\s*#.*$/gm,
            css: "preprocessor"
        }, {
            regex: new RegExp(this.getKeywords("AddHandler AddressOf AndAlso Alias And Ansi As Assembly Auto Boolean ByRef Byte ByVal Call Case Catch CBool CByte CChar CDate CDec CDbl Char CInt Class CLng CObj Const CShort CSng CStr CType Date Decimal Declare Default Delegate Dim DirectCast Do Double Each Else ElseIf End Enum Erase Error Event Exit False Finally For Friend Function Get GetType GoSub GoTo Handles If Implements Imports In Inherits Integer Interface Is Let Lib Like Long Loop Me Mod Module MustInherit MustOverride MyBase MyClass Namespace New Next Not Nothing NotInheritable NotOverridable Object On Option Optional Or OrElse Overloads Overridable Overrides ParamArray Preserve Private Property Protected Public RaiseEvent ReadOnly ReDim REM RemoveHandler Resume Return Select Set Shadows Shared Short Single Static Step Stop String Structure Sub SyncLock Then Throw To True Try TypeOf Unicode Until Variant When While With WithEvents WriteOnly Xor"), "gm"),
            css: "keyword"
        }], this.forHtmlScript(SyntaxHighlighter.regexLib.aspScriptTags)
    }

    s.prototype = new SyntaxHighlighter.Highlighter, s.aliases = ["vb", "vbnet"], SyntaxHighlighter.brushes.Vb = s, void 0 !== t && (t.Brush = s)
});
define("//static.nowcoder.com/nc/plugin/1.0.14/release/highlighter/shBrushCpp", [], function (t, e, s) {
    function r() {
        this.regexList = [{
            regex: SyntaxHighlighter.regexLib.singleLineCComments,
            css: "comments"
        }, {
            regex: SyntaxHighlighter.regexLib.multiLineCComments,
            css: "comments"
        }, {
            regex: SyntaxHighlighter.regexLib.doubleQuotedString,
            css: "string"
        }, {regex: SyntaxHighlighter.regexLib.singleQuotedString, css: "string"}, {
            regex: /^ *#.*/gm,
            css: "preprocessor"
        }, {
            regex: new RegExp(this.getKeywords("ATOM BOOL BOOLEAN BYTE CHAR COLORREF DWORD DWORDLONG DWORD_PTR DWORD32 DWORD64 FLOAT HACCEL HALF_PTR HANDLE HBITMAP HBRUSH HCOLORSPACE HCONV HCONVLIST HCURSOR HDC HDDEDATA HDESK HDROP HDWP HENHMETAFILE HFILE HFONT HGDIOBJ HGLOBAL HHOOK HICON HINSTANCE HKEY HKL HLOCAL HMENU HMETAFILE HMODULE HMONITOR HPALETTE HPEN HRESULT HRGN HRSRC HSZ HWINSTA HWND INT INT_PTR INT32 INT64 LANGID LCID LCTYPE LGRPID LONG LONGLONG LONG_PTR LONG32 LONG64 LPARAM LPBOOL LPBYTE LPCOLORREF LPCSTR LPCTSTR LPCVOID LPCWSTR LPDWORD LPHANDLE LPINT LPLONG LPSTR LPTSTR LPVOID LPWORD LPWSTR LRESULT PBOOL PBOOLEAN PBYTE PCHAR PCSTR PCTSTR PCWSTR PDWORDLONG PDWORD_PTR PDWORD32 PDWORD64 PFLOAT PHALF_PTR PHANDLE PHKEY PINT PINT_PTR PINT32 PINT64 PLCID PLONG PLONGLONG PLONG_PTR PLONG32 PLONG64 POINTER_32 POINTER_64 PSHORT PSIZE_T PSSIZE_T PSTR PTBYTE PTCHAR PTSTR PUCHAR PUHALF_PTR PUINT PUINT_PTR PUINT32 PUINT64 PULONG PULONGLONG PULONG_PTR PULONG32 PULONG64 PUSHORT PVOID PWCHAR PWORD PWSTR SC_HANDLE SC_LOCK SERVICE_STATUS_HANDLE SHORT SIZE_T SSIZE_T TBYTE TCHAR UCHAR UHALF_PTR UINT UINT_PTR UINT32 UINT64 ULONG ULONGLONG ULONG_PTR ULONG32 ULONG64 USHORT USN VOID WCHAR WORD WPARAM WPARAM WPARAM char bool short int __int32 __int64 __int8 __int16 long float double __wchar_t clock_t _complex _dev_t _diskfree_t div_t ldiv_t _exception _EXCEPTION_POINTERS FILE _finddata_t _finddatai64_t _wfinddata_t _wfinddatai64_t __finddata64_t __wfinddata64_t _FPIEEE_RECORD fpos_t _HEAPINFO _HFILE lconv intptr_t jmp_buf mbstate_t _off_t _onexit_t _PNH ptrdiff_t _purecall_handler sig_atomic_t size_t _stat __stat64 _stati64 terminate_function time_t __time64_t _timeb __timeb64 tm uintptr_t _utimbuf va_list wchar_t wctrans_t wctype_t wint_t signed"), "gm"),
            css: "color1 bold"
        }, {
            regex: new RegExp(this.getKeywords("assert isalnum isalpha iscntrl isdigit isgraph islower isprintispunct isspace isupper isxdigit tolower toupper errno localeconv setlocale acos asin atan atan2 ceil cos cosh exp fabs floor fmod frexp ldexp log log10 modf pow sin sinh sqrt tan tanh jmp_buf longjmp setjmp raise signal sig_atomic_t va_arg va_end va_start clearerr fclose feof ferror fflush fgetc fgetpos fgets fopen fprintf fputc fputs fread freopen fscanf fseek fsetpos ftell fwrite getc getchar gets perror printf putc putchar puts remove rename rewind scanf setbuf setvbuf sprintf sscanf tmpfile tmpnam ungetc vfprintf vprintf vsprintf abort abs atexit atof atoi atol bsearch calloc div exit free getenv labs ldiv malloc mblen mbstowcs mbtowc qsort rand realloc srand strtod strtol strtoul system wcstombs wctomb memchr memcmp memcpy memmove memset strcat strchr strcmp strcoll strcpy strcspn strerror strlen strncat strncmp strncpy strpbrk strrchr strspn strstr strtok strxfrm asctime clock ctime difftime gmtime localtime mktime strftime time"), "gm"),
            css: "functions bold"
        }, {
            regex: new RegExp(this.getKeywords("break case catch class const __finally __exception __try const_cast continue private public protected __declspec default delete deprecated dllexport dllimport do dynamic_cast else enum explicit extern if for friend goto inline mutable naked namespace new noinline noreturn nothrow register reinterpret_cast return selectany sizeof static static_cast struct switch template this thread throw true false try typedef typeid typename union using uuid virtual void volatile whcar_t while"), "gm"),
            css: "keyword bold"
        }]
    }

    r.prototype = new SyntaxHighlighter.Highlighter, r.aliases = ["cpp", "c"], SyntaxHighlighter.brushes.Cpp = r, void 0 !== e && (e.Brush = r)
});
define("//static.nowcoder.com/nc/plugin/1.0.14/release/highlighter/shBrushCSharp", [], function (e, t, r) {
    function i() {
        this.regexList = [{
            regex: SyntaxHighlighter.regexLib.singleLineCComments, func: function i(e, t) {
                var r = 0 == e[0].indexOf("///") ? "color1" : "comments";
                return [new SyntaxHighlighter.Match(e[0], e.index, r)]
            }
        }, {regex: SyntaxHighlighter.regexLib.multiLineCComments, css: "comments"}, {
            regex: /@"(?:[^"]|"")*"/g,
            css: "string"
        }, {
            regex: SyntaxHighlighter.regexLib.doubleQuotedString,
            css: "string"
        }, {regex: SyntaxHighlighter.regexLib.singleQuotedString, css: "string"}, {
            regex: /^\s*#.*/gm,
            css: "preprocessor"
        }, {
            regex: new RegExp(this.getKeywords("abstract as base bool break byte case catch char checked class const continue decimal default delegate do double else enum event explicit extern false finally fixed float for foreach get goto if implicit in int interface internal is lock long namespace new null object operator out override params private protected public readonly ref return sbyte sealed set short sizeof stackalloc static string struct switch this throw true try typeof uint ulong unchecked unsafe ushort using virtual void while"), "gm"),
            css: "keyword"
        }, {
            regex: /\bpartial(?=\s+(?:class|interface|struct)\b)/g,
            css: "keyword"
        }, {
            regex: /\byield(?=\s+(?:return|break)\b)/g,
            css: "keyword"
        }], this.forHtmlScript(SyntaxHighlighter.regexLib.aspScriptTags)
    }

    i.prototype = new SyntaxHighlighter.Highlighter, i.aliases = ["c#", "c-sharp", "csharp"], SyntaxHighlighter.brushes.CSharp = i, void 0 !== t && (t.Brush = i)
});
define("//static.nowcoder.com/nc/plugin/1.0.14/release/highlighter/shBrushBash", [], function (e, s, t) {
    function r() {
        this.regexList = [{regex: /^#!.*$/gm, css: "preprocessor bold"}, {
            regex: /\/[\w-\/]+/gm,
            css: "plain"
        }, {
            regex: SyntaxHighlighter.regexLib.singleLinePerlComments,
            css: "comments"
        }, {
            regex: SyntaxHighlighter.regexLib.doubleQuotedString,
            css: "string"
        }, {
            regex: SyntaxHighlighter.regexLib.singleQuotedString,
            css: "string"
        }, {
            regex: new RegExp(this.getKeywords("if fi then elif else for do done until while break continue case function return in eq ne ge le"), "gm"),
            css: "keyword"
        }, {
            regex: new RegExp(this.getKeywords("alias apropos awk basename bash bc bg builtin bzip2 cal cat cd cfdisk chgrp chmod chown chrootcksum clear cmp comm command cp cron crontab csplit cut date dc dd ddrescue declare df diff diff3 dig dir dircolors dirname dirs du echo egrep eject enable env ethtool eval exec exit expand export expr false fdformat fdisk fg fgrep file find fmt fold format free fsck ftp gawk getopts grep groups gzip hash head history hostname id ifconfig import install join kill less let ln local locate logname logout look lpc lpr lprint lprintd lprintq lprm ls lsof make man mkdir mkfifo mkisofs mknod more mount mtools mv netstat nice nl nohup nslookup open op passwd paste pathchk ping popd pr printcap printenv printf ps pushd pwd quota quotacheck quotactl ram rcp read readonly renice remsync rm rmdir rsync screen scp sdiff sed select seq set sftp shift shopt shutdown sleep sort source split ssh strace su sudo sum symlink sync tail tar tee test time times touch top traceroute trap tr true tsort tty type ulimit umask umount unalias uname unexpand uniq units unset unshar useradd usermod users uuencode uudecode v vdir vi watch wc whereis which who whoami Wget xargs yes"), "gm"),
            css: "functions"
        }]
    }

    r.prototype = new SyntaxHighlighter.Highlighter, r.aliases = ["bash", "shell"], SyntaxHighlighter.brushes.Bash = r, void 0 !== s && (s.Brush = r)
});