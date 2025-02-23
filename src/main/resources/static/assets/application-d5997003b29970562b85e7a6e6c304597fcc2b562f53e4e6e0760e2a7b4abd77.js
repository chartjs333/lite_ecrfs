var instance = null;
if (instance === null) {
    instance = {};
    instance.stringToColorHash = {};
    instance.nextVeryDifferntColorIdx = 0;

    instance.veryDifferentColors = ["#ac202d", "#434348", "#154789", "#f7a35c", "#187422", "#604a7b", "#e4d354", "#2b908f", "#f45b5b", "#91e8e1", "#ac202d", "#434348", "#154789", "#f7a35c", "#187422", "#604a7b", "#e4d354", "#2b908f", "#f45b5b", "#91e8e1", "#ac202d", "#434348", "#154789", "#f7a35c", "#187422", "#604a7b", "#e4d354", "#2b908f", "#f45b5b", "#91e8e1", "#ac202d", "#434348", "#154789", "#f7a35c", "#187422", "#604a7b", "#e4d354", "#2b908f", "#f45b5b", "#91e8e1", "#ac202d", "#434348", "#154789", "#f7a35c", "#187422", "#604a7b", "#e4d354", "#2b908f", "#f45b5b", "#91e8e1", "#ac202d", "#434348", "#154789", "#f7a35c", "#187422", "#604a7b", "#e4d354", "#2b908f", "#f45b5b", "#91e8e1", "#ac202d", "#434348", "#154789", "#f7a35c", "#187422", "#604a7b", "#e4d354", "#2b908f", "#f45b5b", "#91e8e1", "#ac202d", "#434348", "#154789", "#f7a35c", "#187422", "#604a7b", "#e4d354", "#2b908f", "#f45b5b", "#91e8e1", "#ac202d", "#434348", "#154789", "#f7a35c", "#187422", "#604a7b", "#e4d354", "#2b908f", "#f45b5b", "#91e8e1", "#ac202d", "#434348", "#154789", "#f7a35c", "#187422", "#604a7b", "#e4d354", "#2b908f", "#f45b5b", "#91e8e1", "#ac202d", "#434348", "#154789", "#f7a35c", "#187422", "#604a7b", "#e4d354", "#2b908f", "#f45b5b", "#91e8e1", "#ac202d", "#434348", "#154789", "#f7a35c", "#187422", "#604a7b", "#e4d354", "#2b908f", "#f45b5b", "#91e8e1", "#ac202d", "#434348", "#154789", "#f7a35c", "#187422", "#604a7b", "#e4d354", "#2b908f", "#f45b5b", "#91e8e1", "#ac202d", "#434348", "#154789", "#f7a35c", "#187422", "#604a7b", "#e4d354", "#2b908f", "#f45b5b", "#91e8e1", "#ac202d", "#434348", "#154789", "#f7a35c", "#187422", "#604a7b", "#e4d354", "#2b908f", "#f45b5b", "#91e8e1", "#ac202d", "#434348", "#154789", "#f7a35c", "#187422", "#604a7b", "#e4d354", "#2b908f", "#f45b5b", "#91e8e1", "#ac202d", "#434348", "#154789", "#f7a35c", "#187422", "#604a7b", "#e4d354", "#2b908f", "#f45b5b", "#91e8e1", "#ac202d", "#434348", "#154789", "#f7a35c", "#187422", "#604a7b", "#e4d354", "#2b908f", "#f45b5b", "#91e8e1", "#ac202d", "#434348", "#154789", "#f7a35c", "#187422", "#604a7b", "#e4d354", "#2b908f", "#f45b5b", "#91e8e1", "#ac202d", "#434348", "#154789", "#f7a35c", "#187422", "#604a7b", "#e4d354", "#2b908f", "#f45b5b", "#91e8e1"];
}

function str2hex(str) {
//  var hash = 0;
//  for (var i = 0; i < str.length; i++) {
//    hash = str.charCodeAt(i) + ((hash << 5) - hash);
//  }
//  var colour = '#';
//  for (var i = 0; i < 3; i++) {
//    var value = (hash >> (i * 8)) & 0xFF;
//    colour += ('00' + value.toString(16)).substr(-2);
//  }
//  return colour;

    if (!instance.stringToColorHash[str])
        instance.stringToColorHash[str] = instance.veryDifferentColors[instance.nextVeryDifferntColorIdx++];

    return instance.stringToColorHash[str];
}

function array2hex(_data) {
    var _colors = [];
    for (var i = 0; i < _data.length; i++) {
        _colors.push(str2hex(_data[i][0]));
    }
    return _colors;
}

function FastClick(t, e) {
    "use strict";

    function i(t, e) {
        return function () {
            return t.apply(e, arguments)
        }
    }

    var n;
    if (e = e || {}, this.trackingClick = !1, this.trackingClickStart = 0, this.targetElement = null, this.touchStartX = 0, this.touchStartY = 0, this.lastTouchIdentifier = 0, this.touchBoundary = e.touchBoundary || 10, this.layer = t, this.tapDelay = e.tapDelay || 200, !FastClick.notNeeded(t)) {
        for (var s = ["onMouse", "onClick", "onTouchStart", "onTouchMove", "onTouchEnd", "onTouchCancel"], o = this, r = 0, a = s.length; a > r; r++) o[s[r]] = i(o[s[r]], o);
        deviceIsAndroid && (t.addEventListener("mouseover", this.onMouse, !0), t.addEventListener("mousedown", this.onMouse, !0), t.addEventListener("mouseup", this.onMouse, !0)), t.addEventListener("click", this.onClick, !0), t.addEventListener("touchstart", this.onTouchStart, !1), t.addEventListener("touchmove", this.onTouchMove, !1), t.addEventListener("touchend", this.onTouchEnd, !1), t.addEventListener("touchcancel", this.onTouchCancel, !1), Event.prototype.stopImmediatePropagation || (t.removeEventListener = function (e, i, n) {
            var s = Node.prototype.removeEventListener;
            "click" === e ? s.call(t, e, i.hijacked || i, n) : s.call(t, e, i, n)
        }, t.addEventListener = function (e, i, n) {
            var s = Node.prototype.addEventListener;
            "click" === e ? s.call(t, e, i.hijacked || (i.hijacked = function (t) {
                t.propagationStopped || i(t)
            }), n) : s.call(t, e, i, n)
        }), "function" == typeof t.onclick && (n = t.onclick, t.addEventListener("click", function (t) {
            n(t)
        }, !1), t.onclick = null)
    }
}

function switch_right(t) {
    user_id = t.split("_")[0], right_id = t.split("_")[1], $.ajax({
        type: "POST",
        url: "/users/toggle_right",
        dataType: "json",
        data: {id: user_id, right_id: right_id}
    })
}

function toggle_admin_menu() {
    "hidden" == $("#admin_dropdown_menu").css("visibility") ? $("#admin_dropdown_menu").css("visibility", "visible") : $("#admin_dropdown_menu").css("visibility", "hidden")
}

function check_family() {
    fam_name = $("#patient_family_attributes_name").val(), $.ajax({
        type: "POST",
        url: "/families/check_name",
        dataType: "json",
        data: {name: fam_name},
        success: function (t) {
            null == t ? $("#patient_family_attributes_history").prop("disabled") && ($("#patient_family_form *").attr("disabled", !1), $("#patient_family_form *").not("#patient_family_attributes_name, #patient_family_attributes_history option, #patient_family_attributes_consanguinity option").val(""), $("#patient_family_attributes_history").val(""), $("#patient_family_attributes_consanguinity").val("")) : ($("#patient_family_form *").not("#patient_family_attributes_name").attr("disabled", !0), null == t.history ? $("#patient_family_attributes_history").val("") : $("#patient_family_attributes_history").val(t.history.toString()), null == t.consanguinity ? $("#patient_family_attributes_consanguinity").val("") : $("#patient_family_attributes_consanguinity").val(t.consanguinity.toString()), $("#patient_family_attributes_num_het_mut_affected").val(t.num_het_mut_affected), $("#patient_family_attributes_num_hom_mut_affected").val(t.num_hom_mut_affected), $("#patient_family_attributes_num_hom_mut_unaffected").val(t.num_hom_mut_unaffected), $("#patient_family_attributes_num_het_mut_unaffected").val(t.num_het_mut_unaffected), $("#patient_family_attributes_num_wildtype_affected").val(t.num_wildtype_affected), $("#patient_family_attributes_num_wildtype_unaffected").val(t.num_wildtype_unaffected))
        }
    })
}

function reset_meta_analysis() {
    $("#mds_meta_analysis_form *").attr("disabled", !1).val(""), $("#create_new_meta_analysis_link").hide()
}

function force_reset() {
    $("input[type='checkbox']").removeAttr("checked"), $("input[type='reset']").blur()
}

function reload_the_filter(t) {
    var e = t.form.elements.fc, i = t.form.elements["mu[]"];
    if (t === e && t.form.elements.aao) t.form.elements.aao.value = '';
    //t.form.elements.aao && 3 != e.value && 4 != e.value && (t.form.elements.aao.disabled = !0), "" === e.value && (e.disabled = !0), "" === i.value && (i.disabled = !0), t.form.target = "_self", t.form.submit()
    t.form.submit()
}

function reload_table_Data_Filter(t) {
    // var e = t.form.elements.fc, i = t.form.elements["mu[]"];
    // if (t === e && t.form.elements.aao) t.form.elements.aao.value = '';
    //t.form.elements.aao && 3 != e.value && 4 != e.value && (t.form.elements.aao.disabled = !0), "" === e.value && (e.disabled = !0), "" === i.value && (i.disabled = !0), t.form.target = "_self", t.form.submit()
    t.form.submit()
}


function search_PubMed(t) {
    var e = function (t) {
        var e = t.innerHTML;
        $.ajax({
            url: "https://eutils.ncbi.nlm.nih.gov/entrez/eutils/esummary.fcgi",
            data: {db: "pubmed", id: e, retmode: "json", retmax: 1}
        }).done(function (i) {
            var n = i.result[e];
            if (n && !n.hasOwnProperty("error")) {
                var s = n.sortfirstauthor.split(" ")[0], o = n.sortpubdate.split("/")[0];
                t.innerHTML = s + ", " + o
            }
        })
    }, n = document.getElementsByClassName(t);
    for (i = 0; i < n.length; ++i) e(n[i])
}

function show_more_or_less(t, e) {
    _el = document.getElementById(e), _el.classList.contains("hide") ? t.innerHTML = t.innerHTML.replace("more (+", "less (-") : t.innerHTML = t.innerHTML.replace("less (-", "more (+"), _el.classList.toggle("hide")
}

!function (t, e) {
    "object" == typeof module && "object" == typeof module.exports ? module.exports = t.document ? e(t, !0) : function (t) {
        if (!t.document) throw new Error("jQuery requires a window with a document");
        return e(t)
    } : e(t)
}("undefined" != typeof window ? window : this, function (t, e) {
    function i(t) {
        var e = t.length, i = J.type(t);
        return "function" !== i && !J.isWindow(t) && (!(1 !== t.nodeType || !e) || ("array" === i || 0 === e || "number" == typeof e && e > 0 && e - 1 in t))
    }

    function n(t, e, i) {
        if (J.isFunction(e)) return J.grep(t, function (t, n) {
            return !!e.call(t, n, t) !== i
        });
        if (e.nodeType) return J.grep(t, function (t) {
            return t === e !== i
        });
        if ("string" == typeof e) {
            if (at.test(e)) return J.filter(e, t, i);
            e = J.filter(e, t)
        }
        return J.grep(t, function (t) {
            return G.call(e, t) >= 0 !== i
        })
    }

    function s(t, e) {
        for (; (t = t[e]) && 1 !== t.nodeType;) ;
        return t
    }

    function o(t) {
        var e = pt[t] = {};
        return J.each(t.match(ut) || [], function (t, i) {
            e[i] = !0
        }), e
    }

    function r() {
        Q.removeEventListener("DOMContentLoaded", r, !1), t.removeEventListener("load", r, !1), J.ready()
    }

    function a() {
        Object.defineProperty(this.cache = {}, 0, {
            get: function () {
                return {}
            }
        }), this.expando = J.expando + Math.random()
    }

    function l(t, e, i) {
        var n;
        if (void 0 === i && 1 === t.nodeType) if (n = "data-" + e.replace(_t, "-$1").toLowerCase(), "string" == typeof (i = t.getAttribute(n))) {
            try {
                i = "true" === i || "false" !== i && ("null" === i ? null : +i + "" === i ? +i : yt.test(i) ? J.parseJSON(i) : i)
            } catch (t) {
            }
            vt.set(t, e, i)
        } else i = void 0;
        return i
    }

    function h() {
        return !0
    }

    function c() {
        return !1
    }

    function d() {
        try {
            return Q.activeElement
        } catch (t) {
        }
    }

    function u(t, e) {
        return J.nodeName(t, "table") && J.nodeName(11 !== e.nodeType ? e : e.firstChild, "tr") ? t.getElementsByTagName("tbody")[0] || t.appendChild(t.ownerDocument.createElement("tbody")) : t
    }

    function p(t) {
        return t.type = (null !== t.getAttribute("type")) + "/" + t.type, t
    }

    function f(t) {
        var e = jt.exec(t.type);
        return e ? t.type = e[1] : t.removeAttribute("type"), t
    }

    function g(t, e) {
        for (var i = 0, n = t.length; n > i; i++) mt.set(t[i], "globalEval", !e || mt.get(e[i], "globalEval"))
    }

    function m(t, e) {
        var i, n, s, o, r, a, l, h;
        if (1 === e.nodeType) {
            if (mt.hasData(t) && (o = mt.access(t), r = mt.set(e, o), h = o.events)) {
                delete r.handle, r.events = {};
                for (s in h) for (i = 0, n = h[s].length; n > i; i++) J.event.add(e, s, h[s][i])
            }
            vt.hasData(t) && (a = vt.access(t), l = J.extend({}, a), vt.set(e, l))
        }
    }

    function v(t, e) {
        var i = t.getElementsByTagName ? t.getElementsByTagName(e || "*") : t.querySelectorAll ? t.querySelectorAll(e || "*") : [];
        return void 0 === e || e && J.nodeName(t, e) ? J.merge([t], i) : i
    }

    function y(t, e) {
        var i = e.nodeName.toLowerCase();
        "input" === i && kt.test(t.type) ? e.checked = t.checked : ("input" === i || "textarea" === i) && (e.defaultValue = t.defaultValue)
    }

    function _(e, i) {
        var n, s = J(i.createElement(e)).appendTo(i.body),
            o = t.getDefaultComputedStyle && (n = t.getDefaultComputedStyle(s[0])) ? n.display : J.css(s[0], "display");
        return s.detach(), o
    }

    function b(t) {
        var e = Q, i = Nt[t];
        return i || (i = _(t, e), "none" !== i && i || (Ht = (Ht || J("<iframe frameborder='0' width='0' height='0'/>")).appendTo(e.documentElement), e = Ht[0].contentDocument, e.write(), e.close(), i = _(t, e), Ht.detach()), Nt[t] = i), i
    }

    function x(t, e, i) {
        var n, s, o, r, a = t.style;
        return i = i || Bt(t), i && (r = i.getPropertyValue(e) || i[e]), i && ("" !== r || J.contains(t.ownerDocument, t) || (r = J.style(t, e)), Wt.test(r) && Rt.test(e) && (n = a.width, s = a.minWidth, o = a.maxWidth, a.minWidth = a.maxWidth = a.width = r, r = i.width, a.width = n, a.minWidth = s, a.maxWidth = o)), void 0 !== r ? r + "" : r
    }

    function w(t, e) {
        return {
            get: function () {
                return t() ? void delete this.get : (this.get = e).apply(this, arguments)
            }
        }
    }

    function k(t, e) {
        if (e in t) return e;
        for (var i = e[0].toUpperCase() + e.slice(1), n = e, s = Vt.length; s--;) if ((e = Vt[s] + i) in t) return e;
        return n
    }

    function C(t, e, i) {
        var n = qt.exec(e);
        return n ? Math.max(0, n[1] - (i || 0)) + (n[2] || "px") : e
    }

    function S(t, e, i, n, s) {
        for (var o = i === (n ? "border" : "content") ? 4 : "width" === e ? 1 : 0, r = 0; 4 > o; o += 2) "margin" === i && (r += J.css(t, i + xt[o], !0, s)), n ? ("content" === i && (r -= J.css(t, "padding" + xt[o], !0, s)), "margin" !== i && (r -= J.css(t, "border" + xt[o] + "Width", !0, s))) : (r += J.css(t, "padding" + xt[o], !0, s), "padding" !== i && (r += J.css(t, "border" + xt[o] + "Width", !0, s)));
        return r
    }

    function T(t, e, i) {
        var n = !0, s = "width" === e ? t.offsetWidth : t.offsetHeight, o = Bt(t),
            r = "border-box" === J.css(t, "boxSizing", !1, o);
        if (0 >= s || null == s) {
            if (s = x(t, e, o), (0 > s || null == s) && (s = t.style[e]), Wt.test(s)) return s;
            n = r && (Z.boxSizingReliable() || s === t.style[e]), s = parseFloat(s) || 0
        }
        return s + S(t, e, i || (r ? "border" : "content"), n, o) + "px"
    }

    function A(t, e) {
        for (var i, n, s, o = [], r = 0, a = t.length; a > r; r++) n = t[r], n.style && (o[r] = mt.get(n, "olddisplay"), i = n.style.display, e ? (o[r] || "none" !== i || (n.style.display = ""), "" === n.style.display && wt(n) && (o[r] = mt.access(n, "olddisplay", b(n.nodeName)))) : (s = wt(n), "none" === i && s || mt.set(n, "olddisplay", s ? i : J.css(n, "display"))));
        for (r = 0; a > r; r++) n = t[r], n.style && (e && "none" !== n.style.display && "" !== n.style.display || (n.style.display = e ? o[r] || "" : "none"));
        return t
    }

    function E(t, e, i, n, s) {
        return new E.prototype.init(t, e, i, n, s)
    }

    function L() {
        return setTimeout(function () {
            Ut = void 0
        }), Ut = J.now()
    }

    function M(t, e) {
        var i, n = 0, s = {height: t};
        for (e = e ? 1 : 0; 4 > n; n += 2 - e) i = xt[n], s["margin" + i] = s["padding" + i] = t;
        return e && (s.opacity = s.width = t), s
    }

    function D(t, e, i) {
        for (var n, s = (ee[e] || []).concat(ee["*"]), o = 0, r = s.length; r > o; o++) if (n = s[o].call(i, e, t)) return n
    }

    function P(t, e, i) {
        var n, s, o, r, a, l, h, c = this, d = {}, u = t.style, p = t.nodeType && wt(t), f = mt.get(t, "fxshow");
        i.queue || (a = J._queueHooks(t, "fx"), null == a.unqueued && (a.unqueued = 0, l = a.empty.fire, a.empty.fire = function () {
            a.unqueued || l()
        }), a.unqueued++, c.always(function () {
            c.always(function () {
                a.unqueued--, J.queue(t, "fx").length || a.empty.fire()
            })
        })), 1 === t.nodeType && ("height" in e || "width" in e) && (i.overflow = [u.overflow, u.overflowX, u.overflowY], h = J.css(t, "display"), "inline" === ("none" === h ? mt.get(t, "olddisplay") || b(t.nodeName) : h) && "none" === J.css(t, "float") && (u.display = "inline-block")), i.overflow && (u.overflow = "hidden", c.always(function () {
            u.overflow = i.overflow[0], u.overflowX = i.overflow[1], u.overflowY = i.overflow[2]
        }));
        for (n in e) if (s = e[n], Qt.exec(s)) {
            if (delete e[n], o = o || "toggle" === s, s === (p ? "hide" : "show")) {
                if ("show" !== s || !f || void 0 === f[n]) continue;
                p = !0
            }
            d[n] = f && f[n] || J.style(t, n)
        } else h = void 0;
        if (J.isEmptyObject(d)) "inline" === ("none" === h ? b(t.nodeName) : h) && (u.display = h); else {
            f ? "hidden" in f && (p = f.hidden) : f = mt.access(t, "fxshow", {}), o && (f.hidden = !p), p ? J(t).show() : c.done(function () {
                J(t).hide()
            }), c.done(function () {
                var e;
                mt.remove(t, "fxshow");
                for (e in d) J.style(t, e, d[e])
            });
            for (n in d) r = D(p ? f[n] : 0, n, c), n in f || (f[n] = r.start, p && (r.end = r.start, r.start = "width" === n || "height" === n ? 1 : 0))
        }
    }

    function F(t, e) {
        var i, n, s, o, r;
        for (i in t) if (n = J.camelCase(i), s = e[n], o = t[i], J.isArray(o) && (s = o[1], o = t[i] = o[0]), i !== n && (t[n] = o, delete t[i]), (r = J.cssHooks[n]) && "expand" in r) {
            o = r.expand(o), delete t[n];
            for (i in o) i in t || (t[i] = o[i], e[i] = s)
        } else e[n] = s
    }

    function I(t, e, i) {
        var n, s, o = 0, r = te.length, a = J.Deferred().always(function () {
            delete l.elem
        }), l = function () {
            if (s) return !1;
            for (var e = Ut || L(), i = Math.max(0, h.startTime + h.duration - e), n = i / h.duration || 0, o = 1 - n, r = 0, l = h.tweens.length; l > r; r++) h.tweens[r].run(o);
            return a.notifyWith(t, [h, o, i]), 1 > o && l ? i : (a.resolveWith(t, [h]), !1)
        }, h = a.promise({
            elem: t,
            props: J.extend({}, e),
            opts: J.extend(!0, {specialEasing: {}}, i),
            originalProperties: e,
            originalOptions: i,
            startTime: Ut || L(),
            duration: i.duration,
            tweens: [],
            createTween: function (e, i) {
                var n = J.Tween(t, h.opts, e, i, h.opts.specialEasing[e] || h.opts.easing);
                return h.tweens.push(n), n
            },
            stop: function (e) {
                var i = 0, n = e ? h.tweens.length : 0;
                if (s) return this;
                for (s = !0; n > i; i++) h.tweens[i].run(1);
                return e ? a.resolveWith(t, [h, e]) : a.rejectWith(t, [h, e]), this
            }
        }), c = h.props;
        for (F(c, h.opts.specialEasing); r > o; o++) if (n = te[o].call(h, t, c, h.opts)) return n;
        return J.map(c, D, h), J.isFunction(h.opts.start) && h.opts.start.call(t, h), J.fx.timer(J.extend(l, {
            elem: t,
            anim: h,
            queue: h.opts.queue
        })), h.progress(h.opts.progress).done(h.opts.done, h.opts.complete).fail(h.opts.fail).always(h.opts.always)
    }

    function j(t) {
        return function (e, i) {
            "string" != typeof e && (i = e, e = "*");
            var n, s = 0, o = e.toLowerCase().match(ut) || [];
            if (J.isFunction(i)) for (; n = o[s++];) "+" === n[0] ? (n = n.slice(1) || "*", (t[n] = t[n] || []).unshift(i)) : (t[n] = t[n] || []).push(i)
        }
    }

    function O(t, e, i, n) {
        function s(a) {
            var l;
            return o[a] = !0, J.each(t[a] || [], function (t, a) {
                var h = a(e, i, n);
                return "string" != typeof h || r || o[h] ? r ? !(l = h) : void 0 : (e.dataTypes.unshift(h), s(h), !1)
            }), l
        }

        var o = {}, r = t === be;
        return s(e.dataTypes[0]) || !o["*"] && s("*")
    }

    function z(t, e) {
        var i, n, s = J.ajaxSettings.flatOptions || {};
        for (i in e) void 0 !== e[i] && ((s[i] ? t : n || (n = {}))[i] = e[i]);
        return n && J.extend(!0, t, n), t
    }

    function H(t, e, i) {
        for (var n, s, o, r, a = t.contents, l = t.dataTypes; "*" === l[0];) l.shift(), void 0 === n && (n = t.mimeType || e.getResponseHeader("Content-Type"));
        if (n) for (s in a) if (a[s] && a[s].test(n)) {
            l.unshift(s);
            break
        }
        if (l[0] in i) o = l[0]; else {
            for (s in i) {
                if (!l[0] || t.converters[s + " " + l[0]]) {
                    o = s;
                    break
                }
                r || (r = s)
            }
            o = o || r
        }
        return o ? (o !== l[0] && l.unshift(o), i[o]) : void 0
    }

    function N(t, e, i, n) {
        var s, o, r, a, l, h = {}, c = t.dataTypes.slice();
        if (c[1]) for (r in t.converters) h[r.toLowerCase()] = t.converters[r];
        for (o = c.shift(); o;) if (t.responseFields[o] && (i[t.responseFields[o]] = e), !l && n && t.dataFilter && (e = t.dataFilter(e, t.dataType)), l = o, o = c.shift()) if ("*" === o) o = l; else if ("*" !== l && l !== o) {
            if (!(r = h[l + " " + o] || h["* " + o])) for (s in h) if (a = s.split(" "), a[1] === o && (r = h[l + " " + a[0]] || h["* " + a[0]])) {
                !0 === r ? r = h[s] : !0 !== h[s] && (o = a[0], c.unshift(a[1]));
                break
            }
            if (!0 !== r) if (r && t["throws"]) e = r(e); else try {
                e = r(e)
            } catch (t) {
                return {state: "parsererror", error: r ? t : "No conversion from " + l + " to " + o}
            }
        }
        return {state: "success", data: e}
    }

    function R(t, e, i, n) {
        var s;
        if (J.isArray(e)) J.each(e, function (e, s) {
            i || ke.test(t) ? n(t, s) : R(t + "[" + ("object" == typeof s ? e : "") + "]", s, i, n)
        }); else if (i || "object" !== J.type(e)) n(t, e); else for (s in e) R(t + "[" + s + "]", e[s], i, n)
    }

    function W(t) {
        return J.isWindow(t) ? t : 9 === t.nodeType && t.defaultView
    }

    var B = [], $ = B.slice, q = B.concat, X = B.push, G = B.indexOf, Y = {}, V = Y.toString, U = Y.hasOwnProperty,
        Z = {}, Q = t.document, K = "2.1.1", J = function (t, e) {
            return new J.fn.init(t, e)
        }, tt = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g, et = /^-ms-/, it = /-([\da-z])/gi, nt = function (t, e) {
            return e.toUpperCase()
        };
    J.fn = J.prototype = {
        jquery: K, constructor: J, selector: "", length: 0, toArray: function () {
            return $.call(this)
        }, get: function (t) {
            return null != t ? 0 > t ? this[t + this.length] : this[t] : $.call(this)
        }, pushStack: function (t) {
            var e = J.merge(this.constructor(), t);
            return e.prevObject = this, e.context = this.context, e
        }, each: function (t, e) {
            return J.each(this, t, e)
        }, map: function (t) {
            return this.pushStack(J.map(this, function (e, i) {
                return t.call(e, i, e)
            }))
        }, slice: function () {
            return this.pushStack($.apply(this, arguments))
        }, first: function () {
            return this.eq(0)
        }, last: function () {
            return this.eq(-1)
        }, eq: function (t) {
            var e = this.length, i = +t + (0 > t ? e : 0);
            return this.pushStack(i >= 0 && e > i ? [this[i]] : [])
        }, end: function () {
            return this.prevObject || this.constructor(null)
        }, push: X, sort: B.sort, splice: B.splice
    }, J.extend = J.fn.extend = function () {
        var t, e, i, n, s, o, r = arguments[0] || {}, a = 1, l = arguments.length, h = !1;
        for ("boolean" == typeof r && (h = r, r = arguments[a] || {}, a++), "object" == typeof r || J.isFunction(r) || (r = {}), a === l && (r = this, a--); l > a; a++) if (null != (t = arguments[a])) for (e in t) i = r[e], n = t[e], r !== n && (h && n && (J.isPlainObject(n) || (s = J.isArray(n))) ? (s ? (s = !1, o = i && J.isArray(i) ? i : []) : o = i && J.isPlainObject(i) ? i : {}, r[e] = J.extend(h, o, n)) : void 0 !== n && (r[e] = n));
        return r
    }, J.extend({
        expando: "jQuery" + (K + Math.random()).replace(/\D/g, ""), isReady: !0, error: function (t) {
            throw new Error(t)
        }, noop: function () {
        }, isFunction: function (t) {
            return "function" === J.type(t)
        }, isArray: Array.isArray, isWindow: function (t) {
            return null != t && t === t.window
        }, isNumeric: function (t) {
            return !J.isArray(t) && t - parseFloat(t) >= 0
        }, isPlainObject: function (t) {
            return "object" === J.type(t) && !t.nodeType && !J.isWindow(t) && !(t.constructor && !U.call(t.constructor.prototype, "isPrototypeOf"))
        }, isEmptyObject: function (t) {
            var e;
            for (e in t) return !1;
            return !0
        }, type: function (t) {
            return null == t ? t + "" : "object" == typeof t || "function" == typeof t ? Y[V.call(t)] || "object" : typeof t
        }, globalEval: function (t) {
            var e, i = eval;
            (t = J.trim(t)) && (1 === t.indexOf("use strict") ? (e = Q.createElement("script"), e.text = t, Q.head.appendChild(e).parentNode.removeChild(e)) : i(t))
        }, camelCase: function (t) {
            return t.replace(et, "ms-").replace(it, nt)
        }, nodeName: function (t, e) {
            return t.nodeName && t.nodeName.toLowerCase() === e.toLowerCase()
        }, each: function (t, e, n) {
            var s = 0, o = t.length, r = i(t);
            if (n) {
                if (r) for (; o > s && !1 !== e.apply(t[s], n); s++) ; else for (s in t) if (!1 === e.apply(t[s], n)) break
            } else if (r) for (; o > s && !1 !== e.call(t[s], s, t[s]); s++) ; else for (s in t) if (!1 === e.call(t[s], s, t[s])) break;
            return t
        }, trim: function (t) {
            return null == t ? "" : (t + "").replace(tt, "")
        }, makeArray: function (t, e) {
            var n = e || [];
            return null != t && (i(Object(t)) ? J.merge(n, "string" == typeof t ? [t] : t) : X.call(n, t)), n
        }, inArray: function (t, e, i) {
            return null == e ? -1 : G.call(e, t, i)
        }, merge: function (t, e) {
            for (var i = +e.length, n = 0, s = t.length; i > n; n++) t[s++] = e[n];
            return t.length = s, t
        }, grep: function (t, e, i) {
            for (var n = [], s = 0, o = t.length, r = !i; o > s; s++) !e(t[s], s) !== r && n.push(t[s]);
            return n
        }, map: function (t, e, n) {
            var s, o = 0, r = t.length, a = i(t), l = [];
            if (a) for (; r > o; o++) null != (s = e(t[o], o, n)) && l.push(s); else for (o in t) null != (s = e(t[o], o, n)) && l.push(s);
            return q.apply([], l)
        }, guid: 1, proxy: function (t, e) {
            var i, n, s;
            return "string" == typeof e && (i = t[e], e = t, t = i), J.isFunction(t) ? (n = $.call(arguments, 2), s = function () {
                return t.apply(e || this, n.concat($.call(arguments)))
            }, s.guid = t.guid = t.guid || J.guid++, s) : void 0
        }, now: Date.now, support: Z
    }), J.each("Boolean Number String Function Array Date RegExp Object Error".split(" "), function (t, e) {
        Y["[object " + e + "]"] = e.toLowerCase()
    });
    var st = function (t) {
        function e(t, e, i, n) {
            var s, o, r, a, l, h, d, p, f, g;
            if ((e ? e.ownerDocument || e : R) !== P && D(e), e = e || P, i = i || [], !t || "string" != typeof t) return i;
            if (1 !== (a = e.nodeType) && 9 !== a) return [];
            if (I && !n) {
                if (s = yt.exec(t)) if (r = s[1]) {
                    if (9 === a) {
                        if (!(o = e.getElementById(r)) || !o.parentNode) return i;
                        if (o.id === r) return i.push(o), i
                    } else if (e.ownerDocument && (o = e.ownerDocument.getElementById(r)) && H(e, o) && o.id === r) return i.push(o), i
                } else {
                    if (s[2]) return J.apply(i, e.getElementsByTagName(t)), i;
                    if ((r = s[3]) && x.getElementsByClassName && e.getElementsByClassName) return J.apply(i, e.getElementsByClassName(r)), i
                }
                if (x.qsa && (!j || !j.test(t))) {
                    if (p = d = N, f = e, g = 9 === a && t, 1 === a && "object" !== e.nodeName.toLowerCase()) {
                        for (h = S(t), (d = e.getAttribute("id")) ? p = d.replace(bt, "\\$&") : e.setAttribute("id", p), p = "[id='" + p + "'] ", l = h.length; l--;) h[l] = p + u(h[l]);
                        f = _t.test(t) && c(e.parentNode) || e, g = h.join(",")
                    }
                    if (g) try {
                        return J.apply(i, f.querySelectorAll(g)), i
                    } catch (t) {
                    } finally {
                        d || e.removeAttribute("id")
                    }
                }
            }
            return A(t.replace(lt, "$1"), e, i, n)
        }

        function i() {
            function t(i, n) {
                return e.push(i + " ") > w.cacheLength && delete t[e.shift()], t[i + " "] = n
            }

            var e = [];
            return t
        }

        function n(t) {
            return t[N] = !0, t
        }

        function s(t) {
            var e = P.createElement("div");
            try {
                return !!t(e)
            } catch (t) {
                return !1
            } finally {
                e.parentNode && e.parentNode.removeChild(e), e = null
            }
        }

        function o(t, e) {
            for (var i = t.split("|"), n = t.length; n--;) w.attrHandle[i[n]] = e
        }

        function r(t, e) {
            var i = e && t,
                n = i && 1 === t.nodeType && 1 === e.nodeType && (~e.sourceIndex || V) - (~t.sourceIndex || V);
            if (n) return n;
            if (i) for (; i = i.nextSibling;) if (i === e) return -1;
            return t ? 1 : -1
        }

        function a(t) {
            return function (e) {
                return "input" === e.nodeName.toLowerCase() && e.type === t
            }
        }

        function l(t) {
            return function (e) {
                var i = e.nodeName.toLowerCase();
                return ("input" === i || "button" === i) && e.type === t
            }
        }

        function h(t) {
            return n(function (e) {
                return e = +e, n(function (i, n) {
                    for (var s, o = t([], i.length, e), r = o.length; r--;) i[s = o[r]] && (i[s] = !(n[s] = i[s]))
                })
            })
        }

        function c(t) {
            return t && typeof t.getElementsByTagName !== Y && t
        }

        function d() {
        }

        function u(t) {
            for (var e = 0, i = t.length, n = ""; i > e; e++) n += t[e].value;
            return n
        }

        function p(t, e, i) {
            var n = e.dir, s = i && "parentNode" === n, o = B++;
            return e.first ? function (e, i, o) {
                for (; e = e[n];) if (1 === e.nodeType || s) return t(e, i, o)
            } : function (e, i, r) {
                var a, l, h = [W, o];
                if (r) {
                    for (; e = e[n];) if ((1 === e.nodeType || s) && t(e, i, r)) return !0
                } else for (; e = e[n];) if (1 === e.nodeType || s) {
                    if (l = e[N] || (e[N] = {}), (a = l[n]) && a[0] === W && a[1] === o) return h[2] = a[2];
                    if (l[n] = h, h[2] = t(e, i, r)) return !0
                }
            }
        }

        function f(t) {
            return t.length > 1 ? function (e, i, n) {
                for (var s = t.length; s--;) if (!t[s](e, i, n)) return !1;
                return !0
            } : t[0]
        }

        function g(t, i, n) {
            for (var s = 0, o = i.length; o > s; s++) e(t, i[s], n);
            return n
        }

        function m(t, e, i, n, s) {
            for (var o, r = [], a = 0, l = t.length, h = null != e; l > a; a++) (o = t[a]) && (!i || i(o, n, s)) && (r.push(o), h && e.push(a));
            return r
        }

        function v(t, e, i, s, o, r) {
            return s && !s[N] && (s = v(s)), o && !o[N] && (o = v(o, r)), n(function (n, r, a, l) {
                var h, c, d, u = [], p = [], f = r.length, v = n || g(e || "*", a.nodeType ? [a] : a, []),
                    y = !t || !n && e ? v : m(v, u, t, a, l), _ = i ? o || (n ? t : f || s) ? [] : r : y;
                if (i && i(y, _, a, l), s) for (h = m(_, p), s(h, [], a, l), c = h.length; c--;) (d = h[c]) && (_[p[c]] = !(y[p[c]] = d));
                if (n) {
                    if (o || t) {
                        if (o) {
                            for (h = [], c = _.length; c--;) (d = _[c]) && h.push(y[c] = d);
                            o(null, _ = [], h, l)
                        }
                        for (c = _.length; c--;) (d = _[c]) && (h = o ? et.call(n, d) : u[c]) > -1 && (n[h] = !(r[h] = d))
                    }
                } else _ = m(_ === r ? _.splice(f, _.length) : _), o ? o(null, r, _, l) : J.apply(r, _)
            })
        }

        function y(t) {
            for (var e, i, n, s = t.length, o = w.relative[t[0].type], r = o || w.relative[" "], a = o ? 1 : 0, l = p(function (t) {
                return t === e
            }, r, !0), h = p(function (t) {
                return et.call(e, t) > -1
            }, r, !0), c = [function (t, i, n) {
                return !o && (n || i !== E) || ((e = i).nodeType ? l(t, i, n) : h(t, i, n))
            }]; s > a; a++) if (i = w.relative[t[a].type]) c = [p(f(c), i)]; else {
                if (i = w.filter[t[a].type].apply(null, t[a].matches), i[N]) {
                    for (n = ++a; s > n && !w.relative[t[n].type]; n++) ;
                    return v(a > 1 && f(c), a > 1 && u(t.slice(0, a - 1).concat({value: " " === t[a - 2].type ? "*" : ""})).replace(lt, "$1"), i, n > a && y(t.slice(a, n)), s > n && y(t = t.slice(n)), s > n && u(t))
                }
                c.push(i)
            }
            return f(c)
        }

        function _(t, i) {
            var s = i.length > 0, o = t.length > 0, r = function (n, r, a, l, h) {
                var c, d, u, p = 0, f = "0", g = n && [], v = [], y = E, _ = n || o && w.find.TAG("*", h),
                    b = W += null == y ? 1 : Math.random() || .1, x = _.length;
                for (h && (E = r !== P && r); f !== x && null != (c = _[f]); f++) {
                    if (o && c) {
                        for (d = 0; u = t[d++];) if (u(c, r, a)) {
                            l.push(c);
                            break
                        }
                        h && (W = b)
                    }
                    s && ((c = !u && c) && p--, n && g.push(c))
                }
                if (p += f, s && f !== p) {
                    for (d = 0; u = i[d++];) u(g, v, r, a);
                    if (n) {
                        if (p > 0) for (; f--;) g[f] || v[f] || (v[f] = Q.call(l));
                        v = m(v)
                    }
                    J.apply(l, v), h && !n && v.length > 0 && p + i.length > 1 && e.uniqueSort(l)
                }
                return h && (W = b, E = y), g
            };
            return s ? n(r) : r
        }

        var b, x, w, k, C, S, T, A, E, L, M, D, P, F, I, j, O, z, H, N = "sizzle" + -new Date, R = t.document, W = 0,
            B = 0, $ = i(), q = i(), X = i(), G = function (t, e) {
                return t === e && (M = !0), 0
            }, Y = "undefined", V = 1 << 31, U = {}.hasOwnProperty, Z = [], Q = Z.pop, K = Z.push, J = Z.push, tt = Z.slice,
            et = Z.indexOf || function (t) {
                for (var e = 0, i = this.length; i > e; e++) if (this[e] === t) return e;
                return -1
            },
            it = "checked|selected|async|autofocus|autoplay|controls|defer|disabled|hidden|ismap|loop|multiple|open|readonly|required|scoped",
            nt = "[\\x20\\t\\r\\n\\f]", st = "(?:\\\\.|[\\w-]|[^\\x00-\\xa0])+", ot = st.replace("w", "w#"),
            rt = "\\[" + nt + "*(" + st + ")(?:" + nt + "*([*^$|!~]?=)" + nt + "*(?:'((?:\\\\.|[^\\\\'])*)'|\"((?:\\\\.|[^\\\\\"])*)\"|(" + ot + "))|)" + nt + "*\\]",
            at = ":(" + st + ")(?:\\((('((?:\\\\.|[^\\\\'])*)'|\"((?:\\\\.|[^\\\\\"])*)\")|((?:\\\\.|[^\\\\()[\\]]|" + rt + ")*)|.*)\\)|)",
            lt = new RegExp("^" + nt + "+|((?:^|[^\\\\])(?:\\\\.)*)" + nt + "+$", "g"),
            ht = new RegExp("^" + nt + "*," + nt + "*"), ct = new RegExp("^" + nt + "*([>+~]|" + nt + ")" + nt + "*"),
            dt = new RegExp("=" + nt + "*([^\\]'\"]*?)" + nt + "*\\]", "g"), ut = new RegExp(at),
            pt = new RegExp("^" + ot + "$"), ft = {
                ID: new RegExp("^#(" + st + ")"),
                CLASS: new RegExp("^\\.(" + st + ")"),
                TAG: new RegExp("^(" + st.replace("w", "w*") + ")"),
                ATTR: new RegExp("^" + rt),
                PSEUDO: new RegExp("^" + at),
                CHILD: new RegExp("^:(only|first|last|nth|nth-last)-(child|of-type)(?:\\(" + nt + "*(even|odd|(([+-]|)(\\d*)n|)" + nt + "*(?:([+-]|)" + nt + "*(\\d+)|))" + nt + "*\\)|)", "i"),
                bool: new RegExp("^(?:" + it + ")$", "i"),
                needsContext: new RegExp("^" + nt + "*[>+~]|:(even|odd|eq|gt|lt|nth|first|last)(?:\\(" + nt + "*((?:-\\d)?\\d*)" + nt + "*\\)|)(?=[^-]|$)", "i")
            }, gt = /^(?:input|select|textarea|button)$/i, mt = /^h\d$/i, vt = /^[^{]+\{\s*\[native \w/,
            yt = /^(?:#([\w-]+)|(\w+)|\.([\w-]+))$/, _t = /[+~]/, bt = /'|\\/g,
            xt = new RegExp("\\\\([\\da-f]{1,6}" + nt + "?|(" + nt + ")|.)", "ig"), wt = function (t, e, i) {
                var n = "0x" + e - 65536;
                return n !== n || i ? e : 0 > n ? String.fromCharCode(n + 65536) : String.fromCharCode(n >> 10 | 55296, 1023 & n | 56320)
            };
        try {
            J.apply(Z = tt.call(R.childNodes), R.childNodes), Z[R.childNodes.length].nodeType
        } catch (t) {
            J = {
                apply: Z.length ? function (t, e) {
                    K.apply(t, tt.call(e))
                } : function (t, e) {
                    for (var i = t.length, n = 0; t[i++] = e[n++];) ;
                    t.length = i - 1
                }
            }
        }
        x = e.support = {}, C = e.isXML = function (t) {
            var e = t && (t.ownerDocument || t).documentElement;
            return !!e && "HTML" !== e.nodeName
        }, D = e.setDocument = function (t) {
            var e, i = t ? t.ownerDocument || t : R, n = i.defaultView;
            return i !== P && 9 === i.nodeType && i.documentElement ? (P = i, F = i.documentElement, I = !C(i), n && n !== n.top && (n.addEventListener ? n.addEventListener("unload", function () {
                D()
            }, !1) : n.attachEvent && n.attachEvent("onunload", function () {
                D()
            })), x.attributes = s(function (t) {
                return t.className = "i", !t.getAttribute("className")
            }), x.getElementsByTagName = s(function (t) {
                return t.appendChild(i.createComment("")), !t.getElementsByTagName("*").length
            }), x.getElementsByClassName = vt.test(i.getElementsByClassName) && s(function (t) {
                return t.innerHTML = "<div class='a'></div><div class='a i'></div>", t.firstChild.className = "i", 2 === t.getElementsByClassName("i").length
            }), x.getById = s(function (t) {
                return F.appendChild(t).id = N, !i.getElementsByName || !i.getElementsByName(N).length
            }), x.getById ? (w.find.ID = function (t, e) {
                if (typeof e.getElementById !== Y && I) {
                    var i = e.getElementById(t);
                    return i && i.parentNode ? [i] : []
                }
            }, w.filter.ID = function (t) {
                var e = t.replace(xt, wt);
                return function (t) {
                    return t.getAttribute("id") === e
                }
            }) : (delete w.find.ID, w.filter.ID = function (t) {
                var e = t.replace(xt, wt);
                return function (t) {
                    var i = typeof t.getAttributeNode !== Y && t.getAttributeNode("id");
                    return i && i.value === e
                }
            }), w.find.TAG = x.getElementsByTagName ? function (t, e) {
                return typeof e.getElementsByTagName !== Y ? e.getElementsByTagName(t) : void 0
            } : function (t, e) {
                var i, n = [], s = 0, o = e.getElementsByTagName(t);
                if ("*" === t) {
                    for (; i = o[s++];) 1 === i.nodeType && n.push(i);
                    return n
                }
                return o
            }, w.find.CLASS = x.getElementsByClassName && function (t, e) {
                return typeof e.getElementsByClassName !== Y && I ? e.getElementsByClassName(t) : void 0
            }, O = [], j = [], (x.qsa = vt.test(i.querySelectorAll)) && (s(function (t) {
                t.innerHTML = "<select msallowclip=''><option selected=''></option></select>", t.querySelectorAll("[msallowclip^='']").length && j.push("[*^$]=" + nt + "*(?:''|\"\")"), t.querySelectorAll("[selected]").length || j.push("\\[" + nt + "*(?:value|" + it + ")"), t.querySelectorAll(":checked").length || j.push(":checked")
            }), s(function (t) {
                var e = i.createElement("input");
                e.setAttribute("type", "hidden"), t.appendChild(e).setAttribute("name", "D"), t.querySelectorAll("[name=d]").length && j.push("name" + nt + "*[*^$|!~]?="), t.querySelectorAll(":enabled").length || j.push(":enabled", ":disabled"), t.querySelectorAll("*,:x"), j.push(",.*:")
            })), (x.matchesSelector = vt.test(z = F.matches || F.webkitMatchesSelector || F.mozMatchesSelector || F.oMatchesSelector || F.msMatchesSelector)) && s(function (t) {
                x.disconnectedMatch = z.call(t, "div"), z.call(t, "[s!='']:x"), O.push("!=", at)
            }), j = j.length && new RegExp(j.join("|")), O = O.length && new RegExp(O.join("|")), e = vt.test(F.compareDocumentPosition), H = e || vt.test(F.contains) ? function (t, e) {
                var i = 9 === t.nodeType ? t.documentElement : t, n = e && e.parentNode;
                return t === n || !(!n || 1 !== n.nodeType || !(i.contains ? i.contains(n) : t.compareDocumentPosition && 16 & t.compareDocumentPosition(n)))
            } : function (t, e) {
                if (e) for (; e = e.parentNode;) if (e === t) return !0;
                return !1
            }, G = e ? function (t, e) {
                if (t === e) return M = !0, 0;
                var n = !t.compareDocumentPosition - !e.compareDocumentPosition;
                return n || (n = (t.ownerDocument || t) === (e.ownerDocument || e) ? t.compareDocumentPosition(e) : 1, 1 & n || !x.sortDetached && e.compareDocumentPosition(t) === n ? t === i || t.ownerDocument === R && H(R, t) ? -1 : e === i || e.ownerDocument === R && H(R, e) ? 1 : L ? et.call(L, t) - et.call(L, e) : 0 : 4 & n ? -1 : 1)
            } : function (t, e) {
                if (t === e) return M = !0, 0;
                var n, s = 0, o = t.parentNode, a = e.parentNode, l = [t], h = [e];
                if (!o || !a) return t === i ? -1 : e === i ? 1 : o ? -1 : a ? 1 : L ? et.call(L, t) - et.call(L, e) : 0;
                if (o === a) return r(t, e);
                for (n = t; n = n.parentNode;) l.unshift(n);
                for (n = e; n = n.parentNode;) h.unshift(n);
                for (; l[s] === h[s];) s++;
                return s ? r(l[s], h[s]) : l[s] === R ? -1 : h[s] === R ? 1 : 0
            }, i) : P
        }, e.matches = function (t, i) {
            return e(t, null, null, i)
        }, e.matchesSelector = function (t, i) {
            if ((t.ownerDocument || t) !== P && D(t), i = i.replace(dt, "='$1']"), !(!x.matchesSelector || !I || O && O.test(i) || j && j.test(i))) try {
                var n = z.call(t, i);
                if (n || x.disconnectedMatch || t.document && 11 !== t.document.nodeType) return n
            } catch (t) {
            }
            return e(i, P, null, [t]).length > 0
        }, e.contains = function (t, e) {
            return (t.ownerDocument || t) !== P && D(t), H(t, e)
        }, e.attr = function (t, e) {
            (t.ownerDocument || t) !== P && D(t);
            var i = w.attrHandle[e.toLowerCase()],
                n = i && U.call(w.attrHandle, e.toLowerCase()) ? i(t, e, !I) : void 0;
            return void 0 !== n ? n : x.attributes || !I ? t.getAttribute(e) : (n = t.getAttributeNode(e)) && n.specified ? n.value : null
        }, e.error = function (t) {
            throw new Error("Syntax error, unrecognized expression: " + t)
        }, e.uniqueSort = function (t) {
            var e, i = [], n = 0, s = 0;
            if (M = !x.detectDuplicates, L = !x.sortStable && t.slice(0), t.sort(G), M) {
                for (; e = t[s++];) e === t[s] && (n = i.push(s));
                for (; n--;) t.splice(i[n], 1)
            }
            return L = null, t
        }, k = e.getText = function (t) {
            var e, i = "", n = 0, s = t.nodeType;
            if (s) {
                if (1 === s || 9 === s || 11 === s) {
                    if ("string" == typeof t.textContent) return t.textContent;
                    for (t = t.firstChild; t; t = t.nextSibling) i += k(t)
                } else if (3 === s || 4 === s) return t.nodeValue
            } else for (; e = t[n++];) i += k(e);
            return i
        }, w = e.selectors = {
            cacheLength: 50,
            createPseudo: n,
            match: ft,
            attrHandle: {},
            find: {},
            relative: {
                ">": {dir: "parentNode", first: !0},
                " ": {dir: "parentNode"},
                "+": {dir: "previousSibling", first: !0},
                "~": {dir: "previousSibling"}
            },
            preFilter: {
                ATTR: function (t) {
                    return t[1] = t[1].replace(xt, wt), t[3] = (t[3] || t[4] || t[5] || "").replace(xt, wt), "~=" === t[2] && (t[3] = " " + t[3] + " "), t.slice(0, 4)
                }, CHILD: function (t) {
                    return t[1] = t[1].toLowerCase(), "nth" === t[1].slice(0, 3) ? (t[3] || e.error(t[0]), t[4] = +(t[4] ? t[5] + (t[6] || 1) : 2 * ("even" === t[3] || "odd" === t[3])), t[5] = +(t[7] + t[8] || "odd" === t[3])) : t[3] && e.error(t[0]), t
                }, PSEUDO: function (t) {
                    var e, i = !t[6] && t[2];
                    return ft.CHILD.test(t[0]) ? null : (t[3] ? t[2] = t[4] || t[5] || "" : i && ut.test(i) && (e = S(i, !0)) && (e = i.indexOf(")", i.length - e) - i.length) && (t[0] = t[0].slice(0, e), t[2] = i.slice(0, e)), t.slice(0, 3))
                }
            },
            filter: {
                TAG: function (t) {
                    var e = t.replace(xt, wt).toLowerCase();
                    return "*" === t ? function () {
                        return !0
                    } : function (t) {
                        return t.nodeName && t.nodeName.toLowerCase() === e
                    }
                }, CLASS: function (t) {
                    var e = $[t + " "];
                    return e || (e = new RegExp("(^|" + nt + ")" + t + "(" + nt + "|$)")) && $(t, function (t) {
                        return e.test("string" == typeof t.className && t.className || typeof t.getAttribute !== Y && t.getAttribute("class") || "")
                    })
                }, ATTR: function (t, i, n) {
                    return function (s) {
                        var o = e.attr(s, t);
                        return null == o ? "!=" === i : !i || (o += "", "=" === i ? o === n : "!=" === i ? o !== n : "^=" === i ? n && 0 === o.indexOf(n) : "*=" === i ? n && o.indexOf(n) > -1 : "$=" === i ? n && o.slice(-n.length) === n : "~=" === i ? (" " + o + " ").indexOf(n) > -1 : "|=" === i && (o === n || o.slice(0, n.length + 1) === n + "-"))
                    }
                }, CHILD: function (t, e, i, n, s) {
                    var o = "nth" !== t.slice(0, 3), r = "last" !== t.slice(-4), a = "of-type" === e;
                    return 1 === n && 0 === s ? function (t) {
                        return !!t.parentNode
                    } : function (e, i, l) {
                        var h, c, d, u, p, f, g = o !== r ? "nextSibling" : "previousSibling", m = e.parentNode,
                            v = a && e.nodeName.toLowerCase(), y = !l && !a;
                        if (m) {
                            if (o) {
                                for (; g;) {
                                    for (d = e; d = d[g];) if (a ? d.nodeName.toLowerCase() === v : 1 === d.nodeType) return !1;
                                    f = g = "only" === t && !f && "nextSibling"
                                }
                                return !0
                            }
                            if (f = [r ? m.firstChild : m.lastChild], r && y) {
                                for (c = m[N] || (m[N] = {}), h = c[t] || [], p = h[0] === W && h[1], u = h[0] === W && h[2], d = p && m.childNodes[p]; d = ++p && d && d[g] || (u = p = 0) || f.pop();) if (1 === d.nodeType && ++u && d === e) {
                                    c[t] = [W, p, u];
                                    break
                                }
                            } else if (y && (h = (e[N] || (e[N] = {}))[t]) && h[0] === W) u = h[1]; else for (; (d = ++p && d && d[g] || (u = p = 0) || f.pop()) && ((a ? d.nodeName.toLowerCase() !== v : 1 !== d.nodeType) || !++u || (y && ((d[N] || (d[N] = {}))[t] = [W, u]), d !== e));) ;
                            return (u -= s) === n || u % n == 0 && u / n >= 0
                        }
                    }
                }, PSEUDO: function (t, i) {
                    var s, o = w.pseudos[t] || w.setFilters[t.toLowerCase()] || e.error("unsupported pseudo: " + t);
                    return o[N] ? o(i) : o.length > 1 ? (s = [t, t, "", i], w.setFilters.hasOwnProperty(t.toLowerCase()) ? n(function (t, e) {
                        for (var n, s = o(t, i), r = s.length; r--;) n = et.call(t, s[r]), t[n] = !(e[n] = s[r])
                    }) : function (t) {
                        return o(t, 0, s)
                    }) : o
                }
            },
            pseudos: {
                not: n(function (t) {
                    var e = [], i = [], s = T(t.replace(lt, "$1"));
                    return s[N] ? n(function (t, e, i, n) {
                        for (var o, r = s(t, null, n, []), a = t.length; a--;) (o = r[a]) && (t[a] = !(e[a] = o))
                    }) : function (t, n, o) {
                        return e[0] = t, s(e, null, o, i), !i.pop()
                    }
                }), has: n(function (t) {
                    return function (i) {
                        return e(t, i).length > 0
                    }
                }), contains: n(function (t) {
                    return function (e) {
                        return (e.textContent || e.innerText || k(e)).indexOf(t) > -1
                    }
                }), lang: n(function (t) {
                    return pt.test(t || "") || e.error("unsupported lang: " + t), t = t.replace(xt, wt).toLowerCase(), function (e) {
                        var i;
                        do {
                            if (i = I ? e.lang : e.getAttribute("xml:lang") || e.getAttribute("lang")) return (i = i.toLowerCase()) === t || 0 === i.indexOf(t + "-")
                        } while ((e = e.parentNode) && 1 === e.nodeType);
                        return !1
                    }
                }), target: function (e) {
                    var i = t.location && t.location.hash;
                    return i && i.slice(1) === e.id
                }, root: function (t) {
                    return t === F
                }, focus: function (t) {
                    return t === P.activeElement && (!P.hasFocus || P.hasFocus()) && !!(t.type || t.href || ~t.tabIndex)
                }, enabled: function (t) {
                    return !1 === t.disabled
                }, disabled: function (t) {
                    return !0 === t.disabled
                }, checked: function (t) {
                    var e = t.nodeName.toLowerCase();
                    return "input" === e && !!t.checked || "option" === e && !!t.selected
                }, selected: function (t) {
                    return t.parentNode && t.parentNode.selectedIndex, !0 === t.selected
                }, empty: function (t) {
                    for (t = t.firstChild; t; t = t.nextSibling) if (t.nodeType < 6) return !1;
                    return !0
                }, parent: function (t) {
                    return !w.pseudos.empty(t)
                },
                header: function (t) {
                    return mt.test(t.nodeName)
                }, input: function (t) {
                    return gt.test(t.nodeName)
                }, button: function (t) {
                    var e = t.nodeName.toLowerCase();
                    return "input" === e && "button" === t.type || "button" === e
                }, text: function (t) {
                    var e;
                    return "input" === t.nodeName.toLowerCase() && "text" === t.type && (null == (e = t.getAttribute("type")) || "text" === e.toLowerCase())
                }, first: h(function () {
                    return [0]
                }), last: h(function (t, e) {
                    return [e - 1]
                }), eq: h(function (t, e, i) {
                    return [0 > i ? i + e : i]
                }), even: h(function (t, e) {
                    for (var i = 0; e > i; i += 2) t.push(i);
                    return t
                }), odd: h(function (t, e) {
                    for (var i = 1; e > i; i += 2) t.push(i);
                    return t
                }), lt: h(function (t, e, i) {
                    for (var n = 0 > i ? i + e : i; --n >= 0;) t.push(n);
                    return t
                }), gt: h(function (t, e, i) {
                    for (var n = 0 > i ? i + e : i; ++n < e;) t.push(n);
                    return t
                })
            }
        }, w.pseudos.nth = w.pseudos.eq;
        for (b in {radio: !0, checkbox: !0, file: !0, password: !0, image: !0}) w.pseudos[b] = a(b);
        for (b in {submit: !0, reset: !0}) w.pseudos[b] = l(b);
        return d.prototype = w.filters = w.pseudos, w.setFilters = new d, S = e.tokenize = function (t, i) {
            var n, s, o, r, a, l, h, c = q[t + " "];
            if (c) return i ? 0 : c.slice(0);
            for (a = t, l = [], h = w.preFilter; a;) {
                (!n || (s = ht.exec(a))) && (s && (a = a.slice(s[0].length) || a), l.push(o = [])), n = !1, (s = ct.exec(a)) && (n = s.shift(), o.push({
                    value: n,
                    type: s[0].replace(lt, " ")
                }), a = a.slice(n.length));
                for (r in w.filter) !(s = ft[r].exec(a)) || h[r] && !(s = h[r](s)) || (n = s.shift(), o.push({
                    value: n,
                    type: r,
                    matches: s
                }), a = a.slice(n.length));
                if (!n) break
            }
            return i ? a.length : a ? e.error(t) : q(t, l).slice(0)
        }, T = e.compile = function (t, e) {
            var i, n = [], s = [], o = X[t + " "];
            if (!o) {
                for (e || (e = S(t)), i = e.length; i--;) o = y(e[i]), o[N] ? n.push(o) : s.push(o);
                o = X(t, _(s, n)), o.selector = t
            }
            return o
        }, A = e.select = function (t, e, i, n) {
            var s, o, r, a, l, h = "function" == typeof t && t, d = !n && S(t = h.selector || t);
            if (i = i || [], 1 === d.length) {
                if (o = d[0] = d[0].slice(0), o.length > 2 && "ID" === (r = o[0]).type && x.getById && 9 === e.nodeType && I && w.relative[o[1].type]) {
                    if (!(e = (w.find.ID(r.matches[0].replace(xt, wt), e) || [])[0])) return i;
                    h && (e = e.parentNode), t = t.slice(o.shift().value.length)
                }
                for (s = ft.needsContext.test(t) ? 0 : o.length; s-- && (r = o[s], !w.relative[a = r.type]);) if ((l = w.find[a]) && (n = l(r.matches[0].replace(xt, wt), _t.test(o[0].type) && c(e.parentNode) || e))) {
                    if (o.splice(s, 1), !(t = n.length && u(o))) return J.apply(i, n), i;
                    break
                }
            }
            return (h || T(t, d))(n, e, !I, i, _t.test(t) && c(e.parentNode) || e), i
        }, x.sortStable = N.split("").sort(G).join("") === N, x.detectDuplicates = !!M, D(), x.sortDetached = s(function (t) {
            return 1 & t.compareDocumentPosition(P.createElement("div"))
        }), s(function (t) {
            return t.innerHTML = "<a href='#'></a>", "#" === t.firstChild.getAttribute("href")
        }) || o("type|href|height|width", function (t, e, i) {
            return i ? void 0 : t.getAttribute(e, "type" === e.toLowerCase() ? 1 : 2)
        }), x.attributes && s(function (t) {
            return t.innerHTML = "<input/>", t.firstChild.setAttribute("value", ""), "" === t.firstChild.getAttribute("value")
        }) || o("value", function (t, e, i) {
            return i || "input" !== t.nodeName.toLowerCase() ? void 0 : t.defaultValue
        }), s(function (t) {
            return null == t.getAttribute("disabled")
        }) || o(it, function (t, e, i) {
            var n;
            return i ? void 0 : !0 === t[e] ? e.toLowerCase() : (n = t.getAttributeNode(e)) && n.specified ? n.value : null
        }), e
    }(t);
    J.find = st, J.expr = st.selectors, J.expr[":"] = J.expr.pseudos, J.unique = st.uniqueSort, J.text = st.getText, J.isXMLDoc = st.isXML, J.contains = st.contains;
    var ot = J.expr.match.needsContext, rt = /^<(\w+)\s*\/?>(?:<\/\1>|)$/, at = /^.[^:#\[\.,]*$/;
    J.filter = function (t, e, i) {
        var n = e[0];
        return i && (t = ":not(" + t + ")"), 1 === e.length && 1 === n.nodeType ? J.find.matchesSelector(n, t) ? [n] : [] : J.find.matches(t, J.grep(e, function (t) {
            return 1 === t.nodeType
        }))
    }, J.fn.extend({
        find: function (t) {
            var e, i = this.length, n = [], s = this;
            if ("string" != typeof t) return this.pushStack(J(t).filter(function () {
                for (e = 0; i > e; e++) if (J.contains(s[e], this)) return !0
            }));
            for (e = 0; i > e; e++) J.find(t, s[e], n);
            return n = this.pushStack(i > 1 ? J.unique(n) : n), n.selector = this.selector ? this.selector + " " + t : t, n
        }, filter: function (t) {
            return this.pushStack(n(this, t || [], !1))
        }, not: function (t) {
            return this.pushStack(n(this, t || [], !0))
        }, is: function (t) {
            return !!n(this, "string" == typeof t && ot.test(t) ? J(t) : t || [], !1).length
        }
    });
    var lt, ht = /^(?:\s*(<[\w\W]+>)[^>]*|#([\w-]*))$/;
    (J.fn.init = function (t, e) {
        var i, n;
        if (!t) return this;
        if ("string" == typeof t) {
            if (!(i = "<" === t[0] && ">" === t[t.length - 1] && t.length >= 3 ? [null, t, null] : ht.exec(t)) || !i[1] && e) return !e || e.jquery ? (e || lt).find(t) : this.constructor(e).find(t);
            if (i[1]) {
                if (e = e instanceof J ? e[0] : e, J.merge(this, J.parseHTML(i[1], e && e.nodeType ? e.ownerDocument || e : Q, !0)), rt.test(i[1]) && J.isPlainObject(e)) for (i in e) J.isFunction(this[i]) ? this[i](e[i]) : this.attr(i, e[i]);
                return this
            }
            return n = Q.getElementById(i[2]), n && n.parentNode && (this.length = 1, this[0] = n), this.context = Q, this.selector = t, this
        }
        return t.nodeType ? (this.context = this[0] = t, this.length = 1, this) : J.isFunction(t) ? "undefined" != typeof lt.ready ? lt.ready(t) : t(J) : (void 0 !== t.selector && (this.selector = t.selector, this.context = t.context), J.makeArray(t, this))
    }).prototype = J.fn, lt = J(Q);
    var ct = /^(?:parents|prev(?:Until|All))/, dt = {children: !0, contents: !0, next: !0, prev: !0};
    J.extend({
        dir: function (t, e, i) {
            for (var n = [], s = void 0 !== i; (t = t[e]) && 9 !== t.nodeType;) if (1 === t.nodeType) {
                if (s && J(t).is(i)) break;
                n.push(t)
            }
            return n
        }, sibling: function (t, e) {
            for (var i = []; t; t = t.nextSibling) 1 === t.nodeType && t !== e && i.push(t);
            return i
        }
    }), J.fn.extend({
        has: function (t) {
            var e = J(t, this), i = e.length;
            return this.filter(function () {
                for (var t = 0; i > t; t++) if (J.contains(this, e[t])) return !0
            })
        }, closest: function (t, e) {
            for (var i, n = 0, s = this.length, o = [], r = ot.test(t) || "string" != typeof t ? J(t, e || this.context) : 0; s > n; n++) for (i = this[n]; i && i !== e; i = i.parentNode) if (i.nodeType < 11 && (r ? r.index(i) > -1 : 1 === i.nodeType && J.find.matchesSelector(i, t))) {
                o.push(i);
                break
            }
            return this.pushStack(o.length > 1 ? J.unique(o) : o)
        }, index: function (t) {
            return t ? "string" == typeof t ? G.call(J(t), this[0]) : G.call(this, t.jquery ? t[0] : t) : this[0] && this[0].parentNode ? this.first().prevAll().length : -1
        }, add: function (t, e) {
            return this.pushStack(J.unique(J.merge(this.get(), J(t, e))))
        }, addBack: function (t) {
            return this.add(null == t ? this.prevObject : this.prevObject.filter(t))
        }
    }), J.each({
        parent: function (t) {
            var e = t.parentNode;
            return e && 11 !== e.nodeType ? e : null
        }, parents: function (t) {
            return J.dir(t, "parentNode")
        }, parentsUntil: function (t, e, i) {
            return J.dir(t, "parentNode", i)
        }, next: function (t) {
            return s(t, "nextSibling")
        }, prev: function (t) {
            return s(t, "previousSibling")
        }, nextAll: function (t) {
            return J.dir(t, "nextSibling")
        }, prevAll: function (t) {
            return J.dir(t, "previousSibling")
        }, nextUntil: function (t, e, i) {
            return J.dir(t, "nextSibling", i)
        }, prevUntil: function (t, e, i) {
            return J.dir(t, "previousSibling", i)
        }, siblings: function (t) {
            return J.sibling((t.parentNode || {}).firstChild, t)
        }, children: function (t) {
            return J.sibling(t.firstChild)
        }, contents: function (t) {
            return t.contentDocument || J.merge([], t.childNodes)
        }
    }, function (t, e) {
        J.fn[t] = function (i, n) {
            var s = J.map(this, e, i);
            return "Until" !== t.slice(-5) && (n = i), n && "string" == typeof n && (s = J.filter(n, s)), this.length > 1 && (dt[t] || J.unique(s), ct.test(t) && s.reverse()), this.pushStack(s)
        }
    });
    var ut = /\S+/g, pt = {};
    J.Callbacks = function (t) {
        t = "string" == typeof t ? pt[t] || o(t) : J.extend({}, t);
        var e, i, n, s, r, a, l = [], h = !t.once && [], c = function (o) {
            for (e = t.memory && o, i = !0, a = s || 0, s = 0, r = l.length, n = !0; l && r > a; a++) if (!1 === l[a].apply(o[0], o[1]) && t.stopOnFalse) {
                e = !1;
                break
            }
            n = !1, l && (h ? h.length && c(h.shift()) : e ? l = [] : d.disable())
        }, d = {
            add: function () {
                if (l) {
                    var i = l.length;
                    !function e(i) {
                        J.each(i, function (i, n) {
                            var s = J.type(n);
                            "function" === s ? t.unique && d.has(n) || l.push(n) : n && n.length && "string" !== s && e(n)
                        })
                    }(arguments), n ? r = l.length : e && (s = i, c(e))
                }
                return this
            }, remove: function () {
                return l && J.each(arguments, function (t, e) {
                    for (var i; (i = J.inArray(e, l, i)) > -1;) l.splice(i, 1), n && (r >= i && r--, a >= i && a--)
                }), this
            }, has: function (t) {
                return t ? J.inArray(t, l) > -1 : !(!l || !l.length)
            }, empty: function () {
                return l = [], r = 0, this
            }, disable: function () {
                return l = h = e = void 0, this
            }, disabled: function () {
                return !l
            }, lock: function () {
                return h = void 0, e || d.disable(), this
            }, locked: function () {
                return !h
            }, fireWith: function (t, e) {
                return !l || i && !h || (e = e || [], e = [t, e.slice ? e.slice() : e], n ? h.push(e) : c(e)), this
            }, fire: function () {
                return d.fireWith(this, arguments), this
            }, fired: function () {
                return !!i
            }
        };
        return d
    }, J.extend({
        Deferred: function (t) {
            var e = [["resolve", "done", J.Callbacks("once memory"), "resolved"], ["reject", "fail", J.Callbacks("once memory"), "rejected"], ["notify", "progress", J.Callbacks("memory")]],
                i = "pending", n = {
                    state: function () {
                        return i
                    }, always: function () {
                        return s.done(arguments).fail(arguments), this
                    }, then: function () {
                        var t = arguments;
                        return J.Deferred(function (i) {
                            J.each(e, function (e, o) {
                                var r = J.isFunction(t[e]) && t[e];
                                s[o[1]](function () {
                                    var t = r && r.apply(this, arguments);
                                    t && J.isFunction(t.promise) ? t.promise().done(i.resolve).fail(i.reject).progress(i.notify) : i[o[0] + "With"](this === n ? i.promise() : this, r ? [t] : arguments)
                                })
                            }), t = null
                        }).promise()
                    }, promise: function (t) {
                        return null != t ? J.extend(t, n) : n
                    }
                }, s = {};
            return n.pipe = n.then, J.each(e, function (t, o) {
                var r = o[2], a = o[3];
                n[o[1]] = r.add, a && r.add(function () {
                    i = a
                }, e[1 ^ t][2].disable, e[2][2].lock), s[o[0]] = function () {
                    return s[o[0] + "With"](this === s ? n : this, arguments), this
                }, s[o[0] + "With"] = r.fireWith
            }), n.promise(s), t && t.call(s, s), s
        }, when: function (t) {
            var e, i, n, s = 0, o = $.call(arguments), r = o.length,
                a = 1 !== r || t && J.isFunction(t.promise) ? r : 0, l = 1 === a ? t : J.Deferred(),
                h = function (t, i, n) {
                    return function (s) {
                        i[t] = this, n[t] = arguments.length > 1 ? $.call(arguments) : s, n === e ? l.notifyWith(i, n) : --a || l.resolveWith(i, n)
                    }
                };
            if (r > 1) for (e = new Array(r), i = new Array(r), n = new Array(r); r > s; s++) o[s] && J.isFunction(o[s].promise) ? o[s].promise().done(h(s, n, o)).fail(l.reject).progress(h(s, i, e)) : --a;
            return a || l.resolveWith(n, o), l.promise()
        }
    });
    var ft;
    J.fn.ready = function (t) {
        return J.ready.promise().done(t), this
    }, J.extend({
        isReady: !1, readyWait: 1, holdReady: function (t) {
            t ? J.readyWait++ : J.ready(!0)
        }, ready: function (t) {
            (!0 === t ? --J.readyWait : J.isReady) || (J.isReady = !0, !0 !== t && --J.readyWait > 0 || (ft.resolveWith(Q, [J]), J.fn.triggerHandler && (J(Q).triggerHandler("ready"), J(Q).off("ready"))))
        }
    }), J.ready.promise = function (e) {
        return ft || (ft = J.Deferred(), "complete" === Q.readyState ? setTimeout(J.ready) : (Q.addEventListener("DOMContentLoaded", r, !1), t.addEventListener("load", r, !1))), ft.promise(e)
    }, J.ready.promise();
    var gt = J.access = function (t, e, i, n, s, o, r) {
        var a = 0, l = t.length, h = null == i;
        if ("object" === J.type(i)) {
            s = !0;
            for (a in i) J.access(t, e, a, i[a], !0, o, r)
        } else if (void 0 !== n && (s = !0, J.isFunction(n) || (r = !0), h && (r ? (e.call(t, n), e = null) : (h = e, e = function (t, e, i) {
            return h.call(J(t), i)
        })), e)) for (; l > a; a++) e(t[a], i, r ? n : n.call(t[a], a, e(t[a], i)));
        return s ? t : h ? e.call(t) : l ? e(t[0], i) : o
    };
    J.acceptData = function (t) {
        return 1 === t.nodeType || 9 === t.nodeType || !+t.nodeType
    }, a.uid = 1, a.accepts = J.acceptData, a.prototype = {
        key: function (t) {
            if (!a.accepts(t)) return 0;
            var e = {}, i = t[this.expando];
            if (!i) {
                i = a.uid++;
                try {
                    e[this.expando] = {value: i}, Object.defineProperties(t, e)
                } catch (n) {
                    e[this.expando] = i, J.extend(t, e)
                }
            }
            return this.cache[i] || (this.cache[i] = {}), i
        }, set: function (t, e, i) {
            var n, s = this.key(t), o = this.cache[s];
            if ("string" == typeof e) o[e] = i; else if (J.isEmptyObject(o)) J.extend(this.cache[s], e); else for (n in e) o[n] = e[n];
            return o
        }, get: function (t, e) {
            var i = this.cache[this.key(t)];
            return void 0 === e ? i : i[e]
        }, access: function (t, e, i) {
            var n;
            return void 0 === e || e && "string" == typeof e && void 0 === i ? (n = this.get(t, e), void 0 !== n ? n : this.get(t, J.camelCase(e))) : (this.set(t, e, i), void 0 !== i ? i : e)
        }, remove: function (t, e) {
            var i, n, s, o = this.key(t), r = this.cache[o];
            if (void 0 === e) this.cache[o] = {}; else {
                J.isArray(e) ? n = e.concat(e.map(J.camelCase)) : (s = J.camelCase(e), e in r ? n = [e, s] : (n = s, n = n in r ? [n] : n.match(ut) || [])), i = n.length;
                for (; i--;) delete r[n[i]]
            }
        }, hasData: function (t) {
            return !J.isEmptyObject(this.cache[t[this.expando]] || {})
        }, discard: function (t) {
            t[this.expando] && delete this.cache[t[this.expando]]
        }
    };
    var mt = new a, vt = new a, yt = /^(?:\{[\w\W]*\}|\[[\w\W]*\])$/, _t = /([A-Z])/g;
    J.extend({
        hasData: function (t) {
            return vt.hasData(t) || mt.hasData(t)
        }, data: function (t, e, i) {
            return vt.access(t, e, i)
        }, removeData: function (t, e) {
            vt.remove(t, e)
        }, _data: function (t, e, i) {
            return mt.access(t, e, i)
        }, _removeData: function (t, e) {
            mt.remove(t, e)
        }
    }), J.fn.extend({
        data: function (t, e) {
            var i, n, s, o = this[0], r = o && o.attributes;
            if (void 0 === t) {
                if (this.length && (s = vt.get(o), 1 === o.nodeType && !mt.get(o, "hasDataAttrs"))) {
                    for (i = r.length; i--;) r[i] && (n = r[i].name, 0 === n.indexOf("data-") && (n = J.camelCase(n.slice(5)), l(o, n, s[n])));
                    mt.set(o, "hasDataAttrs", !0)
                }
                return s
            }
            return "object" == typeof t ? this.each(function () {
                vt.set(this, t)
            }) : gt(this, function (e) {
                var i, n = J.camelCase(t);
                if (o && void 0 === e) {
                    if (void 0 !== (i = vt.get(o, t))) return i;
                    if (void 0 !== (i = vt.get(o, n))) return i;
                    if (void 0 !== (i = l(o, n, void 0))) return i
                } else this.each(function () {
                    var i = vt.get(this, n);
                    vt.set(this, n, e), -1 !== t.indexOf("-") && void 0 !== i && vt.set(this, t, e)
                })
            }, null, e, arguments.length > 1, null, !0)
        }, removeData: function (t) {
            return this.each(function () {
                vt.remove(this, t)
            })
        }
    }), J.extend({
        queue: function (t, e, i) {
            var n;
            return t ? (e = (e || "fx") + "queue", n = mt.get(t, e), i && (!n || J.isArray(i) ? n = mt.access(t, e, J.makeArray(i)) : n.push(i)), n || []) : void 0
        }, dequeue: function (t, e) {
            e = e || "fx";
            var i = J.queue(t, e), n = i.length, s = i.shift(), o = J._queueHooks(t, e), r = function () {
                J.dequeue(t, e)
            };
            "inprogress" === s && (s = i.shift(), n--), s && ("fx" === e && i.unshift("inprogress"), delete o.stop, s.call(t, r, o)), !n && o && o.empty.fire()
        }, _queueHooks: function (t, e) {
            var i = e + "queueHooks";
            return mt.get(t, i) || mt.access(t, i, {
                empty: J.Callbacks("once memory").add(function () {
                    mt.remove(t, [e + "queue", i])
                })
            })
        }
    }), J.fn.extend({
        queue: function (t, e) {
            var i = 2;
            return "string" != typeof t && (e = t, t = "fx", i--), arguments.length < i ? J.queue(this[0], t) : void 0 === e ? this : this.each(function () {
                var i = J.queue(this, t, e);
                J._queueHooks(this, t), "fx" === t && "inprogress" !== i[0] && J.dequeue(this, t)
            })
        }, dequeue: function (t) {
            return this.each(function () {
                J.dequeue(this, t)
            })
        }, clearQueue: function (t) {
            return this.queue(t || "fx", [])
        }, promise: function (t, e) {
            var i, n = 1, s = J.Deferred(), o = this, r = this.length, a = function () {
                --n || s.resolveWith(o, [o])
            };
            for ("string" != typeof t && (e = t, t = void 0), t = t || "fx"; r--;) (i = mt.get(o[r], t + "queueHooks")) && i.empty && (n++, i.empty.add(a));
            return a(), s.promise(e)
        }
    });
    var bt = /[+-]?(?:\d*\.|)\d+(?:[eE][+-]?\d+|)/.source, xt = ["Top", "Right", "Bottom", "Left"],
        wt = function (t, e) {
            return t = e || t, "none" === J.css(t, "display") || !J.contains(t.ownerDocument, t)
        }, kt = /^(?:checkbox|radio)$/i;
    !function () {
        var t = Q.createDocumentFragment(), e = t.appendChild(Q.createElement("div")), i = Q.createElement("input");
        i.setAttribute("type", "radio"), i.setAttribute("checked", "checked"), i.setAttribute("name", "t"), e.appendChild(i), Z.checkClone = e.cloneNode(!0).cloneNode(!0).lastChild.checked, e.innerHTML = "<textarea>x</textarea>", Z.noCloneChecked = !!e.cloneNode(!0).lastChild.defaultValue
    }();
    var Ct = "undefined";
    Z.focusinBubbles = "onfocusin" in t;
    var St = /^key/, Tt = /^(?:mouse|pointer|contextmenu)|click/, At = /^(?:focusinfocus|focusoutblur)$/,
        Et = /^([^.]*)(?:\.(.+)|)$/;
    J.event = {
        global: {},
        add: function (t, e, i, n, s) {
            var o, r, a, l, h, c, d, u, p, f, g, m = mt.get(t);
            if (m) for (i.handler && (o = i, i = o.handler, s = o.selector), i.guid || (i.guid = J.guid++), (l = m.events) || (l = m.events = {}), (r = m.handle) || (r = m.handle = function (e) {
                return typeof J !== Ct && J.event.triggered !== e.type ? J.event.dispatch.apply(t, arguments) : void 0
            }), e = (e || "").match(ut) || [""], h = e.length; h--;) a = Et.exec(e[h]) || [], p = g = a[1], f = (a[2] || "").split(".").sort(), p && (d = J.event.special[p] || {}, p = (s ? d.delegateType : d.bindType) || p, d = J.event.special[p] || {}, c = J.extend({
                type: p,
                origType: g,
                data: n,
                handler: i,
                guid: i.guid,
                selector: s,
                needsContext: s && J.expr.match.needsContext.test(s),
                namespace: f.join(".")
            }, o), (u = l[p]) || (u = l[p] = [], u.delegateCount = 0, d.setup && !1 !== d.setup.call(t, n, f, r) || t.addEventListener && t.addEventListener(p, r, !1)), d.add && (d.add.call(t, c), c.handler.guid || (c.handler.guid = i.guid)), s ? u.splice(u.delegateCount++, 0, c) : u.push(c), J.event.global[p] = !0)
        },
        remove: function (t, e, i, n, s) {
            var o, r, a, l, h, c, d, u, p, f, g, m = mt.hasData(t) && mt.get(t);
            if (m && (l = m.events)) {
                for (e = (e || "").match(ut) || [""], h = e.length; h--;) if (a = Et.exec(e[h]) || [], p = g = a[1], f = (a[2] || "").split(".").sort(), p) {
                    for (d = J.event.special[p] || {}, p = (n ? d.delegateType : d.bindType) || p, u = l[p] || [], a = a[2] && new RegExp("(^|\\.)" + f.join("\\.(?:.*\\.|)") + "(\\.|$)"), r = o = u.length; o--;) c = u[o], !s && g !== c.origType || i && i.guid !== c.guid || a && !a.test(c.namespace) || n && n !== c.selector && ("**" !== n || !c.selector) || (u.splice(o, 1), c.selector && u.delegateCount--, d.remove && d.remove.call(t, c));
                    r && !u.length && (d.teardown && !1 !== d.teardown.call(t, f, m.handle) || J.removeEvent(t, p, m.handle), delete l[p])
                } else for (p in l) J.event.remove(t, p + e[h], i, n, !0);
                J.isEmptyObject(l) && (delete m.handle, mt.remove(t, "events"))
            }
        },
        trigger: function (e, i, n, s) {
            var o, r, a, l, h, c, d, u = [n || Q], p = U.call(e, "type") ? e.type : e,
                f = U.call(e, "namespace") ? e.namespace.split(".") : [];
            if (r = a = n = n || Q, 3 !== n.nodeType && 8 !== n.nodeType && !At.test(p + J.event.triggered) && (p.indexOf(".") >= 0 && (f = p.split("."), p = f.shift(), f.sort()), h = p.indexOf(":") < 0 && "on" + p, e = e[J.expando] ? e : new J.Event(p, "object" == typeof e && e), e.isTrigger = s ? 2 : 3, e.namespace = f.join("."), e.namespace_re = e.namespace ? new RegExp("(^|\\.)" + f.join("\\.(?:.*\\.|)") + "(\\.|$)") : null, e.result = void 0, e.target || (e.target = n), i = null == i ? [e] : J.makeArray(i, [e]), d = J.event.special[p] || {}, s || !d.trigger || !1 !== d.trigger.apply(n, i))) {
                if (!s && !d.noBubble && !J.isWindow(n)) {
                    for (l = d.delegateType || p, At.test(l + p) || (r = r.parentNode); r; r = r.parentNode) u.push(r), a = r;
                    a === (n.ownerDocument || Q) && u.push(a.defaultView || a.parentWindow || t)
                }
                for (o = 0; (r = u[o++]) && !e.isPropagationStopped();) e.type = o > 1 ? l : d.bindType || p, c = (mt.get(r, "events") || {})[e.type] && mt.get(r, "handle"), c && c.apply(r, i), (c = h && r[h]) && c.apply && J.acceptData(r) && (e.result = c.apply(r, i), !1 === e.result && e.preventDefault());
                return e.type = p, s || e.isDefaultPrevented() || d._default && !1 !== d._default.apply(u.pop(), i) || !J.acceptData(n) || h && J.isFunction(n[p]) && !J.isWindow(n) && (a = n[h], a && (n[h] = null), J.event.triggered = p, n[p](), J.event.triggered = void 0, a && (n[h] = a)), e.result
            }
        },
        dispatch: function (t) {
            t = J.event.fix(t);
            var e, i, n, s, o, r = [], a = $.call(arguments), l = (mt.get(this, "events") || {})[t.type] || [],
                h = J.event.special[t.type] || {};
            if (a[0] = t, t.delegateTarget = this, !h.preDispatch || !1 !== h.preDispatch.call(this, t)) {
                for (r = J.event.handlers.call(this, t, l), e = 0; (s = r[e++]) && !t.isPropagationStopped();) for (t.currentTarget = s.elem, i = 0; (o = s.handlers[i++]) && !t.isImmediatePropagationStopped();) (!t.namespace_re || t.namespace_re.test(o.namespace)) && (t.handleObj = o, t.data = o.data, void 0 !== (n = ((J.event.special[o.origType] || {}).handle || o.handler).apply(s.elem, a)) && !1 === (t.result = n) && (t.preventDefault(), t.stopPropagation()));
                return h.postDispatch && h.postDispatch.call(this, t), t.result
            }
        },
        handlers: function (t, e) {
            var i, n, s, o, r = [], a = e.delegateCount, l = t.target;
            if (a && l.nodeType && (!t.button || "click" !== t.type)) for (; l !== this; l = l.parentNode || this) if (!0 !== l.disabled || "click" !== t.type) {
                for (n = [], i = 0; a > i; i++) o = e[i], s = o.selector + " ", void 0 === n[s] && (n[s] = o.needsContext ? J(s, this).index(l) >= 0 : J.find(s, this, null, [l]).length), n[s] && n.push(o);
                n.length && r.push({elem: l, handlers: n})
            }
            return a < e.length && r.push({elem: this, handlers: e.slice(a)}), r
        },
        props: "altKey bubbles cancelable ctrlKey currentTarget eventPhase metaKey relatedTarget shiftKey target timeStamp view which".split(" "),
        fixHooks: {},
        keyHooks: {
            props: "char charCode key keyCode".split(" "), filter: function (t, e) {
                return null == t.which && (t.which = null != e.charCode ? e.charCode : e.keyCode), t
            }
        },
        mouseHooks: {
            props: "button buttons clientX clientY offsetX offsetY pageX pageY screenX screenY toElement".split(" "),
            filter: function (t, e) {
                var i, n, s, o = e.button;
                return null == t.pageX && null != e.clientX && (i = t.target.ownerDocument || Q, n = i.documentElement, s = i.body, t.pageX = e.clientX + (n && n.scrollLeft || s && s.scrollLeft || 0) - (n && n.clientLeft || s && s.clientLeft || 0), t.pageY = e.clientY + (n && n.scrollTop || s && s.scrollTop || 0) - (n && n.clientTop || s && s.clientTop || 0)), t.which || void 0 === o || (t.which = 1 & o ? 1 : 2 & o ? 3 : 4 & o ? 2 : 0), t
            }
        },
        fix: function (t) {
            if (t[J.expando]) return t;
            var e, i, n, s = t.type, o = t, r = this.fixHooks[s];
            for (r || (this.fixHooks[s] = r = Tt.test(s) ? this.mouseHooks : St.test(s) ? this.keyHooks : {}), n = r.props ? this.props.concat(r.props) : this.props, t = new J.Event(o), e = n.length; e--;) i = n[e], t[i] = o[i];
            return t.target || (t.target = Q), 3 === t.target.nodeType && (t.target = t.target.parentNode), r.filter ? r.filter(t, o) : t
        },
        special: {
            load: {noBubble: !0}, focus: {
                trigger: function () {
                    return this !== d() && this.focus ? (this.focus(), !1) : void 0
                }, delegateType: "focusin"
            }, blur: {
                trigger: function () {
                    return this === d() && this.blur ? (this.blur(), !1) : void 0
                }, delegateType: "focusout"
            }, click: {
                trigger: function () {
                    return "checkbox" === this.type && this.click && J.nodeName(this, "input") ? (this.click(), !1) : void 0
                }, _default: function (t) {
                    return J.nodeName(t.target, "a")
                }
            }, beforeunload: {
                postDispatch: function (t) {
                    void 0 !== t.result && t.originalEvent && (t.originalEvent.returnValue = t.result)
                }
            }
        },
        simulate: function (t, e, i, n) {
            var s = J.extend(new J.Event, i, {type: t, isSimulated: !0, originalEvent: {}});
            n ? J.event.trigger(s, null, e) : J.event.dispatch.call(e, s), s.isDefaultPrevented() && i.preventDefault()
        }
    }, J.removeEvent = function (t, e, i) {
        t.removeEventListener && t.removeEventListener(e, i, !1)
    }, J.Event = function (t, e) {
        return this instanceof J.Event ? (t && t.type ? (this.originalEvent = t, this.type = t.type, this.isDefaultPrevented = t.defaultPrevented || void 0 === t.defaultPrevented && !1 === t.returnValue ? h : c) : this.type = t, e && J.extend(this, e), this.timeStamp = t && t.timeStamp || J.now(), void (this[J.expando] = !0)) : new J.Event(t, e)
    }, J.Event.prototype = {
        isDefaultPrevented: c,
        isPropagationStopped: c,
        isImmediatePropagationStopped: c,
        preventDefault: function () {
            var t = this.originalEvent;
            this.isDefaultPrevented = h, t && t.preventDefault && t.preventDefault()
        },
        stopPropagation: function () {
            var t = this.originalEvent;
            this.isPropagationStopped = h, t && t.stopPropagation && t.stopPropagation()
        },
        stopImmediatePropagation: function () {
            var t = this.originalEvent;
            this.isImmediatePropagationStopped = h, t && t.stopImmediatePropagation && t.stopImmediatePropagation(), this.stopPropagation()
        }
    }, J.each({
        mouseenter: "mouseover",
        mouseleave: "mouseout",
        pointerenter: "pointerover",
        pointerleave: "pointerout"
    }, function (t, e) {
        J.event.special[t] = {
            delegateType: e, bindType: e, handle: function (t) {
                var i, n = this, s = t.relatedTarget, o = t.handleObj;
                return (!s || s !== n && !J.contains(n, s)) && (t.type = o.origType, i = o.handler.apply(this, arguments), t.type = e), i
            }
        }
    }), Z.focusinBubbles || J.each({focus: "focusin", blur: "focusout"}, function (t, e) {
        var i = function (t) {
            J.event.simulate(e, t.target, J.event.fix(t), !0)
        };
        J.event.special[e] = {
            setup: function () {
                var n = this.ownerDocument || this, s = mt.access(n, e);
                s || n.addEventListener(t, i, !0), mt.access(n, e, (s || 0) + 1)
            }, teardown: function () {
                var n = this.ownerDocument || this, s = mt.access(n, e) - 1;
                s ? mt.access(n, e, s) : (n.removeEventListener(t, i, !0), mt.remove(n, e))
            }
        }
    }), J.fn.extend({
        on: function (t, e, i, n, s) {
            var o, r;
            if ("object" == typeof t) {
                "string" != typeof e && (i = i || e, e = void 0);
                for (r in t) this.on(r, e, i, t[r], s);
                return this
            }
            if (null == i && null == n ? (n = e, i = e = void 0) : null == n && ("string" == typeof e ? (n = i, i = void 0) : (n = i, i = e, e = void 0)), !1 === n) n = c; else if (!n) return this;
            return 1 === s && (o = n, n = function (t) {
                return J().off(t), o.apply(this, arguments)
            }, n.guid = o.guid || (o.guid = J.guid++)), this.each(function () {
                J.event.add(this, t, n, i, e)
            })
        }, one: function (t, e, i, n) {
            return this.on(t, e, i, n, 1)
        }, off: function (t, e, i) {
            var n, s;
            if (t && t.preventDefault && t.handleObj) return n = t.handleObj, J(t.delegateTarget).off(n.namespace ? n.origType + "." + n.namespace : n.origType, n.selector, n.handler), this;
            if ("object" == typeof t) {
                for (s in t) this.off(s, e, t[s]);
                return this
            }
            return (!1 === e || "function" == typeof e) && (i = e, e = void 0), !1 === i && (i = c), this.each(function () {
                J.event.remove(this, t, i, e)
            })
        }, trigger: function (t, e) {
            return this.each(function () {
                J.event.trigger(t, e, this)
            })
        }, triggerHandler: function (t, e) {
            var i = this[0];
            return i ? J.event.trigger(t, e, i, !0) : void 0
        }
    });
    var Lt = /<(?!area|br|col|embed|hr|img|input|link|meta|param)(([\w:]+)[^>]*)\/>/gi, Mt = /<([\w:]+)/,
        Dt = /<|&#?\w+;/, Pt = /<(?:script|style|link)/i, Ft = /checked\s*(?:[^=]|=\s*.checked.)/i,
        It = /^$|\/(?:java|ecma)script/i, jt = /^true\/(.*)/, Ot = /^\s*<!(?:\[CDATA\[|--)|(?:\]\]|--)>\s*$/g, zt = {
            option: [1, "<select multiple='multiple'>", "</select>"],
            thead: [1, "<table>", "</table>"],
            col: [2, "<table><colgroup>", "</colgroup></table>"],
            tr: [2, "<table><tbody>", "</tbody></table>"],
            td: [3, "<table><tbody><tr>", "</tr></tbody></table>"],
            _default: [0, "", ""]
        };
    zt.optgroup = zt.option, zt.tbody = zt.tfoot = zt.colgroup = zt.caption = zt.thead, zt.th = zt.td, J.extend({
        clone: function (t, e, i) {
            var n, s, o, r, a = t.cloneNode(!0), l = J.contains(t.ownerDocument, t);
            if (!(Z.noCloneChecked || 1 !== t.nodeType && 11 !== t.nodeType || J.isXMLDoc(t))) for (r = v(a), o = v(t), n = 0, s = o.length; s > n; n++) y(o[n], r[n]);
            if (e) if (i) for (o = o || v(t), r = r || v(a), n = 0, s = o.length; s > n; n++) m(o[n], r[n]); else m(t, a);
            return r = v(a, "script"), r.length > 0 && g(r, !l && v(t, "script")), a
        }, buildFragment: function (t, e, i, n) {
            for (var s, o, r, a, l, h, c = e.createDocumentFragment(), d = [], u = 0, p = t.length; p > u; u++) if ((s = t[u]) || 0 === s) if ("object" === J.type(s)) J.merge(d, s.nodeType ? [s] : s); else if (Dt.test(s)) {
                for (o = o || c.appendChild(e.createElement("div")), r = (Mt.exec(s) || ["", ""])[1].toLowerCase(), a = zt[r] || zt._default, o.innerHTML = a[1] + s.replace(Lt, "<$1></$2>") + a[2], h = a[0]; h--;) o = o.lastChild;
                J.merge(d, o.childNodes), o = c.firstChild, o.textContent = ""
            } else d.push(e.createTextNode(s));
            for (c.textContent = "", u = 0; s = d[u++];) if ((!n || -1 === J.inArray(s, n)) && (l = J.contains(s.ownerDocument, s), o = v(c.appendChild(s), "script"), l && g(o), i)) for (h = 0; s = o[h++];) It.test(s.type || "") && i.push(s);
            return c
        }, cleanData: function (t) {
            for (var e, i, n, s, o = J.event.special, r = 0; void 0 !== (i = t[r]); r++) {
                if (J.acceptData(i) && (s = i[mt.expando]) && (e = mt.cache[s])) {
                    if (e.events) for (n in e.events) o[n] ? J.event.remove(i, n) : J.removeEvent(i, n, e.handle);
                    mt.cache[s] && delete mt.cache[s]
                }
                delete vt.cache[i[vt.expando]]
            }
        }
    }), J.fn.extend({
        text: function (t) {
            return gt(this, function (t) {
                return void 0 === t ? J.text(this) : this.empty().each(function () {
                    (1 === this.nodeType || 11 === this.nodeType || 9 === this.nodeType) && (this.textContent = t)
                })
            }, null, t, arguments.length)
        }, append: function () {
            return this.domManip(arguments, function (t) {
                if (1 === this.nodeType || 11 === this.nodeType || 9 === this.nodeType) {
                    u(this, t).appendChild(t)
                }
            })
        }, prepend: function () {
            return this.domManip(arguments, function (t) {
                if (1 === this.nodeType || 11 === this.nodeType || 9 === this.nodeType) {
                    var e = u(this, t);
                    e.insertBefore(t, e.firstChild)
                }
            })
        }, before: function () {
            return this.domManip(arguments, function (t) {
                this.parentNode && this.parentNode.insertBefore(t, this)
            })
        }, after: function () {
            return this.domManip(arguments, function (t) {
                this.parentNode && this.parentNode.insertBefore(t, this.nextSibling)
            })
        }, remove: function (t, e) {
            for (var i, n = t ? J.filter(t, this) : this, s = 0; null != (i = n[s]); s++) e || 1 !== i.nodeType || J.cleanData(v(i)), i.parentNode && (e && J.contains(i.ownerDocument, i) && g(v(i, "script")), i.parentNode.removeChild(i));
            return this
        }, empty: function () {
            for (var t, e = 0; null != (t = this[e]); e++) 1 === t.nodeType && (J.cleanData(v(t, !1)), t.textContent = "");
            return this
        }, clone: function (t, e) {
            return t = null != t && t, e = null == e ? t : e, this.map(function () {
                return J.clone(this, t, e)
            })
        }, html: function (t) {
            return gt(this, function (t) {
                var e = this[0] || {}, i = 0, n = this.length;
                if (void 0 === t && 1 === e.nodeType) return e.innerHTML;
                if ("string" == typeof t && !Pt.test(t) && !zt[(Mt.exec(t) || ["", ""])[1].toLowerCase()]) {
                    t = t.replace(Lt, "<$1></$2>");
                    try {
                        for (; n > i; i++) e = this[i] || {}, 1 === e.nodeType && (J.cleanData(v(e, !1)), e.innerHTML = t);
                        e = 0
                    } catch (t) {
                    }
                }
                e && this.empty().append(t)
            }, null, t, arguments.length)
        }, replaceWith: function () {
            var t = arguments[0];
            return this.domManip(arguments, function (e) {
                t = this.parentNode, J.cleanData(v(this)), t && t.replaceChild(e, this)
            }), t && (t.length || t.nodeType) ? this : this.remove()
        }, detach: function (t) {
            return this.remove(t, !0)
        }, domManip: function (t, e) {
            t = q.apply([], t);
            var i, n, s, o, r, a, l = 0, h = this.length, c = this, d = h - 1, u = t[0], g = J.isFunction(u);
            if (g || h > 1 && "string" == typeof u && !Z.checkClone && Ft.test(u)) return this.each(function (i) {
                var n = c.eq(i);
                g && (t[0] = u.call(this, i, n.html())), n.domManip(t, e)
            });
            if (h && (i = J.buildFragment(t, this[0].ownerDocument, !1, this), n = i.firstChild, 1 === i.childNodes.length && (i = n), n)) {
                for (s = J.map(v(i, "script"), p), o = s.length; h > l; l++) r = i, l !== d && (r = J.clone(r, !0, !0), o && J.merge(s, v(r, "script"))), e.call(this[l], r, l);
                if (o) for (a = s[s.length - 1].ownerDocument, J.map(s, f), l = 0; o > l; l++) r = s[l], It.test(r.type || "") && !mt.access(r, "globalEval") && J.contains(a, r) && (r.src ? J._evalUrl && J._evalUrl(r.src) : J.globalEval(r.textContent.replace(Ot, "")))
            }
            return this
        }
    }), J.each({
        appendTo: "append",
        prependTo: "prepend",
        insertBefore: "before",
        insertAfter: "after",
        replaceAll: "replaceWith"
    }, function (t, e) {
        J.fn[t] = function (t) {
            for (var i, n = [], s = J(t), o = s.length - 1, r = 0; o >= r; r++) i = r === o ? this : this.clone(!0), J(s[r])[e](i), X.apply(n, i.get());
            return this.pushStack(n)
        }
    });
    var Ht, Nt = {}, Rt = /^margin/, Wt = new RegExp("^(" + bt + ")(?!px)[a-z%]+$", "i"), Bt = function (t) {
        return t.ownerDocument.defaultView.getComputedStyle(t, null)
    };
    !function () {
        function e() {
            r.style.cssText = "-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box;display:block;margin-top:1%;top:1%;border:1px;padding:1px;width:4px;position:absolute", r.innerHTML = "", s.appendChild(o);
            var e = t.getComputedStyle(r, null);
            i = "1%" !== e.top, n = "4px" === e.width, s.removeChild(o)
        }

        var i, n, s = Q.documentElement, o = Q.createElement("div"), r = Q.createElement("div");
        r.style && (r.style.backgroundClip = "content-box", r.cloneNode(!0).style.backgroundClip = "", Z.clearCloneStyle = "content-box" === r.style.backgroundClip, o.style.cssText = "border:0;width:0;height:0;top:0;left:-9999px;margin-top:1px;position:absolute", o.appendChild(r), t.getComputedStyle && J.extend(Z, {
            pixelPosition: function () {
                return e(), i
            }, boxSizingReliable: function () {
                return null == n && e(), n
            }, reliableMarginRight: function () {
                var e, i = r.appendChild(Q.createElement("div"));
                return i.style.cssText = r.style.cssText = "-webkit-box-sizing:content-box;-moz-box-sizing:content-box;box-sizing:content-box;display:block;margin:0;border:0;padding:0", i.style.marginRight = i.style.width = "0", r.style.width = "1px", s.appendChild(o), e = !parseFloat(t.getComputedStyle(i, null).marginRight), s.removeChild(o), e
            }
        }))
    }(), J.swap = function (t, e, i, n) {
        var s, o, r = {};
        for (o in e) r[o] = t.style[o], t.style[o] = e[o];
        s = i.apply(t, n || []);
        for (o in e) t.style[o] = r[o];
        return s
    };
    var $t = /^(none|table(?!-c[ea]).+)/, qt = new RegExp("^(" + bt + ")(.*)$", "i"),
        Xt = new RegExp("^([+-])=(" + bt + ")", "i"),
        Gt = {position: "absolute", visibility: "hidden", display: "block"},
        Yt = {letterSpacing: "0", fontWeight: "400"}, Vt = ["Webkit", "O", "Moz", "ms"];
    J.extend({
        cssHooks: {
            opacity: {
                get: function (t, e) {
                    if (e) {
                        var i = x(t, "opacity");
                        return "" === i ? "1" : i
                    }
                }
            }
        },
        cssNumber: {
            columnCount: !0,
            fillOpacity: !0,
            flexGrow: !0,
            flexShrink: !0,
            fontWeight: !0,
            lineHeight: !0,
            opacity: !0,
            order: !0,
            orphans: !0,
            widows: !0,
            zIndex: !0,
            zoom: !0
        },
        cssProps: {"float": "cssFloat"},
        style: function (t, e, i, n) {
            if (t && 3 !== t.nodeType && 8 !== t.nodeType && t.style) {
                var s, o, r, a = J.camelCase(e), l = t.style;
                return e = J.cssProps[a] || (J.cssProps[a] = k(l, a)), r = J.cssHooks[e] || J.cssHooks[a], void 0 === i ? r && "get" in r && void 0 !== (s = r.get(t, !1, n)) ? s : l[e] : (o = typeof i, "string" === o && (s = Xt.exec(i)) && (i = (s[1] + 1) * s[2] + parseFloat(J.css(t, e)), o = "number"), void (null != i && i === i && ("number" !== o || J.cssNumber[a] || (i += "px"), Z.clearCloneStyle || "" !== i || 0 !== e.indexOf("background") || (l[e] = "inherit"), r && "set" in r && void 0 === (i = r.set(t, i, n)) || (l[e] = i))))
            }
        },
        css: function (t, e, i, n) {
            var s, o, r, a = J.camelCase(e);
            return e = J.cssProps[a] || (J.cssProps[a] = k(t.style, a)), r = J.cssHooks[e] || J.cssHooks[a], r && "get" in r && (s = r.get(t, !0, i)), void 0 === s && (s = x(t, e, n)), "normal" === s && e in Yt && (s = Yt[e]), "" === i || i ? (o = parseFloat(s), !0 === i || J.isNumeric(o) ? o || 0 : s) : s
        }
    }), J.each(["height", "width"], function (t, e) {
        J.cssHooks[e] = {
            get: function (t, i, n) {
                return i ? $t.test(J.css(t, "display")) && 0 === t.offsetWidth ? J.swap(t, Gt, function () {
                    return T(t, e, n)
                }) : T(t, e, n) : void 0
            }, set: function (t, i, n) {
                var s = n && Bt(t);
                return C(t, i, n ? S(t, e, n, "border-box" === J.css(t, "boxSizing", !1, s), s) : 0)
            }
        }
    }), J.cssHooks.marginRight = w(Z.reliableMarginRight, function (t, e) {
        return e ? J.swap(t, {display: "inline-block"}, x, [t, "marginRight"]) : void 0
    }), J.each({margin: "", padding: "", border: "Width"}, function (t, e) {
        J.cssHooks[t + e] = {
            expand: function (i) {
                for (var n = 0, s = {}, o = "string" == typeof i ? i.split(" ") : [i]; 4 > n; n++) s[t + xt[n] + e] = o[n] || o[n - 2] || o[0];
                return s
            }
        }, Rt.test(t) || (J.cssHooks[t + e].set = C)
    }), J.fn.extend({
        css: function (t, e) {
            return gt(this, function (t, e, i) {
                var n, s, o = {}, r = 0;
                if (J.isArray(e)) {
                    for (n = Bt(t), s = e.length; s > r; r++) o[e[r]] = J.css(t, e[r], !1, n);
                    return o
                }
                return void 0 !== i ? J.style(t, e, i) : J.css(t, e)
            }, t, e, arguments.length > 1)
        }, show: function () {
            return A(this, !0)
        }, hide: function () {
            return A(this)
        }, toggle: function (t) {
            return "boolean" == typeof t ? t ? this.show() : this.hide() : this.each(function () {
                wt(this) ? J(this).show() : J(this).hide()
            })
        }
    }), J.Tween = E, E.prototype = {
        constructor: E, init: function (t, e, i, n, s, o) {
            this.elem = t, this.prop = i, this.easing = s || "swing", this.options = e, this.start = this.now = this.cur(), this.end = n, this.unit = o || (J.cssNumber[i] ? "" : "px")
        }, cur: function () {
            var t = E.propHooks[this.prop];
            return t && t.get ? t.get(this) : E.propHooks._default.get(this)
        }, run: function (t) {
            var e, i = E.propHooks[this.prop];
            return this.pos = e = this.options.duration ? J.easing[this.easing](t, this.options.duration * t, 0, 1, this.options.duration) : t, this.now = (this.end - this.start) * e + this.start, this.options.step && this.options.step.call(this.elem, this.now, this), i && i.set ? i.set(this) : E.propHooks._default.set(this), this
        }
    }, E.prototype.init.prototype = E.prototype, E.propHooks = {
        _default: {
            get: function (t) {
                var e;
                return null == t.elem[t.prop] || t.elem.style && null != t.elem.style[t.prop] ? (e = J.css(t.elem, t.prop, ""),
                    e && "auto" !== e ? e : 0) : t.elem[t.prop]
            }, set: function (t) {
                J.fx.step[t.prop] ? J.fx.step[t.prop](t) : t.elem.style && (null != t.elem.style[J.cssProps[t.prop]] || J.cssHooks[t.prop]) ? J.style(t.elem, t.prop, t.now + t.unit) : t.elem[t.prop] = t.now
            }
        }
    }, E.propHooks.scrollTop = E.propHooks.scrollLeft = {
        set: function (t) {
            t.elem.nodeType && t.elem.parentNode && (t.elem[t.prop] = t.now)
        }
    }, J.easing = {
        linear: function (t) {
            return t
        }, swing: function (t) {
            return .5 - Math.cos(t * Math.PI) / 2
        }
    }, J.fx = E.prototype.init, J.fx.step = {};
    var Ut, Zt, Qt = /^(?:toggle|show|hide)$/, Kt = new RegExp("^(?:([+-])=|)(" + bt + ")([a-z%]*)$", "i"),
        Jt = /queueHooks$/, te = [P], ee = {
            "*": [function (t, e) {
                var i = this.createTween(t, e), n = i.cur(), s = Kt.exec(e), o = s && s[3] || (J.cssNumber[t] ? "" : "px"),
                    r = (J.cssNumber[t] || "px" !== o && +n) && Kt.exec(J.css(i.elem, t)), a = 1, l = 20;
                if (r && r[3] !== o) {
                    o = o || r[3], s = s || [], r = +n || 1;
                    do {
                        a = a || ".5", r /= a, J.style(i.elem, t, r + o)
                    } while (a !== (a = i.cur() / n) && 1 !== a && --l)
                }
                return s && (r = i.start = +r || +n || 0, i.unit = o, i.end = s[1] ? r + (s[1] + 1) * s[2] : +s[2]), i
            }]
        };
    J.Animation = J.extend(I, {
        tweener: function (t, e) {
            J.isFunction(t) ? (e = t, t = ["*"]) : t = t.split(" ");
            for (var i, n = 0, s = t.length; s > n; n++) i = t[n], ee[i] = ee[i] || [], ee[i].unshift(e)
        }, prefilter: function (t, e) {
            e ? te.unshift(t) : te.push(t)
        }
    }), J.speed = function (t, e, i) {
        var n = t && "object" == typeof t ? J.extend({}, t) : {
            complete: i || !i && e || J.isFunction(t) && t,
            duration: t,
            easing: i && e || e && !J.isFunction(e) && e
        };
        return n.duration = J.fx.off ? 0 : "number" == typeof n.duration ? n.duration : n.duration in J.fx.speeds ? J.fx.speeds[n.duration] : J.fx.speeds._default, (null == n.queue || !0 === n.queue) && (n.queue = "fx"), n.old = n.complete, n.complete = function () {
            J.isFunction(n.old) && n.old.call(this), n.queue && J.dequeue(this, n.queue)
        }, n
    }, J.fn.extend({
        fadeTo: function (t, e, i, n) {
            return this.filter(wt).css("opacity", 0).show().end().animate({opacity: e}, t, i, n)
        }, animate: function (t, e, i, n) {
            var s = J.isEmptyObject(t), o = J.speed(e, i, n), r = function () {
                var e = I(this, J.extend({}, t), o);
                (s || mt.get(this, "finish")) && e.stop(!0)
            };
            return r.finish = r, s || !1 === o.queue ? this.each(r) : this.queue(o.queue, r)
        }, stop: function (t, e, i) {
            var n = function (t) {
                var e = t.stop;
                delete t.stop, e(i)
            };
            return "string" != typeof t && (i = e, e = t, t = void 0), e && !1 !== t && this.queue(t || "fx", []), this.each(function () {
                var e = !0, s = null != t && t + "queueHooks", o = J.timers, r = mt.get(this);
                if (s) r[s] && r[s].stop && n(r[s]); else for (s in r) r[s] && r[s].stop && Jt.test(s) && n(r[s]);
                for (s = o.length; s--;) o[s].elem !== this || null != t && o[s].queue !== t || (o[s].anim.stop(i), e = !1, o.splice(s, 1));
                (e || !i) && J.dequeue(this, t)
            })
        }, finish: function (t) {
            return !1 !== t && (t = t || "fx"), this.each(function () {
                var e, i = mt.get(this), n = i[t + "queue"], s = i[t + "queueHooks"], o = J.timers,
                    r = n ? n.length : 0;
                for (i.finish = !0, J.queue(this, t, []), s && s.stop && s.stop.call(this, !0), e = o.length; e--;) o[e].elem === this && o[e].queue === t && (o[e].anim.stop(!0), o.splice(e, 1));
                for (e = 0; r > e; e++) n[e] && n[e].finish && n[e].finish.call(this);
                delete i.finish
            })
        }
    }), J.each(["toggle", "show", "hide"], function (t, e) {
        var i = J.fn[e];
        J.fn[e] = function (t, n, s) {
            return null == t || "boolean" == typeof t ? i.apply(this, arguments) : this.animate(M(e, !0), t, n, s)
        }
    }), J.each({
        slideDown: M("show"),
        slideUp: M("hide"),
        slideToggle: M("toggle"),
        fadeIn: {opacity: "show"},
        fadeOut: {opacity: "hide"},
        fadeToggle: {opacity: "toggle"}
    }, function (t, e) {
        J.fn[t] = function (t, i, n) {
            return this.animate(e, t, i, n)
        }
    }), J.timers = [], J.fx.tick = function () {
        var t, e = 0, i = J.timers;
        for (Ut = J.now(); e < i.length; e++) (t = i[e])() || i[e] !== t || i.splice(e--, 1);
        i.length || J.fx.stop(), Ut = void 0
    }, J.fx.timer = function (t) {
        J.timers.push(t), t() ? J.fx.start() : J.timers.pop()
    }, J.fx.interval = 13, J.fx.start = function () {
        Zt || (Zt = setInterval(J.fx.tick, J.fx.interval))
    }, J.fx.stop = function () {
        clearInterval(Zt), Zt = null
    }, J.fx.speeds = {slow: 600, fast: 200, _default: 400}, J.fn.delay = function (t, e) {
        return t = J.fx ? J.fx.speeds[t] || t : t, e = e || "fx", this.queue(e, function (e, i) {
            var n = setTimeout(e, t);
            i.stop = function () {
                clearTimeout(n)
            }
        })
    }, function () {
        var t = Q.createElement("input"), e = Q.createElement("select"), i = e.appendChild(Q.createElement("option"));
        t.type = "checkbox", Z.checkOn = "" !== t.value, Z.optSelected = i.selected, e.disabled = !0, Z.optDisabled = !i.disabled, t = Q.createElement("input"), t.value = "t", t.type = "radio", Z.radioValue = "t" === t.value
    }();
    var ie, ne, se = J.expr.attrHandle;
    J.fn.extend({
        attr: function (t, e) {
            return gt(this, J.attr, t, e, arguments.length > 1)
        }, removeAttr: function (t) {
            return this.each(function () {
                J.removeAttr(this, t)
            })
        }
    }), J.extend({
        attr: function (t, e, i) {
            var n, s, o = t.nodeType;
            if (t && 3 !== o && 8 !== o && 2 !== o) return typeof t.getAttribute === Ct ? J.prop(t, e, i) : (1 === o && J.isXMLDoc(t) || (e = e.toLowerCase(), n = J.attrHooks[e] || (J.expr.match.bool.test(e) ? ne : ie)), void 0 === i ? n && "get" in n && null !== (s = n.get(t, e)) ? s : (s = J.find.attr(t, e), null == s ? void 0 : s) : null !== i ? n && "set" in n && void 0 !== (s = n.set(t, i, e)) ? s : (t.setAttribute(e, i + ""), i) : void J.removeAttr(t, e))
        }, removeAttr: function (t, e) {
            var i, n, s = 0, o = e && e.match(ut);
            if (o && 1 === t.nodeType) for (; i = o[s++];) n = J.propFix[i] || i, J.expr.match.bool.test(i) && (t[n] = !1), t.removeAttribute(i)
        }, attrHooks: {
            type: {
                set: function (t, e) {
                    if (!Z.radioValue && "radio" === e && J.nodeName(t, "input")) {
                        var i = t.value;
                        return t.setAttribute("type", e), i && (t.value = i), e
                    }
                }
            }
        }
    }), ne = {
        set: function (t, e, i) {
            return !1 === e ? J.removeAttr(t, i) : t.setAttribute(i, i), i
        }
    }, J.each(J.expr.match.bool.source.match(/\w+/g), function (t, e) {
        var i = se[e] || J.find.attr;
        se[e] = function (t, e, n) {
            var s, o;
            return n || (o = se[e], se[e] = s, s = null != i(t, e, n) ? e.toLowerCase() : null, se[e] = o), s
        }
    });
    var oe = /^(?:input|select|textarea|button)$/i;
    J.fn.extend({
        prop: function (t, e) {
            return gt(this, J.prop, t, e, arguments.length > 1)
        }, removeProp: function (t) {
            return this.each(function () {
                delete this[J.propFix[t] || t]
            })
        }
    }), J.extend({
        propFix: {"for": "htmlFor", "class": "className"}, prop: function (t, e, i) {
            var n, s, o, r = t.nodeType;
            if (t && 3 !== r && 8 !== r && 2 !== r) return o = 1 !== r || !J.isXMLDoc(t), o && (e = J.propFix[e] || e, s = J.propHooks[e]), void 0 !== i ? s && "set" in s && void 0 !== (n = s.set(t, i, e)) ? n : t[e] = i : s && "get" in s && null !== (n = s.get(t, e)) ? n : t[e]
        }, propHooks: {
            tabIndex: {
                get: function (t) {
                    return t.hasAttribute("tabindex") || oe.test(t.nodeName) || t.href ? t.tabIndex : -1
                }
            }
        }
    }), Z.optSelected || (J.propHooks.selected = {
        get: function (t) {
            var e = t.parentNode;
            return e && e.parentNode && e.parentNode.selectedIndex, null
        }
    }), J.each(["tabIndex", "readOnly", "maxLength", "cellSpacing", "cellPadding", "rowSpan", "colSpan", "useMap", "frameBorder", "contentEditable"], function () {
        J.propFix[this.toLowerCase()] = this
    });
    var re = /[\t\r\n\f]/g;
    J.fn.extend({
        addClass: function (t) {
            var e, i, n, s, o, r, a = "string" == typeof t && t, l = 0, h = this.length;
            if (J.isFunction(t)) return this.each(function (e) {
                J(this).addClass(t.call(this, e, this.className))
            });
            if (a) for (e = (t || "").match(ut) || []; h > l; l++) if (i = this[l], n = 1 === i.nodeType && (i.className ? (" " + i.className + " ").replace(re, " ") : " ")) {
                for (o = 0; s = e[o++];) n.indexOf(" " + s + " ") < 0 && (n += s + " ");
                r = J.trim(n), i.className !== r && (i.className = r)
            }
            return this
        }, removeClass: function (t) {
            var e, i, n, s, o, r, a = 0 === arguments.length || "string" == typeof t && t, l = 0, h = this.length;
            if (J.isFunction(t)) return this.each(function (e) {
                J(this).removeClass(t.call(this, e, this.className))
            });
            if (a) for (e = (t || "").match(ut) || []; h > l; l++) if (i = this[l], n = 1 === i.nodeType && (i.className ? (" " + i.className + " ").replace(re, " ") : "")) {
                for (o = 0; s = e[o++];) for (; n.indexOf(" " + s + " ") >= 0;) n = n.replace(" " + s + " ", " ");
                r = t ? J.trim(n) : "", i.className !== r && (i.className = r)
            }
            return this
        }, toggleClass: function (t, e) {
            var i = typeof t;
            return "boolean" == typeof e && "string" === i ? e ? this.addClass(t) : this.removeClass(t) : this.each(J.isFunction(t) ? function (i) {
                J(this).toggleClass(t.call(this, i, this.className, e), e)
            } : function () {
                if ("string" === i) for (var e, n = 0, s = J(this), o = t.match(ut) || []; e = o[n++];) s.hasClass(e) ? s.removeClass(e) : s.addClass(e); else (i === Ct || "boolean" === i) && (this.className && mt.set(this, "__className__", this.className), this.className = this.className || !1 === t ? "" : mt.get(this, "__className__") || "")
            })
        }, hasClass: function (t) {
            for (var e = " " + t + " ", i = 0, n = this.length; n > i; i++) if (1 === this[i].nodeType && (" " + this[i].className + " ").replace(re, " ").indexOf(e) >= 0) return !0;
            return !1
        }
    });
    var ae = /\r/g;
    J.fn.extend({
        val: function (t) {
            var e, i, n, s = this[0];
            return arguments.length ? (n = J.isFunction(t), this.each(function (i) {
                var s;
                1 === this.nodeType && (s = n ? t.call(this, i, J(this).val()) : t, null == s ? s = "" : "number" == typeof s ? s += "" : J.isArray(s) && (s = J.map(s, function (t) {
                    return null == t ? "" : t + ""
                })), (e = J.valHooks[this.type] || J.valHooks[this.nodeName.toLowerCase()]) && "set" in e && void 0 !== e.set(this, s, "value") || (this.value = s))
            })) : s ? (e = J.valHooks[s.type] || J.valHooks[s.nodeName.toLowerCase()], e && "get" in e && void 0 !== (i = e.get(s, "value")) ? i : (i = s.value, "string" == typeof i ? i.replace(ae, "") : null == i ? "" : i)) : void 0
        }
    }), J.extend({
        valHooks: {
            option: {
                get: function (t) {
                    var e = J.find.attr(t, "value");
                    return null != e ? e : J.trim(J.text(t))
                }
            }, select: {
                get: function (t) {
                    for (var e, i, n = t.options, s = t.selectedIndex, o = "select-one" === t.type || 0 > s, r = o ? null : [], a = o ? s + 1 : n.length, l = 0 > s ? a : o ? s : 0; a > l; l++) if (i = n[l], !(!i.selected && l !== s || (Z.optDisabled ? i.disabled : null !== i.getAttribute("disabled")) || i.parentNode.disabled && J.nodeName(i.parentNode, "optgroup"))) {
                        if (e = J(i).val(), o) return e;
                        r.push(e)
                    }
                    return r
                }, set: function (t, e) {
                    for (var i, n, s = t.options, o = J.makeArray(e), r = s.length; r--;) n = s[r], (n.selected = J.inArray(n.value, o) >= 0) && (i = !0);
                    return i || (t.selectedIndex = -1), o
                }
            }
        }
    }), J.each(["radio", "checkbox"], function () {
        J.valHooks[this] = {
            set: function (t, e) {
                return J.isArray(e) ? t.checked = J.inArray(J(t).val(), e) >= 0 : void 0
            }
        }, Z.checkOn || (J.valHooks[this].get = function (t) {
            return null === t.getAttribute("value") ? "on" : t.value
        })
    }), J.each("blur focus focusin focusout load resize scroll unload click dblclick mousedown mouseup mousemove mouseover mouseout mouseenter mouseleave change select submit keydown keypress keyup error contextmenu".split(" "), function (t, e) {
        J.fn[e] = function (t, i) {
            return arguments.length > 0 ? this.on(e, null, t, i) : this.trigger(e)
        }
    }), J.fn.extend({
        hover: function (t, e) {
            return this.mouseenter(t).mouseleave(e || t)
        }, bind: function (t, e, i) {
            return this.on(t, null, e, i)
        }, unbind: function (t, e) {
            return this.off(t, null, e)
        }, delegate: function (t, e, i, n) {
            return this.on(e, t, i, n)
        }, undelegate: function (t, e, i) {
            return 1 === arguments.length ? this.off(t, "**") : this.off(e, t || "**", i)
        }
    });
    var le = J.now(), he = /\?/;
    J.parseJSON = function (t) {
        return JSON.parse(t + "")
    }, J.parseXML = function (t) {
        var e, i;
        if (!t || "string" != typeof t) return null;
        try {
            i = new DOMParser, e = i.parseFromString(t, "text/xml")
        } catch (t) {
            e = void 0
        }
        return (!e || e.getElementsByTagName("parsererror").length) && J.error("Invalid XML: " + t), e
    };
    var ce, de, ue = /#.*$/, pe = /([?&])_=[^&]*/, fe = /^(.*?):[ \t]*([^\r\n]*)$/gm,
        ge = /^(?:about|app|app-storage|.+-extension|file|res|widget):$/, me = /^(?:GET|HEAD)$/, ve = /^\/\//,
        ye = /^([\w.+-]+:)(?:\/\/(?:[^\/?#]*@|)([^\/?#:]*)(?::(\d+)|)|)/, _e = {}, be = {}, xe = "*/".concat("*");
    try {
        de = location.href
    } catch (t) {
        de = Q.createElement("a"), de.href = "", de = de.href
    }
    ce = ye.exec(de.toLowerCase()) || [], J.extend({
        active: 0,
        lastModified: {},
        etag: {},
        ajaxSettings: {
            url: de,
            type: "GET",
            isLocal: ge.test(ce[1]),
            global: !0,
            processData: !0,
            async: !0,
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            accepts: {
                "*": xe,
                text: "text/plain",
                html: "text/html",
                xml: "application/xml, text/xml",
                json: "application/json, text/javascript"
            },
            contents: {xml: /xml/, html: /html/, json: /json/},
            responseFields: {xml: "responseXML", text: "responseText", json: "responseJSON"},
            converters: {"* text": String, "text html": !0, "text json": J.parseJSON, "text xml": J.parseXML},
            flatOptions: {url: !0, context: !0}
        },
        ajaxSetup: function (t, e) {
            return e ? z(z(t, J.ajaxSettings), e) : z(J.ajaxSettings, t)
        },
        ajaxPrefilter: j(_e),
        ajaxTransport: j(be),
        ajax: function (t, e) {
            function i(t, e, i, r) {
                var l, c, v, y, b, w = e;
                2 !== _ && (_ = 2, a && clearTimeout(a), n = void 0, o = r || "", x.readyState = t > 0 ? 4 : 0, l = t >= 200 && 300 > t || 304 === t, i && (y = H(d, x, i)), y = N(d, y, x, l), l ? (d.ifModified && (b = x.getResponseHeader("Last-Modified"), b && (J.lastModified[s] = b), (b = x.getResponseHeader("etag")) && (J.etag[s] = b)), 204 === t || "HEAD" === d.type ? w = "nocontent" : 304 === t ? w = "notmodified" : (w = y.state, c = y.data, v = y.error, l = !v)) : (v = w, (t || !w) && (w = "error", 0 > t && (t = 0))), x.status = t, x.statusText = (e || w) + "", l ? f.resolveWith(u, [c, w, x]) : f.rejectWith(u, [x, w, v]), x.statusCode(m), m = void 0, h && p.trigger(l ? "ajaxSuccess" : "ajaxError", [x, d, l ? c : v]), g.fireWith(u, [x, w]), h && (p.trigger("ajaxComplete", [x, d]), --J.active || J.event.trigger("ajaxStop")))
            }

            "object" == typeof t && (e = t, t = void 0), e = e || {};
            var n, s, o, r, a, l, h, c, d = J.ajaxSetup({}, e), u = d.context || d,
                p = d.context && (u.nodeType || u.jquery) ? J(u) : J.event, f = J.Deferred(),
                g = J.Callbacks("once memory"), m = d.statusCode || {}, v = {}, y = {}, _ = 0, b = "canceled", x = {
                    readyState: 0, getResponseHeader: function (t) {
                        var e;
                        if (2 === _) {
                            if (!r) for (r = {}; e = fe.exec(o);) r[e[1].toLowerCase()] = e[2];
                            e = r[t.toLowerCase()]
                        }
                        return null == e ? null : e
                    }, getAllResponseHeaders: function () {
                        return 2 === _ ? o : null
                    }, setRequestHeader: function (t, e) {
                        var i = t.toLowerCase();
                        return _ || (t = y[i] = y[i] || t, v[t] = e), this
                    }, overrideMimeType: function (t) {
                        return _ || (d.mimeType = t), this
                    }, statusCode: function (t) {
                        var e;
                        if (t) if (2 > _) for (e in t) m[e] = [m[e], t[e]]; else x.always(t[x.status]);
                        return this
                    }, abort: function (t) {
                        var e = t || b;
                        return n && n.abort(e), i(0, e), this
                    }
                };
            if (f.promise(x).complete = g.add, x.success = x.done, x.error = x.fail, d.url = ((t || d.url || de) + "").replace(ue, "").replace(ve, ce[1] + "//"), d.type = e.method || e.type || d.method || d.type, d.dataTypes = J.trim(d.dataType || "*").toLowerCase().match(ut) || [""], null == d.crossDomain && (l = ye.exec(d.url.toLowerCase()), d.crossDomain = !(!l || l[1] === ce[1] && l[2] === ce[2] && (l[3] || ("http:" === l[1] ? "80" : "443")) === (ce[3] || ("http:" === ce[1] ? "80" : "443")))), d.data && d.processData && "string" != typeof d.data && (d.data = J.param(d.data, d.traditional)), O(_e, d, e, x), 2 === _) return x;
            h = d.global, h && 0 == J.active++ && J.event.trigger("ajaxStart"), d.type = d.type.toUpperCase(), d.hasContent = !me.test(d.type), s = d.url, d.hasContent || (d.data && (s = d.url += (he.test(s) ? "&" : "?") + d.data, delete d.data), !1 === d.cache && (d.url = pe.test(s) ? s.replace(pe, "$1_=" + le++) : s + (he.test(s) ? "&" : "?") + "_=" + le++)), d.ifModified && (J.lastModified[s] && x.setRequestHeader("If-Modified-Since", J.lastModified[s]), J.etag[s] && x.setRequestHeader("If-None-Match", J.etag[s])), (d.data && d.hasContent && !1 !== d.contentType || e.contentType) && x.setRequestHeader("Content-Type", d.contentType), x.setRequestHeader("Accept", d.dataTypes[0] && d.accepts[d.dataTypes[0]] ? d.accepts[d.dataTypes[0]] + ("*" !== d.dataTypes[0] ? ", " + xe + "; q=0.01" : "") : d.accepts["*"]);
            for (c in d.headers) x.setRequestHeader(c, d.headers[c]);
            if (d.beforeSend && (!1 === d.beforeSend.call(u, x, d) || 2 === _)) return x.abort();
            b = "abort";
            for (c in {success: 1, error: 1, complete: 1}) x[c](d[c]);
            if (n = O(be, d, e, x)) {
                x.readyState = 1, h && p.trigger("ajaxSend", [x, d]), d.async && d.timeout > 0 && (a = setTimeout(function () {
                    x.abort("timeout")
                }, d.timeout));
                try {
                    _ = 1, n.send(v, i)
                } catch (t) {
                    if (!(2 > _)) throw t;
                    i(-1, t)
                }
            } else i(-1, "No Transport");
            return x
        },
        getJSON: function (t, e, i) {
            return J.get(t, e, i, "json")
        },
        getScript: function (t, e) {
            return J.get(t, void 0, e, "script")
        }
    }), J.each(["get", "post"], function (t, e) {
        J[e] = function (t, i, n, s) {
            return J.isFunction(i) && (s = s || n, n = i, i = void 0), J.ajax({
                url: t,
                type: e,
                dataType: s,
                data: i,
                success: n
            })
        }
    }), J.each(["ajaxStart", "ajaxStop", "ajaxComplete", "ajaxError", "ajaxSuccess", "ajaxSend"], function (t, e) {
        J.fn[e] = function (t) {
            return this.on(e, t)
        }
    }), J._evalUrl = function (t) {
        return J.ajax({url: t, type: "GET", dataType: "script", async: !1, global: !1, "throws": !0})
    }, J.fn.extend({
        wrapAll: function (t) {
            var e;
            return J.isFunction(t) ? this.each(function (e) {
                J(this).wrapAll(t.call(this, e))
            }) : (this[0] && (e = J(t, this[0].ownerDocument).eq(0).clone(!0), this[0].parentNode && e.insertBefore(this[0]), e.map(function () {
                for (var t = this; t.firstElementChild;) t = t.firstElementChild;
                return t
            }).append(this)), this)
        }, wrapInner: function (t) {
            return this.each(J.isFunction(t) ? function (e) {
                J(this).wrapInner(t.call(this, e))
            } : function () {
                var e = J(this), i = e.contents();
                i.length ? i.wrapAll(t) : e.append(t)
            })
        }, wrap: function (t) {
            var e = J.isFunction(t);
            return this.each(function (i) {
                J(this).wrapAll(e ? t.call(this, i) : t)
            })
        }, unwrap: function () {
            return this.parent().each(function () {
                J.nodeName(this, "body") || J(this).replaceWith(this.childNodes)
            }).end()
        }
    }), J.expr.filters.hidden = function (t) {
        return t.offsetWidth <= 0 && t.offsetHeight <= 0
    }, J.expr.filters.visible = function (t) {
        return !J.expr.filters.hidden(t)
    };
    var we = /%20/g, ke = /\[\]$/, Ce = /\r?\n/g, Se = /^(?:submit|button|image|reset|file)$/i,
        Te = /^(?:input|select|textarea|keygen)/i;
    J.param = function (t, e) {
        var i, n = [], s = function (t, e) {
            e = J.isFunction(e) ? e() : null == e ? "" : e, n[n.length] = encodeURIComponent(t) + "=" + encodeURIComponent(e)
        };
        if (void 0 === e && (e = J.ajaxSettings && J.ajaxSettings.traditional), J.isArray(t) || t.jquery && !J.isPlainObject(t)) J.each(t, function () {
            s(this.name, this.value)
        }); else for (i in t) R(i, t[i], e, s);
        return n.join("&").replace(we, "+")
    }, J.fn.extend({
        serialize: function () {
            return J.param(this.serializeArray())
        }, serializeArray: function () {
            return this.map(function () {
                var t = J.prop(this, "elements");
                return t ? J.makeArray(t) : this
            }).filter(function () {
                var t = this.type;
                return this.name && !J(this).is(":disabled") && Te.test(this.nodeName) && !Se.test(t) && (this.checked || !kt.test(t))
            }).map(function (t, e) {
                var i = J(this).val();
                return null == i ? null : J.isArray(i) ? J.map(i, function (t) {
                    return {name: e.name, value: t.replace(Ce, "\r\n")}
                }) : {name: e.name, value: i.replace(Ce, "\r\n")}
            }).get()
        }
    }), J.ajaxSettings.xhr = function () {
        try {
            return new XMLHttpRequest
        } catch (t) {
        }
    };
    var Ae = 0, Ee = {}, Le = {0: 200, 1223: 204}, Me = J.ajaxSettings.xhr();
    t.ActiveXObject && J(t).on("unload", function () {
        for (var t in Ee) Ee[t]()
    }), Z.cors = !!Me && "withCredentials" in Me, Z.ajax = Me = !!Me, J.ajaxTransport(function (t) {
        var e;
        return Z.cors || Me && !t.crossDomain ? {
            send: function (i, n) {
                var s, o = t.xhr(), r = ++Ae;
                if (o.open(t.type, t.url, t.async, t.username, t.password), t.xhrFields) for (s in t.xhrFields) o[s] = t.xhrFields[s];
                t.mimeType && o.overrideMimeType && o.overrideMimeType(t.mimeType), t.crossDomain || i["X-Requested-With"] || (i["X-Requested-With"] = "XMLHttpRequest");
                for (s in i) o.setRequestHeader(s, i[s]);
                e = function (t) {
                    return function () {
                        e && (delete Ee[r], e = o.onload = o.onerror = null, "abort" === t ? o.abort() : "error" === t ? n(o.status, o.statusText) : n(Le[o.status] || o.status, o.statusText, "string" == typeof o.responseText ? {text: o.responseText} : void 0, o.getAllResponseHeaders()))
                    }
                }, o.onload = e(), o.onerror = e("error"), e = Ee[r] = e("abort");
                try {
                    o.send(t.hasContent && t.data || null)
                } catch (t) {
                    if (e) throw t
                }
            }, abort: function () {
                e && e()
            }
        } : void 0
    }), J.ajaxSetup({
        accepts: {script: "text/javascript, application/javascript, application/ecmascript, application/x-ecmascript"},
        contents: {script: /(?:java|ecma)script/},
        converters: {
            "text script": function (t) {
                return J.globalEval(t), t
            }
        }
    }), J.ajaxPrefilter("script", function (t) {
        void 0 === t.cache && (t.cache = !1), t.crossDomain && (t.type = "GET")
    }), J.ajaxTransport("script", function (t) {
        if (t.crossDomain) {
            var e, i;
            return {
                send: function (n, s) {
                    e = J("<script>").prop({
                        async: !0,
                        charset: t.scriptCharset,
                        src: t.url
                    }).on("load error", i = function (t) {
                        e.remove(), i = null, t && s("error" === t.type ? 404 : 200, t.type)
                    }), Q.head.appendChild(e[0])
                }, abort: function () {
                    i && i()
                }
            }
        }
    });
    var De = [], Pe = /(=)\?(?=&|$)|\?\?/;
    J.ajaxSetup({
        jsonp: "callback", jsonpCallback: function () {
            var t = De.pop() || J.expando + "_" + le++;
            return this[t] = !0, t
        }
    }), J.ajaxPrefilter("json jsonp", function (e, i, n) {
        var s, o, r,
            a = !1 !== e.jsonp && (Pe.test(e.url) ? "url" : "string" == typeof e.data && !(e.contentType || "").indexOf("application/x-www-form-urlencoded") && Pe.test(e.data) && "data");
        return a || "jsonp" === e.dataTypes[0] ? (s = e.jsonpCallback = J.isFunction(e.jsonpCallback) ? e.jsonpCallback() : e.jsonpCallback, a ? e[a] = e[a].replace(Pe, "$1" + s) : !1 !== e.jsonp && (e.url += (he.test(e.url) ? "&" : "?") + e.jsonp + "=" + s), e.converters["script json"] = function () {
            return r || J.error(s + " was not called"), r[0]
        }, e.dataTypes[0] = "json", o = t[s], t[s] = function () {
            r = arguments
        }, n.always(function () {
            t[s] = o, e[s] && (e.jsonpCallback = i.jsonpCallback, De.push(s)), r && J.isFunction(o) && o(r[0]), r = o = void 0
        }), "script") : void 0
    }), J.parseHTML = function (t, e, i) {
        if (!t || "string" != typeof t) return null;
        "boolean" == typeof e && (i = e, e = !1), e = e || Q;
        var n = rt.exec(t), s = !i && [];
        return n ? [e.createElement(n[1])] : (n = J.buildFragment([t], e, s), s && s.length && J(s).remove(), J.merge([], n.childNodes))
    };
    var Fe = J.fn.load;
    J.fn.load = function (t, e, i) {
        if ("string" != typeof t && Fe) return Fe.apply(this, arguments);
        var n, s, o, r = this, a = t.indexOf(" ");
        return a >= 0 && (n = J.trim(t.slice(a)), t = t.slice(0, a)), J.isFunction(e) ? (i = e, e = void 0) : e && "object" == typeof e && (s = "POST"), r.length > 0 && J.ajax({
            url: t,
            type: s,
            dataType: "html",
            data: e
        }).done(function (t) {
            o = arguments, r.html(n ? J("<div>").append(J.parseHTML(t)).find(n) : t)
        }).complete(i && function (t, e) {
            r.each(i, o || [t.responseText, e, t])
        }), this
    }, J.expr.filters.animated = function (t) {
        return J.grep(J.timers, function (e) {
            return t === e.elem
        }).length
    };
    var Ie = t.document.documentElement;
    J.offset = {
        setOffset: function (t, e, i) {
            var n, s, o, r, a, l, h, c = J.css(t, "position"), d = J(t), u = {};
            "static" === c && (t.style.position = "relative"), a = d.offset(), o = J.css(t, "top"), l = J.css(t, "left"), h = ("absolute" === c || "fixed" === c) && (o + l).indexOf("auto") > -1, h ? (n = d.position(), r = n.top, s = n.left) : (r = parseFloat(o) || 0, s = parseFloat(l) || 0), J.isFunction(e) && (e = e.call(t, i, a)), null != e.top && (u.top = e.top - a.top + r), null != e.left && (u.left = e.left - a.left + s), "using" in e ? e.using.call(t, u) : d.css(u)
        }
    }, J.fn.extend({
        offset: function (t) {
            if (arguments.length) return void 0 === t ? this : this.each(function (e) {
                J.offset.setOffset(this, t, e)
            });
            var e, i, n = this[0], s = {top: 0, left: 0}, o = n && n.ownerDocument;
            return o ? (e = o.documentElement, J.contains(e, n) ? (typeof n.getBoundingClientRect !== Ct && (s = n.getBoundingClientRect()), i = W(o), {
                top: s.top + i.pageYOffset - e.clientTop,
                left: s.left + i.pageXOffset - e.clientLeft
            }) : s) : void 0
        }, position: function () {
            if (this[0]) {
                var t, e, i = this[0], n = {top: 0, left: 0};
                return "fixed" === J.css(i, "position") ? e = i.getBoundingClientRect() : (t = this.offsetParent(), e = this.offset(), J.nodeName(t[0], "html") || (n = t.offset()), n.top += J.css(t[0], "borderTopWidth", !0), n.left += J.css(t[0], "borderLeftWidth", !0)), {
                    top: e.top - n.top - J.css(i, "marginTop", !0),
                    left: e.left - n.left - J.css(i, "marginLeft", !0)
                }
            }
        }, offsetParent: function () {
            return this.map(function () {
                for (var t = this.offsetParent || Ie; t && !J.nodeName(t, "html") && "static" === J.css(t, "position");) t = t.offsetParent;
                return t || Ie
            })
        }
    }), J.each({scrollLeft: "pageXOffset", scrollTop: "pageYOffset"}, function (e, i) {
        var n = "pageYOffset" === i;
        J.fn[e] = function (s) {
            return gt(this, function (e, s, o) {
                var r = W(e);
                return void 0 === o ? r ? r[i] : e[s] : void (r ? r.scrollTo(n ? t.pageXOffset : o, n ? o : t.pageYOffset) : e[s] = o)
            }, e, s, arguments.length, null)
        }
    }), J.each(["top", "left"], function (t, e) {
        J.cssHooks[e] = w(Z.pixelPosition, function (t, i) {
            return i ? (i = x(t, e), Wt.test(i) ? J(t).position()[e] + "px" : i) : void 0
        })
    }), J.each({Height: "height", Width: "width"}, function (t, e) {
        J.each({padding: "inner" + t, content: e, "": "outer" + t}, function (i, n) {
            J.fn[n] = function (n, s) {
                var o = arguments.length && (i || "boolean" != typeof n),
                    r = i || (!0 === n || !0 === s ? "margin" : "border");
                return gt(this, function (e, i, n) {
                    var s;
                    return J.isWindow(e) ? e.document.documentElement["client" + t] : 9 === e.nodeType ? (s = e.documentElement, Math.max(e.body["scroll" + t], s["scroll" + t], e.body["offset" + t], s["offset" + t], s["client" + t])) : void 0 === n ? J.css(e, i, r) : J.style(e, i, n, r)
                }, e, o ? n : void 0, o, null)
            }
        })
    }), J.fn.size = function () {
        return this.length
    }, J.fn.andSelf = J.fn.addBack, "function" == typeof define && define.amd && define("jquery", [], function () {
        return J
    });
    var je = t.jQuery, Oe = t.$;
    return J.noConflict = function (e) {
        return t.$ === J && (t.$ = Oe), e && t.jQuery === J && (t.jQuery = je), J
    }, typeof e === Ct && (t.jQuery = t.$ = J), J
}), function (t, e) {
    "use strict";
    t.rails !== e && t.error("jquery-ujs has already been loaded!");
    var i, n = t(document);
    t.rails = i = {
        linkClickSelector: "a[data-confirm], a[data-method], a[data-remote]:not([disabled]), a[data-disable-with], a[data-disable]",
        buttonClickSelector: "button[data-remote]:not([form]):not(form button), button[data-confirm]:not([form]):not(form button)",
        inputChangeSelector: "select[data-remote], input[data-remote], textarea[data-remote]",
        formSubmitSelector: "form",
        formInputClickSelector: "form input[type=submit], form input[type=image], form button[type=submit], form button:not([type]), input[type=submit][form], input[type=image][form], button[type=submit][form], button[form]:not([type])",
        disableSelector: "input[data-disable-with]:enabled, button[data-disable-with]:enabled, textarea[data-disable-with]:enabled, input[data-disable]:enabled, button[data-disable]:enabled, textarea[data-disable]:enabled",
        enableSelector: "input[data-disable-with]:disabled, button[data-disable-with]:disabled, textarea[data-disable-with]:disabled, input[data-disable]:disabled, button[data-disable]:disabled, textarea[data-disable]:disabled",
        requiredInputSelector: "input[name][required]:not([disabled]), textarea[name][required]:not([disabled])",
        fileInputSelector: "input[name][type=file]:not([disabled])",
        linkDisableSelector: "a[data-disable-with], a[data-disable]",
        buttonDisableSelector: "button[data-remote][data-disable-with], button[data-remote][data-disable]",
        csrfToken: function () {
            return t("meta[name=csrf-token]").attr("content")
        },
        csrfParam: function () {
            return t("meta[name=csrf-param]").attr("content")
        },
        CSRFProtection: function (t) {
            var e = i.csrfToken();
            e && t.setRequestHeader("X-CSRF-Token", e)
        },
        refreshCSRFTokens: function () {
            t('form input[name="' + i.csrfParam() + '"]').val(i.csrfToken())
        },
        fire: function (e, i, n) {
            var s = t.Event(i);
            return e.trigger(s, n), !1 !== s.result
        },
        confirm: function (t) {
            return confirm(t)
        },
        ajax: function (e) {
            return t.ajax(e)
        },
        href: function (t) {
            return t[0].href
        },
        isRemote: function (t) {
            return t.data("remote") !== e && !1 !== t.data("remote")
        },
        handleRemote: function (n) {
            var s, o, r, a, l, h;
            if (i.fire(n, "ajax:before")) {
                if (a = n.data("with-credentials") || null, l = n.data("type") || t.ajaxSettings && t.ajaxSettings.dataType, n.is("form")) {
                    s = n.data("ujs:submit-button-formmethod") || n.attr("method"), o = n.data("ujs:submit-button-formaction") || n.attr("action"), r = t(n[0]).serializeArray();
                    var c = n.data("ujs:submit-button");
                    c && (r.push(c), n.data("ujs:submit-button", null)), n.data("ujs:submit-button-formmethod", null), n.data("ujs:submit-button-formaction", null)
                } else n.is(i.inputChangeSelector) ? (s = n.data("method"), o = n.data("url"), r = n.serialize(), n.data("params") && (r = r + "&" + n.data("params"))) : n.is(i.buttonClickSelector) ? (s = n.data("method") || "get", o = n.data("url"), r = n.serialize(), n.data("params") && (r = r + "&" + n.data("params"))) : (s = n.data("method"), o = i.href(n), r = n.data("params") || null);
                return h = {
                    type: s || "GET", data: r, dataType: l, beforeSend: function (t, s) {
                        if (s.dataType === e && t.setRequestHeader("accept", "*/*;q=0.5, " + s.accepts.script), !i.fire(n, "ajax:beforeSend", [t, s])) return !1;
                        n.trigger("ajax:send", t)
                    }, success: function (t, e, i) {
                        n.trigger("ajax:success", [t, e, i])
                    }, complete: function (t, e) {
                        n.trigger("ajax:complete", [t, e])
                    }, error: function (t, e, i) {
                        n.trigger("ajax:error", [t, e, i])
                    }, crossDomain: i.isCrossDomain(o)
                }, a && (h.xhrFields = {withCredentials: a}), o && (h.url = o), i.ajax(h)
            }
            return !1
        },
        isCrossDomain: function (t) {
            var e = document.createElement("a");
            e.href = location.href;
            var i = document.createElement("a");
            try {
                return i.href = t, i.href = i.href, !((!i.protocol || ":" === i.protocol) && !i.host || e.protocol + "//" + e.host == i.protocol + "//" + i.host)
            } catch (t) {
                return !0
            }
        },
        handleMethod: function (n) {
            var s = i.href(n), o = n.data("method"), r = n.attr("target"), a = i.csrfToken(), l = i.csrfParam(),
                h = t('<form method="post" action="' + s + '"></form>'),
                c = '<input name="_method" value="' + o + '" type="hidden" />';
            l === e || a === e || i.isCrossDomain(s) || (c += '<input name="' + l + '" value="' + a + '" type="hidden" />'), r && h.attr("target", r), h.hide().append(c).appendTo("body"), h.submit()
        },
        formElements: function (e, i) {
            return e.is("form") ? t(e[0].elements).filter(i) : e.find(i)
        },
        disableFormElements: function (e) {
            i.formElements(e, i.disableSelector).each(function () {
                i.disableFormElement(t(this))
            })
        },
        disableFormElement: function (t) {
            var i, n;
            i = t.is("button") ? "html" : "val", n = t.data("disable-with"), n !== e && (t.data("ujs:enable-with", t[i]()), t[i](n)), t.prop("disabled", !0), t.data("ujs:disabled", !0)
        },
        enableFormElements: function (e) {
            i.formElements(e, i.enableSelector).each(function () {
                i.enableFormElement(t(this))
            })
        },
        enableFormElement: function (t) {
            var i = t.is("button") ? "html" : "val";
            t.data("ujs:enable-with") !== e && (t[i](t.data("ujs:enable-with")), t.removeData("ujs:enable-with")), t.prop("disabled", !1), t.removeData("ujs:disabled")
        },
        allowAction: function (t) {
            var e, n = t.data("confirm"), s = !1;
            if (!n) return !0;
            if (i.fire(t, "confirm")) {
                try {
                    s = i.confirm(n)
                } catch (t) {
                    (console.error || console.log).call(console, t.stack || t)
                }
                e = i.fire(t, "confirm:complete", [s])
            }
            return s && e
        },
        blankInputs: function (e, i, n) {
            var s, o, r, a, l = t(), h = i || "input,textarea", c = e.find(h), d = {};
            return c.each(function () {
                s = t(this), s.is("input[type=radio]") ? (a = s.attr("name"), d[a] || (0 === e.find('input[type=radio]:checked[name="' + a + '"]').length && (r = e.find('input[type=radio][name="' + a + '"]'), l = l.add(r)), d[a] = a)) : (o = s.is("input[type=checkbox],input[type=radio]") ? s.is(":checked") : !!s.val()) === n && (l = l.add(s))
            }), !!l.length && l
        },
        nonBlankInputs: function (t, e) {
            return i.blankInputs(t, e, !0)
        },
        stopEverything: function (e) {
            return t(e.target).trigger("ujs:everythingStopped"), e.stopImmediatePropagation(), !1
        },
        disableElement: function (t) {
            var n = t.data("disable-with");
            n !== e && (t.data("ujs:enable-with", t.html()), t.html(n)), t.bind("click.railsDisable", function (t) {
                return i.stopEverything(t)
            }), t.data("ujs:disabled", !0)
        },
        enableElement: function (t) {
            t.data("ujs:enable-with") !== e && (t.html(t.data("ujs:enable-with")), t.removeData("ujs:enable-with")), t.unbind("click.railsDisable"), t.removeData("ujs:disabled")
        }
    }, i.fire(n, "rails:attachBindings") && (t.ajaxPrefilter(function (t, e, n) {
        t.crossDomain || i.CSRFProtection(n)
    }), t(window).on("pageshow.rails", function () {
        t(t.rails.enableSelector).each(function () {
            var e = t(this);
            e.data("ujs:disabled") && t.rails.enableFormElement(e)
        }), t(t.rails.linkDisableSelector).each(function () {
            var e = t(this);
            e.data("ujs:disabled") && t.rails.enableElement(e)
        })
    }), n.on("ajax:complete", i.linkDisableSelector, function () {
        i.enableElement(t(this))
    }), n.on("ajax:complete", i.buttonDisableSelector, function () {
        i.enableFormElement(t(this))
    }), n.on("click.rails", i.linkClickSelector, function (e) {
        var n = t(this), s = n.data("method"), o = n.data("params"), r = e.metaKey || e.ctrlKey;
        if (!i.allowAction(n)) return i.stopEverything(e);
        if (!r && n.is(i.linkDisableSelector) && i.disableElement(n), i.isRemote(n)) {
            if (r && (!s || "GET" === s) && !o) return !0;
            var a = i.handleRemote(n);
            return !1 === a ? i.enableElement(n) : a.fail(function () {
                i.enableElement(n)
            }), !1
        }
        return s ? (i.handleMethod(n), !1) : void 0
    }), n.on("click.rails", i.buttonClickSelector, function (e) {
        var n = t(this);
        if (!i.allowAction(n) || !i.isRemote(n)) return i.stopEverything(e);
        n.is(i.buttonDisableSelector) && i.disableFormElement(n);
        var s = i.handleRemote(n);
        return !1 === s ? i.enableFormElement(n) : s.fail(function () {
            i.enableFormElement(n)
        }), !1
    }), n.on("change.rails", i.inputChangeSelector, function (e) {
        var n = t(this);
        return i.allowAction(n) && i.isRemote(n) ? (i.handleRemote(n), !1) : i.stopEverything(e)
    }), n.on("submit.rails", i.formSubmitSelector, function (n) {
        var s, o, r = t(this), a = i.isRemote(r);
        if (!i.allowAction(r)) return i.stopEverything(n);
        if (r.attr("novalidate") === e) if (r.data("ujs:formnovalidate-button") === e) {
            if ((s = i.blankInputs(r, i.requiredInputSelector, !1)) && i.fire(r, "ajax:aborted:required", [s])) return i.stopEverything(n)
        } else r.data("ujs:formnovalidate-button", e);
        if (a) {
            if (o = i.nonBlankInputs(r, i.fileInputSelector)) {
                setTimeout(function () {
                    i.disableFormElements(r)
                }, 13);
                var l = i.fire(r, "ajax:aborted:file", [o]);
                return l || setTimeout(function () {
                    i.enableFormElements(r)
                }, 13), l
            }
            return i.handleRemote(r), !1
        }
        setTimeout(function () {
            i.disableFormElements(r)
        }, 13)
    }), n.on("click.rails", i.formInputClickSelector, function (e) {
        var n = t(this);
        if (!i.allowAction(n)) return i.stopEverything(e);
        var s = n.attr("name"), o = s ? {name: s, value: n.val()} : null, r = n.closest("form");
        0 === r.length && (r = t("#" + n.attr("form"))), r.data("ujs:submit-button", o), r.data("ujs:formnovalidate-button", n.attr("formnovalidate")), r.data("ujs:submit-button-formaction", n.attr("formaction")), r.data("ujs:submit-button-formmethod", n.attr("formmethod"))
    }), n.on("ajax:send.rails", i.formSubmitSelector, function (e) {
        this === e.target && i.disableFormElements(t(this))
    }), n.on("ajax:complete.rails", i.formSubmitSelector, function (e) {
        this === e.target && i.enableFormElements(t(this))
    }), t(function () {
        i.refreshCSRFTokens()
    }))
}(jQuery), function (t) {
    "use strict";
    t.ajaxPrefilter(function (t) {
        if (t.iframe) return "iframe"
    }), t.ajaxTransport("iframe", function (e, i, n) {
        function s() {
            c.each(function (e) {
                t(this).replaceWith(h[e]), c.splice(e, 1)
            }), r.remove(), a.bind("load", function () {
                a.remove()
            }), a.attr("src", "about:blank")
        }

        var o, r = null, a = null, l = "iframe-" + t.now(), h = t(e.files).filter(":file:enabled"), c = null;
        if (e.dataTypes.shift(), h.length) return r = t("<form enctype='multipart/form-data' method='post'></form>").hide().attr({
            action: e.url,
            target: l
        }), "string" == typeof e.data && e.data.length > 0 && t.error("data must not be serialized"), t.each(e.data || {}, function (e, i) {
            t.isPlainObject(i) && (e = i.name, i = i.value), t("<input type='hidden' />").attr({
                name: e,
                value: i
            }).appendTo(r)
        }), t("<input type='hidden' value='IFrame' name='X-Requested-With' />").appendTo(r), o = e.dataTypes[0] && e.accepts[e.dataTypes[0]] ? e.accepts[e.dataTypes[0]] + ("*" !== e.dataTypes[0] ? ", */*; q=0.01" : "") : e.accepts["*"], t("<input type='hidden' name='X-Http-Accept'>").attr("value", o).appendTo(r), c = h.after(function () {
            return t(this).clone().prop("disabled", !0)
        }).next(), h.appendTo(r), {
            send: function (e, i) {
                a = t("<iframe src='about:blank' name='" + l + "' id='" + l + "' style='display:none'></iframe>"), a.bind("load", function () {
                    a.unbind("load").bind("load", function () {
                        var t = this.contentWindow ? this.contentWindow.document : this.contentDocument ? this.contentDocument : this.document,
                            e = t.documentElement ? t.documentElement : t.body,
                            o = e.getElementsByTagName("textarea")[0], r = o && o.getAttribute("data-type") || null,
                            a = o && o.getAttribute("data-status") || 200,
                            l = o && o.getAttribute("data-statusText") || "OK",
                            h = {html: e.innerHTML, text: r ? o.value : e ? e.textContent || e.innerText : null};
                        s(), n.responseText || (n.responseText = h.text), i(a, l, h, r ? "Content-Type: " + r : null)
                    }), r[0].submit()
                }), t("body").append(r, a)
            }, abort: function () {
                null !== a && (a.unbind("load").attr("src", "javascript:false;"), s())
            }
        }
    })
}(jQuery), function (t) {
    var e;
    t.remotipart = e = {
        setup: function (i) {
            var n = i.data("ujs:submit-button"), s = t('meta[name="csrf-param"]').attr("content"),
                o = t('meta[name="csrf-token"]').attr("content"), r = i.find('input[name="' + s + '"]').length;
            i.one("ajax:beforeSend.remotipart", function (a, l, h) {
                return delete h.beforeSend, h.iframe = !0, h.files = t(t.rails.fileInputSelector, i), h.data = i.serializeArray(), n && h.data.push(n), h.files.each(function (t, e) {
                    for (var i = h.data.length - 1; i >= 0; i--) h.data[i].name == e.name && h.data.splice(i, 1)
                }), h.processData = !1, h.dataType === undefined && (h.dataType = "script *"), h.data.push({
                    name: "remotipart_submitted",
                    value: !0
                }), o && s && !r && h.data.push({
                    name: s,
                    value: o
                }), t.rails.fire(i, "ajax:remotipartSubmit", [l, h]) && (t.rails.ajax(h).complete(function (e) {
                    t.rails.fire(i, "ajax:remotipartComplete", [e])
                }), setTimeout(function () {
                    t.rails.disableFormElements(i)
                }, 20)), e.teardown(i), !1
            }).data("remotipartSubmitted", !0)
        }, teardown: function (t) {
            t.unbind("ajax:beforeSend.remotipart").removeData("remotipartSubmitted")
        }
    }, t(document).on("ajax:aborted:file", "form", function () {
        var i = t(this);
        return e.setup(i), t.rails.handleRemote(i), !1
    })
}(jQuery), function () {
    function t() {
        var t, e, i = arguments, n = {}, s = function (t, e) {
            var i, n;
            "object" != typeof t && (t = {});
            for (n in e) e.hasOwnProperty(n) && (i = e[n], t[n] = i && "object" == typeof i && "[object Array]" !== Object.prototype.toString.call(i) && "renderTo" !== n && "number" != typeof i.nodeType ? s(t[n] || {}, i) : e[n]);
            return t
        };
        for (!0 === i[0] && (n = i[1], i = Array.prototype.slice.call(i, 2)), e = i.length, t = 0; t < e; t++) n = s(n, i[t]);
        return n
    }

    function e(t, e) {
        return parseInt(t, e || 10)
    }

    function i(t) {
        return "string" == typeof t
    }

    function n(t) {
        return t && "object" == typeof t
    }

    function s(t) {
        return "[object Array]" === Object.prototype.toString.call(t)
    }

    function o(t) {
        return "number" == typeof t
    }

    function r(t) {
        return at.log(t) / at.LN10
    }

    function a(t) {
        return at.pow(10, t)
    }

    function l(t, e) {
        for (var i = t.length; i--;) if (t[i] === e) {
            t.splice(i, 1);
            break
        }
    }

    function h(t) {
        return t !== P && null !== t
    }

    function c(t, e, s) {
        var o, r;
        if (i(e)) h(s) ? t.setAttribute(e, s) : t && t.getAttribute && (r = t.getAttribute(e)); else if (h(e) && n(e)) for (o in e) t.setAttribute(o, e[o]);
        return r
    }

    function d(t) {
        return s(t) ? t : [t]
    }

    function u(t, e) {
        bt && !Tt && e && e.opacity !== P && (e.filter = "alpha(opacity=" + 100 * e.opacity + ")"), Rt(t.style, e)
    }

    function p(t, e, i, n, s) {
        return t = ot.createElement(t), e && Rt(t, e), s && u(t, {
            padding: 0,
            border: jt,
            margin: 0
        }), i && u(t, i), n && n.appendChild(t), t
    }

    function f(t, e) {
        var i = function () {
            return P
        };
        return i.prototype = new t, Rt(i.prototype, e), i
    }

    function g(t, e) {
        return Array((e || 2) + 1 - String(t).length).join(0) + t
    }

    function m(t) {
        return 6e4 * (q && q(t) || $ || 0)
    }

    function v(t, e) {
        for (var i, n, s, o, r, a = "{", l = !1, h = []; -1 !== (a = t.indexOf(a));) {
            if (i = t.slice(0, a), l) {
                for (n = i.split(":"), s = n.shift().split("."), r = s.length, i = e, o = 0; o < r; o++) i = i[s[o]];
                n.length && (n = n.join(":"), s = /\.([0-9])/, o = O.lang, r = void 0, /f$/.test(n) ? (r = (r = n.match(s)) ? r[1] : -1, null !== i && (i = st.numberFormat(i, r, o.decimalPoint, n.indexOf(",") > -1 ? o.thousandsSep : ""))) : i = z(n, i))
            }
            h.push(i), t = t.slice(a + 1), a = (l = !l) ? "}" : "{"
        }
        return h.push(t), h.join("")
    }

    function y(t) {
        return at.pow(10, ht(at.log(t) / at.LN10))
    }

    function _(t, e, i, n, s) {
        var o, r = t, i = Wt(i, 1);
        for (o = t / i, e || (e = [1, 2, 2.5, 5, 10], !1 === n && (1 === i ? e = [1, 2, 5, 10] : i <= .1 && (e = [1 / i]))), n = 0; n < e.length && (r = e[n], !(s && r * i >= t || !s && o <= (e[n] + (e[n + 1] || e[n])) / 2)); n++) ;
        return r *= i
    }

    function b(t, e) {
        var i, n, s = t.length;
        for (n = 0; n < s; n++) t[n].ss_i = n;
        for (t.sort(function (t, n) {
            return i = e(t, n), 0 === i ? t.ss_i - n.ss_i : i
        }), n = 0; n < s; n++) delete t[n].ss_i
    }

    function x(t) {
        for (var e = t.length, i = t[0]; e--;) t[e] < i && (i = t[e]);
        return i
    }

    function w(t) {
        for (var e = t.length, i = t[0]; e--;) t[e] > i && (i = t[e]);
        return i
    }

    function k(t, e) {
        for (var i in t) t[i] && t[i] !== e && t[i].destroy && t[i].destroy(), delete t[i]
    }

    function C(t) {
        j || (j = p(It)), t && j.appendChild(t), j.innerHTML = ""
    }

    function S(t, e) {
        var i = "Highcharts error #" + t + ": www.highcharts.com/errors/" + t;
        if (e) throw i;
        rt.console && console.log(i)
    }

    function T(t) {
        return parseFloat(t.toPrecision(14))
    }

    function A(t, e) {
        H = Wt(t, e.animation)
    }

    function E() {
        var t = O.global, e = t.useUTC, i = e ? "getUTC" : "get", n = e ? "setUTC" : "set";
        W = t.Date || window.Date, $ = e && t.timezoneOffset, q = e && t.getTimezoneOffset, B = function (t, i, n, s, o, r) {
            var a;
            return e ? (a = W.UTC.apply(0, arguments), a += m(a)) : a = new W(t, i, Wt(n, 1), Wt(s, 0), Wt(o, 0), Wt(r, 0)).getTime(), a
        }, X = i + "Minutes", G = i + "Hours", Y = i + "Day", V = i + "Date", U = i + "Month", Z = i + "FullYear", Q = n + "Milliseconds", K = n + "Seconds", J = n + "Minutes", tt = n + "Hours", et = n + "Date", it = n + "Month", nt = n + "FullYear"
    }

    function L() {
    }

    function M(t, e, i, n) {
        this.axis = t, this.pos = e, this.type = i || "", this.isNew = !0, !i && !n && this.addLabel()
    }

    function D(t, e, i, n, s) {
        var o = t.chart.inverted;
        this.axis = t, this.isNegative = i, this.options = e, this.x = n, this.total = null, this.points = {}, this.stack = s, this.alignOptions = {
            align: e.align || (o ? i ? "left" : "right" : "center"),
            verticalAlign: e.verticalAlign || (o ? "middle" : i ? "bottom" : "top"),
            y: Wt(e.y, o ? 4 : i ? 14 : -6),
            x: Wt(e.x, o ? i ? -6 : 6 : 0)
        }, this.textAlign = e.textAlign || (o ? i ? "right" : "left" : "center")
    }

    var P, F, I, j, O, z, H, N, R, W, B, $, q, X, G, Y, V, U, Z, Q, K, J, tt, et, it, nt, st, ot = document,
        rt = window, at = Math, lt = at.round, ht = at.floor, ct = at.ceil, dt = at.max, ut = at.min, pt = at.abs,
        ft = at.cos, gt = at.sin, mt = at.PI, vt = 2 * mt / 360, yt = navigator.userAgent, _t = rt.opera,
        bt = /(msie|trident)/i.test(yt) && !_t, xt = 8 === ot.documentMode, wt = /AppleWebKit/.test(yt),
        kt = /Firefox/.test(yt), Ct = /(Mobile|Android|Windows Phone)/.test(yt), St = "http://www.w3.org/2000/svg",
        Tt = !!ot.createElementNS && !!ot.createElementNS(St, "svg").createSVGRect,
        At = kt && parseInt(yt.split("Firefox/")[1], 10) < 4,
        Et = !Tt && !bt && !!ot.createElement("canvas").getContext, Lt = {}, Mt = 0, Dt = function () {
            return P
        }, Pt = [], Ft = 0, It = "div", jt = "none", Ot = /^[0-9]+$/,
        zt = ["plotTop", "marginRight", "marginBottom", "plotLeft"], Ht = "stroke-width", Nt = {};
    st = rt.Highcharts = rt.Highcharts ? S(16, !0) : {}, st.seriesTypes = Nt;
    var Rt = st.extend = function (t, e) {
        var i;
        t || (t = {});
        for (i in e) t[i] = e[i];
        return t
    }, Wt = st.pick = function () {
        var t, e, i = arguments, n = i.length;
        for (t = 0; t < n; t++) if ((e = i[t]) !== P && null !== e) return e
    }, Bt = st.wrap = function (t, e, i) {
        var n = t[e];
        t[e] = function () {
            var t = Array.prototype.slice.call(arguments);
            return t.unshift(n), i.apply(this, t)
        }
    };
    z = function (t, e, i) {
        if (!h(e) || isNaN(e)) return "Invalid date";
        var n, t = Wt(t, "%Y-%m-%d %H:%M:%S"), s = new W(e - m(e)), o = s[G](), r = s[Y](), a = s[V](), l = s[U](),
            c = s[Z](), d = O.lang, u = d.weekdays, s = Rt({
                a: u[r].substr(0, 3),
                A: u[r],
                d: g(a),
                e: a,
                w: r,
                b: d.shortMonths[l],
                B: d.months[l],
                m: g(l + 1),
                y: c.toString().substr(2, 2),
                Y: c,
                H: g(o),
                I: g(o % 12 || 12),
                l: o % 12 || 12,
                M: g(s[X]()),
                p: o < 12 ? "AM" : "PM",
                P: o < 12 ? "am" : "pm",
                S: g(s.getSeconds()),
                L: g(lt(e % 1e3), 3)
            }, st.dateFormats);
        for (n in s) for (; -1 !== t.indexOf("%" + n);) t = t.replace("%" + n, "function" == typeof s[n] ? s[n](e) : s[n]);
        return i ? t.substr(0, 1).toUpperCase() + t.substr(1) : t
    }, R = {
        millisecond: 1,
        second: 1e3,
        minute: 6e4,
        hour: 36e5,
        day: 864e5,
        week: 6048e5,
        month: 24192e5,
        year: 314496e5
    }, st.numberFormat = function (t, i, n, s) {
        var o = O.lang, t = +t || 0,
            r = -1 === i ? ut((t.toString().split(".")[1] || "").length, 20) : isNaN(i = pt(i)) ? 2 : i,
            i = void 0 === n ? o.decimalPoint : n, s = void 0 === s ? o.thousandsSep : s, o = t < 0 ? "-" : "",
            n = String(e(t = pt(t).toFixed(r))), a = n.length > 3 ? n.length % 3 : 0;
        return o + (a ? n.substr(0, a) + s : "") + n.substr(a).replace(/(\d{3})(?=\d)/g, "$1" + s) + (r ? i + pt(t - n).toFixed(r).slice(2) : "")
    }, N = {
        init: function (t, e, i) {
            var n, s, o, e = e || "", r = t.shift, a = e.indexOf("C") > -1, l = a ? 7 : 3, e = e.split(" "),
                i = [].concat(i), h = function (t) {
                    for (n = t.length; n--;) "M" === t[n] && t.splice(n + 1, 0, t[n + 1], t[n + 2], t[n + 1], t[n + 2])
                };
            if (a && (h(e), h(i)), t.isArea && (s = e.splice(e.length - 6, 6), o = i.splice(i.length - 6, 6)), r <= i.length / l && e.length === i.length) for (; r--;) i = [].concat(i).splice(0, l).concat(i);
            if (t.shift = 0, e.length) for (t = i.length; e.length < t;) r = [].concat(e).splice(e.length - l, l), a && (r[l - 6] = r[l - 2], r[l - 5] = r[l - 1]), e = e.concat(r);
            return s && (e = e.concat(s), i = i.concat(o)), [e, i]
        }, step: function (t, e, i, n) {
            var s = [], o = t.length;
            if (1 === i) s = n; else if (o === e.length && i < 1) for (; o--;) n = parseFloat(t[o]), s[o] = isNaN(n) ? t[o] : i * parseFloat(e[o] - n) + n; else s = e;
            return s
        }
    }, function (t) {
        rt.HighchartsAdapter = rt.HighchartsAdapter || t && {
            init: function (e) {
                var n = t.fx;
                t.extend(t.easing, {
                    easeOutQuad: function (t, e, i, n, s) {
                        return -n * (e /= s) * (e - 2) + i
                    }
                }), t.each(["cur", "_default", "width", "height", "opacity"], function (e, i) {
                    var s, o = n.step;
                    "cur" === i ? o = n.prototype : "_default" === i && t.Tween && (o = t.Tween.propHooks[i], i = "set"), (s = o[i]) && (o[i] = function (t) {
                        var n, t = e ? t : this;
                        if ("align" !== t.prop) return n = t.elem, n.attr ? n.attr(t.prop, "cur" === i ? P : t.now) : s.apply(this, arguments)
                    })
                }), Bt(t.cssHooks.opacity, "get", function (t, e, i) {
                    return e.attr ? e.opacity || 0 : t.call(this, e, i)
                }), this.addAnimSetter("d", function (t) {
                    var i, n = t.elem;
                    t.started || (i = e.init(n, n.d, n.toD), t.start = i[0], t.end = i[1], t.started = !0), n.attr("d", e.step(t.start, t.end, t.pos, n.toD))
                }), this.each = Array.prototype.forEach ? function (t, e) {
                    return Array.prototype.forEach.call(t, e)
                } : function (t, e) {
                    var i, n = t.length;
                    for (i = 0; i < n; i++) if (!1 === e.call(t[i], t[i], i, t)) return i
                }, t.fn.highcharts = function () {
                    var t, e, n = "Chart", s = arguments;
                    return this[0] && (i(s[0]) && (n = s[0], s = Array.prototype.slice.call(s, 1)), t = s[0], t !== P && (t.chart = t.chart || {}, t.chart.renderTo = this[0], new st[n](t, s[1]), e = this), t === P && (e = Pt[c(this[0], "data-highcharts-chart")])), e
                }
            }, addAnimSetter: function (e, i) {
                t.Tween ? t.Tween.propHooks[e] = {set: i} : t.fx.step[e] = i
            }, getScript: t.getScript, inArray: t.inArray, adapterRun: function (e, i) {
                return t(e)[i]()
            }, grep: t.grep, map: function (t, e) {
                for (var i = [], n = 0, s = t.length; n < s; n++) i[n] = e.call(t[n], t[n], n, t);
                return i
            }, offset: function (e) {
                return t(e).offset()
            }, addEvent: function (e, i, n) {
                t(e).bind(i, n)
            }, removeEvent: function (e, i, n) {
                var s = ot.removeEventListener ? "removeEventListener" : "detachEvent";
                ot[s] && e && !e[s] && (e[s] = function () {
                }), t(e).unbind(i, n)
            }, fireEvent: function (e, i, n, s) {
                var o, r = t.Event(i), a = "detached" + i;
                !bt && n && (delete n.layerX, delete n.layerY, delete n.returnValue), Rt(r, n), e[i] && (e[a] = e[i], e[i] = null), t.each(["preventDefault", "stopPropagation"], function (t, e) {
                    var i = r[e];
                    r[e] = function () {
                        try {
                            i.call(r)
                        } catch (t) {
                            "preventDefault" === e && (o = !0)
                        }
                    }
                }), t(e).trigger(r), e[a] && (e[i] = e[a], e[a] = null), s && !r.isDefaultPrevented() && !o && s(r)
            }, washMouseEvent: function (t) {
                var e = t.originalEvent || t;
                return e.pageX === P && (e.pageX = t.pageX, e.pageY = t.pageY), e
            }, animate: function (e, i, n) {
                var s = t(e);
                e.style || (e.style = {}), i.d && (e.toD = i.d, i.d = 1), s.stop(), i.opacity !== P && e.attr && (i.opacity += "px"), e.hasAnim = 1, s.animate(i, n)
            }, stop: function (e) {
                e.hasAnim && t(e).stop()
            }
        }
    }(rt.jQuery);
    var $t = rt.HighchartsAdapter, qt = $t || {};
    $t && $t.init.call($t, N);
    var Xt = qt.adapterRun, Gt = qt.getScript, Yt = qt.inArray, Vt = st.each = qt.each, Ut = qt.grep, Zt = qt.offset,
        Qt = qt.map, Kt = qt.addEvent, Jt = qt.removeEvent, te = qt.fireEvent, ee = qt.washMouseEvent, ie = qt.animate,
        ne = qt.stop;
    O = {
        colors: "#7cb5ec,#434348,#90ed7d,#f7a35c,#8085e9,#f15c80,#e4d354,#2b908f,#f45b5b,#91e8e1".split(","),
        symbols: ["circle", "diamond", "square", "triangle", "triangle-down"],
        lang: {
            loading: "Loading...",
            months: "January,February,March,April,May,June,July,August,September,October,November,December".split(","),
            shortMonths: "Jan,Feb,Mar,Apr,May,Jun,Jul,Aug,Sep,Oct,Nov,Dec".split(","),
            weekdays: "Sunday,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday".split(","),
            decimalPoint: ".",
            numericSymbols: "k,M,G,T,P,E".split(","),
            resetZoom: "Reset zoom",
            resetZoomTitle: "Reset zoom level 1:1",
            thousandsSep: " "
        },
        global: {
            useUTC: !0,
            canvasToolsURL: "http://code.highcharts.com/4.1.5/modules/canvas-tools.js",
            VMLRadialGradientURL: "http://code.highcharts.com/4.1.5/gfx/vml-radial-gradient.png"
        },
        chart: {
            borderColor: "#4572A7",
            borderRadius: 0,
            defaultSeriesType: "line",
            ignoreHiddenSeries: !0,
            spacing: [10, 10, 15, 10],
            backgroundColor: "#FFFFFF",
            plotBorderColor: "#C0C0C0",
            resetZoomButton: {theme: {zIndex: 20}, position: {align: "right", x: -10, y: 10}}
        },
        title: {text: "Chart title", align: "center", margin: 15, style: {color: "#333333", fontSize: "18px"}},
        subtitle: {text: "", align: "center", style: {color: "#555555"}},
        plotOptions: {
            line: {
                allowPointSelect: !1,
                showCheckbox: !1,
                animation: {duration: 1e3},
                events: {},
                lineWidth: 2,
                marker: {
                    lineWidth: 0,
                    radius: 4,
                    lineColor: "#FFFFFF",
                    states: {
                        hover: {enabled: !0, lineWidthPlus: 1, radiusPlus: 2},
                        select: {fillColor: "#FFFFFF", lineColor: "#000000", lineWidth: 2}
                    }
                },
                point: {events: {}},
                dataLabels: {
                    align: "center",
                    formatter: function () {
                        return null === this.y ? "" : st.numberFormat(this.y, -1)
                    },
                    style: {
                        color: "contrast",
                        fontSize: "11px",
                        fontWeight: "bold",
                        textShadow: "0 0 6px contrast, 0 0 3px contrast"
                    },
                    verticalAlign: "bottom",
                    x: 0,
                    y: 0,
                    padding: 5
                },
                cropThreshold: 300,
                pointRange: 0,
                states: {hover: {lineWidthPlus: 1, marker: {}, halo: {size: 10, opacity: .25}}, select: {marker: {}}},
                stickyTracking: !0,
                turboThreshold: 1e3
            }
        },
        labels: {style: {position: "absolute", color: "#3E576F"}},
        legend: {
            enabled: !0,
            align: "center",
            layout: "horizontal",
            labelFormatter: function () {
                return this.name
            },
            borderColor: "#909090",
            borderRadius: 0,
            navigation: {activeColor: "#274b6d", inactiveColor: "#CCC"},
            shadow: !1,
            itemStyle: {color: "#333333", fontSize: "12px", fontWeight: "bold"},
            itemHoverStyle: {color: "#000"},
            itemHiddenStyle: {color: "#CCC"},
            itemCheckboxStyle: {position: "absolute", width: "13px", height: "13px"},
            symbolPadding: 5,
            verticalAlign: "bottom",
            x: 0,
            y: 0,
            title: {style: {fontWeight: "bold"}}
        },
        loading: {
            labelStyle: {fontWeight: "bold", position: "relative", top: "45%"},
            style: {position: "absolute", backgroundColor: "white", opacity: .5, textAlign: "center"}
        },
        tooltip: {
            enabled: !0,
            animation: Tt,
            backgroundColor: "rgba(249, 249, 249, .85)",
            borderWidth: 1,
            borderRadius: 3,
            dateTimeLabelFormats: {
                millisecond: "%A, %b %e, %H:%M:%S.%L",
                second: "%A, %b %e, %H:%M:%S",
                minute: "%A, %b %e, %H:%M",
                hour: "%A, %b %e, %H:%M",
                day: "%A, %b %e, %Y",
                week: "Week from %A, %b %e, %Y",
                month: "%B %Y",
                year: "%Y"
            },
            footerFormat: "",
            headerFormat: '<span style="font-size: 10px">{point.key}</span><br/>',
            pointFormat: '<span style="color:{point.color}">\u25cf</span> {series.name}: <b>{point.y}</b><br/>',
            shadow: !0,
            snap: Ct ? 25 : 10,
            style: {color: "#333333", cursor: "default", fontSize: "12px", padding: "8px", whiteSpace: "nowrap"}
        },
        credits: {
            enabled: !0,
            text: "Highcharts.com",
            href: "http://www.highcharts.com",
            position: {align: "right", x: -10, verticalAlign: "bottom", y: -5},
            style: {cursor: "pointer", color: "#909090", fontSize: "9px"}
        }
    };
    var se = O.plotOptions, $t = se.line;
    E();
    var oe = /rgba\(\s*([0-9]{1,3})\s*,\s*([0-9]{1,3})\s*,\s*([0-9]{1,3})\s*,\s*([0-9]?(?:\.[0-9]+)?)\s*\)/,
        re = /#([a-fA-F0-9]{2})([a-fA-F0-9]{2})([a-fA-F0-9]{2})/,
        ae = /rgb\(\s*([0-9]{1,3})\s*,\s*([0-9]{1,3})\s*,\s*([0-9]{1,3})\s*\)/, le = function (i) {
            var n, s, r = [];
            return function (t) {
                t && t.stops ? s = Qt(t.stops, function (t) {
                    return le(t[1])
                }) : (n = oe.exec(t)) ? r = [e(n[1]), e(n[2]), e(n[3]), parseFloat(n[4], 10)] : (n = re.exec(t)) ? r = [e(n[1], 16), e(n[2], 16), e(n[3], 16), 1] : (n = ae.exec(t)) && (r = [e(n[1]), e(n[2]), e(n[3]), 1])
            }(i), {
                get: function (e) {
                    var n;
                    return s ? (n = t(i), n.stops = [].concat(n.stops), Vt(s, function (t, i) {
                        n.stops[i] = [n.stops[i][0], t.get(e)]
                    })) : n = r && !isNaN(r[0]) ? "rgb" === e ? "rgb(" + r[0] + "," + r[1] + "," + r[2] + ")" : "a" === e ? r[3] : "rgba(" + r.join(",") + ")" : i, n
                }, brighten: function (t) {
                    if (s) Vt(s, function (e) {
                        e.brighten(t)
                    }); else if (o(t) && 0 !== t) {
                        var i;
                        for (i = 0; i < 3; i++) r[i] += e(255 * t), r[i] < 0 && (r[i] = 0), r[i] > 255 && (r[i] = 255)
                    }
                    return this
                }, rgba: r, setOpacity: function (t) {
                    return r[3] = t, this
                }, raw: i
            }
        };
    L.prototype = {
        opacity: 1,
        textProps: "fontSize,fontWeight,fontFamily,fontStyle,color,lineHeight,width,textDecoration,textShadow".split(","),
        init: function (t, e) {
            this.element = "span" === e ? p(e) : ot.createElementNS(St, e), this.renderer = t
        },
        animate: function (e, i, n) {
            return i = Wt(i, H, !0), ne(this), i ? (i = t(i, {}), n && (i.complete = n), ie(this, e, i)) : (this.attr(e), n && n()), this
        },
        colorGradient: function (e, i, n) {
            var o, r, a, l, c, d, u, p, f, g, m = this.renderer, v = [];
            if (e.linearGradient ? r = "linearGradient" : e.radialGradient && (r = "radialGradient"), r) {
                a = e[r], l = m.gradients, d = e.stops, f = n.radialReference, s(a) && (e[r] = a = {
                    x1: a[0],
                    y1: a[1],
                    x2: a[2],
                    y2: a[3],
                    gradientUnits: "userSpaceOnUse"
                }), "radialGradient" === r && f && !h(a.gradientUnits) && (a = t(a, {
                    cx: f[0] - f[2] / 2 + a.cx * f[2],
                    cy: f[1] - f[2] / 2 + a.cy * f[2],
                    r: a.r * f[2],
                    gradientUnits: "userSpaceOnUse"
                }));
                for (g in a) "id" !== g && v.push(g, a[g]);
                for (g in d) v.push(d[g]);
                v = v.join(","), l[v] ? e = l[v].attr("id") : (a.id = e = "highcharts-" + Mt++, l[v] = c = m.createElement(r).attr(a).add(m.defs), c.stops = [], Vt(d, function (t) {
                    0 === t[1].indexOf("rgba") ? (o = le(t[1]), u = o.get("rgb"), p = o.get("a")) : (u = t[1], p = 1), t = m.createElement("stop").attr({
                        offset: t[0],
                        "stop-color": u,
                        "stop-opacity": p
                    }).add(c), c.stops.push(t)
                })), n.setAttribute(i, "url(" + m.url + "#" + e + ")")
            }
        },
        applyTextShadow: function (t) {
            var i, n = this.element, s = -1 !== t.indexOf("contrast"),
                o = this.renderer.forExport || n.style.textShadow !== P && !bt;
            s && (t = t.replace(/contrast/g, this.renderer.getContrast(n.style.fill))), o ? s && u(n, {textShadow: t}) : (this.fakeTS = !0, this.ySetter = this.xSetter, i = [].slice.call(n.getElementsByTagName("tspan")), Vt(t.split(/\s?,\s?/g), function (t) {
                var s, o, r = n.firstChild, t = t.split(" ");
                s = t[t.length - 1], (o = t[t.length - 2]) && Vt(i, function (t, i) {
                    var a;
                    0 === i && (t.setAttribute("x", n.getAttribute("x")), i = n.getAttribute("y"), t.setAttribute("y", i || 0), null === i && n.setAttribute("y", 0)), a = t.cloneNode(1), c(a, {
                        "class": "highcharts-text-shadow",
                        fill: s,
                        stroke: s,
                        "stroke-opacity": 1 / dt(e(o), 3),
                        "stroke-width": o,
                        "stroke-linejoin": "round"
                    }), n.insertBefore(a, r)
                })
            }))
        },
        attr: function (t, e) {
            var i, n, s, o, r = this.element, a = this;
            if ("string" == typeof t && e !== P && (i = t, t = {}, t[i] = e), "string" == typeof t) a = (this[t + "Getter"] || this._defaultGetter).call(this, t, r); else {
                for (i in t) n = t[i], o = !1, this.symbolName && /^(x|y|width|height|r|start|end|innerR|anchorX|anchorY)/.test(i) && (s || (this.symbolAttr(t), s = !0), o = !0), !this.rotation || "x" !== i && "y" !== i || (this.doTransform = !0), o || (this[i + "Setter"] || this._defaultSetter).call(this, n, i, r), this.shadows && /^(width|height|visibility|x|y|d|transform|cx|cy|r)$/.test(i) && this.updateShadows(i, n);
                this.doTransform && (this.updateTransform(), this.doTransform = !1)
            }
            return a
        },
        updateShadows: function (t, e) {
            for (var i = this.shadows, n = i.length; n--;) i[n].setAttribute(t, "height" === t ? dt(e - (i[n].cutHeight || 0), 0) : "d" === t ? this.d : e)
        },
        addClass: function (t) {
            var e = this.element, i = c(e, "class") || "";
            return -1 === i.indexOf(t) && c(e, "class", i + " " + t), this
        },
        symbolAttr: function (t) {
            var e = this;
            Vt("x,y,r,start,end,width,height,innerR,anchorX,anchorY".split(","), function (i) {
                e[i] = Wt(t[i], e[i])
            }), e.attr({d: e.renderer.symbols[e.symbolName](e.x, e.y, e.width, e.height, e)})
        },
        clip: function (t) {
            return this.attr("clip-path", t ? "url(" + this.renderer.url + "#" + t.id + ")" : jt)
        },
        crisp: function (t) {
            var e, i, n = {}, s = t.strokeWidth || this.strokeWidth || 0;
            i = lt(s) % 2 / 2, t.x = ht(t.x || this.x || 0) + i, t.y = ht(t.y || this.y || 0) + i, t.width = ht((t.width || this.width || 0) - 2 * i), t.height = ht((t.height || this.height || 0) - 2 * i), t.strokeWidth = s;
            for (e in t) this[e] !== t[e] && (this[e] = n[e] = t[e]);
            return n
        },
        css: function (t) {
            var i, n, s = this.styles, o = {}, r = this.element, a = "";
            if (i = !s, t && t.color && (t.fill = t.color), s) for (n in t) t[n] !== s[n] && (o[n] = t[n], i = !0);
            if (i) {
                if (i = this.textWidth = t && t.width && "text" === r.nodeName.toLowerCase() && e(t.width) || this.textWidth, s && (t = Rt(s, o)), this.styles = t, i && (Et || !Tt && this.renderer.forExport) && delete t.width, bt && !Tt) u(this.element, t); else {
                    s = function (t, e) {
                        return "-" + e.toLowerCase()
                    };
                    for (n in t) a += n.replace(/([A-Z])/g, s) + ":" + t[n] + ";";
                    c(r, "style", a)
                }
                i && this.added && this.renderer.buildText(this)
            }
            return this
        },
        on: function (t, e) {
            var i = this, n = i.element;
            return I && "click" === t ? (n.ontouchstart = function (t) {
                i.touchEventFired = W.now(), t.preventDefault(), e.call(n, t)
            }, n.onclick = function (t) {
                (-1 === yt.indexOf("Android") || W.now() - (i.touchEventFired || 0) > 1100) && e.call(n, t)
            }) : n["on" + t] = e, this
        },
        setRadialReference: function (t) {
            return this.element.radialReference = t, this
        },
        translate: function (t, e) {
            return this.attr({translateX: t, translateY: e})
        },
        invert: function () {
            return this.inverted = !0, this.updateTransform(), this
        },
        updateTransform: function () {
            var t = this.translateX || 0, e = this.translateY || 0, i = this.scaleX, n = this.scaleY, s = this.inverted,
                o = this.rotation, r = this.element;
            s && (t += this.attr("width"), e += this.attr("height")), t = ["translate(" + t + "," + e + ")"], s ? t.push("rotate(90) scale(-1,1)") : o && t.push("rotate(" + o + " " + (r.getAttribute("x") || 0) + " " + (r.getAttribute("y") || 0) + ")"), (h(i) || h(n)) && t.push("scale(" + Wt(i, 1) + " " + Wt(n, 1) + ")"), t.length && r.setAttribute("transform", t.join(" "))
        },
        toFront: function () {
            var t = this.element;
            return t.parentNode.appendChild(t), this
        },
        align: function (t, e, n) {
            var s, o, r, a, h = {};
            return o = this.renderer, r = o.alignedObjects, t ? (this.alignOptions = t, this.alignByTranslate = e, (!n || i(n)) && (this.alignTo = s = n || "renderer", l(r, this), r.push(this), n = null)) : (t = this.alignOptions, e = this.alignByTranslate, s = this.alignTo), n = Wt(n, o[s], o), s = t.align, o = t.verticalAlign, r = (n.x || 0) + (t.x || 0), a = (n.y || 0) + (t.y || 0), "right" !== s && "center" !== s || (r += (n.width - (t.width || 0)) / {
                right: 1,
                center: 2
            }[s]), h[e ? "translateX" : "x"] = lt(r), "bottom" !== o && "middle" !== o || (a += (n.height - (t.height || 0)) / ({
                bottom: 1,
                middle: 2
            }[o] || 1)), h[e ? "translateY" : "y"] = lt(a), this[this.placed ? "animate" : "attr"](h), this.placed = !0, this.alignAttr = h, this
        },
        getBBox: function (t) {
            var e, i, n = this.renderer, s = this.rotation, o = this.element, r = this.styles, a = s * vt;
            i = this.textStr;
            var l, h, c, d = o.style;
            if (i !== P && (c = ["", s || 0, r && r.fontSize, o.style.width].join(","), c = "" === i || Ot.test(i) ? "num:" + i.toString().length + c : i + c), c && !t && (e = n.cache[c]), !e) {
                if (o.namespaceURI === St || n.forExport) {
                    try {
                        h = this.fakeTS && function (t) {
                            Vt(o.querySelectorAll(".highcharts-text-shadow"), function (e) {
                                e.style.display = t
                            })
                        }, kt && d.textShadow ? (l = d.textShadow, d.textShadow = "") : h && h(jt), e = o.getBBox ? Rt({}, o.getBBox()) : {
                            width: o.offsetWidth,
                            height: o.offsetHeight
                        }, l ? d.textShadow = l : h && h("")
                    } catch (t) {
                    }
                    (!e || e.width < 0) && (e = {width: 0, height: 0})
                } else e = this.htmlGetBBox();
                n.isSVG && (t = e.width, i = e.height, bt && r && "11px" === r.fontSize && "16.9" === i.toPrecision(3) && (e.height = i = 14), s && (e.width = pt(i * gt(a)) + pt(t * ft(a)), e.height = pt(i * ft(a)) + pt(t * gt(a)))), n.cache[c] = e
            }
            return e
        },
        show: function (t) {
            return t && this.element.namespaceURI === St ? this.element.removeAttribute("visibility") : this.attr({visibility: t ? "inherit" : "visible"}), this
        },
        hide: function () {
            return this.attr({visibility: "hidden"})
        },
        fadeOut: function (t) {
            var e = this;
            e.animate({opacity: 0}, {
                duration: t || 150, complete: function () {
                    e.attr({y: -9999})
                }
            })
        },
        add: function (t) {
            var e, i = this.renderer, n = this.element;
            return t && (this.parentGroup = t), this.parentInverted = t && t.inverted, void 0 !== this.textStr && i.buildText(this), this.added = !0, (!t || t.handleZ || this.zIndex) && (e = this.zIndexSetter()), e || (t ? t.element : i.box).appendChild(n), this.onAdd && this.onAdd(), this
        },
        safeRemoveChild: function (t) {
            var e = t.parentNode;
            e && e.removeChild(t)
        },
        destroy: function () {
            var t, e, i = this, n = i.element || {}, s = i.shadows,
                o = i.renderer.isSVG && "SPAN" === n.nodeName && i.parentGroup;
            if (n.onclick = n.onmouseout = n.onmouseover = n.onmousemove = n.point = null, ne(i), i.clipPath && (i.clipPath = i.clipPath.destroy()), i.stops) {
                for (e = 0; e < i.stops.length; e++) i.stops[e] = i.stops[e].destroy();
                i.stops = null
            }
            for (i.safeRemoveChild(n), s && Vt(s, function (t) {
                i.safeRemoveChild(t)
            }); o && o.div && 0 === o.div.childNodes.length;) n = o.parentGroup, i.safeRemoveChild(o.div), delete o.div, o = n;
            i.alignTo && l(i.renderer.alignedObjects, i);
            for (t in i) delete i[t];
            return null
        },
        shadow: function (t, e, i) {
            var n, s, o, r, a, l, h = [], d = this.element;
            if (t) {
                for (r = Wt(t.width, 3), a = (t.opacity || .15) / r, l = this.parentInverted ? "(-1,-1)" : "(" + Wt(t.offsetX, 1) + ", " + Wt(t.offsetY, 1) + ")", n = 1; n <= r; n++) s = d.cloneNode(0), o = 2 * r + 1 - 2 * n, c(s, {
                    isShadow: "true",
                    stroke: t.color || "black",
                    "stroke-opacity": a * n,
                    "stroke-width": o,
                    transform: "translate" + l,
                    fill: jt
                }), i && (c(s, "height", dt(c(s, "height") - o, 0)), s.cutHeight = o), e ? e.element.appendChild(s) : d.parentNode.insertBefore(s, d), h.push(s);
                this.shadows = h
            }
            return this
        },
        xGetter: function (t) {
            return "circle" === this.element.nodeName && (t = {x: "cx", y: "cy"}[t] || t), this._defaultGetter(t)
        },
        _defaultGetter: function (t) {
            return t = Wt(this[t], this.element ? this.element.getAttribute(t) : null, 0), /^[\-0-9\.]+$/.test(t) && (t = parseFloat(t)), t
        },
        dSetter: function (t, e, i) {
            t && t.join && (t = t.join(" ")), /(NaN| {2}|^$)/.test(t) && (t = "M 0 0"), i.setAttribute(e, t), this[e] = t
        },
        dashstyleSetter: function (t) {
            var i;
            if (t = t && t.toLowerCase()) {
                for (t = t.replace("shortdashdotdot", "3,1,1,1,1,1,").replace("shortdashdot", "3,1,1,1").replace("shortdot", "1,1,").replace("shortdash", "3,1,").replace("longdash", "8,3,").replace(/dot/g, "1,3,").replace("dash", "4,3,").replace(/,$/, "").split(","), i = t.length; i--;) t[i] = e(t[i]) * this["stroke-width"];
                t = t.join(",").replace("NaN", "none"), this.element.setAttribute("stroke-dasharray", t)
            }
        },
        alignSetter: function (t) {
            this.element.setAttribute("text-anchor", {left: "start", center: "middle", right: "end"}[t])
        },
        opacitySetter: function (t, e, i) {
            this[e] = t, i.setAttribute(e, t)
        },
        titleSetter: function (t) {
            var e = this.element.getElementsByTagName("title")[0];
            e || (e = ot.createElementNS(St, "title"), this.element.appendChild(e)), e.textContent = String(Wt(t), "").replace(/<[^>]*>/g, "")
        },
        textSetter: function (t) {
            t !== this.textStr && (delete this.bBox, this.textStr = t, this.added && this.renderer.buildText(this))
        },
        fillSetter: function (t, e, i) {
            "string" == typeof t ? i.setAttribute(e, t) : t && this.colorGradient(t, e, i)
        },
        zIndexSetter: function (t, i) {
            var n, s, o, r = this.renderer, a = this.parentGroup, r = (a || r).element || r.box, l = this.element;
            n = this.added;
            var d;
            if (h(t) && (l.setAttribute(i, t), t = +t, this[i] === t && (n = !1), this[i] = t), n) {
                for ((t = this.zIndex) && a && (a.handleZ = !0), a = r.childNodes, d = 0; d < a.length && !o; d++) n = a[d], s = c(n, "zIndex"), n !== l && (e(s) > t || !h(t) && h(s)) && (r.insertBefore(l, n), o = !0);
                o || r.appendChild(l)
            }
            return o
        },
        _defaultSetter: function (t, e, i) {
            i.setAttribute(e, t)
        }
    }, L.prototype.yGetter = L.prototype.xGetter, L.prototype.translateXSetter = L.prototype.translateYSetter = L.prototype.rotationSetter = L.prototype.verticalAlignSetter = L.prototype.scaleXSetter = L.prototype.scaleYSetter = function (t, e) {
        this[e] = t, this.doTransform = !0
    }, L.prototype["stroke-widthSetter"] = L.prototype.strokeSetter = function (t, e, i) {
        this[e] = t, this.stroke && this["stroke-width"] ? (this.strokeWidth = this["stroke-width"], L.prototype.fillSetter.call(this, this.stroke, "stroke", i), i.setAttribute("stroke-width", this["stroke-width"]), this.hasStroke = !0) : "stroke-width" === e && 0 === t && this.hasStroke && (i.removeAttribute("stroke"), this.hasStroke = !1)
    };
    var he = function () {
        this.init.apply(this, arguments)
    };
    if (he.prototype = {
        Element: L, init: function (t, e, i, n, s) {
            var o, r = location, n = this.createElement("svg").attr({version: "1.1"}).css(this.getStyle(n));
            o = n.element, t.appendChild(o), -1 === t.innerHTML.indexOf("xmlns") && c(o, "xmlns", St), this.isSVG = !0, this.box = o, this.boxWrapper = n, this.alignedObjects = [], this.url = (kt || wt) && ot.getElementsByTagName("base").length ? r.href.replace(/#.*?$/, "").replace(/([\('\)])/g, "\\$1").replace(/ /g, "%20") : "", this.createElement("desc").add().element.appendChild(ot.createTextNode("Created with Highcharts 4.1.5")), this.defs = this.createElement("defs").add(), this.forExport = s, this.gradients = {}, this.cache = {}, this.setSize(e, i, !1);
            var a;
            kt && t.getBoundingClientRect && (this.subPixelFix = e = function () {
                u(t, {left: 0, top: 0}), a = t.getBoundingClientRect(), u(t, {
                    left: ct(a.left) - a.left + "px",
                    top: ct(a.top) - a.top + "px"
                })
            }, e(), Kt(rt, "resize", e))
        }, getStyle: function (t) {
            return this.style = Rt({
                fontFamily: '"Lucida Grande", "Lucida Sans Unicode", Arial, Helvetica, sans-serif',
                fontSize: "12px"
            }, t)
        }, isHidden: function () {
            return !this.boxWrapper.getBBox().width
        }, destroy: function () {
            var t = this.defs;
            return this.box = null, this.boxWrapper = this.boxWrapper.destroy(), k(this.gradients || {}), this.gradients = null, t && (this.defs = t.destroy()), this.subPixelFix && Jt(rt, "resize", this.subPixelFix), this.alignedObjects = null
        }, createElement: function (t) {
            var e = new this.Element;
            return e.init(this, t), e
        }, draw: function () {
        }, buildText: function (t) {
            for (var i, n, s = t.element, o = this, r = o.forExport, a = Wt(t.textStr, "").toString(), l = -1 !== a.indexOf("<"), h = s.childNodes, d = c(s, "x"), p = t.styles, f = t.textWidth, g = p && p.lineHeight, m = p && p.textShadow, v = p && "ellipsis" === p.textOverflow, y = h.length, _ = f && !t.added && this.box, b = function (t) {
                return g ? e(g) : o.fontMetrics(/(px|em)$/.test(t && t.style.fontSize) ? t.style.fontSize : p && p.fontSize || o.style.fontSize || 12, t).h
            }, x = function (t) {
                return t.replace(/&lt;/g, "<").replace(/&gt;/g, ">")
            }; y--;) s.removeChild(h[y]);
            l || m || v || -1 !== a.indexOf(" ") ? (i = /<.*style="([^"]+)".*>/, n = /<.*href="(http[^"]+)".*>/, _ && _.appendChild(s), a = l ? a.replace(/<(b|strong)>/g, '<span style="font-weight:bold">').replace(/<(i|em)>/g, '<span style="font-style:italic">').replace(/<a/g, "<span").replace(/<\/(b|strong|i|em|a)>/g, "</span>").split(/<br.*?>/g) : [a], "" === a[a.length - 1] && a.pop(), Vt(a, function (e, a) {
                var l, h = 0, e = e.replace(/<span/g, "|||<span").replace(/<\/span>/g, "</span>|||");
                l = e.split("|||"), Vt(l, function (e) {
                    if ("" !== e || 1 === l.length) {
                        var g, m = {}, y = ot.createElementNS(St, "tspan");
                        if (i.test(e) && (g = e.match(i)[1].replace(/(;| |^)color([ :])/, "$1fill$2"), c(y, "style", g)), n.test(e) && !r && (c(y, "onclick", 'location.href="' + e.match(n)[1] + '"'), u(y, {cursor: "pointer"})), " " !== (e = x(e.replace(/<(.|\n)*?>/g, "") || " "))) {
                            if (y.appendChild(ot.createTextNode(e)), h ? m.dx = 0 : a && null !== d && (m.x = d), c(y, m), s.appendChild(y), !h && a && (!Tt && r && u(y, {display: "block"}), c(y, "dy", b(y))), f) {
                                for (var _, w, k, m = e.replace(/([^\^])-/g, "$1- ").split(" "), C = l.length > 1 || a || m.length > 1 && "nowrap" !== p.whiteSpace, S = [], T = b(y), A = 1, E = t.rotation, L = e, M = L.length; (C || v) && (m.length || S.length);) t.rotation = 0, _ = t.getBBox(!0), k = _.width, !Tt && o.forExport && (k = o.measureSpanWidth(y.firstChild.data, t.styles)), _ = k > f, void 0 === w && (w = _), v && w ? (M /= 2, "" === L || !_ && M < .5 ? m = [] : (_ && (w = !0), L = e.substring(0, L.length + (_ ? -1 : 1) * ct(M)), m = [L + "\u2026"], y.removeChild(y.firstChild))) : _ && 1 !== m.length ? (y.removeChild(y.firstChild), S.unshift(m.pop())) : (m = S, S = [], m.length && (A++, y = ot.createElementNS(St, "tspan"), c(y, {
                                    dy: T,
                                    x: d
                                }), g && c(y, "style", g), s.appendChild(y)), k > f && (f = k)), m.length && y.appendChild(ot.createTextNode(m.join(" ").replace(/- /g, "-")));
                                w && t.attr("title", t.textStr), t.rotation = E
                            }
                            h++
                        }
                    }
                })
            }), _ && _.removeChild(s), m && t.applyTextShadow && t.applyTextShadow(m)) : s.appendChild(ot.createTextNode(x(a)))
        }, getContrast: function (t) {
            return t = le(t).rgba, t[0] + t[1] + t[2] > 384 ? "#000" : "#FFF"
        }, button: function (e, i, n, s, o, r, a, l, h) {
            var c, d, u, p, f, g, m = this.label(e, i, n, h, null, null, null, null, "button"), v = 0,
                e = {x1: 0, y1: 0, x2: 0, y2: 1}, o = t({
                    "stroke-width": 1,
                    stroke: "#CCCCCC",
                    fill: {linearGradient: e, stops: [[0, "#FEFEFE"], [1, "#F6F6F6"]]},
                    r: 2,
                    padding: 5,
                    style: {color: "black"}
                }, o);
            return u = o.style, delete o.style, r = t(o, {
                stroke: "#68A",
                fill: {linearGradient: e, stops: [[0, "#FFF"], [1, "#ACF"]]}
            }, r), p = r.style, delete r.style, a = t(o, {
                stroke: "#68A",
                fill: {linearGradient: e, stops: [[0, "#9BD"], [1, "#CDF"]]}
            }, a), f = a.style, delete a.style, l = t(o, {style: {color: "#CCC"}}, l), g = l.style, delete l.style, Kt(m.element, bt ? "mouseover" : "mouseenter", function () {
                3 !== v && m.attr(r).css(p)
            }), Kt(m.element, bt ? "mouseout" : "mouseleave", function () {
                3 !== v && (c = [o, r, a][v], d = [u, p, f][v], m.attr(c).css(d))
            }), m.setState = function (t) {
                (m.state = v = t) ? 2 === t ? m.attr(a).css(f) : 3 === t && m.attr(l).css(g) : m.attr(o).css(u)
            }, m.on("click", function () {
                3 !== v && s.call(m)
            }).attr(o).css(Rt({cursor: "default"}, u))
        }, crispLine: function (t, e) {
            return t[1] === t[4] && (t[1] = t[4] = lt(t[1]) - e % 2 / 2), t[2] === t[5] && (t[2] = t[5] = lt(t[2]) + e % 2 / 2), t
        }, path: function (t) {
            var e = {fill: jt};
            return s(t) ? e.d = t : n(t) && Rt(e, t), this.createElement("path").attr(e)
        }, circle: function (t, e, i) {
            return t = n(t) ? t : {x: t, y: e, r: i}, e = this.createElement("circle"), e.xSetter = function (t) {
                this.element.setAttribute("cx", t)
            }, e.ySetter = function (t) {
                this.element.setAttribute("cy", t)
            }, e.attr(t)
        }, arc: function (t, e, i, s, o, r) {
            return n(t) && (e = t.y, i = t.r, s = t.innerR, o = t.start, r = t.end, t = t.x), t = this.symbol("arc", t || 0, e || 0, i || 0, i || 0, {
                innerR: s || 0,
                start: o || 0,
                end: r || 0
            }), t.r = i, t
        }, rect: function (t, e, i, s, o, r) {
            var o = n(t) ? t.r : o, a = this.createElement("rect"),
                t = n(t) ? t : t === P ? {} : {x: t, y: e, width: dt(i, 0), height: dt(s, 0)};
            return r !== P && (t.strokeWidth = r, t = a.crisp(t)), o && (t.r = o), a.rSetter = function (t) {
                c(this.element, {rx: t, ry: t})
            }, a.attr(t)
        }, setSize: function (t, e, i) {
            var n = this.alignedObjects, s = n.length;
            for (this.width = t, this.height = e, this.boxWrapper[Wt(i, !0) ? "animate" : "attr"]({
                width: t,
                height: e
            }); s--;) n[s].align()
        }, g: function (t) {
            var e = this.createElement("g");
            return h(t) ? e.attr({"class": "highcharts-" + t}) : e
        }, image: function (t, e, i, n, s) {
            var o = {preserveAspectRatio: jt};
            return arguments.length > 1 && Rt(o, {
                x: e,
                y: i,
                width: n,
                height: s
            }), o = this.createElement("image").attr(o), o.element.setAttributeNS ? o.element.setAttributeNS("http://www.w3.org/1999/xlink", "href", t) : o.element.setAttribute("hc-svg-href", t), o
        }, symbol: function (t, e, i, n, s, o) {
            var r, a, l, h = this.symbols[t], h = h && h(lt(e), lt(i), n, s, o), c = /^url\((.*?)\)$/;
            return h ? (r = this.path(h), Rt(r, {
                symbolName: t,
                x: e,
                y: i,
                width: n,
                height: s
            }), o && Rt(r, o)) : c.test(t) && (l = function (t, e) {
                t.element && (t.attr({
                    width: e[0],
                    height: e[1]
                }), t.alignByTranslate || t.translate(lt((n - e[0]) / 2), lt((s - e[1]) / 2)))
            }, a = t.match(c)[1], t = Lt[a] || o && o.width && o.height && [o.width, o.height], r = this.image(a).attr({
                x: e,
                y: i
            }), r.isImg = !0, t ? l(r, t) : (r.attr({width: 0, height: 0}), p("img", {
                onload: function () {
                    l(r, Lt[a] = [this.width, this.height])
                }, src: a
            }))), r
        }, symbols: {
            circle: function (t, e, i, n) {
                var s = .166 * i
                ;
                return ["M", t + i / 2, e, "C", t + i + s, e, t + i + s, e + n, t + i / 2, e + n, "C", t - s, e + n, t - s, e, t + i / 2, e, "Z"]
            }, square: function (t, e, i, n) {
                return ["M", t, e, "L", t + i, e, t + i, e + n, t, e + n, "Z"]
            }, triangle: function (t, e, i, n) {
                return ["M", t + i / 2, e, "L", t + i, e + n, t, e + n, "Z"]
            }, "triangle-down": function (t, e, i, n) {
                return ["M", t, e, "L", t + i, e, t + i / 2, e + n, "Z"]
            }, diamond: function (t, e, i, n) {
                return ["M", t + i / 2, e, "L", t + i, e + n / 2, t + i / 2, e + n, t, e + n / 2, "Z"]
            }, arc: function (t, e, i, n, s) {
                var o = s.start, i = s.r || i || n, r = s.end - .001, n = s.innerR, a = s.open, l = ft(o), h = gt(o),
                    c = ft(r), r = gt(r), s = s.end - o < mt ? 0 : 1;
                return ["M", t + i * l, e + i * h, "A", i, i, 0, s, 1, t + i * c, e + i * r, a ? "M" : "L", t + n * c, e + n * r, "A", n, n, 0, s, 0, t + n * l, e + n * h, a ? "" : "Z"]
            }, callout: function (t, e, i, n, s) {
                var o = ut(s && s.r || 0, i, n), r = o + 6, a = s && s.anchorX, l = s && s.anchorY,
                    s = lt(s.strokeWidth || 0) % 2 / 2;
                return t += s, e += s, s = ["M", t + o, e, "L", t + i - o, e, "C", t + i, e, t + i, e, t + i, e + o, "L", t + i, e + n - o, "C", t + i, e + n, t + i, e + n, t + i - o, e + n, "L", t + o, e + n, "C", t, e + n, t, e + n, t, e + n - o, "L", t, e + o, "C", t, e, t, e, t + o, e], a && a > i && l > e + r && l < e + n - r ? s.splice(13, 3, "L", t + i, l - 6, t + i + 6, l, t + i, l + 6, t + i, e + n - o) : a && a < 0 && l > e + r && l < e + n - r ? s.splice(33, 3, "L", t, l + 6, t - 6, l, t, l - 6, t, e + o) : l && l > n && a > t + r && a < t + i - r ? s.splice(23, 3, "L", a + 6, e + n, a, e + n + 6, a - 6, e + n, t + o, e + n) : l && l < 0 && a > t + r && a < t + i - r && s.splice(3, 3, "L", a - 6, e, a, e - 6, a + 6, e, i - o, e), s
            }
        }, clipRect: function (t, e, i, n) {
            var s = "highcharts-" + Mt++, o = this.createElement("clipPath").attr({id: s}).add(this.defs),
                t = this.rect(t, e, i, n, 0).add(o);
            return t.id = s, t.clipPath = o, t.count = 0, t
        }, text: function (t, e, i, n) {
            var s = Et || !Tt && this.forExport, o = {};
            return n && !this.forExport ? this.html(t, e, i) : (o.x = Math.round(e || 0), i && (o.y = Math.round(i)), (t || 0 === t) && (o.text = t), t = this.createElement("text").attr(o), s && t.css({position: "absolute"}), n || (t.xSetter = function (t, e, i) {
                var n, s, o = i.getElementsByTagName("tspan"), r = i.getAttribute(e);
                for (s = 0; s < o.length; s++) n = o[s], n.getAttribute(e) === r && n.setAttribute(e, t);
                i.setAttribute(e, t)
            }), t)
        }, fontMetrics: function (t, i) {
            t = t || this.style.fontSize, i && rt.getComputedStyle && (i = i.element || i, t = rt.getComputedStyle(i, "").fontSize);
            var t = /px/.test(t) ? e(t) : /em/.test(t) ? 12 * parseFloat(t) : 12, n = t < 24 ? t + 3 : lt(1.2 * t);
            return {h: n, b: lt(.8 * n), f: t}
        }, rotCorr: function (t, e, i) {
            var n = t;
            return e && i && (n = dt(n * ft(e * vt), 4)), {x: -t / 3 * gt(e * vt), y: n}
        }, label: function (e, i, n, s, o, r, a, l, c) {
            function d() {
                var t, e;
                t = C.element.style, g = (void 0 === m || void 0 === v || k.styles.textAlign) && h(C.textStr) && C.getBBox(), k.width = (m || g.width || 0) + 2 * T + A, k.height = (v || g.height || 0) + 2 * T, b = T + w.fontMetrics(t && t.fontSize, C).b, x && (f || (t = lt(-S * T), e = l ? -b : 0, k.box = f = s ? w.symbol(s, t, e, k.width, k.height, M) : w.rect(t, e, k.width, k.height, 0, M[Ht]), f.attr("fill", jt).add(k)), f.isImg || f.attr(Rt({
                    width: lt(k.width),
                    height: lt(k.height)
                }, M)), M = null)
            }

            function u() {
                var t, e = k.styles, e = e && e.textAlign, i = A + T * (1 - S);
                t = l ? 0 : b, h(m) && g && ("center" === e || "right" === e) && (i += {
                    center: .5,
                    right: 1
                }[e] * (m - g.width)), i === C.x && t === C.y || (C.attr("x", i), t !== P && C.attr("SPAN" === C.element.nodeName ? "y" : "translateY", t)), C.x = i, C.y = t
            }

            function p(t, e) {
                f ? f.attr(t, e) : M[t] = e
            }

            var f, g, m, v, y, _, b, x, w = this, k = w.g(c), C = w.text("", 0, 0, a).attr({zIndex: 1}), S = 0, T = 3,
                A = 0, E = 0, M = {};
            k.onAdd = function () {
                C.add(k), k.attr({text: e || 0 === e ? e : "", x: i, y: n}), f && h(o) && k.attr({
                    anchorX: o,
                    anchorY: r
                })
            }, k.widthSetter = function (t) {
                m = t
            }, k.heightSetter = function (t) {
                v = t
            }, k.paddingSetter = function (t) {
                h(t) && t !== T && (T = k.padding = t, u())
            }, k.paddingLeftSetter = function (t) {
                h(t) && t !== A && (A = t, u())
            }, k.alignSetter = function (t) {
                S = {left: 0, center: .5, right: 1}[t]
            }, k.textSetter = function (t) {
                t !== P && C.textSetter(t), d(), u()
            }, k["stroke-widthSetter"] = function (t, e) {
                t && (x = !0), E = t % 2 / 2, p(e, t)
            }, k.strokeSetter = k.fillSetter = k.rSetter = function (t, e) {
                "fill" === e && t && (x = !0), p(e, t)
            }, k.anchorXSetter = function (t, e) {
                o = t, p(e, t + E - y)
            }, k.anchorYSetter = function (t, e) {
                r = t, p(e, t - _)
            }, k.xSetter = function (t) {
                k.x = t, S && (t -= S * ((m || g.width) + T)), y = lt(t), k.attr("translateX", y)
            }, k.ySetter = function (t) {
                _ = k.y = lt(t), k.attr("translateY", _)
            };
            var D = k.css;
            return Rt(k, {
                css: function (e) {
                    if (e) {
                        var i = {}, e = t(e);
                        Vt(k.textProps, function (t) {
                            e[t] !== P && (i[t] = e[t], delete e[t])
                        }), C.css(i)
                    }
                    return D.call(k, e)
                }, getBBox: function () {
                    return {width: g.width + 2 * T, height: g.height + 2 * T, x: g.x - T, y: g.y - T}
                }, shadow: function (t) {
                    return f && f.shadow(t), k
                }, destroy: function () {
                    Jt(k.element, "mouseenter"), Jt(k.element, "mouseleave"), C && (C = C.destroy()), f && (f = f.destroy()), L.prototype.destroy.call(k), k = w = d = u = p = null
                }
            })
        }
    }, F = he, Rt(L.prototype, {
        htmlCss: function (t) {
            var e = this.element;
            return (e = t && "SPAN" === e.tagName && t.width) && (delete t.width, this.textWidth = e, this.updateTransform()), t && "ellipsis" === t.textOverflow && (t.whiteSpace = "nowrap", t.overflow = "hidden"), this.styles = Rt(this.styles, t), u(this.element, t), this
        }, htmlGetBBox: function () {
            var t = this.element;
            return "text" === t.nodeName && (t.style.position = "absolute"), {
                x: t.offsetLeft,
                y: t.offsetTop,
                width: t.offsetWidth,
                height: t.offsetHeight
            }
        }, htmlUpdateTransform: function () {
            if (this.added) {
                var t = this.renderer, i = this.element, n = this.translateX || 0, s = this.translateY || 0,
                    o = this.x || 0, r = this.y || 0, a = this.textAlign || "left",
                    l = {left: 0, center: .5, right: 1}[a], c = this.shadows, d = this.styles;
                if (u(i, {marginLeft: n, marginTop: s}), c && Vt(c, function (t) {
                    u(t, {marginLeft: n + 1, marginTop: s + 1})
                }), this.inverted && Vt(i.childNodes, function (e) {
                    t.invertChild(e, i)
                }), "SPAN" === i.tagName) {
                    var p, f = this.rotation, g = e(this.textWidth), m = [f, a, i.innerHTML, this.textWidth].join(",");
                    m !== this.cTT && (p = t.fontMetrics(i.style.fontSize).b, h(f) && this.setSpanRotation(f, l, p), c = Wt(this.elemWidth, i.offsetWidth), c > g && /[ \-]/.test(i.textContent || i.innerText) && (u(i, {
                        width: g + "px",
                        display: "block",
                        whiteSpace: d && d.whiteSpace || "normal"
                    }), c = g), this.getSpanCorrection(c, p, l, f, a)), u(i, {
                        left: o + (this.xCorr || 0) + "px",
                        top: r + (this.yCorr || 0) + "px"
                    }), wt && (p = i.offsetHeight), this.cTT = m
                }
            } else this.alignOnAdd = !0
        }, setSpanRotation: function (t, e, i) {
            var n = {},
                s = bt ? "-ms-transform" : wt ? "-webkit-transform" : kt ? "MozTransform" : _t ? "-o-transform" : "";
            n[s] = n.transform = "rotate(" + t + "deg)", n[s + (kt ? "Origin" : "-origin")] = n.transformOrigin = 100 * e + "% " + i + "px", u(this.element, n)
        }, getSpanCorrection: function (t, e, i) {
            this.xCorr = -t * i, this.yCorr = -e
        }
    }), Rt(he.prototype, {
        html: function (t, e, i) {
            var n = this.createElement("span"), s = n.element, o = n.renderer;
            return n.textSetter = function (t) {
                t !== s.innerHTML && delete this.bBox, s.innerHTML = this.textStr = t
            }, n.xSetter = n.ySetter = n.alignSetter = n.rotationSetter = function (t, e) {
                "align" === e && (e = "textAlign"), n[e] = t, n.htmlUpdateTransform()
            }, n.attr({text: t, x: lt(e), y: lt(i)}).css({
                position: "absolute",
                fontFamily: this.style.fontFamily,
                fontSize: this.style.fontSize
            }), s.style.whiteSpace = "nowrap", n.css = n.htmlCss, o.isSVG && (n.add = function (t) {
                var e, i = o.box.parentNode, r = [];
                if (this.parentGroup = t) {
                    if (!(e = t.div)) {
                        for (; t;) r.push(t), t = t.parentGroup;
                        Vt(r.reverse(), function (t) {
                            var n;
                            e = t.div = t.div || p(It, {className: c(t.element, "class")}, {
                                position: "absolute",
                                left: (t.translateX || 0) + "px",
                                top: (t.translateY || 0) + "px"
                            }, e || i), n = e.style, Rt(t, {
                                translateXSetter: function (e, i) {
                                    n.left = e + "px", t[i] = e, t.doTransform = !0
                                }, translateYSetter: function (e, i) {
                                    n.top = e + "px", t[i] = e, t.doTransform = !0
                                }, visibilitySetter: function (t, e) {
                                    n[e] = t
                                }
                            })
                        })
                    }
                } else e = i;
                return e.appendChild(s), n.added = !0, n.alignOnAdd && n.htmlUpdateTransform(), n
            }), n
        }
    }), !Tt && !Et) {
        qt = {
            init: function (t, e) {
                var i = ["<", e, ' filled="f" stroked="f"'], n = ["position: ", "absolute", ";"], s = e === It;
                ("shape" === e || s) && n.push("left:0;top:0;width:1px;height:1px;"), n.push("visibility: ", s ? "hidden" : "visible"), i.push(' style="', n.join(""), '"/>'), e && (i = s || "span" === e || "img" === e ? i.join("") : t.prepVML(i), this.element = p(i)), this.renderer = t
            }, add: function (t) {
                var e = this.renderer, i = this.element, n = e.box, n = t ? t.element || t : n;
                return t && t.inverted && e.invertChild(i, n), n.appendChild(i), this.added = !0, this.alignOnAdd && !this.deferUpdateTransform && this.updateTransform(), this.onAdd && this.onAdd(), this
            }, updateTransform: L.prototype.htmlUpdateTransform, setSpanRotation: function () {
                var t = this.rotation, e = ft(t * vt), i = gt(t * vt);
                u(this.element, {filter: t ? ["progid:DXImageTransform.Microsoft.Matrix(M11=", e, ", M12=", -i, ", M21=", i, ", M22=", e, ", sizingMethod='auto expand')"].join("") : jt})
            }, getSpanCorrection: function (t, e, i, n, s) {
                var o, r = n ? ft(n * vt) : 1, a = n ? gt(n * vt) : 0,
                    l = Wt(this.elemHeight, this.element.offsetHeight);
                this.xCorr = r < 0 && -t, this.yCorr = a < 0 && -l, o = r * a < 0, this.xCorr += a * e * (o ? 1 - i : i), this.yCorr -= r * e * (n ? o ? i : 1 - i : 1), s && "left" !== s && (this.xCorr -= t * i * (r < 0 ? -1 : 1), n && (this.yCorr -= l * i * (a < 0 ? -1 : 1)), u(this.element, {textAlign: s}))
            }, pathToVML: function (t) {
                for (var e = t.length, i = []; e--;) o(t[e]) ? i[e] = lt(10 * t[e]) - 5 : "Z" === t[e] ? i[e] = "x" : (i[e] = t[e], !t.isArc || "wa" !== t[e] && "at" !== t[e] || (i[e + 5] === i[e + 7] && (i[e + 7] += t[e + 7] > t[e + 5] ? 1 : -1), i[e + 6] === i[e + 8] && (i[e + 8] += t[e + 8] > t[e + 6] ? 1 : -1)));
                return i.join(" ") || "x"
            }, clip: function (t) {
                var e, i = this;
                return t ? (e = t.members, l(e, i), e.push(i), i.destroyClip = function () {
                    l(e, i)
                }, t = t.getCSS(i)) : (i.destroyClip && i.destroyClip(), t = {clip: xt ? "inherit" : "rect(auto)"}), i.css(t)
            }, css: L.prototype.htmlCss, safeRemoveChild: function (t) {
                t.parentNode && C(t)
            }, destroy: function () {
                return this.destroyClip && this.destroyClip(), L.prototype.destroy.apply(this)
            }, on: function (t, e) {
                return this.element["on" + t] = function () {
                    var t = rt.event;
                    t.target = t.srcElement, e(t)
                }, this
            }, cutOffPath: function (t, i) {
                var n, t = t.split(/[ ,]/);
                return n = t.length, 9 !== n && 11 !== n || (t[n - 4] = t[n - 2] = e(t[n - 2]) - 10 * i), t.join(" ")
            }, shadow: function (t, i, n) {
                var s, o, r, a, l, h, c, d = [], u = this.element, f = this.renderer, g = u.style, m = u.path;
                if (m && "string" != typeof m.value && (m = "x"), l = m, t) {
                    for (h = Wt(t.width, 3), c = (t.opacity || .15) / h, s = 1; s <= 3; s++) a = 2 * h + 1 - 2 * s, n && (l = this.cutOffPath(m.value, a + .5)), r = ['<shape isShadow="true" strokeweight="', a, '" filled="false" path="', l, '" coordsize="10 10" style="', u.style.cssText, '" />'], o = p(f.prepVML(r), null, {
                        left: e(g.left) + Wt(t.offsetX, 1),
                        top: e(g.top) + Wt(t.offsetY, 1)
                    }), n && (o.cutOff = a + 1), r = ['<stroke color="', t.color || "black", '" opacity="', c * s, '"/>'], p(f.prepVML(r), null, null, o), i ? i.element.appendChild(o) : u.parentNode.insertBefore(o, u), d.push(o);
                    this.shadows = d
                }
                return this
            }, updateShadows: Dt, setAttr: function (t, e) {
                xt ? this.element[t] = e : this.element.setAttribute(t, e)
            }, classSetter: function (t) {
                this.element.className = t
            }, dashstyleSetter: function (t, e, i) {
                (i.getElementsByTagName("stroke")[0] || p(this.renderer.prepVML(["<stroke/>"]), null, null, i))[e] = t || "solid", this[e] = t
            }, dSetter: function (t, e, i) {
                var n = this.shadows, t = t || [];
                if (this.d = t.join && t.join(" "), i.path = t = this.pathToVML(t), n) for (i = n.length; i--;) n[i].path = n[i].cutOff ? this.cutOffPath(t, n[i].cutOff) : t;
                this.setAttr(e, t)
            }, fillSetter: function (t, e, i) {
                var n = i.nodeName;
                "SPAN" === n ? i.style.color = t : "IMG" !== n && (i.filled = t !== jt, this.setAttr("fillcolor", this.renderer.color(t, i, e, this)))
            }, opacitySetter: Dt, rotationSetter: function (t, e, i) {
                i = i.style, this[e] = i[e] = t, i.left = -lt(gt(t * vt) + 1) + "px", i.top = lt(ft(t * vt)) + "px"
            }, strokeSetter: function (t, e, i) {
                this.setAttr("strokecolor", this.renderer.color(t, i, e))
            }, "stroke-widthSetter": function (t, e, i) {
                i.stroked = !!t, this[e] = t, o(t) && (t += "px"), this.setAttr("strokeweight", t)
            }, titleSetter: function (t, e) {
                this.setAttr(e, t)
            }, visibilitySetter: function (t, e, i) {
                "inherit" === t && (t = "visible"), this.shadows && Vt(this.shadows, function (i) {
                    i.style[e] = t
                }), "DIV" === i.nodeName && (t = "hidden" === t ? "-999em" : 0, xt || (i.style[e] = t ? "visible" : "hidden"), e = "top"), i.style[e] = t
            }, xSetter: function (t, e, i) {
                this[e] = t, "x" === e ? e = "left" : "y" === e && (e = "top"), this.updateClipping ? (this[e] = t, this.updateClipping()) : i.style[e] = t
            }, zIndexSetter: function (t, e, i) {
                i.style[e] = t
            }
        }, st.VMLElement = qt = f(L, qt), qt.prototype.ySetter = qt.prototype.widthSetter = qt.prototype.heightSetter = qt.prototype.xSetter;
        var ce = {
            Element: qt, isIE8: yt.indexOf("MSIE 8.0") > -1, init: function (t, e, i, n) {
                var s;
                if (this.alignedObjects = [], n = this.createElement(It).css(Rt(this.getStyle(n), {position: "relative"})), s = n.element, t.appendChild(n.element), this.isVML = !0, this.box = s, this.boxWrapper = n, this.cache = {}, this.setSize(e, i, !1), !ot.namespaces.hcv) {
                    ot.namespaces.add("hcv", "urn:schemas-microsoft-com:vml");
                    try {
                        ot.createStyleSheet().cssText = "hcv\\:fill, hcv\\:path, hcv\\:shape, hcv\\:stroke{ behavior:url(#default#VML); display: inline-block; } "
                    } catch (t) {
                        ot.styleSheets[0].cssText += "hcv\\:fill, hcv\\:path, hcv\\:shape, hcv\\:stroke{ behavior:url(#default#VML); display: inline-block; } "
                    }
                }
            }, isHidden: function () {
                return !this.box.offsetWidth
            }, clipRect: function (t, e, i, s) {
                var o = this.createElement(), r = n(t);
                return Rt(o, {
                    members: [],
                    count: 0,
                    left: (r ? t.x : t) + 1,
                    top: (r ? t.y : e) + 1,
                    width: (r ? t.width : i) - 1,
                    height: (r ? t.height : s) - 1,
                    getCSS: function (t) {
                        var e = t.element, i = e.nodeName, t = t.inverted,
                            n = this.top - ("shape" === i ? e.offsetTop : 0), s = this.left, e = s + this.width,
                            o = n + this.height,
                            n = {clip: "rect(" + lt(t ? s : n) + "px," + lt(t ? o : e) + "px," + lt(t ? e : o) + "px," + lt(t ? n : s) + "px)"};
                        return !t && xt && "DIV" === i && Rt(n, {width: e + "px", height: o + "px"}), n
                    },
                    updateClipping: function () {
                        Vt(o.members, function (t) {
                            t.element && t.css(o.getCSS(t))
                        })
                    }
                })
            }, color: function (t, e, i, n) {
                var s, o, r, a = this, l = /^rgba/, h = jt;
                if (t && t.linearGradient ? r = "gradient" : t && t.radialGradient && (r = "pattern"), r) {
                    var c, d, u, f, g, m, v, y, _ = t.linearGradient || t.radialGradient, b = "", t = t.stops, x = [],
                        w = function () {
                            o = ['<fill colors="' + x.join(",") + '" opacity="', g, '" o:opacity2="', f, '" type="', r, '" ', b, 'focus="100%" method="any" />'], p(a.prepVML(o), null, null, e)
                        };
                    if (u = t[0], y = t[t.length - 1], u[0] > 0 && t.unshift([0, u[1]]), y[0] < 1 && t.push([1, y[1]]), Vt(t, function (t, e) {
                        l.test(t[1]) ? (s = le(t[1]), c = s.get("rgb"), d = s.get("a")) : (c = t[1], d = 1), x.push(100 * t[0] + "% " + c), e ? (g = d, m = c) : (f = d, v = c)
                    }), "fill" === i) if ("gradient" === r) i = _.x1 || _[0] || 0, t = _.y1 || _[1] || 0, u = _.x2 || _[2] || 0, _ = _.y2 || _[3] || 0, b = 'angle="' + (90 - 180 * at.atan((_ - t) / (u - i)) / mt) + '"', w(); else {
                        var k, h = _.r, C = 2 * h, S = 2 * h, T = _.cx, A = _.cy, E = e.radialReference,
                            h = function () {
                                E && (k = n.getBBox(), T += (E[0] - k.x) / k.width - .5, A += (E[1] - k.y) / k.height - .5, C *= E[2] / k.width, S *= E[2] / k.height), b = 'src="' + O.global.VMLRadialGradientURL + '" size="' + C + "," + S + '" origin="0.5,0.5" position="' + T + "," + A + '" color2="' + v + '" ', w()
                            };
                        n.added ? h() : n.onAdd = h, h = m
                    } else h = c
                } else l.test(t) && "IMG" !== e.tagName ? (s = le(t), o = ["<", i, ' opacity="', s.get("a"), '"/>'], p(this.prepVML(o), null, null, e), h = s.get("rgb")) : (h = e.getElementsByTagName(i), h.length && (h[0].opacity = 1, h[0].type = "solid"), h = t);
                return h
            }, prepVML: function (t) {
                var e = this.isIE8, t = t.join("");
                return e ? (t = t.replace("/>", ' xmlns="urn:schemas-microsoft-com:vml" />'), t = -1 === t.indexOf('style="') ? t.replace("/>", ' style="display:inline-block;behavior:url(#default#VML);" />') : t.replace('style="', 'style="display:inline-block;behavior:url(#default#VML);')) : t = t.replace("<", "<hcv:"), t
            }, text: he.prototype.html, path: function (t) {
                var e = {coordsize: "10 10"};
                return s(t) ? e.d = t : n(t) && Rt(e, t), this.createElement("shape").attr(e)
            }, circle: function (t, e, i) {
                var s = this.symbol("circle");
                return n(t) && (i = t.r, e = t.y, t = t.x), s.isCircle = !0, s.r = i, s.attr({x: t, y: e})
            }, g: function (t) {
                var e;
                return t && (e = {
                    className: "highcharts-" + t,
                    "class": "highcharts-" + t
                }), this.createElement(It).attr(e)
            }, image: function (t, e, i, n, s) {
                var o = this.createElement("img").attr({src: t});
                return arguments.length > 1 && o.attr({x: e, y: i, width: n, height: s}), o
            }, createElement: function (t) {
                return "rect" === t ? this.symbol(t) : he.prototype.createElement.call(this, t)
            }, invertChild: function (t, i) {
                var n = this, s = i.style, o = "IMG" === t.tagName && t.style;
                u(t, {
                    flip: "x",
                    left: e(s.width) - (o ? e(o.top) : 1),
                    top: e(s.height) - (o ? e(o.left) : 1),
                    rotation: -90
                }), Vt(t.childNodes, function (e) {
                    n.invertChild(e, t)
                })
            }, symbols: {
                arc: function (t, e, i, n, s) {
                    var o = s.start, r = s.end, a = s.r || i || n, i = s.innerR, n = ft(o), l = gt(o), h = ft(r),
                        c = gt(r);
                    return r - o == 0 ? ["x"] : (o = ["wa", t - a, e - a, t + a, e + a, t + a * n, e + a * l, t + a * h, e + a * c], s.open && !i && o.push("e", "M", t, e), o.push("at", t - i, e - i, t + i, e + i, t + i * h, e + i * c, t + i * n, e + i * l, "x", "e"), o.isArc = !0, o)
                }, circle: function (t, e, i, n, s) {
                    return s && (i = n = 2 * s.r), s && s.isCircle && (t -= i / 2, e -= n / 2), ["wa", t, e, t + i, e + n, t + i, e + n / 2, t + i, e + n / 2, "e"]
                }, rect: function (t, e, i, n, s) {
                    return he.prototype.symbols[h(s) && s.r ? "callout" : "square"].call(0, t, e, i, n, s)
                }
            }
        };
        st.VMLRenderer = qt = function () {
            this.init.apply(this, arguments)
        }, qt.prototype = t(he.prototype, ce), F = qt
    }
    he.prototype.measureSpanWidth = function (t, e) {
        var i, n = ot.createElement("span");
        return i = ot.createTextNode(t), n.appendChild(i), u(n, e), this.box.appendChild(n), i = n.offsetWidth, C(n), i
    };
    var de;
    Et && (st.CanVGRenderer = qt = function () {
        St = "http://www.w3.org/1999/xhtml"
    }, qt.prototype.symbols = {}, de = function () {
        function t() {
            var t, i = e.length;
            for (t = 0; t < i; t++) e[t]();
            e = []
        }

        var e = [];
        return {
            push: function (i, n) {
                0 === e.length && Gt(n, t), e.push(i)
            }
        }
    }(), F = qt), M.prototype = {
        addLabel: function () {
            var e, i = this.axis, n = i.options, s = i.chart, o = i.categories, r = i.names, l = this.pos, c = n.labels,
                d = i.tickPositions, u = l === d[0], p = l === d[d.length - 1], r = o ? Wt(o[l], r[l], l) : l,
                o = this.label, d = d.info;
            i.isDatetimeAxis && d && (e = n.dateTimeLabelFormats[d.higherRanks[l] || d.unitName]), this.isFirst = u, this.isLast = p, n = i.labelFormatter.call({
                axis: i,
                chart: s,
                isFirst: u,
                isLast: p,
                dateTimeLabelFormat: e,
                value: i.isLog ? T(a(r)) : r
            }), h(o) ? o && o.attr({text: n}) : (this.labelLength = (this.label = o = h(n) && c.enabled ? s.renderer.text(n, 0, 0, c.useHTML).css(t(c.style)).add(i.labelGroup) : null) && o.getBBox().width, this.rotation = 0)
        }, getLabelSize: function () {
            return this.label ? this.label.getBBox()[this.axis.horiz ? "height" : "width"] : 0
        }, handleOverflow: function (t) {
            var e, i = this.axis, n = t.x, s = i.chart.chartWidth, o = i.chart.spacing, r = Wt(i.labelLeft, o[3]),
                o = Wt(i.labelRight, s - o[1]), a = this.label, l = this.rotation,
                h = {left: 0, center: .5, right: 1}[i.labelAlign], c = a.getBBox().width, d = i.slotWidth;
            l ? l < 0 && n - h * c < r ? e = lt(n / ft(l * vt) - r) : l > 0 && n + h * c > o && (e = lt((s - n) / ft(l * vt))) : (s = n - h * c, n += h * c, s < r ? (d -= r - s, t.x = r, a.attr({align: "left"})) : n > o && (d -= n - o, t.x = o, a.attr({align: "right"})), (c > d || i.autoRotation && a.styles.width) && (e = d)), e && a.css({
                width: e,
                textOverflow: "ellipsis"
            })
        }, getPosition: function (t, e, i, n) {
            var s = this.axis, o = s.chart, r = n && o.oldChartHeight || o.chartHeight;
            return {
                x: t ? s.translate(e + i, null, null, n) + s.transB : s.left + s.offset + (s.opposite ? (n && o.oldChartWidth || o.chartWidth) - s.right - s.left : 0),
                y: t ? r - s.bottom + s.offset - (s.opposite ? s.height : 0) : r - s.translate(e + i, null, null, n) - s.transB
            }
        }, getLabelPosition: function (t, e, i, n, s, o, r, a) {
            var l = this.axis, h = l.transA, c = l.reversed, d = l.staggerLines, u = l.tickRotCorr || {x: 0, y: 0},
                i = Wt(s.y, u.y + (2 === l.side ? 8 : -i.getBBox().height / 2)),
                t = t + s.x + u.x - (o && n ? o * h * (c ? -1 : 1) : 0),
                e = e + i - (o && !n ? o * h * (c ? 1 : -1) : 0);
            return d && (e += r / (a || 1) % d * (l.labelOffset / d)), {x: t, y: lt(e)}
        }, getMarkPath: function (t, e, i, n, s, o) {
            return o.crispLine(["M", t, e, "L", t + (s ? 0 : -i), e + (s ? i : 0)], n)
        }, render: function (t, e, i) {
            var n = this.axis, s = n.options, o = n.chart.renderer, r = n.horiz, a = this.type, l = this.label,
                h = this.pos, c = s.labels, d = this.gridLine, u = a ? a + "Grid" : "grid", p = a ? a + "Tick" : "tick",
                f = s[u + "LineWidth"], g = s[u + "LineColor"], m = s[u + "LineDashStyle"], v = s[p + "Length"],
                u = s[p + "Width"] || 0, y = s[p + "Color"], _ = s[p + "Position"], p = this.mark, b = c.step, x = !0,
                w = n.tickmarkOffset, k = this.getPosition(r, h, w, e), C = k.x, k = k.y,
                S = r && C === n.pos + n.len || !r && k === n.pos ? -1 : 1, i = Wt(i, 1);
            this.isActive = !0, f && (h = n.getPlotLinePath(h + w, f * S, e, !0), d === P && (d = {
                stroke: g,
                "stroke-width": f
            }, m && (d.dashstyle = m), a || (d.zIndex = 1), e && (d.opacity = 0), this.gridLine = d = f ? o.path(h).attr(d).add(n.gridGroup) : null), !e && d && h && d[this.isNew ? "attr" : "animate"]({
                d: h,
                opacity: i
            })), u && v && ("inside" === _ && (v = -v), n.opposite && (v = -v), a = this.getMarkPath(C, k, v, u * S, r, o), p ? p.animate({
                d: a,
                opacity: i
            }) : this.mark = o.path(a).attr({
                stroke: y,
                "stroke-width": u,
                opacity: i
            }).add(n.axisGroup)), l && !isNaN(C) && (l.xy = k = this.getLabelPosition(C, k, l, r, c, w, t, b), this.isFirst && !this.isLast && !Wt(s.showFirstLabel, 1) || this.isLast && !this.isFirst && !Wt(s.showLastLabel, 1) ? x = !1 : r && !n.isRadial && !c.step && !c.rotation && !e && 0 !== i && this.handleOverflow(k), b && t % b && (x = !1), x && !isNaN(k.y) ? (k.opacity = i, l[this.isNew ? "attr" : "animate"](k), this.isNew = !1) : l.attr("y", -9999))
        }, destroy: function () {
            k(this, this.axis)
        }
    }, st.PlotLineOrBand = function (t, e) {
        this.axis = t, e && (this.options = e, this.id = e.id)
    }, st.PlotLineOrBand.prototype = {
        render: function () {
            var e, i = this, n = i.axis, s = n.horiz, o = i.options, a = o.label, l = i.label, c = o.width, d = o.to,
                u = o.from, p = h(u) && h(d), f = o.value, g = o.dashStyle, m = i.svgElem, v = [], y = o.color,
                _ = o.zIndex, b = o.events, k = {}, C = n.chart.renderer;
            if (n.isLog && (u = r(u), d = r(d), f = r(f)), c) v = n.getPlotLinePath(f, c), k = {
                stroke: y,
                "stroke-width": c
            }, g && (k.dashstyle = g); else {
                if (!p) return;
                v = n.getPlotBandPath(u, d, o), y && (k.fill = y), o.borderWidth && (k.stroke = o.borderColor, k["stroke-width"] = o.borderWidth)
            }
            if (h(_) && (k.zIndex = _), m) v ? m.animate({d: v}, null, m.onGetPath) : (m.hide(), m.onGetPath = function () {
                m.show()
            }, l && (i.label = l = l.destroy())); else if (v && v.length && (i.svgElem = m = C.path(v).attr(k).add(), b)) for (e in o = function (t) {
                m.on(t, function (e) {
                    b[t].apply(i, [e])
                })
            }, b) o(e);
            return a && h(a.text) && v && v.length && n.width > 0 && n.height > 0 ? (a = t({
                align: s && p && "center",
                x: s ? !p && 4 : 10,
                verticalAlign: !s && p && "middle",
                y: s ? p ? 16 : 10 : p ? 6 : -4,
                rotation: s && !p && 90
            }, a), l || (k = {
                align: a.textAlign || a.align,
                rotation: a.rotation
            }, h(_) && (k.zIndex = _), i.label = l = C.text(a.text, 0, 0, a.useHTML).attr(k).css(a.style).add()), n = [v[1], v[4], p ? v[6] : v[1]], p = [v[2], v[5], p ? v[7] : v[2]], v = x(n), s = x(p), l.align(a, !1, {
                x: v,
                y: s,
                width: w(n) - v,
                height: w(p) - s
            }), l.show()) : l && l.hide(), i
        }, destroy: function () {
            l(this.axis.plotLinesAndBands, this), delete this.axis, k(this)
        }
    };
    var ue = st.Axis = function () {
        this.init.apply(this, arguments)
    };
    ue.prototype = {
        defaultOptions: {
            dateTimeLabelFormats: {
                millisecond: "%H:%M:%S.%L",
                second: "%H:%M:%S",
                minute: "%H:%M",
                hour: "%H:%M",
                day: "%e. %b",
                week: "%e. %b",
                month: "%b '%y",
                year: "%Y"
            },
            endOnTick: !1,
            gridLineColor: "#D8D8D8",
            labels: {enabled: !0, style: {color: "#606060", cursor: "default", fontSize: "11px"}, x: 0, y: 15},
            lineColor: "#C0D0E0",
            lineWidth: 1,
            minPadding: .01,
            maxPadding: .01,
            minorGridLineColor: "#E0E0E0",
            minorGridLineWidth: 1,
            minorTickColor: "#A0A0A0",
            minorTickLength: 2,
            minorTickPosition: "outside",
            startOfWeek: 1,
            startOnTick: !1,
            tickColor: "#C0D0E0",
            tickLength: 10,
            tickmarkPlacement: "between",
            tickPixelInterval: 100,
            tickPosition: "outside",
            tickWidth: 1,
            title: {align: "middle", style: {color: "#707070"}},
            type: "linear"
        },
        defaultYAxisOptions: {
            endOnTick: !0,
            gridLineWidth: 1,
            tickPixelInterval: 72,
            showLastLabel: !0,
            labels: {x: -8, y: 3},
            lineWidth: 0,
            maxPadding: .05,
            minPadding: .05,
            startOnTick: !0,
            tickWidth: 0,
            title: {rotation: 270, text: "Values"},
            stackLabels: {
                enabled: !1, formatter: function () {
                    return st.numberFormat(this.total, -1)
                }, style: t(se.line.dataLabels.style, {color: "#000000"})
            }
        },
        defaultLeftAxisOptions: {labels: {x: -15, y: null}, title: {rotation: 270}},
        defaultRightAxisOptions: {labels: {x: 15, y: null}, title: {rotation: 90}},
        defaultBottomAxisOptions: {labels: {autoRotation: [-45], x: 0, y: null}, title: {rotation: 0}},
        defaultTopAxisOptions: {labels: {autoRotation: [-45], x: 0, y: -15}, title: {rotation: 0}},
        init: function (t, e) {
            var i = e.isX;
            this.horiz = t.inverted ? !i : i, this.coll = (this.isXAxis = i) ? "xAxis" : "yAxis", this.opposite = e.opposite, this.side = e.side || (this.horiz ? this.opposite ? 0 : 2 : this.opposite ? 1 : 3), this.setOptions(e);
            var n = this.options, s = n.type;
            this.labelFormatter = n.labels.formatter || this.defaultLabelFormatter, this.userOptions = e, this.minPixelPadding = 0, this.chart = t, this.reversed = n.reversed, this.zoomEnabled = !1 !== n.zoomEnabled, this.categories = n.categories || "category" === s, this.names = this.names || [], this.isLog = "logarithmic" === s, this.isDatetimeAxis = "datetime" === s, this.isLinked = h(n.linkedTo), this.ticks = {}, this.labelEdge = [], this.minorTicks = {}, this.plotLinesAndBands = [], this.alternateBands = {}, this.len = 0, this.minRange = this.userMinRange = n.minRange || n.maxZoom, this.range = n.range, this.offset = n.offset || 0, this.stacks = {}, this.oldStacks = {}, this.min = this.max = null, this.crosshair = Wt(n.crosshair, d(t.options.tooltip.crosshairs)[i ? 0 : 1], !1);
            var o, n = this.options.events;
            -1 === Yt(this, t.axes) && (i && !this.isColorAxis ? t.axes.splice(t.xAxis.length, 0, this) : t.axes.push(this), t[this.coll].push(this)), this.series = this.series || [], t.inverted && i && this.reversed === P && (this.reversed = !0), this.removePlotLine = this.removePlotBand = this.removePlotBandOrLine;
            for (o in n) Kt(this, o, n[o]);
            this.isLog && (this.val2lin = r, this.lin2val = a)
        },
        setOptions: function (e) {
            this.options = t(this.defaultOptions, this.isXAxis ? {} : this.defaultYAxisOptions, [this.defaultTopAxisOptions, this.defaultRightAxisOptions, this.defaultBottomAxisOptions, this.defaultLeftAxisOptions][this.side], t(O[this.coll], e))
        },
        defaultLabelFormatter: function () {
            var t, e = this.axis, i = this.value, n = e.categories, s = this.dateTimeLabelFormat,
                o = O.lang.numericSymbols, r = o && o.length, a = e.options.labels.format,
                e = e.isLog ? i : e.tickInterval;
            if (a) t = v(a, this); else if (n) t = i; else if (s) t = z(s, i); else if (r && e >= 1e3) for (; r-- && t === P;) n = Math.pow(1e3, r + 1), e >= n && null !== o[r] && (t = st.numberFormat(i / n, -1) + o[r]);
            return t === P && (t = pt(i) >= 1e4 ? st.numberFormat(i, 0) : st.numberFormat(i, -1, P, "")), t
        },
        getSeriesExtremes: function () {
            var t = this, e = t.chart;
            t.hasVisibleSeries = !1, t.dataMin = t.dataMax = t.ignoreMinPadding = t.ignoreMaxPadding = null, t.buildStacks && t.buildStacks(), Vt(t.series, function (i) {
                if (i.visible || !e.options.chart.ignoreHiddenSeries) {
                    var n;
                    n = i.options.threshold;
                    var s;
                    t.hasVisibleSeries = !0, t.isLog && n <= 0 && (n = null), t.isXAxis ? (n = i.xData, n.length && (t.dataMin = ut(Wt(t.dataMin, n[0]), x(n)), t.dataMax = dt(Wt(t.dataMax, n[0]), w(n)))) : (i.getExtremes(), s = i.dataMax, i = i.dataMin, h(i) && h(s) && (t.dataMin = ut(Wt(t.dataMin, i), i), t.dataMax = dt(Wt(t.dataMax, s), s)), h(n) && (t.dataMin >= n ? (t.dataMin = n, t.ignoreMinPadding = !0) : t.dataMax < n && (t.dataMax = n, t.ignoreMaxPadding = !0)))
                }
            })
        },
        translate: function (t, e, i, n, s, r) {
            var a = 1, l = 0, h = n ? this.oldTransA : this.transA, n = n ? this.oldMin : this.min,
                c = this.minPixelPadding, s = (this.doPostTranslate || this.isLog && s) && this.lin2val;
            return h || (h = this.transA), i && (a *= -1, l = this.len), this.reversed && (a *= -1, l -= a * (this.sector || this.len)), e ? (t = t * a + l, t -= c, t = t / h + n, s && (t = this.lin2val(t))) : (s && (t = this.val2lin(t)), "between" === r && (r = .5), t = a * (t - n) * h + l + a * c + (o(r) ? h * r * this.pointRange : 0)), t
        },
        toPixels: function (t, e) {
            return this.translate(t, !1, !this.horiz, null, !0) + (e ? 0 : this.pos)
        },
        toValue: function (t, e) {
            return this.translate(t - (e ? 0 : this.pos), !0, !this.horiz, null, !0)
        },
        getPlotLinePath: function (t, e, i, n, s) {
            var o, r, a, l = this.chart, h = this.left, c = this.top, d = i && l.oldChartHeight || l.chartHeight,
                u = i && l.oldChartWidth || l.chartWidth;
            o = this.transB;
            var p = function (t, e, i) {
                return (t < e || t > i) && (n ? t = ut(dt(e, t), i) : a = !0), t
            }, s = Wt(s, this.translate(t, null, null, i)), t = i = lt(s + o);
            return o = r = lt(d - s - o), isNaN(s) ? a = !0 : this.horiz ? (o = c, r = d - this.bottom, t = i = p(t, h, h + this.width)) : (t = h, i = u - this.right, o = r = p(o, c, c + this.height)), a && !n ? null : l.renderer.crispLine(["M", t, o, "L", i, r], e || 1)
        },
        getLinearTickPositions: function (t, e, i) {
            var n, s = T(ht(e / t) * t), r = T(ct(i / t) * t), a = [];
            if (e === i && o(e)) return [e];
            for (e = s; e <= r && (a.push(e), (e = T(e + t)) !== n);) n = e;
            return a
        },
        getMinorTickPositions: function () {
            var t, e = this.options, i = this.tickPositions, n = this.minorTickInterval, s = [], o = this.min;
            t = this.max;
            var r = t - o;
            if (r && r / n < this.len / 3) if (this.isLog) for (e = i.length, t = 1; t < e; t++) s = s.concat(this.getLogTickPositions(n, i[t - 1], i[t], !0)); else if (this.isDatetimeAxis && "auto" === e.minorTickInterval) s = s.concat(this.getTimeTicks(this.normalizeTimeTickInterval(n), o, t, e.startOfWeek)); else for (i = o + (i[0] - o) % n; i <= t; i += n) s.push(i);
            return this.trimTicks(s), s
        },
        adjustForMinRange: function () {
            var t, e, i, n, s, o, r = this.options, a = this.min, l = this.max,
                c = this.dataMax - this.dataMin >= this.minRange;
            if (this.isXAxis && this.minRange === P && !this.isLog && (h(r.min) || h(r.max) ? this.minRange = null : (Vt(this.series, function (t) {
                for (s = t.xData, i = o = t.xIncrement ? 1 : s.length - 1; i > 0; i--) n = s[i] - s[i - 1], (e === P || n < e) && (e = n)
            }), this.minRange = ut(5 * e, this.dataMax - this.dataMin))), l - a < this.minRange) {
                var d = this.minRange;
                t = (d - l + a) / 2, t = [a - t, Wt(r.min, a - t)], c && (t[2] = this.dataMin), a = w(t), l = [a + d, Wt(r.max, a + d)], c && (l[2] = this.dataMax), l = x(l), l - a < d && (t[0] = l - d, t[1] = Wt(r.min, l - d), a = w(t))
            }
            this.min = a, this.max = l
        },
        setAxisTranslation: function (t) {
            var e, n = this, s = n.max - n.min, o = n.axisPointRange || 0, r = 0, a = 0, l = n.linkedParent,
                c = !!n.categories, d = n.transA, u = n.isXAxis;
            (u || c || o) && (l ? (r = l.minPointOffset, a = l.pointRangePadding) : Vt(n.series, function (t) {
                var l = c ? 1 : u ? t.pointRange : n.axisPointRange || 0, d = t.options.pointPlacement,
                    p = t.closestPointRange;
                l > s && (l = 0), o = dt(o, l), n.single || (r = dt(r, i(d) ? 0 : l / 2), a = dt(a, "on" === d ? 0 : l)), !t.noSharedTooltip && h(p) && (e = h(e) ? ut(e, p) : p)
            }), l = n.ordinalSlope && e ? n.ordinalSlope / e : 1, n.minPointOffset = r *= l, n.pointRangePadding = a *= l, n.pointRange = ut(o, s), u && (n.closestPointRange = e)), t && (n.oldTransA = d), n.translationSlope = n.transA = d = n.len / (s + a || 1), n.transB = n.horiz ? n.left : n.bottom, n.minPixelPadding = d * r
        },
        setTickInterval: function (t) {
            var e = this, i = e.chart, n = e.options, s = e.isLog, a = e.isDatetimeAxis, l = e.isXAxis, c = e.isLinked,
                d = n.maxPadding, u = n.minPadding, p = n.tickInterval, f = n.tickPixelInterval, g = e.categories;
            !a && !g && !c && this.getTickAmount(), c ? (e.linkedParent = i[e.coll][n.linkedTo], i = e.linkedParent.getExtremes(), e.min = Wt(i.min, i.dataMin), e.max = Wt(i.max, i.dataMax), n.type !== e.linkedParent.options.type && S(11, 1)) : (e.min = Wt(e.userMin, n.min, e.dataMin), e.max = Wt(e.userMax, n.max, e.dataMax)), s && (!t && ut(e.min, Wt(e.dataMin, e.min)) <= 0 && S(10, 1), e.min = T(r(e.min)), e.max = T(r(e.max))), e.range && h(e.max) && (e.userMin = e.min = dt(e.min, e.max - e.range), e.userMax = e.max, e.range = null), e.beforePadding && e.beforePadding(), e.adjustForMinRange(), g || e.axisPointRange || e.usePercentage || c || !h(e.min) || !h(e.max) || !(i = e.max - e.min) || (h(n.min) || h(e.userMin) || !u || !(e.dataMin < 0) && e.ignoreMinPadding || (e.min -= i * u), h(n.max) || h(e.userMax) || !d || !(e.dataMax > 0) && e.ignoreMaxPadding || (e.max += i * d)), o(n.floor) && (e.min = dt(e.min, n.floor)), o(n.ceiling) && (e.max = ut(e.max, n.ceiling)), e.tickInterval = e.min === e.max || void 0 === e.min || void 0 === e.max ? 1 : c && !p && f === e.linkedParent.options.tickPixelInterval ? e.linkedParent.tickInterval : Wt(p, this.tickAmount ? (e.max - e.min) / dt(this.tickAmount - 1, 1) : void 0, g ? 1 : (e.max - e.min) * f / dt(e.len, f)), l && !t && Vt(e.series, function (t) {
                t.processData(e.min !== e.oldMin || e.max !== e.oldMax)
            }), e.setAxisTranslation(!0), e.beforeSetTickPositions && e.beforeSetTickPositions(), e.postProcessTickInterval && (e.tickInterval = e.postProcessTickInterval(e.tickInterval)), e.pointRange && (e.tickInterval = dt(e.pointRange, e.tickInterval)), t = Wt(n.minTickInterval, e.isDatetimeAxis && e.closestPointRange), !p && e.tickInterval < t && (e.tickInterval = t), a || s || p || (e.tickInterval = _(e.tickInterval, null, y(e.tickInterval), Wt(n.allowDecimals, !(e.tickInterval > .5 && e.tickInterval < 5 && e.max > 1e3 && e.max < 9999)), !!this.tickAmount)), !this.tickAmount && this.len && (e.tickInterval = e.unsquish()), this.setTickPositions()
        },
        setTickPositions: function () {
            var t, e, i = this.options, n = i.tickPositions, s = i.tickPositioner, o = i.startOnTick, r = i.endOnTick;
            this.tickmarkOffset = this.categories && "between" === i.tickmarkPlacement && 1 === this.tickInterval ? .5 : 0, this.minorTickInterval = "auto" === i.minorTickInterval && this.tickInterval ? this.tickInterval / 5 : i.minorTickInterval, this.tickPositions = t = i.tickPositions && i.tickPositions.slice(), !t && (this.tickPositions = t = this.isDatetimeAxis ? this.getTimeTicks(this.normalizeTimeTickInterval(this.tickInterval, i.units), this.min, this.max, i.startOfWeek, this.ordinalPositions, this.closestPointRange, !0) : this.isLog ? this.getLogTickPositions(this.tickInterval, this.min, this.max) : this.getLinearTickPositions(this.tickInterval, this.min, this.max), s && (s = s.apply(this, [this.min, this.max]))) && (this.tickPositions = t = s), this.isLinked || (this.trimTicks(t, o, r), this.min === this.max && h(this.min) && !this.tickAmount && (e = !0, this.min -= .5, this.max += .5), this.single = e, !n && !s && this.adjustTickAmount())
        },
        trimTicks: function (t, e, i) {
            var n = t[0], s = t[t.length - 1], o = this.minPointOffset || 0;
            e ? this.min = n : this.min - o > n && t.shift(), i ? this.max = s : this.max + o < s && t.pop(), 0 === t.length && h(n) && t.push((s + n) / 2)
        },
        getTickAmount: function () {
            var t, e = {}, i = this.options, n = i.tickAmount, s = i.tickPixelInterval;
            !h(i.tickInterval) && this.len < s && !this.isRadial && !this.isLog && i.startOnTick && i.endOnTick && (n = 2), !n && !1 !== this.chart.options.chart.alignTicks && !1 !== i.alignTicks && (Vt(this.chart[this.coll], function (i) {
                var n = i.options, i = i.horiz, n = [i ? n.left : n.top, i ? n.width : n.height, n.pane].join(",");
                e[n] ? t = !0 : e[n] = 1
            }), t && (n = ct(this.len / s) + 1)), n < 4 && (this.finalTickAmt = n, n = 5), this.tickAmount = n
        },
        adjustTickAmount: function () {
            var t = this.tickInterval, e = this.tickPositions, i = this.tickAmount, n = this.finalTickAmt,
                s = e && e.length;
            if (s < i) {
                for (; e.length < i;) e.push(T(e[e.length - 1] + t));
                this.transA *= (s - 1) / (i - 1), this.max = e[e.length - 1]
            } else s > i && (this.tickInterval *= 2, this.setTickPositions());
            if (h(n)) {
                for (t = i = e.length; t--;) (3 === n && t % 2 == 1 || n <= 2 && t > 0 && t < i - 1) && e.splice(t, 1);
                this.finalTickAmt = P
            }
        },
        setScale: function () {
            var t, e, i, n, s = this.stacks;
            if (this.oldMin = this.min, this.oldMax = this.max, this.oldAxisLength = this.len, this.setAxisSize(), n = this.len !== this.oldAxisLength, Vt(this.series, function (t) {
                (t.isDirtyData || t.isDirty || t.xAxis.isDirty) && (i = !0)
            }), n || i || this.isLinked || this.forceRedraw || this.userMin !== this.oldUserMin || this.userMax !== this.oldUserMax) {
                if (!this.isXAxis) for (t in s) for (e in s[t]) s[t][e].total = null, s[t][e].cum = 0;
                this.forceRedraw = !1, this.getSeriesExtremes(), this.setTickInterval(), this.oldUserMin = this.userMin, this.oldUserMax = this.userMax, this.isDirty || (this.isDirty = n || this.min !== this.oldMin || this.max !== this.oldMax)
            } else if (!this.isXAxis) {
                this.oldStacks && (s = this.stacks = this.oldStacks);
                for (t in s) for (e in s[t]) s[t][e].cum = s[t][e].total
            }
        },
        setExtremes: function (t, e, i, n, s) {
            var o = this, r = o.chart, i = Wt(i, !0);
            Vt(o.series, function (t) {
                delete t.kdTree
            }), s = Rt(s, {min: t, max: e}), te(o, "setExtremes", s, function () {
                o.userMin = t, o.userMax = e, o.eventArgs = s, o.isDirtyExtremes = !0, i && r.redraw(n)
            })
        },
        zoom: function (t, e) {
            var i = this.dataMin, n = this.dataMax, s = this.options;
            return this.allowZoomOutside || (h(i) && t <= ut(i, Wt(s.min, i)) && (t = P), h(n) && e >= dt(n, Wt(s.max, n)) && (e = P)), this.displayBtn = t !== P || e !== P, this.setExtremes(t, e, !1, P, {trigger: "zoom"}), !0
        },
        setAxisSize: function () {
            var t = this.chart, e = this.options, i = e.offsetLeft || 0, n = this.horiz,
                s = Wt(e.width, t.plotWidth - i + (e.offsetRight || 0)), o = Wt(e.height, t.plotHeight),
                r = Wt(e.top, t.plotTop), e = Wt(e.left, t.plotLeft + i), i = /%$/;
            i.test(o) && (o = parseFloat(o) / 100 * t.plotHeight), i.test(r) && (r = parseFloat(r) / 100 * t.plotHeight + t.plotTop), this.left = e, this.top = r, this.width = s, this.height = o, this.bottom = t.chartHeight - o - r, this.right = t.chartWidth - s - e, this.len = dt(n ? s : o, 0), this.pos = n ? e : r
        },
        getExtremes: function () {
            var t = this.isLog;
            return {
                min: t ? T(a(this.min)) : this.min,
                max: t ? T(a(this.max)) : this.max,
                dataMin: this.dataMin,
                dataMax: this.dataMax,
                userMin: this.userMin,
                userMax: this.userMax
            }
        },
        getThreshold: function (t) {
            var e = this.isLog, i = e ? a(this.min) : this.min, e = e ? a(this.max) : this.max;
            return i > t || null === t ? t = i : e < t && (t = e), this.translate(t, 0, 1, 0, 1)
        },
        autoLabelAlign: function (t) {
            return t = (Wt(t, 0) - 90 * this.side + 720) % 360, t > 15 && t < 165 ? "right" : t > 195 && t < 345 ? "left" : "center"
        },
        unsquish: function () {
            var t, e, i, n = this.ticks, s = this.options.labels, o = this.horiz, r = this.tickInterval, a = r,
                l = this.len / (((this.categories ? 1 : 0) + this.max - this.min) / r), c = s.rotation,
                d = this.chart.renderer.fontMetrics(s.style.fontSize, n[0] && n[0].label), u = Number.MAX_VALUE,
                p = function (t) {
                    return t /= l || 1, (t = t > 1 ? ct(t) : 1) * r
                };
            return o ? (i = h(c) ? [c] : l < Wt(s.autoRotationLimit, 80) && !s.staggerLines && !s.step && s.autoRotation) && Vt(i, function (i) {
                var n;
                (i === c || i && i >= -90 && i <= 90) && (e = p(pt(d.h / gt(vt * i))), (n = e + pt(i / 360)) < u && (u = n, t = i, a = e))
            }) : a = p(d.h), this.autoRotation = i, this.labelRotation = t, a
        },
        renderUnsquish: function () {
            var e, n = this.chart, s = n.renderer, o = this.tickPositions, r = this.ticks, a = this.options.labels,
                l = this.horiz, h = n.margin,
                c = this.slotWidth = l && !a.step && !a.rotation && (this.staggerLines || 1) * n.plotWidth / o.length || !l && (h[3] && h[3] - n.spacing[3] || .33 * n.chartWidth),
                d = dt(1, lt(c - 2 * (a.padding || 5))), u = {},
                h = s.fontMetrics(a.style.fontSize, r[0] && r[0].label), p = 0;
            if (i(a.rotation) || (u.rotation = a.rotation), this.autoRotation) Vt(o, function (t) {
                (t = r[t]) && t.labelLength > p && (p = t.labelLength)
            }), p > d && p > h.h ? u.rotation = this.labelRotation : this.labelRotation = 0; else if (c) for (e = {
                width: d + "px",
                textOverflow: "clip"
            }, c = o.length; !l && c--;) d = o[c], (d = r[d].label) && ("ellipsis" === d.styles.textOverflow && d.css({textOverflow: "clip"}), d.getBBox().height > this.len / o.length - (h.h - h.f) && (d.specCss = {textOverflow: "ellipsis"}));
            u.rotation && (e = {
                width: (p > .5 * n.chartHeight ? .33 * n.chartHeight : n.chartHeight) + "px",
                textOverflow: "ellipsis"
            }), this.labelAlign = u.align = a.align || this.autoLabelAlign(this.labelRotation), Vt(o, function (i) {
                var n = (i = r[i]) && i.label;
                n && (e && n.css(t(e, n.specCss)), delete n.specCss, n.attr(u), i.rotation = u.rotation)
            }), this.tickRotCorr = s.rotCorr(h.b, this.labelRotation || 0, 2 === this.side)
        },
        getOffset: function () {
            var t, e, i, n, s = this, o = s.chart, r = o.renderer, a = s.options, l = s.tickPositions, c = s.ticks,
                d = s.horiz, u = s.side, p = o.inverted ? [1, 0, 3, 2][u] : u, f = 0, g = 0, m = a.title, v = a.labels,
                y = 0, _ = o.axisOffset, o = o.clipOffset, b = [-1, 1, 1, -1][u];
            if (s.hasData = t = s.hasVisibleSeries || h(s.min) && h(s.max) && !!l, s.showAxis = e = t || Wt(a.showEmpty, !0), s.staggerLines = s.horiz && v.staggerLines, s.axisGroup || (s.gridGroup = r.g("grid").attr({zIndex: a.gridZIndex || 1}).add(), s.axisGroup = r.g("axis").attr({zIndex: a.zIndex || 2}).add(), s.labelGroup = r.g("axis-labels").attr({zIndex: v.zIndex || 7}).addClass("highcharts-" + s.coll.toLowerCase() + "-labels").add()), t || s.isLinked) Vt(l, function (t) {
                c[t] ? c[t].addLabel() : c[t] = new M(s, t)
            }), s.renderUnsquish(), Vt(l, function (t) {
                0 !== u && 2 !== u && {1: "left", 3: "right"}[u] !== s.labelAlign || (y = dt(c[t].getLabelSize(), y))
            }), s.staggerLines && (y *= s.staggerLines, s.labelOffset = y); else for (n in c) c[n].destroy(), delete c[n];
            m && m.text && !1 !== m.enabled && (s.axisTitle || (s.axisTitle = r.text(m.text, 0, 0, m.useHTML).attr({
                zIndex: 7,
                rotation: m.rotation || 0,
                align: m.textAlign || {low: "left", middle: "center", high: "right"}[m.align]
            }).addClass("highcharts-" + this.coll.toLowerCase() + "-title").css(m.style).add(s.axisGroup), s.axisTitle.isNew = !0), e && (f = s.axisTitle.getBBox()[d ? "height" : "width"], i = m.offset, g = h(i) ? 0 : Wt(m.margin, d ? 5 : 10)), s.axisTitle[e ? "show" : "hide"]()), s.offset = b * Wt(a.offset, _[u]), s.tickRotCorr = s.tickRotCorr || {
                x: 0,
                y: 0
            }, r = 2 === u ? s.tickRotCorr.y : 0, d = y + g + (y && b * (d ? Wt(v.y, s.tickRotCorr.y + 8) : v.x) - r), s.axisTitleMargin = Wt(i, d), _[u] = dt(_[u], s.axisTitleMargin + f + b * s.offset, d), o[p] = dt(o[p], 2 * ht(a.lineWidth / 2))
        },
        getLinePath: function (t) {
            var e = this.chart, i = this.opposite, n = this.offset, s = this.horiz,
                o = this.left + (i ? this.width : 0) + n, n = e.chartHeight - this.bottom - (i ? this.height : 0) + n;
            return i && (t *= -1), e.renderer.crispLine(["M", s ? this.left : o, s ? n : this.top, "L", s ? e.chartWidth - this.right : o, s ? n : e.chartHeight - this.bottom], t)
        },
        getTitlePosition: function () {
            var t = this.horiz, i = this.left, n = this.top, s = this.len, o = this.options.title, r = t ? i : n,
                a = this.opposite, l = this.offset, h = e(o.style.fontSize || 12),
                s = {low: r + (t ? 0 : s), middle: r + s / 2, high: r + (t ? s : 0)}[o.align],
                i = (t ? n + this.height : i) + (t ? 1 : -1) * (a ? -1 : 1) * this.axisTitleMargin + (2 === this.side ? h : 0);
            return {
                x: t ? s : i + (a ? this.width : 0) + l + (o.x || 0),
                y: t ? i - (a ? this.height : 0) + l : s + (o.y || 0)
            }
        },
        render: function () {
            var t, e = this, i = e.chart, n = i.renderer, s = e.options, o = e.isLog, r = e.isLinked,
                l = e.tickPositions, c = e.axisTitle, d = e.ticks, u = e.minorTicks, p = e.alternateBands,
                f = s.stackLabels, g = s.alternateGridColor, m = e.tickmarkOffset, v = s.lineWidth,
                y = i.hasRendered && h(e.oldMin) && !isNaN(e.oldMin);
            t = e.hasData;
            var _, b, x = e.showAxis;
            e.labelEdge.length = 0, e.overlap = !1, Vt([d, u, p], function (t) {
                for (var e in t) t[e].isActive = !1
            }), (t || r) && (e.minorTickInterval && !e.categories && Vt(e.getMinorTickPositions(), function (t) {
                u[t] || (u[t] = new M(e, t, "minor")), y && u[t].isNew && u[t].render(null, !0), u[t].render(null, !1, 1)
            }), l.length && (Vt(l, function (t, i) {
                (!r || t >= e.min && t <= e.max) && (d[t] || (d[t] = new M(e, t)), y && d[t].isNew && d[t].render(i, !0, .1), d[t].render(i))
            }), m && (0 === e.min || e.single)) && (d[-1] || (d[-1] = new M(e, -1, null, !0)), d[-1].render(-1)), g && Vt(l, function (t, i) {
                i % 2 == 0 && t < e.max && (p[t] || (p[t] = new st.PlotLineOrBand(e)), _ = t + m, b = l[i + 1] !== P ? l[i + 1] + m : e.max, p[t].options = {
                    from: o ? a(_) : _,
                    to: o ? a(b) : b,
                    color: g
                }, p[t].render(), p[t].isActive = !0)
            }), e._addedPlotLB || (Vt((s.plotLines || []).concat(s.plotBands || []), function (t) {
                e.addPlotBandOrLine(t)
            }), e._addedPlotLB = !0)), Vt([d, u, p], function (t) {
                var e, n, s = [], o = H ? H.duration || 500 : 0, r = function () {
                    for (n = s.length; n--;) t[s[n]] && !t[s[n]].isActive && (t[s[n]].destroy(), delete t[s[n]])
                };
                for (e in t) t[e].isActive || (t[e].render(e, !1, 0), t[e].isActive = !1, s.push(e));
                t !== p && i.hasRendered && o ? o && setTimeout(r, o) : r()
            }), v && (t = e.getLinePath(v), e.axisLine ? e.axisLine.animate({d: t}) : e.axisLine = n.path(t).attr({
                stroke: s.lineColor,
                "stroke-width": v,
                zIndex: 7
            }).add(e.axisGroup), e.axisLine[x ? "show" : "hide"]()), c && x && (c[c.isNew ? "attr" : "animate"](e.getTitlePosition()), c.isNew = !1), f && f.enabled && e.renderStackTotals(), e.isDirty = !1
        },
        redraw: function () {
            this.render(), Vt(this.plotLinesAndBands, function (t) {
                t.render()
            }), Vt(this.series, function (t) {
                t.isDirty = !0
            })
        },
        destroy: function (t) {
            var e, i = this, n = i.stacks, s = i.plotLinesAndBands;
            t || Jt(i);
            for (e in n) k(n[e]), n[e] = null;
            for (Vt([i.ticks, i.minorTicks, i.alternateBands], function (t) {
                k(t)
            }), t = s.length; t--;) s[t].destroy();
            Vt("stackTotalGroup,axisLine,axisTitle,axisGroup,cross,gridGroup,labelGroup".split(","), function (t) {
                i[t] && (i[t] = i[t].destroy())
            }), this.cross && this.cross.destroy()
        },
        drawCrosshair: function (t, e) {
            var i, n = this.crosshair, s = n.animation;
            this.crosshair && !1 !== (h(e) || !Wt(this.crosshair.snap, !0)) ? (Wt(n.snap, !0) ? h(e) && (i = this.isXAxis ? e.plotX : this.len - e.plotY) : i = this.horiz ? t.chartX - this.pos : this.len - t.chartY + this.pos, null === (i = this.isRadial ? this.getPlotLinePath(this.isXAxis ? e.x : Wt(e.stackY, e.y)) || null : this.getPlotLinePath(null, null, null, null, i) || null) ? this.hideCrosshair() : this.cross ? this.cross.attr({visibility: "visible"})[s ? "animate" : "attr"]({d: i}, s) : (s = this.categories && !this.isRadial, s = {
                "stroke-width": n.width || (s ? this.transA : 1),
                stroke: n.color || (s ? "rgba(155,200,255,0.2)" : "#C0C0C0"),
                zIndex: n.zIndex || 2
            }, n.dashStyle && (s.dashstyle = n.dashStyle), this.cross = this.chart.renderer.path(i).attr(s).add())) : this.hideCrosshair()
        },
        hideCrosshair: function () {
            this.cross && this.cross.hide()
        }
    }, Rt(ue.prototype, {
        getPlotBandPath: function (t, e) {
            var i = this.getPlotLinePath(e, null, null, !0), n = this.getPlotLinePath(t, null, null, !0);
            return n && i && n.toString() !== i.toString() ? n.push(i[4], i[5], i[1], i[2]) : n = null, n
        }, addPlotBand: function (t) {
            return this.addPlotBandOrLine(t, "plotBands")
        }, addPlotLine: function (t) {
            return this.addPlotBandOrLine(t, "plotLines")
        }, addPlotBandOrLine: function (t, e) {
            var i = new st.PlotLineOrBand(this, t).render(), n = this.userOptions;
            return i && (e && (n[e] = n[e] || [], n[e].push(t)), this.plotLinesAndBands.push(i)), i
        }, removePlotBandOrLine: function (t) {
            for (var e = this.plotLinesAndBands, i = this.options, n = this.userOptions, s = e.length; s--;) e[s].id === t && e[s].destroy();
            Vt([i.plotLines || [], n.plotLines || [], i.plotBands || [], n.plotBands || []], function (e) {
                for (s = e.length; s--;) e[s].id === t && l(e, e[s])
            })
        }
    }), ue.prototype.getTimeTicks = function (t, e, i, n) {
        var s, o = [], r = {}, a = O.global.useUTC, l = new W(e - m(e)), c = t.unitRange, d = t.count;
        if (h(e)) {
            l[Q](c >= R.second ? 0 : d * ht(l.getMilliseconds() / d)), c >= R.second && l[K](c >= R.minute ? 0 : d * ht(l.getSeconds() / d)), c >= R.minute && l[J](c >= R.hour ? 0 : d * ht(l[X]() / d)), c >= R.hour && l[tt](c >= R.day ? 0 : d * ht(l[G]() / d)), c >= R.day && l[et](c >= R.month ? 1 : d * ht(l[V]() / d)), c >= R.month && (l[it](c >= R.year ? 0 : d * ht(l[U]() / d)), s = l[Z]()), c >= R.year && (s -= s % d, l[nt](s)), c === R.week && l[et](l[V]() - l[Y]() + Wt(n, 1)), e = 1, ($ || q) && (l = l.getTime(), l = new W(l + m(l))), s = l[Z]();
            for (var n = l.getTime(), u = l[U](), p = l[V](), f = (R.day + (a ? m(l) : 6e4 * l.getTimezoneOffset())) % R.day; n < i;) o.push(n), c === R.year ? n = B(s + e * d, 0) : c === R.month ? n = B(s, u + e * d) : a || c !== R.day && c !== R.week ? n += c * d : n = B(s, u, p + e * d * (c === R.day ? 1 : 7)), e++;
            o.push(n), Vt(Ut(o, function (t) {
                return c <= R.hour && t % R.day === f
            }), function (t) {
                r[t] = "day"
            })
        }
        return o.info = Rt(t, {higherRanks: r, totalRange: c * d}), o
    }, ue.prototype.normalizeTimeTickInterval = function (t, e) {
        var i,
            n = e || [["millisecond", [1, 2, 5, 10, 20, 25, 50, 100, 200, 500]], ["second", [1, 2, 5, 10, 15, 30]], ["minute", [1, 2, 5, 10, 15, 30]], ["hour", [1, 2, 3, 4, 6, 8, 12]], ["day", [1, 2]], ["week", [1, 2]], ["month", [1, 2, 3, 4, 6]], ["year", null]],
            s = n[n.length - 1], o = R[s[0]], r = s[1];
        for (i = 0; i < n.length && (s = n[i], o = R[s[0]], r = s[1], !(n[i + 1] && t <= (o * r[r.length - 1] + R[n[i + 1][0]]) / 2)); i++) ;
        return o === R.year && t < 5 * o && (r = [1, 2, 5]), n = _(t / o, r, "year" === s[0] ? dt(y(t / o), 1) : 1), {
            unitRange: o,
            count: n,
            unitName: s[0]
        }
    }, ue.prototype.getLogTickPositions = function (t, e, i, n) {
        var s = this.options, o = this.len, l = [];
        if (n || (this._minorAutoInterval = null), t >= .5) t = lt(t), l = this.getLinearTickPositions(t, e, i); else if (t >= .08) for (var h, c, d, u, p, o = ht(e), s = t > .3 ? [1, 2, 4] : t > .15 ? [1, 2, 4, 6, 8] : [1, 2, 3, 4, 5, 6, 7, 8, 9]; o < i + 1 && !p; o++) for (c = s.length, h = 0; h < c && !p; h++) d = r(a(o) * s[h]), d > e && (!n || u <= i) && u !== P && l.push(u), u > i && (p = !0), u = d; else e = a(e), i = a(i), t = s[n ? "minorTickInterval" : "tickInterval"], t = Wt("auto" === t ? null : t, this._minorAutoInterval, (i - e) * (s.tickPixelInterval / (n ? 5 : 1)) / ((n ? o / this.tickPositions.length : o) || 1)), t = _(t, null, y(t)), l = Qt(this.getLinearTickPositions(t, e, i), r), n || (this._minorAutoInterval = t / 5);
        return n || (this.tickInterval = t), l
    };
    var pe = st.Tooltip = function () {
        this.init.apply(this, arguments)
    };
    pe.prototype = {
        init: function (t, i) {
            var n = i.borderWidth, s = i.style, o = e(s.padding);
            this.chart = t, this.options = i, this.crosshairs = [], this.now = {
                x: 0,
                y: 0
            }, this.isHidden = !0, this.label = t.renderer.label("", 0, 0, i.shape || "callout", null, null, i.useHTML, null, "tooltip").attr({
                padding: o,
                fill: i.backgroundColor,
                "stroke-width": n,
                r: i.borderRadius,
                zIndex: 8
            }).css(s).css({padding: 0}).add().attr({y: -9999}), Et || this.label.shadow(i.shadow), this.shared = i.shared
        }, destroy: function () {
            this.label && (this.label = this.label.destroy()), clearTimeout(this.hideTimer), clearTimeout(this.tooltipTimeout)
        }, move: function (t, e, i, n) {
            var s = this, o = s.now,
                r = !1 !== s.options.animation && !s.isHidden && (pt(t - o.x) > 1 || pt(e - o.y) > 1),
                a = s.followPointer || s.len > 1;
            Rt(o, {
                x: r ? (2 * o.x + t) / 3 : t,
                y: r ? (o.y + e) / 2 : e,
                anchorX: a ? P : r ? (2 * o.anchorX + i) / 3 : i,
                anchorY: a ? P : r ? (o.anchorY + n) / 2 : n
            }), s.label.attr(o), r && (clearTimeout(this.tooltipTimeout), this.tooltipTimeout = setTimeout(function () {
                s && s.move(t, e, i, n)
            }, 32))
        }, hide: function (t) {
            var e, i = this;
            clearTimeout(this.hideTimer), this.isHidden || (e = this.chart.hoverPoints, this.hideTimer = setTimeout(function () {
                i.label.fadeOut(), i.isHidden = !0
            }, Wt(t, this.options.hideDelay, 500)), e && Vt(e, function (t) {
                t.setState()
            }), this.chart.hoverPoints = null, this.chart.hoverSeries = null)
        }, getAnchor: function (t, e) {
            var i, n, s, o = this.chart, r = o.inverted, a = o.plotTop, l = o.plotLeft, h = 0, c = 0, t = d(t);
            return i = t[0].tooltipPos, this.followPointer && e && (e.chartX === P && (e = o.pointer.normalize(e)), i = [e.chartX - o.plotLeft, e.chartY - a]), i || (Vt(t, function (t) {
                n = t.series.yAxis, s = t.series.xAxis, h += t.plotX + (!r && s ? s.left - l : 0), c += (t.plotLow ? (t.plotLow + t.plotHigh) / 2 : t.plotY) + (!r && n ? n.top - a : 0)
            }), h /= t.length, c /= t.length, i = [r ? o.plotWidth - c : h, this.shared && !r && t.length > 1 && e ? e.chartY - a : r ? o.plotHeight - h : c]), Qt(i, lt)
        }, getPosition: function (t, e, i) {
            var n, s = this.chart, o = this.distance, r = {}, a = i.h, l = ["y", s.chartHeight, e, i.plotY + s.plotTop],
                h = ["x", s.chartWidth, t, i.plotX + s.plotLeft],
                c = Wt(i.ttBelow, s.inverted && !i.negative || !s.inverted && i.negative), d = function (t, e, i, n) {
                    var s = i < n - o, l = n + o + i < e, h = n - o - i;
                    if (n += o, c && l) r[t] = n; else if (!c && s) r[t] = h; else if (s) r[t] = h - a < 0 ? h : h - a; else {
                        if (!l) return !1;
                        r[t] = n + a + i > e ? n : n + a
                    }
                }, u = function (t, e, i, n) {
                    if (n < o || n > e - o) return !1;
                    r[t] = n < i / 2 ? 1 : n > e - i / 2 ? e - i - 2 : n - i / 2
                }, p = function (t) {
                    var e = l;
                    l = h, h = e, n = t
                }, f = function () {
                    !1 !== d.apply(0, l) ? !1 === u.apply(0, h) && !n && (p(!0), f()) : n ? r.x = r.y = 0 : (p(!0), f())
                };
            return (s.inverted || this.len > 1) && p(), f(), r
        }, defaultFormatter: function (t) {
            var e, i = this.points || d(this);
            return e = [t.tooltipFooterHeaderFormatter(i[0])], e = e.concat(t.bodyFormatter(i)), e.push(t.tooltipFooterHeaderFormatter(i[0], !0)), e.join("")
        }, refresh: function (t, e) {
            var i, n, s, o = this.chart, r = this.label, a = this.options, l = {}, h = [];
            s = a.formatter || this.defaultFormatter;
            var c, l = o.hoverPoints, u = this.shared;
            clearTimeout(this.hideTimer), this.followPointer = d(t)[0].series.tooltipOptions.followPointer, n = this.getAnchor(t, e), i = n[0], n = n[1], !u || t.series && t.series.noSharedTooltip ? l = t.getLabelConfig() : (o.hoverPoints = t, l && Vt(l, function (t) {
                t.setState()
            }), Vt(t, function (t) {
                t.setState("hover"), h.push(t.getLabelConfig())
            }), l = {
                x: t[0].category,
                y: t[0].y
            }, l.points = h, this.len = h.length, t = t[0]), s = s.call(l, this), l = t.series, this.distance = Wt(l.tooltipOptions.distance, 16), !1 === s ? this.hide() : (this.isHidden && (ne(r), r.attr("opacity", 1).show()), r.attr({text: s}), c = a.borderColor || t.color || l.color || "#606060", r.attr({stroke: c}), this.updatePosition({
                plotX: i,
                plotY: n,
                negative: t.negative,
                ttBelow: t.ttBelow,
                h: t.shapeArgs && t.shapeArgs.height || 0
            }), this.isHidden = !1), te(o, "tooltipRefresh", {
                text: s,
                x: i + o.plotLeft,
                y: n + o.plotTop,
                borderColor: c
            })
        }, updatePosition: function (t) {
            var e = this.chart, i = this.label,
                i = (this.options.positioner || this.getPosition).call(this, i.width, i.height, t);
            this.move(lt(i.x), lt(i.y), t.plotX + e.plotLeft, t.plotY + e.plotTop)
        }, getXDateFormat: function (t, e, i) {
            var n, s, o, r, e = e.dateTimeLabelFormats, a = i && i.closestPointRange,
                l = {millisecond: 15, second: 12, minute: 9, hour: 6, day: 3};
            if (a) {
                o = z("%m-%d %H:%M:%S.%L", t.x);
                for (s in R) {
                    if (a === R.week && +z("%w", t.x) === i.options.startOfWeek && "00:00:00.000" === o.substr(6)) {
                        s = "week";
                        break
                    }
                    if (R[s] > a) {
                        s = r;
                        break
                    }
                    if (l[s] && o.substr(l[s]) !== "01-01 00:00:00.000".substr(l[s])) break;
                    "week" !== s && (r = s)
                }
                s && (n = e[s])
            } else n = e.day;
            return n || e.year
        }, tooltipFooterHeaderFormatter: function (t, e) {
            var i = e ? "footer" : "header", n = t.series, s = n.tooltipOptions, r = s.xDateFormat, a = n.xAxis,
                l = a && "datetime" === a.options.type && o(t.key), i = s[i + "Format"];
            return l && !r && (r = this.getXDateFormat(t, s, a)), l && r && (i = i.replace("{point.key}", "{point.key:" + r + "}")), v(i, {
                point: t,
                series: n
            })
        }, bodyFormatter: function (t) {
            return Qt(t, function (t) {
                var e = t.series.tooltipOptions;
                return (e.pointFormatter || t.point.tooltipFormatter).call(t.point, e.pointFormat)
            })
        }
    };
    var fe;
    I = ot.documentElement.ontouchstart !== P;
    var ge = st.Pointer = function (t, e) {
        this.init(t, e)
    };
    if (ge.prototype = {
        init: function (t, e) {
            var i, n = e.chart, s = n.events, o = Et ? "" : n.zoomType, n = t.inverted;
            this.options = e, this.chart = t, this.zoomX = i = /x/.test(o), this.zoomY = o = /y/.test(o), this.zoomHor = i && !n || o && n, this.zoomVert = o && !n || i && n, this.hasZoom = i || o, this.runChartClick = s && !!s.click, this.pinchDown = [], this.lastValidTouch = {}, st.Tooltip && e.tooltip.enabled && (t.tooltip = new pe(t, e.tooltip), this.followTouchMove = Wt(e.tooltip.followTouchMove, !0)), this.setDOMEvents()
        }, normalize: function (t, e) {
            var i, n, t = t || window.event, t = ee(t);
            return t.target || (t.target = t.srcElement), n = t.touches ? t.touches.length ? t.touches.item(0) : t.changedTouches[0] : t, e || (this.chartPosition = e = Zt(this.chart.container)), n.pageX === P ? (i = dt(t.x, t.clientX - e.left), n = t.y) : (i = n.pageX - e.left, n = n.pageY - e.top), Rt(t, {
                chartX: lt(i),
                chartY: lt(n)
            })
        }, getCoordinates: function (t) {
            var e = {xAxis: [], yAxis: []};
            return Vt(this.chart.axes, function (i) {
                e[i.isXAxis ? "xAxis" : "yAxis"].push({axis: i, value: i.toValue(t[i.horiz ? "chartX" : "chartY"])})
            }), e
        }, runPointActions: function (t) {
            var e, i, n, s, o = this.chart, r = o.series, a = o.tooltip, l = !!a && a.shared, c = o.hoverPoint,
                d = o.hoverSeries, u = o.chartWidth, p = o.chartWidth, f = [];
            if (!l && !d) for (e = 0; e < r.length; e++) !r[e].directTouch && r[e].options.stickyTracking || (r = []);
            if (!l && d && d.directTouch && c ? n = c : (Vt(r, function (e) {
                i = e.noSharedTooltip && l, e.visible && !i && Wt(e.options.enableMouseTracking, !0) && (s = e.searchPoint(t)) && f.push(s)
            }), Vt(f, function (t) {
                t && h(t.plotX) && h(t.plotY) && (t.dist.distX < u || (t.dist.distX === u || t.series.kdDimensions > 1) && t.dist.distR < p) && (u = t.dist.distX, p = t.dist.distR, n = t)
            })), n && (n !== c || a && a.isHidden)) if (l && !n.series.noSharedTooltip) {
                for (e = f.length; e--;) (f[e].clientX !== n.clientX || f[e].series.noSharedTooltip) && f.splice(e, 1);
                f.length && a && a.refresh(f, t), Vt(f, function (e) {
                    e !== n && e.onMouseOver(t)
                }), (d && d.directTouch && c || n).onMouseOver(t)
            } else a && a.refresh(n, t), n.onMouseOver(t); else r = d && d.tooltipOptions.followPointer, a && r && !a.isHidden && (r = a.getAnchor([{}], t), a.updatePosition({
                plotX: r[0],
                plotY: r[1]
            }));
            a && !this._onDocumentMouseMove && (this._onDocumentMouseMove = function (t) {
                Pt[fe] && Pt[fe].pointer.onDocumentMouseMove(t)
            }, Kt(ot, "mousemove", this._onDocumentMouseMove)), Vt(o.axes, function (e) {
                e.drawCrosshair(t, Wt(n, c))
            })
        }, reset: function (t, e) {
            var i = this.chart, n = i.hoverSeries, s = i.hoverPoint, o = i.tooltip,
                r = o && o.shared ? i.hoverPoints : s;
            (t = t && o && r) && d(r)[0].plotX === P && (t = !1), t ? (o.refresh(r), s && (s.setState(s.state, !0), Vt(i.axes, function (e) {
                Wt(e.options.crosshair && e.options.crosshair.snap, !0) ? e.drawCrosshair(null, t) : e.hideCrosshair()
            }))) : (s && s.onMouseOut(), n && n.onMouseOut(), o && o.hide(e), this._onDocumentMouseMove && (Jt(ot, "mousemove", this._onDocumentMouseMove), this._onDocumentMouseMove = null), Vt(i.axes, function (t) {
                t.hideCrosshair()
            }), this.hoverX = null)
        }, scaleGroups: function (t, e) {
            var i, n = this.chart;
            Vt(n.series, function (s) {
                i = t || s.getPlotBox(), s.xAxis && s.xAxis.zoomEnabled && (s.group.attr(i), s.markerGroup && (s.markerGroup.attr(i), s.markerGroup.clip(e ? n.clipRect : null)), s.dataLabelsGroup && s.dataLabelsGroup.attr(i))
            }), n.clipRect.attr(e || n.clipBox)
        }, dragStart: function (t) {
            var e = this.chart;
            e.mouseIsDown = t.type, e.cancelClick = !1, e.mouseDownX = this.mouseDownX = t.chartX, e.mouseDownY = this.mouseDownY = t.chartY
        }, drag: function (t) {
            var e, i = this.chart, n = i.options.chart, s = t.chartX, o = t.chartY, r = this.zoomHor, a = this.zoomVert,
                l = i.plotLeft, h = i.plotTop, c = i.plotWidth, d = i.plotHeight, u = this.mouseDownX,
                p = this.mouseDownY, f = n.panKey && t[n.panKey + "Key"];
            s < l ? s = l : s > l + c && (s = l + c), o < h ? o = h : o > h + d && (o = h + d), this.hasDragged = Math.sqrt(Math.pow(u - s, 2) + Math.pow(p - o, 2)), this.hasDragged > 10 && (e = i.isInsidePlot(u - l, p - h), i.hasCartesianSeries && (this.zoomX || this.zoomY) && e && !f && !this.selectionMarker && (this.selectionMarker = i.renderer.rect(l, h, r ? 1 : c, a ? 1 : d, 0).attr({
                fill: n.selectionMarkerFill || "rgba(69,114,167,0.25)",
                zIndex: 7
            }).add()), this.selectionMarker && r && (s -= u, this.selectionMarker.attr({
                width: pt(s),
                x: (s > 0 ? 0 : s) + u
            })), this.selectionMarker && a && (s = o - p, this.selectionMarker.attr({
                height: pt(s),
                y: (s > 0 ? 0 : s) + p
            })), e && !this.selectionMarker && n.panning && i.pan(t, n.panning))
        }, drop: function (t) {
            var e = this, i = this.chart, n = this.hasPinched;
            if (this.selectionMarker) {
                var s, o = {xAxis: [], yAxis: [], originalEvent: t.originalEvent || t}, r = this.selectionMarker,
                    a = r.attr ? r.attr("x") : r.x, l = r.attr ? r.attr("y") : r.y,
                    c = r.attr ? r.attr("width") : r.width, d = r.attr ? r.attr("height") : r.height;
                (this.hasDragged || n) && (Vt(i.axes, function (i) {
                    if (i.zoomEnabled && h(i.min) && (n || e[{xAxis: "zoomX", yAxis: "zoomY"}[i.coll]])) {
                        var r = i.horiz, u = "touchend" === t.type ? i.minPixelPadding : 0,
                            p = i.toValue((r ? a : l) + u), r = i.toValue((r ? a + c : l + d) - u);
                        o[i.coll].push({axis: i, min: ut(p, r), max: dt(p, r)}), s = !0
                    }
                }), s && te(i, "selection", o, function (t) {
                    i.zoom(Rt(t, n ? {animation: !1} : null))
                })), this.selectionMarker = this.selectionMarker.destroy(), n && this.scaleGroups()
            }
            i && (u(i.container, {cursor: i._cursor}), i.cancelClick = this.hasDragged > 10, i.mouseIsDown = this.hasDragged = this.hasPinched = !1, this.pinchDown = [])
        }, onContainerMouseDown: function (t) {
            t = this.normalize(t), t.preventDefault && t.preventDefault(), this.dragStart(t)
        }, onDocumentMouseUp: function (t) {
            Pt[fe] && Pt[fe].pointer.drop(t)
        }, onDocumentMouseMove: function (t) {
            var e = this.chart, i = this.chartPosition, t = this.normalize(t, i);
            i && !this.inClass(t.target, "highcharts-tracker") && !e.isInsidePlot(t.chartX - e.plotLeft, t.chartY - e.plotTop) && this.reset()
        }, onContainerMouseLeave: function () {
            var t = Pt[fe];
            t && (t.pointer.reset(), t.pointer.chartPosition = null)
        }, onContainerMouseMove: function (t) {
            var e = this.chart;
            fe = e.index, t = this.normalize(t), t.returnValue = !1, "mousedown" === e.mouseIsDown && this.drag(t), (this.inClass(t.target, "highcharts-tracker") || e.isInsidePlot(t.chartX - e.plotLeft, t.chartY - e.plotTop)) && !e.openMenu && this.runPointActions(t)
        }, inClass: function (t, e) {
            for (var i; t;) {
                if (i = c(t, "class")) {
                    if (-1 !== i.indexOf(e)) return !0;
                    if (-1 !== i.indexOf("highcharts-container")) return !1
                }
                t = t.parentNode
            }
        }, onTrackerMouseOut: function (t) {
            var e = this.chart.hoverSeries, i = (t = t.relatedTarget || t.toElement) && t.point && t.point.series;
            !e || e.options.stickyTracking || this.inClass(t, "highcharts-tooltip") || i === e || e.onMouseOut()
        }, onContainerClick: function (t) {
            var e = this.chart, i = e.hoverPoint, n = e.plotLeft, s = e.plotTop, t = this.normalize(t);
            t.originalEvent = t, t.cancelBubble = !0, e.cancelClick || (i && this.inClass(t.target, "highcharts-tracker") ? (te(i.series, "click", Rt(t, {point: i})), e.hoverPoint && i.firePointEvent("click", t)) : (Rt(t, this.getCoordinates(t)), e.isInsidePlot(t.chartX - n, t.chartY - s) && te(e, "click", t)))
        }, setDOMEvents: function () {
            var t = this, e = t.chart.container;
            e.onmousedown = function (e) {
                t.onContainerMouseDown(e)
            }, e.onmousemove = function (e) {
                t.onContainerMouseMove(e)
            }, e.onclick = function (e) {
                t.onContainerClick(e)
            }, Kt(e, "mouseleave", t.onContainerMouseLeave), 1 === Ft && Kt(ot, "mouseup", t.onDocumentMouseUp), I && (e.ontouchstart = function (e) {
                t.onContainerTouchStart(e)
            }, e.ontouchmove = function (e) {
                t.onContainerTouchMove(e)
            }, 1 === Ft && Kt(ot, "touchend", t.onDocumentTouchEnd))
        }, destroy: function () {
            var t;
            Jt(this.chart.container, "mouseleave", this.onContainerMouseLeave), Ft || (Jt(ot, "mouseup", this.onDocumentMouseUp), Jt(ot, "touchend", this.onDocumentTouchEnd)), clearInterval(this.tooltipTimeout);
            for (t in this) this[t] = null
        }
    }, Rt(st.Pointer.prototype, {
        pinchTranslate: function (t, e, i, n, s, o) {
            (this.zoomHor || this.pinchHor) && this.pinchTranslateDirection(!0, t, e, i, n, s, o), (this.zoomVert || this.pinchVert) && this.pinchTranslateDirection(!1, t, e, i, n, s, o)
        }, pinchTranslateDirection: function (t, e, i, n, s, o, r, a) {
            var l, h, c, d = this.chart, u = t ? "x" : "y", p = t ? "X" : "Y", f = "chart" + p,
                g = t ? "width" : "height", m = d["plot" + (t ? "Left" : "Top")], v = a || 1, y = d.inverted,
                _ = d.bounds[t ? "h" : "v"], b = 1 === e.length, x = e[0][f], w = i[0][f], k = !b && e[1][f],
                C = !b && i[1][f], i = function () {
                    !b && pt(x - k) > 20 && (v = a || pt(w - C) / pt(x - k)), h = (m - w) / v + x, l = d["plot" + (t ? "Width" : "Height")] / v
                };
            i(), e = h, e < _.min ? (e = _.min, c = !0) : e + l > _.max && (e = _.max - l, c = !0), c ? (w -= .8 * (w - r[u][0]), b || (C -= .8 * (C - r[u][1])), i()) : r[u] = [w, C], y || (o[u] = h - m, o[g] = l), o = y ? 1 / v : v, s[g] = l, s[u] = e, n[y ? t ? "scaleY" : "scaleX" : "scale" + p] = v, n["translate" + p] = o * m + (w - o * x)
        }, pinch: function (t) {
            var e = this, i = e.chart, n = e.pinchDown, s = t.touches, o = s.length, r = e.lastValidTouch,
                a = e.hasZoom, l = e.selectionMarker, h = {},
                c = 1 === o && (e.inClass(t.target, "highcharts-tracker") && i.runTrackerClick || e.runChartClick),
                d = {};
            a && !c && t.preventDefault(), Qt(s, function (t) {
                return e.normalize(t)
            }), "touchstart" === t.type ? (Vt(s, function (t, e) {
                n[e] = {chartX: t.chartX, chartY: t.chartY}
            }), r.x = [n[0].chartX, n[1] && n[1].chartX], r.y = [n[0].chartY, n[1] && n[1].chartY], Vt(i.axes, function (t) {
                if (t.zoomEnabled) {
                    var e = i.bounds[t.horiz ? "h" : "v"], n = t.minPixelPadding,
                        s = t.toPixels(Wt(t.options.min, t.dataMin)), o = t.toPixels(Wt(t.options.max, t.dataMax)),
                        r = ut(s, o), s = dt(s, o);
                    e.min = ut(t.pos, r - n), e.max = dt(t.pos + t.len, s + n)
                }
            }), e.res = !0) : n.length && (l || (e.selectionMarker = l = Rt({destroy: Dt}, i.plotBox)), e.pinchTranslate(n, s, h, l, d, r), e.hasPinched = a, e.scaleGroups(h, d), !a && e.followTouchMove && 1 === o ? this.runPointActions(e.normalize(t)) : e.res && (e.res = !1, this.reset(!1, 0)))
        }, onContainerTouchStart: function (t) {
            var e = this.chart;
            fe = e.index, 1 === t.touches.length ? (t = this.normalize(t), e.isInsidePlot(t.chartX - e.plotLeft, t.chartY - e.plotTop) && !e.openMenu ? (this.runPointActions(t), this.pinch(t)) : this.reset()) : 2 === t.touches.length && this.pinch(t)
        }, onContainerTouchMove: function (t) {
            (1 === t.touches.length || 2 === t.touches.length) && this.pinch(t)
        }, onDocumentTouchEnd: function (t) {
            Pt[fe] && Pt[fe].pointer.drop(t)
        }
    }), rt.PointerEvent || rt.MSPointerEvent) {
        var me = {}, ve = !!rt.PointerEvent, ye = function () {
            var t, e = [];
            e.item = function (t) {
                return this[t]
            };
            for (t in me) me.hasOwnProperty(t) && e.push({
                pageX: me[t].pageX,
                pageY: me[t].pageY,
                target: me[t].target
            });
            return e
        }, _e = function (t, e, i, n) {
            t = t.originalEvent || t, "touch" !== t.pointerType && t.pointerType !== t.MSPOINTER_TYPE_TOUCH || !Pt[fe] || (n(t), n = Pt[fe].pointer, n[e]({
                type: i,
                target: t.currentTarget,
                preventDefault: Dt,
                touches: ye()
            }))
        };
        Rt(ge.prototype, {
            onContainerPointerDown: function (t) {
                _e(t, "onContainerTouchStart", "touchstart", function (t) {
                    me[t.pointerId] = {pageX: t.pageX, pageY: t.pageY, target: t.currentTarget}
                })
            }, onContainerPointerMove: function (t) {
                _e(t, "onContainerTouchMove", "touchmove", function (t) {
                    me[t.pointerId] = {
                        pageX: t.pageX,
                        pageY: t.pageY
                    }, me[t.pointerId].target || (me[t.pointerId].target = t.currentTarget)
                })
            }, onDocumentPointerUp: function (t) {
                _e(t, "onDocumentTouchEnd", "touchend", function (t) {
                    delete me[t.pointerId]
                })
            }, batchMSEvents: function (t) {
                t(this.chart.container, ve ? "pointerdown" : "MSPointerDown", this.onContainerPointerDown), t(this.chart.container, ve ? "pointermove" : "MSPointerMove", this.onContainerPointerMove), t(ot, ve ? "pointerup" : "MSPointerUp", this.onDocumentPointerUp)
            }
        }), Bt(ge.prototype, "init", function (t, e, i) {
            t.call(this, e, i), this.hasZoom && u(e.container, {"-ms-touch-action": jt, "touch-action": jt})
        }), Bt(ge.prototype, "setDOMEvents", function (t) {
            t.apply(this), (this.hasZoom || this.followTouchMove) && this.batchMSEvents(Kt)
        }), Bt(ge.prototype, "destroy", function (t) {
            this.batchMSEvents(Jt), t.call(this)
        })
    }
    var be = st.Legend = function (t, e) {
        this.init(t, e)
    };
    be.prototype = {
        init: function (e, i) {
            var n = this, s = i.itemStyle, o = i.itemMarginTop || 0;
            this.options = i, i.enabled && (n.itemStyle = s, n.itemHiddenStyle = t(s, i.itemHiddenStyle), n.itemMarginTop = o, n.padding = s = Wt(i.padding, 8), n.initialItemX = s, n.initialItemY = s - 5, n.maxItemWidth = 0, n.chart = e, n.itemHeight = 0, n.symbolWidth = Wt(i.symbolWidth, 16), n.pages = [], n.render(), Kt(n.chart, "endResize", function () {
                n.positionCheckboxes()
            }))
        }, colorizeItem: function (t, e) {
            var i, n = this.options, s = t.legendItem, o = t.legendLine, r = t.legendSymbol,
                a = this.itemHiddenStyle.color, n = e ? n.itemStyle.color : a,
                l = e ? t.legendColor || t.color || "#CCC" : a, a = t.options && t.options.marker, h = {fill: l};
            if (s && s.css({fill: n, color: n}), o && o.attr({stroke: l}), r) {
                if (a && r.isMarker) for (i in h.stroke = l, a = t.convertAttribs(a)) (s = a[i]) !== P && (h[i] = s);
                r.attr(h)
            }
        }, positionItem: function (t) {
            var e = this.options, i = e.symbolPadding, e = !e.rtl, n = t._legendItemPos, s = n[0], n = n[1],
                o = t.checkbox;
            t.legendGroup && t.legendGroup.translate(e ? s : this.legendWidth - s - 2 * i - 4, n), o && (o.x = s, o.y = n)
        }, destroyItem: function (t) {
            var e = t.checkbox;
            Vt(["legendItem", "legendLine", "legendSymbol", "legendGroup"], function (e) {
                t[e] && (t[e] = t[e].destroy())
            }), e && C(t.checkbox)
        }, clearItems: function () {
            var t = this;
            Vt(t.getAllItems(), function (e) {
                t.destroyItem(e)
            })
        }, destroy: function () {
            var t = this.group, e = this.box;
            e && (this.box = e.destroy()), t && (this.group = t.destroy())
        }, positionCheckboxes: function (t) {
            var e, i = this.group.alignAttr, n = this.clipHeight || this.legendHeight;
            i && (e = i.translateY, Vt(this.allItems, function (s) {
                var o, r = s.checkbox;
                r && (o = e + r.y + (t || 0) + 3, u(r, {
                    left: i.translateX + s.checkboxOffset + r.x - 20 + "px",
                    top: o + "px",
                    display: o > e - 6 && o < e + n - 6 ? "" : jt
                }))
            }))
        }, renderTitle: function () {
            var t = this.padding, e = this.options.title, i = 0;
            e.text && (this.title || (this.title = this.chart.renderer.label(e.text, t - 3, t - 4, null, null, null, null, null, "legend-title").attr({zIndex: 1}).css(e.style).add(this.group)), t = this.title.getBBox(), i = t.height, this.offsetWidth = t.width, this.contentGroup.attr({translateY: i})), this.titleHeight = i
        }, renderItem: function (e) {
            var i = this.chart, n = i.renderer, s = this.options, o = "horizontal" === s.layout, r = this.symbolWidth,
                a = s.symbolPadding, l = this.itemStyle, h = this.itemHiddenStyle, c = this.padding,
                d = o ? Wt(s.itemDistance, 20) : 0, u = !s.rtl, p = s.width, f = s.itemMarginBottom || 0,
                g = this.itemMarginTop, m = this.initialItemX, y = e.legendItem,
                _ = e.series && e.series.drawLegendSymbol ? e.series : e, b = _.options,
                b = this.createCheckboxForItem && b && b.showCheckbox, x = s.useHTML;
            y || (e.legendGroup = n.g("legend-item").attr({zIndex: 1}).add(this.scrollGroup), e.legendItem = y = n.text(s.labelFormat ? v(s.labelFormat, e) : s.labelFormatter.call(e), u ? r + a : -a, this.baseline || 0, x).css(t(e.visible ? l : h)).attr({
                align: u ? "left" : "right",
                zIndex: 2
            }).add(e.legendGroup), this.baseline || (this.fontMetrics = n.fontMetrics(l.fontSize, y), this.baseline = this.fontMetrics.f + 3 + g, y.attr("y", this.baseline)), _.drawLegendSymbol(this, e), this.setItemEvents && this.setItemEvents(e, y, x, l, h), this.colorizeItem(e, e.visible), b && this.createCheckboxForItem(e)), n = y.getBBox(), r = e.checkboxOffset = s.itemWidth || e.legendItemWidth || r + a + n.width + d + (b ? 20 : 0), this.itemHeight = a = lt(e.legendItemHeight || n.height), o && this.itemX - m + r > (p || i.chartWidth - 2 * c - m - s.x) && (this.itemX = m, this.itemY += g + this.lastLineHeight + f, this.lastLineHeight = 0), this.maxItemWidth = dt(this.maxItemWidth, r), this.lastItemY = g + this.itemY + f, this.lastLineHeight = dt(a, this.lastLineHeight), e._legendItemPos = [this.itemX, this.itemY], o ? this.itemX += r : (this.itemY += g + a + f, this.lastLineHeight = a), this.offsetWidth = p || dt((o ? this.itemX - m - d : r) + c, this.offsetWidth)
        }, getAllItems: function () {
            var t = [];
            return Vt(this.chart.series, function (e) {
                var i = e.options;
                Wt(i.showInLegend, !h(i.linkedTo) && P, !0) && (t = t.concat(e.legendItems || ("point" === i.legendType ? e.data : e)))
            }), t
        }, adjustMargins: function (t, e) {
            var i = this.chart, n = this.options, s = n.align[0] + n.verticalAlign[0] + n.layout[0];
            this.display && !n.floating && Vt([/(lth|ct|rth)/, /(rtv|rm|rbv)/, /(rbh|cb|lbh)/, /(lbv|lm|ltv)/], function (o, r) {
                o.test(s) && !h(t[r]) && (i[zt[r]] = dt(i[zt[r]], i.legend[(r + 1) % 2 ? "legendHeight" : "legendWidth"] + [1, -1, -1, 1][r] * n[r % 2 ? "x" : "y"] + Wt(n.margin, 12) + e[r]))
            })
        }, render: function () {
            var t, e, i, n, s = this, o = s.chart, r = o.renderer, a = s.group, l = s.box, h = s.options, c = s.padding,
                d = h.borderWidth, u = h.backgroundColor;
            s.itemX = s.initialItemX, s.itemY = s.initialItemY, s.offsetWidth = 0, s.lastItemY = 0, a || (s.group = a = r.g("legend").attr({zIndex: 7}).add(), s.contentGroup = r.g().attr({zIndex: 1}).add(a), s.scrollGroup = r.g().add(s.contentGroup)), s.renderTitle(), t = s.getAllItems(), b(t, function (t, e) {
                return (t.options && t.options.legendIndex || 0) - (e.options && e.options.legendIndex || 0)
            }), h.reversed && t.reverse(), s.allItems = t, s.display = e = !!t.length, s.lastLineHeight = 0, Vt(t, function (t) {
                s.renderItem(t)
            }), i = (h.width || s.offsetWidth) + c, n = s.lastItemY + s.lastLineHeight + s.titleHeight, n = s.handleOverflow(n), n += c, (d || u) && (l ? i > 0 && n > 0 && (l[l.isNew ? "attr" : "animate"](l.crisp({
                width: i,
                height: n
            })), l.isNew = !1) : (s.box = l = r.rect(0, 0, i, n, h.borderRadius, d || 0).attr({
                stroke: h.borderColor,
                "stroke-width": d || 0,
                fill: u || jt
            }).add(a).shadow(h.shadow), l.isNew = !0), l[e ? "show" : "hide"]()), s.legendWidth = i, s.legendHeight = n, Vt(t, function (t) {
                s.positionItem(t)
            }), e && a.align(Rt({width: i, height: n}, h), !0, "spacingBox"), o.isResizing || this.positionCheckboxes()
        }, handleOverflow: function (t) {
            var e, i, n = this, s = this.chart, o = s.renderer, r = this.options, a = r.y,
                a = s.spacingBox.height + ("top" === r.verticalAlign ? -a : a) - this.padding, l = r.maxHeight,
                h = this.clipRect, c = r.navigation, d = Wt(c.animation, !0), u = c.arrowSize || 12, p = this.nav,
                f = this.pages, g = this.allItems;
            return "horizontal" === r.layout && (a /= 2), l && (a = ut(a, l)), f.length = 0, t > a && !r.useHTML ? (this.clipHeight = e = dt(a - 20 - this.titleHeight - this.padding, 0), this.currentPage = Wt(this.currentPage, 1), this.fullHeight = t, Vt(g, function (t, n) {
                var s = t._legendItemPos[1], o = lt(t.legendItem.getBBox().height), r = f.length;
                (!r || s - f[r - 1] > e && (i || s) !== f[r - 1]) && (f.push(i || s), r++), n === g.length - 1 && s + o - f[r - 1] > e && f.push(s), s !== i && (i = s)
            }), h || (h = n.clipRect = o.clipRect(0, this.padding, 9999, 0), n.contentGroup.clip(h)), h.attr({height: e}), p || (this.nav = p = o.g().attr({zIndex: 1}).add(this.group), this.up = o.symbol("triangle", 0, 0, u, u).on("click", function () {
                n.scroll(-1, d)
            }).add(p), this.pager = o.text("", 15, 10).css(c.style).add(p), this.down = o.symbol("triangle-down", 0, 0, u, u).on("click", function () {
                n.scroll(1, d)
            }).add(p)), n.scroll(0), t = a) : p && (h.attr({height: s.chartHeight}), p.hide(), this.scrollGroup.attr({translateY: 1}), this.clipHeight = 0), t
        }, scroll: function (t, e) {
            var i = this.pages, n = i.length, s = this.currentPage + t, o = this.clipHeight,
                r = this.options.navigation, a = r.activeColor, r = r.inactiveColor, l = this.pager, h = this.padding;
            s > n && (s = n), s > 0 && (e !== P && A(e, this.chart), this.nav.attr({
                translateX: h,
                translateY: o + this.padding + 7 + this.titleHeight,
                visibility: "visible"
            }), this.up.attr({fill: 1 === s ? r : a}).css({cursor: 1 === s ? "default" : "pointer"}), l.attr({text: s + "/" + n}), this.down.attr({
                x: 18 + this.pager.getBBox().width,
                fill: s === n ? r : a
            }).css({cursor: s === n ? "default" : "pointer"}), i = -i[s - 1] + this.initialItemY, this.scrollGroup.animate({translateY: i}), this.currentPage = s, this.positionCheckboxes(i))
        }
    }, ce = st.LegendSymbolMixin = {
        drawRectangle: function (t, e) {
            var i = t.options.symbolHeight || t.fontMetrics.f;
            e.legendSymbol = this.chart.renderer.rect(0, t.baseline - i + 1, t.symbolWidth, i, t.options.symbolRadius || 0).attr({zIndex: 3}).add(e.legendGroup)
        }, drawLineMarker: function (t) {
            var e, i = this.options, n = i.marker;
            e = t.symbolWidth;
            var s, o = this.chart.renderer, r = this.legendGroup, t = t.baseline - lt(.3 * t.fontMetrics.b);
            i.lineWidth && (s = {"stroke-width": i.lineWidth}, i.dashStyle && (s.dashstyle = i.dashStyle), this.legendLine = o.path(["M", 0, t, "L", e, t]).attr(s).add(r)), n && !1 !== n.enabled && (i = n.radius, this.legendSymbol = e = o.symbol(this.symbol, e / 2 - i, t - i, 2 * i, 2 * i).add(r), e.isMarker = !0)
        }
    }, (/Trident\/7\.0/.test(yt) || kt) && Bt(be.prototype, "positionItem", function (t, e) {
        var i = this, n = function () {
            e._legendItemPos && t.call(i, e)
        };
        n(), setTimeout(n)
    }), qt = st.Chart = function () {
        this.init.apply(this, arguments)
    }, qt.prototype = {
        callbacks: [], init: function (e, i) {
            var n, s = e.series;
            e.series = null, n = t(O, e), n.series = e.series = s, this.userOptions = e, s = n.chart, this.margin = this.splashArray("margin", s), this.spacing = this.splashArray("spacing", s);
            var o = s.events;
            this.bounds = {
                h: {},
                v: {}
            }, this.callback = i, this.isResizing = 0, this.options = n, this.axes = [], this.series = [], this.hasCartesianSeries = s.showAxes;
            var r, a = this;
            if (a.index = Pt.length, Pt.push(a), Ft++, !1 !== s.reflow && Kt(a, "load", function () {
                a.initReflow()
            }), o) for (r in o) Kt(a, r, o[r]);
            a.xAxis = [], a.yAxis = [], a.animation = !Et && Wt(s.animation, !0), a.pointCount = a.colorCounter = a.symbolCounter = 0, a.firstRender()
        }, initSeries: function (t) {
            var e = this.options.chart;
            return (e = Nt[t.type || e.type || e.defaultSeriesType]) || S(17, !0), e = new e, e.init(this, t), e
        }, isInsidePlot: function (t, e, i) {
            var n = i ? e : t, t = i ? t : e;
            return n >= 0 && n <= this.plotWidth && t >= 0 && t <= this.plotHeight
        }, redraw: function (t) {
            var e, i, n = this.axes, s = this.series, o = this.pointer, r = this.legend, a = this.isDirtyLegend,
                l = this.hasCartesianSeries, h = this.isDirtyBox, c = s.length, d = c, u = this.renderer,
                p = u.isHidden(), f = [];
            for (A(t, this), p && this.cloneRenderTo(), this.layOutTitles(); d--;) if (t = s[d], t.options.stacking && (e = !0, t.isDirty)) {
                i = !0;
                break
            }
            if (i) for (d = c; d--;) t = s[d], t.options.stacking && (t.isDirty = !0);
            Vt(s, function (t) {
                t.isDirty && "point" === t.options.legendType && (a = !0)
            }), a && r.options.enabled && (r.render(), this.isDirtyLegend = !1), e && this.getStacks(), l && !this.isResizing && (this.maxTicks = null, Vt(n, function (t) {
                t.setScale()
            })), this.getMargins(), l && (Vt(n, function (t) {
                t.isDirty && (h = !0)
            }), Vt(n, function (t) {
                t.isDirtyExtremes && (t.isDirtyExtremes = !1, f.push(function () {
                    te(t, "afterSetExtremes", Rt(t.eventArgs, t.getExtremes())), delete t.eventArgs
                })), (h || e) && t.redraw()
            })), h && this.drawChartBox(), Vt(s, function (t) {
                t.isDirty && t.visible && (!t.isCartesian || t.xAxis) && t.redraw()
            }), o && o.reset(!0), u.draw(), te(this, "redraw"), p && this.cloneRenderTo(!0), Vt(f, function (t) {
                t.call()
            })
        }, get: function (t) {
            var e, i, n = this.axes, s = this.series;
            for (e = 0; e < n.length; e++) if (n[e].options.id === t) return n[e];
            for (e = 0; e < s.length; e++) if (s[e].options.id === t) return s[e];
            for (e = 0; e < s.length; e++) for (i = s[e].points || [], n = 0; n < i.length; n++) if (i[n].id === t) return i[n];
            return null
        }, getAxes: function () {
            var t = this, e = this.options, i = e.xAxis = d(e.xAxis || {}), e = e.yAxis = d(e.yAxis || {});
            Vt(i, function (t, e) {
                t.index = e, t.isX = !0
            }), Vt(e, function (t, e) {
                t.index = e
            }), i = i.concat(e), Vt(i, function (e) {
                new ue(t, e)
            })
        }, getSelectedPoints: function () {
            var t = [];
            return Vt(this.series, function (e) {
                t = t.concat(Ut(e.points || [], function (t) {
                    return t.selected
                }))
            }), t
        }, getSelectedSeries: function () {
            return Ut(this.series, function (t) {
                return t.selected
            })
        }, getStacks: function () {
            var t = this;
            Vt(t.yAxis, function (t) {
                t.stacks && t.hasVisibleSeries && (t.oldStacks = t.stacks)
            }), Vt(t.series, function (e) {
                !e.options.stacking || !0 !== e.visible && !1 !== t.options.chart.ignoreHiddenSeries || (e.stackKey = e.type + Wt(e.options.stack, ""))
            })
        }, setTitle: function (e, i, n) {
            var s, o, r = this, a = r.options;
            o = a.title = t(a.title, e), s = a.subtitle = t(a.subtitle, i), a = s, Vt([["title", e, o], ["subtitle", i, a]], function (t) {
                var e = t[0], i = r[e], n = t[1], t = t[2];
                i && n && (r[e] = i = i.destroy()), t && t.text && !i && (r[e] = r.renderer.text(t.text, 0, 0, t.useHTML).attr({
                    align: t.align,
                    "class": "highcharts-" + e,
                    zIndex: t.zIndex || 4
                }).css(t.style).add())
            }), r.layOutTitles(n)
        }, layOutTitles: function (t) {
            var e = 0, i = this.title, n = this.subtitle, s = this.options, o = s.title, s = s.subtitle,
                r = this.renderer, a = this.spacingBox.width - 44;
            !i || (i.css({width: (o.width || a) + "px"}).align(Rt({y: r.fontMetrics(o.style.fontSize, i).b - 3}, o), !1, "spacingBox"), o.floating || o.verticalAlign) || (e = i.getBBox().height), n && (n.css({width: (s.width || a) + "px"}).align(Rt({y: e + (o.margin - 13) + r.fontMetrics(o.style.fontSize, n).b}, s), !1, "spacingBox"), !s.floating && !s.verticalAlign && (e = ct(e + n.getBBox().height))), i = this.titleOffset !== e, this.titleOffset = e, !this.isDirtyBox && i && (this.isDirtyBox = i, this.hasRendered && Wt(t, !0) && this.isDirtyBox && this.redraw())
        }, getChartSize: function () {
            var t = this.options.chart, e = t.width, t = t.height, i = this.renderToClone || this.renderTo;
            h(e) || (this.containerWidth = Xt(i, "width")), h(t) || (this.containerHeight = Xt(i, "height")), this.chartWidth = dt(0, e || this.containerWidth || 600), this.chartHeight = dt(0, Wt(t, this.containerHeight > 19 ? this.containerHeight : 400))
        }, cloneRenderTo: function (t) {
            var e = this.renderToClone, i = this.container;
            t ? e && (this.renderTo.appendChild(i), C(e), delete this.renderToClone) : (i && i.parentNode === this.renderTo && this.renderTo.removeChild(i), this.renderToClone = e = this.renderTo.cloneNode(0), u(e, {
                position: "absolute",
                top: "-9999px",
                display: "block"
            }), e.style.setProperty && e.style.setProperty("display", "block", "important"), ot.body.appendChild(e), i && e.appendChild(i))
        }, getContainer: function () {
            var t, n, s, o, r = this.options.chart;
            this.renderTo = t = r.renderTo, o = "highcharts-" + Mt++, i(t) && (this.renderTo = t = ot.getElementById(t)), t || S(13, !0), n = e(c(t, "data-highcharts-chart")), !isNaN(n) && Pt[n] && Pt[n].hasRendered && Pt[n].destroy(), c(t, "data-highcharts-chart", this.index), t.innerHTML = "", !r.skipClone && !t.offsetWidth && this.cloneRenderTo(), this.getChartSize(), n = this.chartWidth, s = this.chartHeight, this.container = t = p(It, {
                className: "highcharts-container" + (r.className ? " " + r.className : ""),
                id: o
            }, Rt({
                position: "relative",
                overflow: "hidden",
                width: n + "px",
                height: s + "px",
                textAlign: "left",
                lineHeight: "normal",
                zIndex: 0,
                "-webkit-tap-highlight-color": "rgba(0,0,0,0)"
            }, r.style), this.renderToClone || t), this._cursor = t.style.cursor, this.renderer = r.forExport ? new he(t, n, s, r.style, !0) : new F(t, n, s, r.style), Et && this.renderer.create(this, t, n, s), this.renderer.chartIndex = this.index
        }, getMargins: function (t) {
            var e = this.spacing, i = this.margin, n = this.titleOffset;
            this.resetMargins(), n && !h(i[0]) && (this.plotTop = dt(this.plotTop, n + this.options.title.margin + e[0])), this.legend.adjustMargins(i, e), this.extraBottomMargin && (this.marginBottom += this.extraBottomMargin), this.extraTopMargin && (this.plotTop += this.extraTopMargin), t || this.getAxisMargins()
        }, getAxisMargins: function () {
            var t = this, e = t.axisOffset = [0, 0, 0, 0], i = t.margin;
            t.hasCartesianSeries && Vt(t.axes, function (t) {
                t.getOffset()
            }), Vt(zt, function (n, s) {
                h(i[s]) || (t[n] += e[s])
            }), t.setChartSize()
        }, reflow: function (t) {
            var e = this, i = e.options.chart, n = e.renderTo, s = i.width || Xt(n, "width"),
                o = i.height || Xt(n, "height"), i = t ? t.target : rt, n = function () {
                    e.container && (e.setSize(s, o, !1), e.hasUserSize = null)
                };
            e.hasUserSize || e.isPrinting || !s || !o || i !== rt && i !== ot || (s === e.containerWidth && o === e.containerHeight || (clearTimeout(e.reflowTimeout), t ? e.reflowTimeout = setTimeout(n, 100) : n()), e.containerWidth = s, e.containerHeight = o)
        }, initReflow: function () {
            var t = this, e = function (e) {
                t.reflow(e)
            };
            Kt(rt, "resize", e), Kt(t, "destroy", function () {
                Jt(rt, "resize", e)
            })
        }, setSize: function (t, e, i) {
            var n, s, o, r = this;
            r.isResizing += 1, o = function () {
                r && te(r, "endResize", null, function () {
                    r.isResizing -= 1
                })
            }, A(i, r), r.oldChartHeight = r.chartHeight, r.oldChartWidth = r.chartWidth, h(t) && (r.chartWidth = n = dt(0, lt(t)), r.hasUserSize = !!n), h(e) && (r.chartHeight = s = dt(0, lt(e))), (H ? ie : u)(r.container, {
                width: n + "px",
                height: s + "px"
            }, H), r.setChartSize(!0), r.renderer.setSize(n, s, i), r.maxTicks = null, Vt(r.axes, function (t) {
                t.isDirty = !0, t.setScale()
            }), Vt(r.series, function (t) {
                t.isDirty = !0
            }), r.isDirtyLegend = !0, r.isDirtyBox = !0, r.layOutTitles(), r.getMargins(), r.redraw(i), r.oldChartHeight = null, te(r, "resize"), !1 === H ? o() : setTimeout(o, H && H.duration || 500)
        }, setChartSize: function (t) {
            var e, i, n, s, o = this.inverted, r = this.renderer, a = this.chartWidth, l = this.chartHeight,
                h = this.options.chart, c = this.spacing, d = this.clipOffset;
            this.plotLeft = e = lt(this.plotLeft), this.plotTop = i = lt(this.plotTop), this.plotWidth = n = dt(0, lt(a - e - this.marginRight)), this.plotHeight = s = dt(0, lt(l - i - this.marginBottom)), this.plotSizeX = o ? s : n, this.plotSizeY = o ? n : s, this.plotBorderWidth = h.plotBorderWidth || 0, this.spacingBox = r.spacingBox = {
                x: c[3],
                y: c[0],
                width: a - c[3] - c[1],
                height: l - c[0] - c[2]
            }, this.plotBox = r.plotBox = {
                x: e,
                y: i,
                width: n,
                height: s
            }, a = 2 * ht(this.plotBorderWidth / 2), o = ct(dt(a, d[3]) / 2), r = ct(dt(a, d[0]) / 2), this.clipBox = {
                x: o,
                y: r,
                width: ht(this.plotSizeX - dt(a, d[1]) / 2 - o),
                height: dt(0, ht(this.plotSizeY - dt(a, d[2]) / 2 - r))
            }, t || Vt(this.axes, function (t) {
                t.setAxisSize(), t.setAxisTranslation()
            })
        }, resetMargins: function () {
            var t = this;
            Vt(zt, function (e, i) {
                t[e] = Wt(t.margin[i], t.spacing[i])
            }), t.axisOffset = [0, 0, 0, 0], t.clipOffset = [0, 0, 0, 0]
        }, drawChartBox: function () {
            var t, e = this.options.chart, i = this.renderer, n = this.chartWidth, s = this.chartHeight,
                o = this.chartBackground, r = this.plotBackground, a = this.plotBorder, l = this.plotBGImage,
                h = e.borderWidth || 0, c = e.backgroundColor, d = e.plotBackgroundColor, u = e.plotBackgroundImage,
                p = e.plotBorderWidth || 0, f = this.plotLeft, g = this.plotTop, m = this.plotWidth,
                v = this.plotHeight, y = this.plotBox, _ = this.clipRect, b = this.clipBox;
            t = h + (e.shadow ? 8 : 0), (h || c) && (o ? o.animate(o.crisp({
                width: n - t,
                height: s - t
            })) : (o = {fill: c || jt}, h && (o.stroke = e.borderColor, o["stroke-width"] = h), this.chartBackground = i.rect(t / 2, t / 2, n - t, s - t, e.borderRadius, h).attr(o).addClass("highcharts-background").add().shadow(e.shadow))), d && (r ? r.animate(y) : this.plotBackground = i.rect(f, g, m, v, 0).attr({fill: d}).add().shadow(e.plotShadow)), u && (l ? l.animate(y) : this.plotBGImage = i.image(u, f, g, m, v).add()), _ ? _.animate({
                width: b.width,
                height: b.height
            }) : this.clipRect = i.clipRect(b), p && (a ? a.animate(a.crisp({
                x: f,
                y: g,
                width: m,
                height: v,
                strokeWidth: -p
            })) : this.plotBorder = i.rect(f, g, m, v, 0, -p).attr({
                stroke: e.plotBorderColor,
                "stroke-width": p,
                fill: jt,
                zIndex: 1
            }).add()), this.isDirtyBox = !1
        }, propFromSeries: function () {
            var t, e, i, n = this, s = n.options.chart, o = n.options.series;
            Vt(["inverted", "angular", "polar"], function (r) {
                for (t = Nt[s.type || s.defaultSeriesType], i = n[r] || s[r] || t && t.prototype[r], e = o && o.length; !i && e--;) (t = Nt[o[e].type]) && t.prototype[r] && (i = !0);
                n[r] = i
            })
        }, linkSeries: function () {
            var t = this, e = t.series;
            Vt(e, function (t) {
                t.linkedSeries.length = 0
            }), Vt(e, function (e) {
                var n = e.options.linkedTo;
                i(n) && (n = ":previous" === n ? t.series[e.index - 1] : t.get(n)) && (n.linkedSeries.push(e), e.linkedParent = n)
            })
        }, renderSeries: function () {
            Vt(this.series, function (t) {
                t.translate(), t.render()
            })
        }, renderLabels: function () {
            var t = this, i = t.options.labels;
            i.items && Vt(i.items, function (n) {
                var s = Rt(i.style, n.style), o = e(s.left) + t.plotLeft, r = e(s.top) + t.plotTop + 12;
                delete s.left, delete s.top, t.renderer.text(n.html, o, r).attr({zIndex: 2}).css(s).add()
            })
        }, render: function () {
            var t, e, i, n, s = this.axes, o = this.renderer, r = this.options;
            this.setTitle(), this.legend = new be(this, r.legend), this.getStacks(), this.getMargins(!0), this.setChartSize(), t = this.plotWidth, e = this.plotHeight -= 13, Vt(s, function (t) {
                t.setScale()
            }), this.getAxisMargins(), i = t / this.plotWidth > 1.1, n = e / this.plotHeight > 1.1, (i || n) && (this.maxTicks = null, Vt(s, function (t) {
                (t.horiz && i || !t.horiz && n) && t.setTickInterval(!0)
            }), this.getMargins()), this.drawChartBox(), this.hasCartesianSeries && Vt(s, function (t) {
                t.render()
            }), this.seriesGroup || (this.seriesGroup = o.g("series-group").attr({zIndex: 3}).add()), this.renderSeries(), this.renderLabels(), this.showCredits(r.credits), this.hasRendered = !0
        }, showCredits: function (t) {
            t.enabled && !this.credits && (this.credits = this.renderer.text(t.text, 0, 0).on("click", function () {
                t.href && (location.href = t.href)
            }).attr({align: t.position.align, zIndex: 8}).css(t.style).add().align(t.position))
        }, destroy: function () {
            var t, e = this, i = e.axes, n = e.series, s = e.container, o = s && s.parentNode;
            for (te(e, "destroy"), Pt[e.index] = P, Ft--, e.renderTo.removeAttribute("data-highcharts-chart"), Jt(e), t = i.length; t--;) i[t] = i[t].destroy();
            for (t = n.length; t--;) n[t] = n[t].destroy();
            Vt("title,subtitle,chartBackground,plotBackground,plotBGImage,plotBorder,seriesGroup,clipRect,credits,pointer,scroller,rangeSelector,legend,resetZoomButton,tooltip,renderer".split(","), function (t) {
                var i = e[t];
                i && i.destroy && (e[t] = i.destroy())
            }), s && (s.innerHTML = "", Jt(s), o && C(s));
            for (t in e) delete e[t]
        }, isReadyToRender: function () {
            var t = this;
            return !(!Tt && rt == rt.top && "complete" !== ot.readyState || Et && !rt.canvg) || (Et ? de.push(function () {
                t.firstRender()
            }, t.options.global.canvasToolsURL) : ot.attachEvent("onreadystatechange", function () {
                ot.detachEvent("onreadystatechange", t.firstRender), "complete" === ot.readyState && t.firstRender()
            }), !1)
        }, firstRender: function () {
            var t = this, e = t.options, i = t.callback;
            t.isReadyToRender() && (t.getContainer(), te(t, "init"), t.resetMargins(), t.setChartSize(), t.propFromSeries(), t.getAxes(), Vt(e.series || [], function (e) {
                t.initSeries(e)
            }), t.linkSeries(), te(t, "beforeRender"), st.Pointer && (t.pointer = new ge(t, e)), t.render(), t.renderer.draw(), i && i.apply(t, [t]), Vt(t.callbacks, function (e) {
                t.index !== P && e.apply(t, [t])
            }), te(t, "load"), t.cloneRenderTo(!0))
        }, splashArray: function (t, e) {
            var i = e[t], i = n(i) ? i : [i, i, i, i];
            return [Wt(e[t + "Top"], i[0]), Wt(e[t + "Right"], i[1]), Wt(e[t + "Bottom"], i[2]), Wt(e[t + "Left"], i[3])]
        }
    };
    var xe = st.CenteredSeriesMixin = {
        getCenter: function () {
            var t, i, n, s = this.options, o = this.chart, r = 2 * (s.slicedOffset || 0), a = o.plotWidth - 2 * r,
                o = o.plotHeight - 2 * r, l = s.center,
                l = [Wt(l[0], "50%"), Wt(l[1], "50%"), s.size || "100%", s.innerSize || 0], h = ut(a, o);
            for (i = 0; i < 4; ++i) n = l[i], t = /%$/.test(n), s = i < 2 || 2 === i && t, l[i] = (t ? [a, o, h, l[2]][i] * e(n) / 100 : e(n)) + (s ? r : 0);
            return l
        }
    }, we = function () {
    };
    we.prototype = {
        init: function (t, e, i) {
            return this.series = t, this.color = t.color, this.applyOptions(e, i), this.pointAttr = {}, t.options.colorByPoint && (e = t.options.colors || t.chart.options.colors, this.color = this.color || e[t.colorCounter++], t.colorCounter === e.length) && (t.colorCounter = 0), t.chart.pointCount++, this
        }, applyOptions: function (t, e) {
            var i = this.series, n = i.options.pointValKey || i.pointValKey,
                t = we.prototype.optionsToObject.call(this, t);
            return Rt(this, t), this.options = this.options ? Rt(this.options, t) : t, n && (this.y = this[n]), this.x === P && i && (this.x = e === P ? i.autoIncrement() : e), this
        }, optionsToObject: function (t) {
            var e = {}, i = this.series, n = i.options.keys, o = n || i.pointArrayMap || ["y"], r = o.length, a = 0,
                l = 0;
            if ("number" == typeof t || null === t) e[o[0]] = t; else if (s(t)) for (!n && t.length > r && (i = typeof t[0], "string" === i ? e.name = t[0] : "number" === i && (e.x = t[0]), a++); l < r;) e[o[l++]] = t[a++]; else "object" == typeof t && (e = t, t.dataLabels && (i._hasPointLabels = !0), t.marker && (i._hasPointMarkers = !0));
            return e
        }, destroy: function () {
            var t, e = this.series.chart, i = e.hoverPoints;
            e.pointCount--, i && (this.setState(), l(i, this), !i.length) && (e.hoverPoints = null), this === e.hoverPoint && this.onMouseOut(), (this.graphic || this.dataLabel) && (Jt(this), this.destroyElements()), this.legendItem && e.legend.destroyItem(this);
            for (t in this) this[t] = null
        }, destroyElements: function () {
            for (var t, e = "graphic,dataLabel,dataLabelUpper,group,connector,shadowGroup".split(","), i = 6; i--;) t = e[i], this[t] && (this[t] = this[t].destroy())
        }, getLabelConfig: function () {
            return {
                x: this.category,
                y: this.y,
                key: this.name || this.category,
                series: this.series,
                point: this,
                percentage: this.percentage,
                total: this.total || this.stackTotal
            }
        }, tooltipFormatter: function (t) {
            var e = this.series, i = e.tooltipOptions, n = Wt(i.valueDecimals, ""), s = i.valuePrefix || "",
                o = i.valueSuffix || "";
            return Vt(e.pointArrayMap || ["y"], function (e) {
                e = "{point." + e, (s || o) && (t = t.replace(e + "}", s + e + "}" + o)), t = t.replace(e + "}", e + ":,." + n + "f}")
            }), v(t, {point: this, series: this.series})
        }, firePointEvent: function (t, e, i) {
            var n = this, s = this.series.options;
            (s.point.events[t] || n.options && n.options.events && n.options.events[t]) && this.importEvents(), "click" === t && s.allowPointSelect && (i = function (t) {
                n.select(null, t.ctrlKey || t.metaKey || t.shiftKey)
            }), te(this, t, e, i)
        }
    };
    var ke = st.Series = function () {
    };
    ke.prototype = {
        isCartesian: !0,
        type: "line",
        pointClass: we,
        sorted: !0,
        requireSorting: !0,
        pointAttrToOptions: {stroke: "lineColor", "stroke-width": "lineWidth", fill: "fillColor", r: "radius"},
        axisTypes: ["xAxis", "yAxis"],
        colorCounter: 0,
        parallelArrays: ["x", "y"],
        init: function (t, e) {
            var i, n, s = this, o = t.series, r = function (t, e) {
                return Wt(t.options.index, t._i) - Wt(e.options.index, e._i)
            };
            s.chart = t, s.options = e = s.setOptions(e), s.linkedSeries = [], s.bindAxes(), Rt(s, {
                name: e.name,
                state: "",
                pointAttr: {},
                visible: !1 !== e.visible,
                selected: !0 === e.selected
            }), Et && (e.animation = !1), n = e.events;
            for (i in n) Kt(s, i, n[i]);
            (n && n.click || e.point && e.point.events && e.point.events.click || e.allowPointSelect) && (t.runTrackerClick = !0), s.getColor(), s.getSymbol(), Vt(s.parallelArrays, function (t) {
                s[t + "Data"] = []
            }), s.setData(e.data, !1), s.isCartesian && (t.hasCartesianSeries = !0), o.push(s), s._i = o.length - 1, b(o, r), this.yAxis && b(this.yAxis.series, r), Vt(o, function (t, e) {
                t.index = e, t.name = t.name || "Series " + (e + 1)
            })
        },
        bindAxes: function () {
            var t, e = this, i = e.options, n = e.chart;
            Vt(e.axisTypes || [], function (s) {
                Vt(n[s], function (n) {
                    t = n.options, (i[s] === t.index || i[s] !== P && i[s] === t.id || i[s] === P && 0 === t.index) && (n.series.push(e), e[s] = n, n.isDirty = !0)
                }), !e[s] && e.optionalAxis !== s && S(18, !0)
            })
        },
        updateParallelArrays: function (t, e) {
            var i = t.series, n = arguments;
            Vt(i.parallelArrays, "number" == typeof e ? function (n) {
                var s = "y" === n && i.toYData ? i.toYData(t) : t[n];
                i[n + "Data"][e] = s
            } : function (t) {
                Array.prototype[e].apply(i[t + "Data"], Array.prototype.slice.call(n, 2))
            })
        },
        autoIncrement: function () {
            var t, e = this.options, i = this.xIncrement, n = e.pointIntervalUnit, i = Wt(i, e.pointStart, 0);
            return this.pointInterval = t = Wt(this.pointInterval, e.pointInterval, 1), "month" !== n && "year" !== n || (e = new W(i), e = "month" === n ? +e[it](e[U]() + t) : +e[nt](e[Z]() + t), t = e - i), this.xIncrement = i + t, i
        },
        getSegments: function () {
            var t, e = -1, i = [], n = this.points, s = n.length;
            if (s) if (this.options.connectNulls) {
                for (t = s; t--;) null === n[t].y && n.splice(t, 1);
                n.length && (i = [n])
            } else Vt(n, function (t, o) {
                null === t.y ? (o > e + 1 && i.push(n.slice(e + 1, o)), e = o) : o === s - 1 && i.push(n.slice(e + 1, o + 1))
            });
            this.segments = i
        },
        setOptions: function (e) {
            var i = this.chart, n = i.options.plotOptions, i = i.userOptions || {}, s = i.plotOptions || {},
                o = n[this.type];
            return this.userOptions = e, n = t(o, n.series, e), this.tooltipOptions = t(O.tooltip, O.plotOptions[this.type].tooltip, i.tooltip, s.series && s.series.tooltip, s[this.type] && s[this.type].tooltip, e.tooltip), null === o.marker && delete n.marker, this.zoneAxis = n.zoneAxis, e = this.zones = (n.zones || []).slice(), !n.negativeColor && !n.negativeFillColor || n.zones || e.push({
                value: n[this.zoneAxis + "Threshold"] || n.threshold || 0,
                color: n.negativeColor,
                fillColor: n.negativeFillColor
            }), e.length && h(e[e.length - 1].value) && e.push({color: this.color, fillColor: this.fillColor}), n
        },
        getCyclic: function (t, e, i) {
            var n = this.userOptions, s = "_" + t + "Index", o = t + "Counter";
            e || (h(n[s]) ? e = n[s] : (n[s] = e = this.chart[o] % i.length, this.chart[o] += 1), e = i[e]), this[t] = e
        },
        getColor: function () {
            this.options.colorByPoint || this.getCyclic("color", this.options.color || se[this.type].color, this.chart.options.colors)
        },
        getSymbol: function () {
            var t = this.options.marker;
            this.getCyclic("symbol", t.symbol, this.chart.options.symbols), /^url/.test(this.symbol) && (t.radius = 0)
        },
        drawLegendSymbol: ce.drawLineMarker,
        setData: function (t, e, n, r) {
            var a, l = this, h = l.points, c = h && h.length || 0, d = l.options, u = l.chart, p = null, f = l.xAxis,
                g = f && !!f.categories, m = d.turboThreshold, v = this.xData, y = this.yData,
                _ = (a = l.pointArrayMap) && a.length, t = t || [];
            if (a = t.length, e = Wt(e, !0), !1 !== r && a && c === a && !l.cropped && !l.hasGroupedData && l.visible) Vt(t, function (t, e) {
                h[e].update(t, !1, null, !1)
            }); else {
                if (l.xIncrement = null, l.pointRange = g ? 1 : d.pointRange, l.colorCounter = 0, Vt(this.parallelArrays, function (t) {
                    l[t + "Data"].length = 0
                }), m && a > m) {
                    for (n = 0; null === p && n < a;) p = t[n], n++;
                    if (o(p)) {
                        for (g = Wt(d.pointStart, 0), d = Wt(d.pointInterval, 1), n = 0; n < a; n++) v[n] = g, y[n] = t[n], g += d;
                        l.xIncrement = g
                    } else if (s(p)) if (_) for (n = 0; n < a; n++) d = t[n], v[n] = d[0], y[n] = d.slice(1, _ + 1); else for (n = 0; n < a; n++) d = t[n], v[n] = d[0], y[n] = d[1]; else S(12)
                } else for (n = 0; n < a; n++) t[n] !== P && (d = {series: l}, l.pointClass.prototype.applyOptions.apply(d, [t[n]]), l.updateParallelArrays(d, n), g && d.name) && (f.names[d.x] = d.name);
                for (i(y[0]) && S(14, !0), l.data = [], l.options.data = t, n = c; n--;) h[n] && h[n].destroy && h[n].destroy();
                f && (f.minRange = f.userMinRange), l.isDirty = l.isDirtyData = u.isDirtyBox = !0, n = !1
            }
            e && u.redraw(n)
        },
        processData: function (t) {
            var e, i = this.xData, n = this.yData, s = i.length;
            e = 0;
            var o, r, a, l = this.xAxis, h = this.options;
            a = h.cropThreshold;
            var c, d, u = this.isCartesian;
            if (u && !this.isDirty && !l.isDirty && !this.yAxis.isDirty && !t) return !1;
            for (l && (t = l.getExtremes(), c = t.min, d = t.max), u && this.sorted && (!a || s > a || this.forceCrop) && (i[s - 1] < c || i[0] > d ? (i = [], n = []) : (i[0] < c || i[s - 1] > d) && (e = this.cropData(this.xData, this.yData, c, d), i = e.xData, n = e.yData, e = e.start, o = !0)), a = i.length - 1; a >= 0; a--) s = i[a] - i[a - 1], s > 0 && (r === P || s < r) ? r = s : s < 0 && this.requireSorting && S(15);
            this.cropped = o, this.cropStart = e, this.processedXData = i, this.processedYData = n, null === h.pointRange && (this.pointRange = r || 1), this.closestPointRange = r
        },
        cropData: function (t, e, i, n) {
            var s, o = t.length, r = 0, a = o, l = Wt(this.cropShoulder, 1);
            for (s = 0; s < o; s++) if (t[s] >= i) {
                r = dt(0, s - l);
                break
            }
            for (; s < o; s++) if (t[s] > n) {
                a = s + l;
                break
            }
            return {xData: t.slice(r, a), yData: e.slice(r, a), start: r, end: a}
        },
        generatePoints: function () {
            var t, e, i, n, s = this.options.data, o = this.data, r = this.processedXData, a = this.processedYData,
                l = this.pointClass, h = r.length, c = this.cropStart || 0, u = this.hasGroupedData, p = [];
            for (o || u || (o = [], o.length = s.length, o = this.data = o), n = 0; n < h; n++) e = c + n, u ? p[n] = (new l).init(this, [r[n]].concat(d(a[n]))) : (o[e] ? i = o[e] : s[e] !== P && (o[e] = i = (new l).init(this, s[e], r[n])), p[n] = i), p[n].index = e;
            if (o && (h !== (t = o.length) || u)) for (n = 0; n < t; n++) n === c && !u && (n += h), o[n] && (o[n].destroyElements(), o[n].plotX = P);
            this.data = o, this.points = p
        },
        getExtremes: function (t) {
            var e, i = this.yAxis, n = this.processedXData, s = [], o = 0;
            e = this.xAxis.getExtremes();
            var r, a, l, h, c = e.min, d = e.max, t = t || this.stackedYData || this.processedYData;
            for (e = t.length, h = 0; h < e; h++) if (a = n[h], l = t[h], r = null !== l && l !== P && (!i.isLog || l.length || l > 0), a = this.getExtremesFromAll || this.cropped || (n[h + 1] || a) >= c && (n[h - 1] || a) <= d, r && a) if (r = l.length) for (; r--;) null !== l[r] && (s[o++] = l[r]); else s[o++] = l;
            this.dataMin = x(s), this.dataMax = w(s)
        },
        translate: function () {
            this.processedXData || this.processData(), this.generatePoints();
            for (var t, e, i, n = this.options, s = n.stacking, r = this.xAxis, a = r.categories, l = this.yAxis, c = this.points, d = c.length, u = !!this.modifyValue, p = n.pointPlacement, f = "between" === p || o(p), g = n.threshold, m = Number.MAX_VALUE, n = 0; n < d; n++) {
                var v = c[n], y = v.x, _ = v.y;
                e = v.low;
                var b = s && l.stacks[(this.negStacks && _ < g ? "-" : "") + this.stackKey];
                l.isLog && null !== _ && _ <= 0 && (v.y = _ = null, S(10)), v.plotX = t = r.translate(y, 0, 0, 0, 1, p, "flags" === this.type), s && this.visible && b && b[y] && (b = b[y], _ = b.points[this.index + "," + n], e = _[0], _ = _[1], 0 === e && (e = Wt(g, l.min)), l.isLog && e <= 0 && (e = null), v.total = v.stackTotal = b.total, v.percentage = b.total && v.y / b.total * 100, v.stackY = _, b.setOffset(this.pointXOffset || 0, this.barW || 0)), v.yBottom = h(e) ? l.translate(e, 0, 1, 0, 1) : null, u && (_ = this.modifyValue(_, v)), v.plotY = e = "number" == typeof _ && _ !== Infinity ? ut(dt(-1e5, l.translate(_, 0, 1, 0, 1)), 1e5) : P, v.isInside = e !== P && e >= 0 && e <= l.len && t >= 0 && t <= r.len, v.clientX = f ? r.translate(y, 0, 0, 0, 1) : t, v.negative = v.y < (g || 0), v.category = a && a[v.x] !== P ? a[v.x] : v.x, n && (m = ut(m, pt(t - i))), i = t
            }
            this.closestPointRangePx = m, this.getSegments()
        },
        setClip: function (t) {
            var e = this.chart, i = e.renderer, n = e.inverted, s = this.clipBox, o = s || e.clipBox,
                r = this.sharedClipKey || ["_sharedClip", t && t.duration, t && t.easing, o.height].join(","), a = e[r],
                l = e[r + "m"];
            a || (t && (o.width = 0, e[r + "m"] = l = i.clipRect(-99, n ? -e.plotLeft : -e.plotTop, 99, n ? e.chartWidth : e.chartHeight)), e[r] = a = i.clipRect(o)), t && (a.count += 1), !1 !== this.options.clip && (this.group.clip(t || s ? a : e.clipRect), this.markerGroup.clip(l), this.sharedClipKey = r), t || (a.count -= 1, a.count <= 0 && r && e[r] && (s || (e[r] = e[r].destroy()), e[r + "m"] && (e[r + "m"] = e[r + "m"].destroy())))
        },
        animate: function (t) {
            var e, i = this.chart, s = this.options.animation;
            s && !n(s) && (s = se[this.type].animation), t ? this.setClip(s) : (e = this.sharedClipKey, (t = i[e]) && t.animate({width: i.plotSizeX}, s), i[e + "m"] && i[e + "m"].animate({width: i.plotSizeX + 99}, s), this.animate = null)
        },
        afterAnimate: function () {
            this.setClip(), te(this, "afterAnimate")
        },
        drawPoints: function () {
            var t, e, i, n, s, o, r, a, l, h, c, d, u = this.points, p = this.chart, f = this.options.marker,
                g = this.pointAttr[""], m = this.markerGroup,
                v = Wt(f.enabled, this.xAxis.isRadial, this.closestPointRangePx > 2 * f.radius);
            if (!1 !== f.enabled || this._hasPointMarkers) for (n = u.length; n--;) s = u[n], e = ht(s.plotX), i = s.plotY, l = s.graphic, h = s.marker || {}, c = !!s.marker, t = v && h.enabled === P || h.enabled, d = s.isInside, t && i !== P && !isNaN(i) && null !== s.y ? (t = s.pointAttr[s.selected ? "select" : ""] || g, o = t.r, r = Wt(h.symbol, this.symbol), a = 0 === r.indexOf("url"), l ? l[d ? "show" : "hide"](!0).animate(Rt({
                x: e - o,
                y: i - o
            }, l.symbolName ? {
                width: 2 * o,
                height: 2 * o
            } : {})) : d && (o > 0 || a) && (s.graphic = p.renderer.symbol(r, e - o, i - o, 2 * o, 2 * o, c ? h : f).attr(t).add(m))) : l && (s.graphic = l.destroy())
        },
        convertAttribs: function (t, e, i, n) {
            var s, o, r = this.pointAttrToOptions, a = {}, t = t || {}, e = e || {}, i = i || {}, n = n || {};
            for (s in r) o = r[s], a[s] = Wt(t[o], e[s], i[s], n[s]);
            return a
        },
        getAttribs: function () {
            var t, e = this, i = e.options, n = se[e.type].marker ? i.marker : i, s = n.states, o = s.hover,
                r = e.color, a = e.options.negativeColor;
            t = {stroke: r, fill: r};
            var l, c, d = e.points || [], u = [], p = e.pointAttrToOptions;
            c = e.hasPointSpecificOptions;
            var f = n.lineColor, g = n.fillColor;
            l = i.turboThreshold;
            var m, v = e.zones, y = e.zoneAxis || "y";
            if (i.marker ? (o.radius = o.radius || n.radius + o.radiusPlus, o.lineWidth = o.lineWidth || n.lineWidth + o.lineWidthPlus) : (o.color = o.color || le(o.color || r).brighten(o.brightness).get(), o.negativeColor = o.negativeColor || le(o.negativeColor || a).brighten(o.brightness).get()), u[""] = e.convertAttribs(n, t), Vt(["hover", "select"], function (t) {
                u[t] = e.convertAttribs(s[t], u[""])
            }), e.pointAttr = u, r = d.length, !l || r < l || c) for (; r--;) {
                if (l = d[r], (n = l.options && l.options.marker || l.options) && !1 === n.enabled && (n.radius = 0), v.length) {
                    for (c = 0, t = v[c]; l[y] >= t.value;) t = v[++c];
                    l.color = l.fillColor = t.color
                }
                if (c = i.colorByPoint || l.color, l.options) for (m in p) h(n[p[m]]) && (c = !0);
                c ? (n = n || {}, c = [], s = n.states || {}, t = s.hover = s.hover || {}, i.marker || (t.color = t.color || !l.options.color && o[l.negative && a ? "negativeColor" : "color"] || le(l.color).brighten(t.brightness || o.brightness).get()), t = {color: l.color}, g || (t.fillColor = l.color), f || (t.lineColor = l.color), n.hasOwnProperty("color") && !n.color && delete n.color, c[""] = e.convertAttribs(Rt(t, n), u[""]), c.hover = e.convertAttribs(s.hover, u.hover, c[""]), c.select = e.convertAttribs(s.select, u.select, c[""])) : c = u, l.pointAttr = c
            }
        },
        destroy: function () {
            var t, e, i, n, s = this, o = s.chart, r = /AppleWebKit\/533/.test(yt), a = s.data || [];
            for (te(s, "destroy"), Jt(s), Vt(s.axisTypes || [], function (t) {
                (n = s[t]) && (l(n.series, s), n.isDirty = n.forceRedraw = !0)
            }), s.legendItem && s.chart.legend.destroyItem(s), t = a.length; t--;) (e = a[t]) && e.destroy && e.destroy();
            s.points = null, clearTimeout(s.animationTimeout);
            for (i in s) s[i] instanceof L && !s[i].survive && (t = r && "group" === i ? "hide" : "destroy", s[i][t]());
            o.hoverSeries === s && (o.hoverSeries = null), l(o.series, s);
            for (i in s) delete s[i]
        },
        getSegmentPath: function (t) {
            var e = this, i = [], n = e.options.step;
            return Vt(t, function (s, o) {
                var r, a = s.plotX, l = s.plotY;
                e.getPointSpline ? i.push.apply(i, e.getPointSpline(t, s, o)) : (i.push(o ? "L" : "M"), n && o && (r = t[o - 1], "right" === n ? i.push(r.plotX, l) : "center" === n ? i.push((r.plotX + a) / 2, r.plotY, (r.plotX + a) / 2, l) : i.push(a, r.plotY)), i.push(s.plotX, s.plotY))
            }), i
        },
        getGraphPath: function () {
            var t, e = this, i = [], n = [];
            return Vt(e.segments, function (s) {
                t = e.getSegmentPath(s), s.length > 1 ? i = i.concat(t) : n.push(s[0])
            }), e.singlePoints = n, e.graphPath = i
        },
        drawGraph: function () {
            var t = this, e = this.options, i = [["graph", e.lineColor || this.color, e.dashStyle]], n = e.lineWidth,
                s = "square" !== e.linecap, o = this.getGraphPath(), r = this.fillGraph && this.color || jt;
            Vt(this.zones, function (n, s) {
                i.push(["zoneGraph" + s, n.color || t.color, n.dashStyle || e.dashStyle])
            }), Vt(i, function (i, a) {
                var l = i[0], h = t[l];
                h ? (ne(h), h.animate({d: o})) : (n || r) && o.length && (h = {
                    stroke: i[1],
                    "stroke-width": n,
                    fill: r,
                    zIndex: 1
                }, i[2] ? h.dashstyle = i[2] : s && (h["stroke-linecap"] = h["stroke-linejoin"] = "round"), t[l] = t.chart.renderer.path(o).attr(h).add(t.group).shadow(a < 2 && e.shadow))
            })
        },
        applyZones: function () {
            var t, e, i, n = this, s = this.chart, o = s.renderer, r = this.zones, a = this.clips || [], l = this.graph,
                h = this.area, c = dt(s.chartWidth, s.chartHeight), d = this[(this.zoneAxis || "y") + "Axis"],
                u = d.reversed, p = d.horiz, f = !1;
            r.length && (l || h) && (l && l.hide(), h && h.hide(), Vt(r, function (r, g) {
                t = Wt(e, u ? p ? s.plotWidth : 0 : p ? 0 : d.toPixels(d.min)), e = lt(d.toPixels(Wt(r.value, d.max), !0)), t = d.isXAxis ? t > e ? e : t : t < e ? e : t, f && (t = e = d.toPixels(d.max)), d.isXAxis ? (i = {
                    x: u ? e : t,
                    y: 0,
                    width: Math.abs(t - e),
                    height: c
                }, p || (i.x = s.plotHeight - i.x)) : (i = {
                    x: 0,
                    y: u ? t : e,
                    width: c,
                    height: Math.abs(t - e)
                }, p && (i.y = s.plotWidth - i.y)), s.inverted && o.isVML && (i = d.isXAxis ? {
                    x: 0,
                    y: u ? t : e,
                    height: i.width,
                    width: s.chartWidth
                } : {
                    x: i.y - s.plotLeft - s.spacingBox.x,
                    y: 0,
                    width: i.height,
                    height: s.chartHeight
                }), a[g] ? a[g].animate(i) : (a[g] = o.clipRect(i), l && n["zoneGraph" + g].clip(a[g]), h && n["zoneArea" + g].clip(a[g])), f = r.value > d.max
            }), this.clips = a)
        },
        invertGroups: function () {
            function t() {
                var t = {width: e.yAxis.len, height: e.xAxis.len};
                Vt(["group", "markerGroup"], function (i) {
                    e[i] && e[i].attr(t).invert()
                })
            }

            var e = this, i = e.chart;
            e.xAxis && (Kt(i, "resize", t), Kt(e, "destroy", function () {
                Jt(i, "resize", t)
            }), t(), e.invertGroups = t)
        },
        plotGroup: function (t, e, i, n, s) {
            var o = this[t], r = !o;
            return r && (this[t] = o = this.chart.renderer.g(e).attr({
                visibility: i,
                zIndex: n || .1
            }).add(s)), o[r ? "attr" : "animate"](this.getPlotBox()), o
        },
        getPlotBox: function () {
            var t = this.chart, e = this.xAxis, i = this.yAxis;
            return t.inverted && (e = i, i = this.xAxis), {
                translateX: e ? e.left : t.plotLeft,
                translateY: i ? i.top : t.plotTop,
                scaleX: 1,
                scaleY: 1
            }
        },
        render: function () {
            var t, e = this, i = e.chart, n = e.options,
                s = (t = n.animation) && !!e.animate && i.renderer.isSVG && Wt(t.duration, 500) || 0,
                o = e.visible ? "visible" : "hidden", r = n.zIndex, a = e.hasRendered, l = i.seriesGroup;
            t = e.plotGroup("group", "series", o, r, l), e.markerGroup = e.plotGroup("markerGroup", "markers", o, r, l), s && e.animate(!0), e.getAttribs(), t.inverted = !!e.isCartesian && i.inverted, e.drawGraph && (e.drawGraph(), e.applyZones()), Vt(e.points, function (t) {
                t.redraw && t.redraw()
            }), e.drawDataLabels && e.drawDataLabels(), e.visible && e.drawPoints(), e.drawTracker && !1 !== e.options.enableMouseTracking && e.drawTracker(), i.inverted && e.invertGroups(), !1 !== n.clip && !e.sharedClipKey && !a && t.clip(i.clipRect), s && e.animate(), a || (s ? e.animationTimeout = setTimeout(function () {
                e.afterAnimate()
            }, s) : e.afterAnimate()), e.isDirty = e.isDirtyData = !1, e.hasRendered = !0
        },
        redraw: function () {
            var t = this.chart, e = this.isDirtyData, i = this.isDirty, n = this.group, s = this.xAxis, o = this.yAxis;
            n && (t.inverted && n.attr({
                width: t.plotWidth,
                height: t.plotHeight
            }), n.animate({
                translateX: Wt(s && s.left, t.plotLeft),
                translateY: Wt(o && o.top, t.plotTop)
            })), this.translate(), this.render(), e && te(this, "updatedData"), (i || e) && delete this.kdTree
        },
        kdDimensions: 1,
        kdTree: null,
        kdAxisArray: ["clientX", "plotY"],
        kdComparer: "distX",
        searchPoint: function (t) {
            var e = this.xAxis, i = this.yAxis, n = this.chart.inverted;
            return this.searchKDTree({
                clientX: n ? e.len - t.chartY + e.pos : t.chartX - e.pos,
                plotY: n ? i.len - t.chartX + i.pos : t.chartY - i.pos
            })
        },
        buildKDTree: function () {
            function t(e, n, s) {
                var o, r;
                if (r = e && e.length) return o = i.kdAxisArray[n % s], e.sort(function (t, e) {
                    return t[o] - e[o]
                }), r = Math.floor(r / 2), {
                    point: e[r],
                    left: t(e.slice(0, r), n + 1, s),
                    right: t(e.slice(r + 1), n + 1, s)
                }
            }

            function e() {
                var e = Ut(i.points, function (t) {
                    return null !== t.y
                });
                i.kdTree = t(e, n, n)
            }

            var i = this, n = i.kdDimensions;
            delete i.kdTree, i.options.kdSync ? e() : setTimeout(e)
        },
        searchKDTree: function (t) {
            function e(t, r, a, l) {
                var c, d = r.point, u = i.kdAxisArray[a % l], p = d;
                c = h(t[s]) && h(d[s]) ? Math.pow(t[s] - d[s], 2) : null;
                var f = h(t[o]) && h(d[o]) ? Math.pow(t[o] - d[o], 2) : null, g = (c || 0) + (f || 0);
                return c = {
                    distX: h(c) ? Math.sqrt(c) : Number.MAX_VALUE,
                    distY: h(f) ? Math.sqrt(f) : Number.MAX_VALUE,
                    distR: h(g) ? Math.sqrt(g) : Number.MAX_VALUE
                }, d.dist = c, u = t[u] - d[u], c = u < 0 ? "left" : "right", r[c] && (c = e(t, r[c], a + 1, l), p = c.dist[n] < p.dist[n] ? c : d, d = u < 0 ? "right" : "left", r[d] && Math.sqrt(u * u) < p.dist[n] && (t = e(t, r[d], a + 1, l), p = t.dist[n] < p.dist[n] ? t : p)), p
            }

            var i = this, n = this.kdComparer, s = this.kdAxisArray[0], o = this.kdAxisArray[1];
            if (this.kdTree || this.buildKDTree(), this.kdTree) return e(t, this.kdTree, this.kdDimensions, this.kdDimensions)
        }
    }, D.prototype = {
        destroy: function () {
            k(this, this.axis)
        }, render: function (t) {
            var e = this.options, i = e.format, i = i ? v(i, this) : e.formatter.call(this);
            this.label ? this.label.attr({
                text: i, visibility: "hidden"
            }) : this.label = this.axis.chart.renderer.text(i, null, null, e.useHTML).css(e.style).attr({
                align: this.textAlign,
                rotation: e.rotation,
                visibility: "hidden"
            }).add(t)
        }, setOffset: function (t, e) {
            var i = this.axis, n = i.chart, s = n.inverted, o = i.reversed,
                o = this.isNegative && !o || !this.isNegative && o,
                r = i.translate(i.usePercentage ? 100 : this.total, 0, 0, 0, 1), i = i.translate(0), i = pt(r - i),
                a = n.xAxis[0].translate(this.x) + t, l = n.plotHeight, o = {
                    x: s ? o ? r : r - i : a,
                    y: s ? l - a - e : o ? l - r - i : l - r,
                    width: s ? i : e,
                    height: s ? e : i
                };
            (s = this.label) && (s.align(this.alignOptions, null, o), o = s.alignAttr, s[!1 === this.options.crop || n.isInsidePlot(o.x, o.y) ? "show" : "hide"](!0))
        }
    }, ue.prototype.buildStacks = function () {
        var t = this.series, e = Wt(this.options.reversedStacks, !0), i = t.length;
        if (!this.isXAxis) {
            for (this.usePercentage = !1; i--;) t[e ? i : t.length - i - 1].setStackedPoints();
            if (this.usePercentage) for (i = 0; i < t.length; i++) t[i].setPercentStacks()
        }
    }, ue.prototype.renderStackTotals = function () {
        var t, e, i = this.chart, n = i.renderer, s = this.stacks, o = this.stackTotalGroup;
        o || (this.stackTotalGroup = o = n.g("stack-labels").attr({
            visibility: "visible",
            zIndex: 6
        }).add()), o.translate(i.plotLeft, i.plotTop);
        for (t in s) for (e in i = s[t]) i[e].render(o)
    }, ke.prototype.setStackedPoints = function () {
        if (this.options.stacking && (!0 === this.visible || !1 === this.chart.options.chart.ignoreHiddenSeries)) {
            var t, e, i, n, s, o, r = this.processedXData, a = this.processedYData, l = [], h = a.length,
                c = this.options, d = c.threshold, u = c.stack, c = c.stacking, p = this.stackKey, f = "-" + p,
                g = this.negStacks, m = this.yAxis, v = m.stacks, y = m.oldStacks;
            for (n = 0; n < h; n++) s = r[n], o = a[n], i = this.index + "," + n, e = (t = g && o < d) ? f : p, v[e] || (v[e] = {}), v[e][s] || (y[e] && y[e][s] ? (v[e][s] = y[e][s], v[e][s].total = null) : v[e][s] = new D(m, m.options.stackLabels, t, s, u)), e = v[e][s], e.points[i] = [e.cum || 0], "percent" === c ? (t = t ? p : f, g && v[t] && v[t][s] ? (t = v[t][s], e.total = t.total = dt(t.total, e.total) + pt(o) || 0) : e.total = T(e.total + (pt(o) || 0))) : e.total = T(e.total + (o || 0)), e.cum = (e.cum || 0) + (o || 0), e.points[i].push(e.cum), l[n] = e.cum;
            "percent" === c && (m.usePercentage = !0), this.stackedYData = l, m.oldStacks = {}
        }
    }, ke.prototype.setPercentStacks = function () {
        var t = this, e = t.stackKey, i = t.yAxis.stacks, n = t.processedXData;
        Vt([e, "-" + e], function (e) {
            for (var s, o, r, a = n.length; a--;) o = n[a], s = (r = i[e] && i[e][o]) && r.points[t.index + "," + a], (o = s) && (r = r.total ? 100 / r.total : 0, o[0] = T(o[0] * r), o[1] = T(o[1] * r), t.stackedYData[a] = o[1])
        })
    }, Rt(qt.prototype, {
        addSeries: function (t, e, i) {
            var n, s = this;
            return t && (e = Wt(e, !0), te(s, "addSeries", {options: t}, function () {
                n = s.initSeries(t), s.isDirtyLegend = !0, s.linkSeries(), e && s.redraw(i)
            })), n
        }, addAxis: function (e, i, n, s) {
            var o = i ? "xAxis" : "yAxis", r = this.options;
            new ue(this, t(e, {
                index: this[o].length,
                isX: i
            })), r[o] = d(r[o] || {}), r[o].push(e), Wt(n, !0) && this.redraw(s)
        }, showLoading: function (t) {
            var e = this, i = e.options, n = e.loadingDiv, s = i.loading, o = function () {
                n && u(n, {
                    left: e.plotLeft + "px",
                    top: e.plotTop + "px",
                    width: e.plotWidth + "px",
                    height: e.plotHeight + "px"
                })
            };
            n || (e.loadingDiv = n = p(It, {className: "highcharts-loading"}, Rt(s.style, {
                zIndex: 10,
                display: jt
            }), e.container), e.loadingSpan = p("span", null, s.labelStyle, n), Kt(e, "redraw", o)), e.loadingSpan.innerHTML = t || i.lang.loading, e.loadingShown || (u(n, {
                opacity: 0,
                display: ""
            }), ie(n, {opacity: s.style.opacity}, {duration: s.showDuration || 0}), e.loadingShown = !0), o()
        }, hideLoading: function () {
            var t = this.options, e = this.loadingDiv;
            e && ie(e, {opacity: 0}, {
                duration: t.loading.hideDuration || 100, complete: function () {
                    u(e, {display: jt})
                }
            }), this.loadingShown = !1
        }
    }), Rt(we.prototype, {
        update: function (t, e, i, o) {
            function r() {
                l.applyOptions(t), n(t) && !s(t) && (l.redraw = function () {
                    c && (t && t.marker && t.marker.symbol ? l.graphic = c.destroy() : c.attr(l.pointAttr[l.state || ""])), t && t.dataLabels && l.dataLabel && (l.dataLabel = l.dataLabel.destroy()), l.redraw = null
                }), a = l.index, h.updateParallelArrays(l, a), p && l.name && (p[l.x] = l.name), u.data[a] = l.options, h.isDirty = h.isDirtyData = !0, !h.fixedBox && h.hasCartesianSeries && (d.isDirtyBox = !0), d.legend.display && "point" === u.legendType && (h.updateTotals(), d.legend.clearItems()), e && d.redraw(i)
            }

            var a, l = this, h = l.series, c = l.graphic, d = h.chart, u = h.options, p = h.xAxis && h.xAxis.names,
                e = Wt(e, !0);
            !1 === o ? r() : l.firePointEvent("update", {options: t}, r)
        }, remove: function (t, e) {
            this.series.removePoint(Yt(this, this.series.data), t, e)
        }
    }), Rt(ke.prototype, {
        addPoint: function (t, e, i, n) {
            var s, o = this, r = o.options, a = o.data, l = o.graph, h = o.area, c = o.chart,
                d = o.xAxis && o.xAxis.names, u = l && l.shift || 0, p = ["graph", "area"], l = r.data, f = o.xData;
            if (A(n, c), i) {
                for (n = o.zones.length; n--;) p.push("zoneGraph" + n, "zoneArea" + n);
                Vt(p, function (t) {
                    o[t] && (o[t].shift = u + 1)
                })
            }
            if (h && (h.isArea = !0), e = Wt(e, !0), h = {series: o}, o.pointClass.prototype.applyOptions.apply(h, [t]), p = h.x, n = f.length, o.requireSorting && p < f[n - 1]) for (s = !0; n && f[n - 1] > p;) n--;
            o.updateParallelArrays(h, "splice", n, 0, 0), o.updateParallelArrays(h, n), d && h.name && (d[p] = h.name), l.splice(n, 0, t), s && (o.data.splice(n, 0, null), o.processData()), "point" === r.legendType && o.generatePoints(), i && (a[0] && a[0].remove ? a[0].remove(!1) : (a.shift(), o.updateParallelArrays(h, "shift"), l.shift())), o.isDirty = !0, o.isDirtyData = !0, e && (o.getAttribs(), c.redraw())
        }, removePoint: function (t, e, i) {
            var n = this, s = n.data, o = s[t], r = n.points, a = n.chart, l = function () {
                s.length === r.length && r.splice(t, 1), s.splice(t, 1), n.options.data.splice(t, 1), n.updateParallelArrays(o || {series: n}, "splice", t, 1), o && o.destroy(), n.isDirty = !0, n.isDirtyData = !0, e && a.redraw()
            };
            A(i, a), e = Wt(e, !0), o ? o.firePointEvent("remove", null, l) : l()
        }, remove: function (t, e) {
            var i = this, n = i.chart, t = Wt(t, !0);
            i.isRemoving || (i.isRemoving = !0, te(i, "remove", null, function () {
                i.destroy(), n.isDirtyLegend = n.isDirtyBox = !0, n.linkSeries(), t && n.redraw(e)
            })), i.isRemoving = !1
        }, update: function (e, i) {
            var n, s = this, o = this.chart, r = this.userOptions, a = this.type, l = Nt[a].prototype,
                h = ["group", "markerGroup", "dataLabelsGroup"];
            (e.type && e.type !== a || void 0 !== e.zIndex) && (h.length = 0), Vt(h, function (t) {
                h[t] = s[t], delete s[t]
            }), e = t(r, {
                animation: !1,
                index: this.index,
                pointStart: this.xData[0]
            }, {data: this.options.data}, e), this.remove(!1);
            for (n in l) this[n] = P;
            Rt(this, Nt[e.type || a].prototype), Vt(h, function (t) {
                s[t] = h[t]
            }), this.init(o, e), o.linkSeries(), Wt(i, !0) && o.redraw(!1)
        }
    }), Rt(ue.prototype, {
        update: function (e, i) {
            var n = this.chart, e = n.options[this.coll][this.options.index] = t(this.userOptions, e);
            this.destroy(!0), this._addedPlotLB = P, this.init(n, Rt(e, {events: P})), n.isDirtyBox = !0, Wt(i, !0) && n.redraw()
        }, remove: function (t) {
            for (var e = this.chart, i = this.coll, n = this.series, s = n.length; s--;) n[s] && n[s].remove(!1);
            l(e.axes, this), l(e[i], this), e.options[i].splice(this.options.index, 1), Vt(e[i], function (t, e) {
                t.options.index = e
            }), this.destroy(), e.isDirtyBox = !0, Wt(t, !0) && e.redraw()
        }, setTitle: function (t, e) {
            this.update({title: t}, e)
        }, setCategories: function (t, e) {
            this.update({categories: t}, e)
        }
    });
    var Ce = f(ke);
    Nt.line = Ce, se.area = t($t, {threshold: 0});
    var Se = f(ke, {
        type: "area", getSegments: function () {
            var t, e, i, n, s = this, o = [], r = [], a = [], l = this.xAxis, h = this.yAxis,
                c = h.stacks[this.stackKey], d = {}, u = this.points, p = this.options.connectNulls;
            if (this.options.stacking && !this.cropped) {
                for (i = 0; i < u.length; i++) d[u[i].x] = u[i];
                for (n in c) null !== c[n].total && a.push(+n);
                a.sort(function (t, e) {
                    return t - e
                }), Vt(a, function (n) {
                    var o, a = 0;
                    if (!p || d[n] && null !== d[n].y) if (d[n]) r.push(d[n]); else {
                        for (i = s.index; i <= h.series.length; i++) if (o = c[n].points[i + "," + n]) {
                            a = o[1];
                            break
                        }
                        t = l.translate(n), e = h.toPixels(a, !0), r.push({
                            y: null,
                            plotX: t,
                            clientX: t,
                            plotY: e,
                            yBottom: e,
                            onMouseOver: Dt
                        })
                    }
                }), r.length && o.push(r)
            } else ke.prototype.getSegments.call(this), o = this.segments;
            this.segments = o
        }, getSegmentPath: function (t) {
            var e, i = ke.prototype.getSegmentPath.call(this, t), n = [].concat(i), s = this.options;
            e = i.length;
            var o, r = this.yAxis.getThreshold(s.threshold);
            if (3 === e && n.push("L", i[1], i[2]), s.stacking && !this.closedStacks) for (e = t.length - 1; e >= 0; e--) o = Wt(t[e].yBottom, r), e < t.length - 1 && s.step && n.push(t[e + 1].plotX, o), n.push(t[e].plotX, o); else this.closeSegment(n, t, r);
            return this.areaPath = this.areaPath.concat(n), i
        }, closeSegment: function (t, e, i) {
            t.push("L", e[e.length - 1].plotX, i, "L", e[0].plotX, i)
        }, drawGraph: function () {
            this.areaPath = [], ke.prototype.drawGraph.apply(this);
            var t = this, e = this.areaPath, i = this.options, n = [["area", this.color, i.fillColor]];
            Vt(this.zones, function (e, s) {
                n.push(["zoneArea" + s, e.color || t.color, e.fillColor || i.fillColor])
            }), Vt(n, function (n) {
                var s = n[0], o = t[s];
                o ? o.animate({d: e}) : t[s] = t.chart.renderer.path(e).attr({
                    fill: Wt(n[2], le(n[1]).setOpacity(Wt(i.fillOpacity, .75)).get()),
                    zIndex: 0
                }).add(t.group)
            })
        }, drawLegendSymbol: ce.drawRectangle
    });
    Nt.area = Se, se.spline = t($t), Ce = f(ke, {
        type: "spline", getPointSpline: function (t, e, i) {
            var n, s, o, r, a = e.plotX, l = e.plotY, h = t[i - 1], c = t[i + 1];
            if (h && c) {
                t = h.plotY, o = c.plotX;
                var d, c = c.plotY;
                n = (1.5 * a + h.plotX) / 2.5, s = (1.5 * l + t) / 2.5, o = (1.5 * a + o) / 2.5, r = (1.5 * l + c) / 2.5, d = (r - s) * (o - a) / (o - n) + l - r, s += d, r += d, s > t && s > l ? (s = dt(t, l), r = 2 * l - s) : s < t && s < l && (s = ut(t, l), r = 2 * l - s), r > c && r > l ? (r = dt(c, l), s = 2 * l - r) : r < c && r < l && (r = ut(c, l), s = 2 * l - r), e.rightContX = o, e.rightContY = r
            }
            return i ? (e = ["C", h.rightContX || h.plotX, h.rightContY || h.plotY, n || a, s || l, a, l], h.rightContX = h.rightContY = null) : e = ["M", a, l], e
        }
    }), Nt.spline = Ce, se.areaspline = t(se.area), Se = Se.prototype, Ce = f(Ce, {
        type: "areaspline",
        closedStacks: !0,
        getSegmentPath: Se.getSegmentPath,
        closeSegment: Se.closeSegment,
        drawGraph: Se.drawGraph,
        drawLegendSymbol: ce.drawRectangle
    }), Nt.areaspline = Ce, se.column = t($t, {
        borderColor: "#FFFFFF",
        borderRadius: 0,
        groupPadding: .2,
        marker: null,
        pointPadding: .1,
        minPointLength: 0,
        cropThreshold: 50,
        pointRange: null,
        states: {
            hover: {brightness: .1, shadow: !1, halo: !1},
            select: {color: "#C0C0C0", borderColor: "#000000", shadow: !1}
        },
        dataLabels: {align: null, verticalAlign: null, y: null},
        stickyTracking: !1,
        tooltip: {distance: 6},
        threshold: 0
    }), Ce = f(ke, {
        type: "column",
        pointAttrToOptions: {stroke: "borderColor", fill: "color", r: "borderRadius"},
        cropShoulder: 0,
        directTouch: !0,
        trackerGroups: ["group", "dataLabelsGroup"],
        negStacks: !0,
        init: function () {
            ke.prototype.init.apply(this, arguments);
            var t = this, e = t.chart;
            e.hasRendered && Vt(e.series, function (e) {
                e.type === t.type && (e.isDirty = !0)
            })
        },
        getColumnMetrics: function () {
            var t, e, i = this, n = i.options, s = i.xAxis, o = i.yAxis, r = s.reversed, a = {}, l = 0;
            !1 === n.grouping ? l = 1 : Vt(i.chart.series, function (n) {
                var s = n.options, r = n.yAxis;
                n.type === i.type && n.visible && o.len === r.len && o.pos === r.pos && (s.stacking ? (t = n.stackKey, a[t] === P && (a[t] = l++), e = a[t]) : !1 !== s.grouping && (e = l++), n.columnIndex = e)
            });
            var s = ut(pt(s.transA) * (s.ordinalSlope || n.pointRange || s.closestPointRange || s.tickInterval || 1), s.len),
                c = s * n.groupPadding, d = (s - 2 * c) / l, u = n.pointWidth,
                n = h(u) ? (d - u) / 2 : d * n.pointPadding, u = Wt(u, d - 2 * n);
            return i.columnMetrics = {
                width: u,
                offset: n + (c + ((r ? l - (i.columnIndex || 0) : i.columnIndex) || 0) * d - s / 2) * (r ? -1 : 1)
            }
        },
        translate: function () {
            var t = this, e = t.chart, i = t.options,
                n = t.borderWidth = Wt(i.borderWidth, t.closestPointRange * t.xAxis.transA < 2 ? 0 : 1), s = t.yAxis,
                o = t.translatedThreshold = s.getThreshold(i.threshold), r = Wt(i.minPointLength, 5),
                a = t.getColumnMetrics(), l = a.width, h = t.barW = dt(l, 1 + 2 * n), c = t.pointXOffset = a.offset,
                d = -(n % 2 ? .5 : 0), u = n % 2 ? .5 : 1;
            e.inverted && (o -= .5, e.renderer.isVML && (u += 1)), i.pointPadding && (h = ct(h)), ke.prototype.translate.apply(t), Vt(t.points, function (i) {
                var n, a, p = Wt(i.yBottom, o), f = ut(dt(-999 - p, i.plotY), s.len + 999 + p), g = i.plotX + c, m = h,
                    v = ut(f, p);
                n = dt(f, p) - v, pt(n) < r && r && (n = r, a = !s.reversed && !i.negative || s.reversed && i.negative, v = lt(pt(v - o) > r ? p - r : o - (a ? r : 0))), i.barX = g, i.pointWidth = l, i.tooltipPos = e.inverted ? [s.len + s.pos - e.plotLeft - f, t.xAxis.len - g - m / 2] : [g + m / 2, f + s.pos - e.plotTop], m = lt(g + m) + d, g = lt(g) + d, m -= g, p = pt(v) < .5, n = ut(lt(v + n) + u, 9e4), v = lt(v) + u, n -= v, p && (v -= 1, n += 1), i.shapeType = "rect", i.shapeArgs = {
                    x: g,
                    y: v,
                    width: m,
                    height: n
                }
            })
        },
        getSymbol: Dt,
        drawLegendSymbol: ce.drawRectangle,
        drawGraph: Dt,
        drawPoints: function () {
            var e, i, n = this, s = this.chart, o = n.options, r = s.renderer, a = o.animationLimit || 250;
            Vt(n.points, function (l) {
                var c = l.plotY, d = l.graphic;
                c === P || isNaN(c) || null === l.y ? d && (l.graphic = d.destroy()) : (e = l.shapeArgs, c = h(n.borderWidth) ? {"stroke-width": n.borderWidth} : {}, i = l.pointAttr[l.selected ? "select" : ""] || n.pointAttr[""], d ? (ne(d), d.attr(c)[s.pointCount < a ? "animate" : "attr"](t(e))) : l.graphic = r[l.shapeType](e).attr(c).attr(i).add(n.group).shadow(o.shadow, null, o.stacking && !o.borderRadius))
            })
        },
        animate: function (t) {
            var e = this.yAxis, i = this.options, n = this.chart.inverted, s = {};
            Tt && (t ? (s.scaleY = .001, t = ut(e.pos + e.len, dt(e.pos, e.toPixels(i.threshold))), n ? s.translateX = t - e.len : s.translateY = t, this.group.attr(s)) : (s.scaleY = 1, s[n ? "translateX" : "translateY"] = e.pos, this.group.animate(s, this.options.animation), this.animate = null))
        },
        remove: function () {
            var t = this, e = t.chart;
            e.hasRendered && Vt(e.series, function (e) {
                e.type === t.type && (e.isDirty = !0)
            }), ke.prototype.remove.apply(t, arguments)
        }
    }), Nt.column = Ce, se.bar = t(se.column), Se = f(Ce, {
        type: "bar",
        inverted: !0
    }), Nt.bar = Se, se.scatter = t($t, {
        lineWidth: 1,
        marker: {enabled: !0},
        tooltip: {
            headerFormat: '',
            pointFormat: "x: <b>{point.x}</b><br/>y: <b>{point.y}</b><br/>"
        }
    }), Se = f(ke, {
        type: "scatter",
        sorted: !1,
        requireSorting: !1,
        noSharedTooltip: !0,
        trackerGroups: ["group", "markerGroup", "dataLabelsGroup"],
        takeOrdinalPosition: !1,
        kdDimensions: 2,
        kdComparer: "distR",
        drawGraph: function () {
            this.options.lineWidth && ke.prototype.drawGraph.call(this)
        }
    }), Nt.scatter = Se, se.pie = t($t, {
        borderColor: "#FFFFFF",
        borderWidth: 1,
        center: [null, null],
        clip: !1,
        colorByPoint: !0,
        dataLabels: {
            distance: 30, enabled: !0, formatter: function () {
                return this.point.name
            }, x: 0
        },
        ignoreHiddenPoint: !0,
        legendType: "point",
        marker: null,
        size: null,
        showInLegend: !1,
        slicedOffset: 10,
        states: {hover: {brightness: .1, shadow: !1}},
        stickyTracking: !1,
        tooltip: {followPointer: !0}
    }), $t = {
        type: "pie",
        isCartesian: !1,
        pointClass: f(we, {
            init: function () {
                we.prototype.init.apply(this, arguments);
                var t, e = this;
                return Rt(e, {visible: !1 !== e.visible, name: Wt(e.name, "Slice")}), t = function (t) {
                    e.slice("select" === t.type)
                }, Kt(e, "select", t), Kt(e, "unselect", t), e
            }, setVisible: function (t, e) {
                var i = this, n = i.series, s = n.chart, o = !n.isDirty && n.options.ignoreHiddenPoint;
                (t !== i.visible || e) && (i.visible = i.options.visible = t = t === P ? !i.visible : t, n.options.data[Yt(i, n.data)] = i.options, Vt(["graphic", "dataLabel", "connector", "shadowGroup"], function (e) {
                    i[e] && i[e][t ? "show" : "hide"](!0)
                }), i.legendItem && (s.hasRendered && (n.updateTotals(), s.legend.clearItems(), o || s.legend.render()), s.legend.colorizeItem(i, t)), o && (n.isDirty = !0, s.redraw()))
            }, slice: function (t, e, i) {
                var n = this.series;
                A(i, n.chart), Wt(e, !0), this.sliced = this.options.sliced = t = h(t) ? t : !this.sliced, n.options.data[Yt(this, n.data)] = this.options, t = t ? this.slicedTranslation : {
                    translateX: 0,
                    translateY: 0
                }, this.graphic.animate(t), this.shadowGroup && this.shadowGroup.animate(t)
            }, haloPath: function (t) {
                var e = this.shapeArgs, i = this.series.chart;
                return this.sliced || !this.visible ? [] : this.series.chart.renderer.symbols.arc(i.plotLeft + e.x, i.plotTop + e.y, e.r + t, e.r + t, {
                    innerR: this.shapeArgs.r,
                    start: e.start,
                    end: e.end
                })
            }
        }),
        requireSorting: !1,
        noSharedTooltip: !0,
        trackerGroups: ["group", "dataLabelsGroup"],
        axisTypes: [],
        pointAttrToOptions: {stroke: "borderColor", "stroke-width": "borderWidth", fill: "color"},
        getColor: Dt,
        animate: function (t) {
            var e = this, i = e.points, n = e.startAngleRad;
            t || (Vt(i, function (t) {
                var i = t.graphic, s = t.shapeArgs;
                i && (i.attr({r: t.startR || e.center[3] / 2, start: n, end: n}), i.animate({
                    r: s.r,
                    start: s.start,
                    end: s.end
                }, e.options.animation))
            }), e.animate = null)
        },
        setData: function (t, e, i, n) {
            ke.prototype.setData.call(this, t, !1, i, n), this.processData(), this.generatePoints(), Wt(e, !0) && this.chart.redraw(i)
        },
        updateTotals: function () {
            var t, e, i, n, s = 0, o = this.options.ignoreHiddenPoint;
            for (e = this.points, i = e.length, t = 0; t < i; t++) n = e[t], n.y < 0 && (n.y = null), s += o && !n.visible ? 0 : n.y;
            for (this.total = s, t = 0; t < i; t++) n = e[t], n.percentage = s > 0 && (n.visible || !o) ? n.y / s * 100 : 0, n.total = s
        },
        generatePoints: function () {
            ke.prototype.generatePoints.call(this), this.updateTotals()
        },
        translate: function (t) {
            this.generatePoints();
            var e, i, n, s, o, r = 0, a = this.options, l = a.slicedOffset, h = l + a.borderWidth,
                c = a.startAngle || 0, d = this.startAngleRad = mt / 180 * (c - 90),
                c = (this.endAngleRad = mt / 180 * (Wt(a.endAngle, c + 360) - 90)) - d, u = this.points,
                p = a.dataLabels.distance, a = a.ignoreHiddenPoint, f = u.length;
            for (t || (this.center = t = this.getCenter()), this.getX = function (e, i) {
                return n = at.asin(ut((e - t[1]) / (t[2] / 2 + p), 1)), t[0] + (i ? -1 : 1) * ft(n) * (t[2] / 2 + p)
            }, s = 0; s < f; s++) o = u[s], e = d + r * c, a && !o.visible || (r += o.percentage / 100), i = d + r * c, o.shapeType = "arc", o.shapeArgs = {
                x: t[0],
                y: t[1],
                r: t[2] / 2,
                innerR: t[3] / 2,
                start: lt(1e3 * e) / 1e3,
                end: lt(1e3 * i) / 1e3
            }, n = (i + e) / 2, n > 1.5 * mt ? n -= 2 * mt : n < -mt / 2 && (n += 2 * mt), o.slicedTranslation = {
                translateX: lt(ft(n) * l),
                translateY: lt(gt(n) * l)
            }, e = ft(n) * t[2] / 2, i = gt(n) * t[2] / 2, o.tooltipPos = [t[0] + .7 * e, t[1] + .7 * i], o.half = n < -mt / 2 || n > mt / 2 ? 1 : 0, o.angle = n, h = ut(h, p / 2), o.labelPos = [t[0] + e + ft(n) * p, t[1] + i + gt(n) * p, t[0] + e + ft(n) * h, t[1] + i + gt(n) * h, t[0] + e, t[1] + i, p < 0 ? "center" : o.half ? "right" : "left", n]
        },
        drawGraph: null,
        drawPoints: function () {
            var t, e, i, n, s = this, o = s.chart.renderer, r = s.options.shadow;
            r && !s.shadowGroup && (s.shadowGroup = o.g("shadow").add(s.group)), Vt(s.points, function (a) {
                var l = a.options.visible;
                e = a.graphic, n = a.shapeArgs, i = a.shadowGroup, r && !i && (i = a.shadowGroup = o.g("shadow").add(s.shadowGroup)), t = a.sliced ? a.slicedTranslation : {
                    translateX: 0,
                    translateY: 0
                }, i && i.attr(t), e ? e.animate(Rt(n, t)) : a.graphic = e = o[a.shapeType](n).setRadialReference(s.center).attr(a.pointAttr[a.selected ? "select" : ""]).attr({"stroke-linejoin": "round"}).attr(t).add(s.group).shadow(r, i), void 0 !== l && a.setVisible(l, !0)
            })
        },
        searchPoint: Dt,
        sortByAngle: function (t, e) {
            t.sort(function (t, i) {
                return void 0 !== t.angle && (i.angle - t.angle) * e
            })
        },
        drawLegendSymbol: ce.drawRectangle,
        getCenter: xe.getCenter,
        getSymbol: Dt
    }, $t = f(ke, $t), Nt.pie = $t, ke.prototype.drawDataLabels = function () {
        var e, i, n, s, o = this, r = o.options, a = r.cursor, l = r.dataLabels, c = o.points, d = o.hasRendered || 0,
            u = o.chart.renderer;
        (l.enabled || o._hasPointLabels) && (o.dlProcessOptions && o.dlProcessOptions(l), s = o.plotGroup("dataLabelsGroup", "data-labels", l.defer ? "hidden" : "visible", l.zIndex || 6), Wt(l.defer, !0) && (s.attr({opacity: +d}), d || Kt(o, "afterAnimate", function () {
            o.visible && s.show(), s[r.animation ? "animate" : "attr"]({opacity: 1}, {duration: 200})
        })), i = l, Vt(c, function (c) {
            var d, p, f, g, m = c.dataLabel, y = c.connector, _ = !0, b = {};
            if (e = c.dlOptions || c.options && c.options.dataLabels, d = Wt(e && e.enabled, i.enabled), m && !d) c.dataLabel = m.destroy(); else if (d) {
                if (l = t(i, e), g = l.style, d = l.rotation, p = c.getLabelConfig(), n = l.format ? v(l.format, p) : l.formatter.call(p, l), g.color = Wt(l.color, g.color, o.color, "black"), m) h(n) ? (m.attr({text: n}), _ = !1) : (c.dataLabel = m = m.destroy(), y && (c.connector = y.destroy())); else if (h(n)) {
                    m = {
                        fill: l.backgroundColor,
                        stroke: l.borderColor,
                        "stroke-width": l.borderWidth,
                        r: l.borderRadius || 0,
                        rotation: d,
                        padding: l.padding,
                        zIndex: 1
                    }, "contrast" === g.color && (b.color = l.inside || l.distance < 0 || r.stacking ? u.getContrast(c.color || o.color) : "#000000"), a && (b.cursor = a);
                    for (f in m) m[f] === P && delete m[f];
                    m = c.dataLabel = u[d ? "text" : "label"](n, 0, -999, l.shape, null, null, l.useHTML).attr(m).css(Rt(g, b)).add(s).shadow(l.shadow)
                }
                m && o.alignDataLabel(c, m, l, null, _)
            }
        }))
    }, ke.prototype.alignDataLabel = function (t, e, i, n, s) {
        var o = this.chart, r = o.inverted, a = Wt(t.plotX, -999), l = Wt(t.plotY, -999), h = e.getBBox(),
            c = o.renderer.fontMetrics(i.style.fontSize).b,
            d = this.visible && (t.series.forceDL || o.isInsidePlot(a, lt(l), r) || n && o.isInsidePlot(a, r ? n.x + 1 : n.y + n.height - 1, r));
        d && (n = Rt({
            x: r ? o.plotWidth - l : a,
            y: lt(r ? o.plotHeight - a : l),
            width: 0,
            height: 0
        }, n), Rt(i, {
            width: h.width,
            height: h.height
        }), i.rotation ? (t = o.renderer.rotCorr(c, i.rotation), e[s ? "attr" : "animate"]({
            x: n.x + i.x + n.width / 2 + t.x,
            y: n.y + i.y + n.height / 2
        }).attr({align: i.align})) : (e.align(i, null, n), r = e.alignAttr, "justify" === Wt(i.overflow, "justify") ? this.justifyDataLabel(e, i, r, h, n, s) : Wt(i.crop, !0) && (d = o.isInsidePlot(r.x, r.y) && o.isInsidePlot(r.x + h.width, r.y + h.height)), i.shape && e.attr({
            anchorX: t.plotX,
            anchorY: t.plotY
        }))), d || (e.attr({y: -999}), e.placed = !1)
    }, ke.prototype.justifyDataLabel = function (t, e, i, n, s, o) {
        var r, a, l = this.chart, h = e.align, c = e.verticalAlign, d = t.box ? 0 : t.padding || 0;
        r = i.x + d, r < 0 && ("right" === h ? e.align = "left" : e.x = -r, a = !0), r = i.x + n.width - d, r > l.plotWidth && ("left" === h ? e.align = "right" : e.x = l.plotWidth - r, a = !0), r = i.y + d, r < 0 && ("bottom" === c ? e.verticalAlign = "top" : e.y = -r, a = !0), r = i.y + n.height - d, r > l.plotHeight && ("top" === c ? e.verticalAlign = "bottom" : e.y = l.plotHeight - r, a = !0), a && (t.placed = !o, t.align(e, null, s))
    }, Nt.pie && (Nt.pie.prototype.drawDataLabels = function () {
        var t, e, i, n, s, o, r, a, l, h, c, d = this, u = d.data, p = d.chart, f = d.options.dataLabels,
            g = Wt(f.connectorPadding, 10), m = Wt(f.connectorWidth, 1), v = p.plotWidth, y = p.plotHeight,
            _ = Wt(f.softConnector, !0), b = f.distance, x = d.center, k = x[2] / 2, C = x[1], S = b > 0, T = [[], []],
            A = [0, 0, 0, 0], E = function (t, e) {
                return e.y - t.y
            };
        if (d.visible && (f.enabled || d._hasPointLabels)) {
            for (ke.prototype.drawDataLabels.apply(d), Vt(u, function (t) {
                t.dataLabel && t.visible && T[t.half].push(t)
            }), h = 2; h--;) {
                var L, M = [], D = [], P = T[h], F = P.length;
                if (F) {
                    for (d.sortByAngle(P, h - .5), c = u = 0; !u && P[c];) u = P[c] && P[c].dataLabel && (P[c].dataLabel.getBBox().height || 21), c++;
                    if (b > 0) {
                        for (s = ut(C + k + b, p.plotHeight), c = dt(0, C - k - b); c <= s; c += u) M.push(c);
                        if (s = M.length, F > s) {
                            for (t = [].concat(P), t.sort(E), c = F; c--;) t[c].rank = c;
                            for (c = F; c--;) P[c].rank >= s && P.splice(c, 1);
                            F = P.length
                        }
                        for (c = 0; c < F; c++) {
                            t = P[c], o = t.labelPos, t = 9999;
                            var I, j;
                            for (j = 0; j < s; j++) (I = pt(M[j] - o[1])) < t && (t = I, L = j);
                            if (L < c && null !== M[c]) L = c; else for (s < F - c + L && null !== M[c] && (L = s - F + c); null === M[L];) L++;
                            D.push({i: L, y: M[L]}), M[L] = null
                        }
                        D.sort(E)
                    }
                    for (c = 0; c < F; c++) t = P[c], o = t.labelPos, n = t.dataLabel, l = !1 === t.visible ? "hidden" : "inherit", t = o[1], b > 0 ? (s = D.pop(), L = s.i, a = s.y, (t > a && null !== M[L + 1] || t < a && null !== M[L - 1]) && (a = ut(dt(0, t), p.plotHeight))) : a = t, r = f.justify ? x[0] + (h ? -1 : 1) * (k + b) : d.getX(a === C - k - b || a === C + k + b ? t : a, h), n._attr = {
                        visibility: l,
                        align: o[6]
                    }, n._pos = {
                        x: r + f.x + ({left: g, right: -g}[o[6]] || 0),
                        y: a + f.y - 10
                    }, n.connX = r, n.connY = a, null === this.options.size && (s = n.width, r - s < g ? A[3] = dt(lt(s - r + g), A[3]) : r + s > v - g && (A[1] = dt(lt(r + s - v + g), A[1])), a - u / 2 < 0 ? A[0] = dt(lt(u / 2 - a), A[0]) : a + u / 2 > y && (A[2] = dt(lt(a + u / 2 - y), A[2])))
                }
            }
            (0 === w(A) || this.verifyDataLabelOverflow(A)) && (this.placeDataLabels(), S && m && Vt(this.points, function (t) {
                e = t.connector, o = t.labelPos, (n = t.dataLabel) && n._pos ? (l = n._attr.visibility, r = n.connX, a = n.connY, i = _ ? ["M", r + ("left" === o[6] ? 5 : -5), a, "C", r, a, 2 * o[2] - o[4], 2 * o[3] - o[5], o[2], o[3], "L", o[4], o[5]] : ["M", r + ("left" === o[6] ? 5 : -5), a, "L", o[2], o[3], "L", o[4], o[5]], e ? (e.animate({d: i}), e.attr("visibility", l)) : t.connector = e = d.chart.renderer.path(i).attr({
                    "stroke-width": m,
                    stroke: f.connectorColor || t.color || "#606060",
                    visibility: l
                }).add(d.dataLabelsGroup)) : e && (t.connector = e.destroy())
            }))
        }
    }, Nt.pie.prototype.placeDataLabels = function () {
        Vt(this.points, function (t) {
            var e, t = t.dataLabel;
            t && ((e = t._pos) ? (t.attr(t._attr), t[t.moved ? "animate" : "attr"](e), t.moved = !0) : t && t.attr({y: -999}))
        })
    }, Nt.pie.prototype.alignDataLabel = Dt, Nt.pie.prototype.verifyDataLabelOverflow = function (t) {
        var e, i = this.center, n = this.options, s = n.center, o = n = n.minSize || 80;
        return null !== s[0] ? o = dt(i[2] - dt(t[1], t[3]), n) : (o = dt(i[2] - t[1] - t[3], n), i[0] += (t[3] - t[1]) / 2), null !== s[1] ? o = dt(ut(o, i[2] - dt(t[0], t[2])), n) : (o = dt(ut(o, i[2] - t[0] - t[2]), n), i[1] += (t[0] - t[2]) / 2), o < i[2] ? (i[2] = o, this.translate(i), Vt(this.points, function (t) {
            t.dataLabel && (t.dataLabel._pos = null)
        }), this.drawDataLabels && this.drawDataLabels()) : e = !0, e
    }), Nt.column && (Nt.column.prototype.alignDataLabel = function (e, i, n, s, o) {
        var r = this.chart.inverted, a = e.series, l = e.dlBox || e.shapeArgs,
            h = e.below || e.plotY > Wt(this.translatedThreshold, a.yAxis.len),
            c = Wt(n.inside, !!this.options.stacking);
        l && (s = t(l), r && (s = {
            x: a.yAxis.len - s.y - s.height,
            y: a.xAxis.len - s.x - s.width,
            width: s.height,
            height: s.width
        }), !c) && (r ? (s.x += h ? 0 : s.width, s.width = 0) : (s.y += h ? s.height : 0, s.height = 0)), n.align = Wt(n.align, !r || c ? "center" : h ? "right" : "left"), n.verticalAlign = Wt(n.verticalAlign, r || c ? "middle" : h ? "top" : "bottom"), ke.prototype.alignDataLabel.call(this, e, i, n, s, o)
    }), function (t) {
        var e = t.Chart, i = t.each, n = HighchartsAdapter.addEvent;
        e.prototype.callbacks.push(function (t) {
            function e() {
                var e = [];
                i(t.series, function (t) {
                    var n = t.options.dataLabels;
                    (n.enabled || t._hasPointLabels) && !n.allowOverlap && t.visible && i(t.points, function (t) {
                        t.dataLabel && (t.dataLabel.labelrank = t.labelrank, e.push(t.dataLabel))
                    })
                }), t.hideOverlappingLabels(e)
            }

            e(), n(t, "redraw", e)
        }), e.prototype.hideOverlappingLabels = function (t) {
            var e, i, n, s, o = t.length;
            for (i = 0; i < o; i++) (e = t[i]) && (e.oldOpacity = e.opacity, e.newOpacity = 1);
            for (i = 0; i < o; i++) for (n = t[i], e = i + 1; e < o; ++e) s = t[e], n && s && n.placed && s.placed && 0 !== n.newOpacity && 0 !== s.newOpacity && !(s.alignAttr.x > n.alignAttr.x + n.width || s.alignAttr.x + s.width < n.alignAttr.x || s.alignAttr.y > n.alignAttr.y + n.height || s.alignAttr.y + s.height < n.alignAttr.y) && ((n.labelrank < s.labelrank ? n : s).newOpacity = 0);
            for (i = 0; i < o; i++) (e = t[i]) && (e.oldOpacity !== e.newOpacity && e.placed && (e.alignAttr.opacity = e.newOpacity, e[e.isOld && e.newOpacity ? "animate" : "attr"](e.alignAttr)), e.isOld = !0)
        }
    }(st), $t = st.TrackerMixin = {
        drawTrackerPoint: function () {
            var t = this, e = t.chart, i = e.pointer, n = t.options.cursor, s = n && {cursor: n}, o = function (t) {
                for (var i, n = t.target; n && !i;) i = n.point, n = n.parentNode;
                i !== P && i !== e.hoverPoint && i.onMouseOver(t)
            };
            Vt(t.points, function (t) {
                t.graphic && (t.graphic.element.point = t), t.dataLabel && (t.dataLabel.element.point = t)
            }), t._hasTracking || (Vt(t.trackerGroups, function (e) {
                t[e] && (t[e].addClass("highcharts-tracker").on("mouseover", o).on("mouseout", function (t) {
                    i.onTrackerMouseOut(t)
                }).css(s), I) && t[e].on("touchstart", o)
            }), t._hasTracking = !0)
        }, drawTrackerGraph: function () {
            var t, e = this, i = e.options, n = i.trackByArea, s = [].concat(n ? e.areaPath : e.graphPath),
                o = s.length, r = e.chart, a = r.pointer, l = r.renderer, h = r.options.tooltip.snap, c = e.tracker,
                d = i.cursor, u = d && {cursor: d}, d = e.singlePoints, p = function () {
                    r.hoverSeries !== e && e.onMouseOver()
                }, f = "rgba(192,192,192," + (Tt ? 1e-4 : .002) + ")";
            if (o && !n) for (t = o + 1; t--;) "M" === s[t] && s.splice(t + 1, 0, s[t + 1] - h, s[t + 2], "L"), (t && "M" === s[t] || t === o) && s.splice(t, 0, "L", s[t - 2] + h, s[t - 1]);
            for (t = 0; t < d.length; t++) o = d[t], s.push("M", o.plotX - h, o.plotY, "L", o.plotX + h, o.plotY);
            c ? c.attr({d: s}) : (e.tracker = l.path(s).attr({
                "stroke-linejoin": "round",
                visibility: e.visible ? "visible" : "hidden",
                stroke: f,
                fill: n ? f : jt,
                "stroke-width": i.lineWidth + (n ? 0 : 2 * h),
                zIndex: 2
            }).add(e.group), Vt([e.tracker, e.markerGroup], function (t) {
                t.addClass("highcharts-tracker").on("mouseover", p).on("mouseout", function (t) {
                    a.onTrackerMouseOut(t)
                }).css(u), I && t.on("touchstart", p)
            }))
        }
    }, Nt.column && (Ce.prototype.drawTracker = $t.drawTrackerPoint), Nt.pie && (Nt.pie.prototype.drawTracker = $t.drawTrackerPoint), Nt.scatter && (Se.prototype.drawTracker = $t.drawTrackerPoint), Rt(be.prototype, {
        setItemEvents: function (t, e, i, n, s) {
            var o = this;
            (i ? e : t.legendGroup).on("mouseover", function () {
                t.setState("hover"), e.css(o.options.itemHoverStyle)
            }).on("mouseout", function () {
                e.css(t.visible ? n : s), t.setState()
            }).on("click", function (e) {
                var i = function () {
                    t.setVisible()
                }, e = {browserEvent: e};
                t.firePointEvent ? t.firePointEvent("legendItemClick", e, i) : te(t, "legendItemClick", e, i)
            })
        }, createCheckboxForItem: function (t) {
            t.checkbox = p("input", {
                type: "checkbox",
                checked: t.selected,
                defaultChecked: t.selected
            }, this.options.itemCheckboxStyle, this.chart.container), Kt(t.checkbox, "click", function (e) {
                te(t.series || t, "checkboxClick", {checked: e.target.checked, item: t}, function () {
                    t.select()
                })
            })
        }
    }), O.legend.itemStyle.cursor = "pointer", Rt(qt.prototype, {
        showResetZoom: function () {
            var t = this, e = O.lang, i = t.options.chart.resetZoomButton, n = i.theme, s = n.states,
                o = "chart" === i.relativeTo ? null : "plotBox";
            this.resetZoomButton = t.renderer.button(e.resetZoom, null, null, function () {
                t.zoomOut()
            }, n, s && s.hover).attr({align: i.position.align, title: e.resetZoomTitle}).add().align(i.position, !1, o)
        }, zoomOut: function () {
            var t = this;
            te(t, "selection", {resetSelection: !0}, function () {
                t.zoom()
            })
        }, zoom: function (t) {
            var e, i, s = this.pointer, o = !1;
            !t || t.resetSelection ? Vt(this.axes, function (t) {
                e = t.zoom()
            }) : Vt(t.xAxis.concat(t.yAxis), function (t) {
                var i = t.axis, n = i.isXAxis;
                (s[n ? "zoomX" : "zoomY"] || s[n ? "pinchX" : "pinchY"]) && (e = i.zoom(t.min, t.max), i.displayBtn && (o = !0))
            }), i = this.resetZoomButton, o && !i ? this.showResetZoom() : !o && n(i) && (this.resetZoomButton = i.destroy()), e && this.redraw(Wt(this.options.chart.animation, t && t.animation, this.pointCount < 100))
        }, pan: function (t, e) {
            var i, n = this, s = n.hoverPoints;
            s && Vt(s, function (t) {
                t.setState()
            }), Vt("xy" === e ? [1, 0] : [1], function (e) {
                var s = t[e ? "chartX" : "chartY"], o = n[e ? "xAxis" : "yAxis"][0],
                    r = n[e ? "mouseDownX" : "mouseDownY"], a = (o.pointRange || 0) / 2, l = o.getExtremes(),
                    h = o.toValue(r - s, !0) + a, a = o.toValue(r + n[e ? "plotWidth" : "plotHeight"] - s, !0) - a,
                    r = r > s;
                o.series.length && (r || h > ut(l.dataMin, l.min)) && (!r || a < dt(l.dataMax, l.max)) && (o.setExtremes(h, a, !1, !1, {trigger: "pan"}), i = !0), n[e ? "mouseDownX" : "mouseDownY"] = s
            }), i && n.redraw(!1), u(n.container, {cursor: "move"})
        }
    }), Rt(we.prototype, {
        select: function (t, e) {
            var i = this, n = i.series, s = n.chart, t = Wt(t, !i.selected);
            i.firePointEvent(t ? "select" : "unselect", {accumulate: e}, function () {
                i.selected = i.options.selected = t, n.options.data[Yt(i, n.data)] = i.options, i.setState(t && "select"), e || Vt(s.getSelectedPoints(), function (t) {
                    t.selected && t !== i && (t.selected = t.options.selected = !1, n.options.data[Yt(t, n.data)] = t.options, t.setState(""), t.firePointEvent("unselect"))
                })
            })
        }, onMouseOver: function (t) {
            var e = this.series, i = e.chart, n = i.tooltip, s = i.hoverPoint;
            i.hoverSeries !== e && e.onMouseOver(), s && s !== this && s.onMouseOut(), this.firePointEvent("mouseOver"), n && (!n.shared || e.noSharedTooltip) && n.refresh(this, t), this.setState("hover"), i.hoverPoint = this
        }, onMouseOut: function () {
            var t = this.series.chart, e = t.hoverPoints;
            this.firePointEvent("mouseOut"), e && -1 !== Yt(this, e) || (this.setState(), t.hoverPoint = null)
        }, importEvents: function () {
            if (!this.hasImportedEvents) {
                var e, i = t(this.series.options.point, this.options).events;
                this.events = i;
                for (e in i) Kt(this, e, i[e]);
                this.hasImportedEvents = !0
            }
        }, setState: function (e, i) {
            var n, s = this.plotX, o = this.plotY, r = this.series, a = r.options.states,
                l = se[r.type].marker && r.options.marker, h = l && !l.enabled, c = l && l.states[e],
                d = c && !1 === c.enabled, u = r.stateMarkerGraphic, p = this.marker || {}, f = r.chart, g = r.halo,
                e = e || "";
            n = this.pointAttr[e] || r.pointAttr[e], e === this.state && !i || this.selected && "select" !== e || a[e] && !1 === a[e].enabled || e && (d || h && !1 === c.enabled) || e && p.states && p.states[e] && !1 === p.states[e].enabled || (this.graphic ? (l = l && this.graphic.symbolName && n.r, this.graphic.attr(t(n, l ? {
                x: s - l,
                y: o - l,
                width: 2 * l,
                height: 2 * l
            } : {})), u && u.hide()) : (e && c && (l = c.radius, p = p.symbol || r.symbol, u && u.currentSymbol !== p && (u = u.destroy()), u ? u[i ? "animate" : "attr"]({
                x: s - l,
                y: o - l
            }) : p && (r.stateMarkerGraphic = u = f.renderer.symbol(p, s - l, o - l, 2 * l, 2 * l).attr(n).add(r.markerGroup), u.currentSymbol = p)), u && u[e && f.isInsidePlot(s, o, f.inverted) ? "show" : "hide"]()), (s = a[e] && a[e].halo) && s.size ? (g || (r.halo = g = f.renderer.path().add(f.seriesGroup)), g.attr(Rt({fill: le(this.color || r.color).setOpacity(s.opacity).get()}, s.attributes))[i ? "animate" : "attr"]({d: this.haloPath(s.size)})) : g && g.attr({d: []}), this.state = e)
        }, haloPath: function (t) {
            var e = this.series, i = e.chart, n = e.getPlotBox(), s = i.inverted;
            return i.renderer.symbols.circle(n.translateX + (s ? e.yAxis.len - this.plotY : this.plotX) - t, n.translateY + (s ? e.xAxis.len - this.plotX : this.plotY) - t, 2 * t, 2 * t)
        }
    }), Rt(ke.prototype, {
        onMouseOver: function () {
            var t = this.chart, e = t.hoverSeries;
            e && e !== this && e.onMouseOut(), this.options.events.mouseOver && te(this, "mouseOver"), this.setState("hover"), t.hoverSeries = this
        }, onMouseOut: function () {
            var t = this.options, e = this.chart, i = e.tooltip, n = e.hoverPoint;
            n && n.onMouseOut(), this && t.events.mouseOut && te(this, "mouseOut"), i && !t.stickyTracking && (!i.shared || this.noSharedTooltip) && i.hide(), this.setState(), e.hoverSeries = null
        }, setState: function (t) {
            var e = this.options, i = this.graph, n = e.states, s = e.lineWidth, e = 0, t = t || "";
            if (this.state !== t && (this.state = t, !(n[t] && !1 === n[t].enabled) && (t && (s = n[t].lineWidth || s + (n[t].lineWidthPlus || 0)), i && !i.dashstyle))) for (t = {"stroke-width": s}, i.attr(t); this["zoneGraph" + e];) this["zoneGraph" + e].attr(t), e += 1
        }, setVisible: function (t, e) {
            var i, n = this, s = n.chart, o = n.legendItem, r = s.options.chart.ignoreHiddenSeries, a = n.visible;
            i = (n.visible = t = n.userOptions.visible = t === P ? !a : t) ? "show" : "hide", Vt(["group", "dataLabelsGroup", "markerGroup", "tracker"], function (t) {
                n[t] && n[t][i]()
            }), s.hoverSeries !== n && (s.hoverPoint && s.hoverPoint.series) !== n || n.onMouseOut(), o && s.legend.colorizeItem(n, t), n.isDirty = !0, n.options.stacking && Vt(s.series, function (t) {
                t.options.stacking && t.visible && (t.isDirty = !0)
            }), Vt(n.linkedSeries, function (e) {
                e.setVisible(t, !1)
            }), r && (s.isDirtyBox = !0), !1 !== e && s.redraw(), te(n, i)
        }, show: function () {
            this.setVisible(!0)
        }, hide: function () {
            this.setVisible(!1)
        }, select: function (t) {
            this.selected = t = t === P ? !this.selected : t, this.checkbox && (this.checkbox.checked = t), te(this, t ? "select" : "unselect")
        }, drawTracker: $t.drawTrackerGraph
    }), Rt(st, {
        Color: le,
        Point: we,
        Tick: M,
        Renderer: F,
        SVGElement: L,
        SVGRenderer: he,
        arrayMin: x,
        arrayMax: w,
        charts: Pt,
        dateFormat: z,
        error: S,
        format: v,
        pathAnim: N,
        getOptions: function () {
            return O
        },
        hasBidiBug: At,
        isTouchDevice: Ct,
        setOptions: function (e) {
            return O = t(!0, O, e), E(), O
        },
        addEvent: Kt,
        removeEvent: Jt,
        createElement: p,
        discardElement: C,
        css: u,
        each: Vt,
        map: Qt,
        merge: t,
        splat: d,
        extendClass: f,
        pInt: e,
        svg: Tt,
        canvas: Et,
        vml: !Tt && !Et,
        product: "Highcharts",
        version: "4.1.5"
    })
}(), function (t) {
    "use strict";

    function e(t) {
        return "[object Array]" === Object.prototype.toString.call(t)
    }

    function i(t) {
        return t instanceof Function
    }

    function n(t) {
        return !i(t) && t instanceof Object
    }

    function s(t, i) {
        var o;
        for (o in i) n(i[o]) || e(i[o]) ? (n(i[o]) && !n(t[o]) && (t[o] = {}), e(i[o]) && !e(t[o]) && (t[o] = []), s(t[o], i[o])) : i[o] !== undefined && (t[o] = i[o])
    }

    function o(t, e) {
        var i = {};
        return s(i, t), s(i, e), i
    }

    function r(t) {
        var e, i, n, s, o, r, a, l, h, c, d;
        return "[object Date]" === (c = Object.prototype.toString.call(t)) ? t : "[object String]" === c && (n = t.match(P)) ? (d = parseInt(n[1], 10), r = parseInt(n[3], 10) - 1, e = parseInt(n[5], 10), i = parseInt(n[7], 10), o = n[9] ? parseInt(n[9], 10) : 0, h = n[11] ? parseInt(n[11], 10) : 0, s = n[12] ? 1e3 * parseFloat(F + n[12].slice(1)) : 0, l = Date.UTC(d, r, e, i, o, h, s), n[13] && n[14] && (a = 60 * n[15], n[17] && (a += parseInt(n[17], 10)), a *= "-" === n[14] ? -1 : 1, l -= 60 * a * 1e3), new Date(l)) : void 0
    }

    function a(t) {
        var e, i, n;
        for (e = 0; e < t.length; e++) for (n = t[e].data, i = 0; i < n.length; i++) if (n[i][1] < 0) return !0;
        return !1
    }

    function l(t, e, i, n, s) {
        return function (r, l, h) {
            var c = o({}, t);
            return c = o(c, h || {}), l.hideLegend && e(c), "min" in l ? i(c, l.min) : a(r) || i(c, 0), "max" in l && n(c, l.max), l.stacked && s(c), l.colors && (c.colors = l.colors), c = o(c, l.library || {})
        }
    }

    function h(t, e) {
        document.body.innerText ? t.innerText = e : t.textContent = e
    }

    function c(t, e) {
        h(t, "Error Loading Chart: " + e), t.style.color = "#ff0000"
    }

    function d(e, i, n) {
        (t.jQuery || t.Zepto || t.$).ajax({
            dataType: "json", url: i, success: n, error: function (t, i, n) {
                var s = "string" == typeof n ? n : n.message;
                c(e, s)
            }
        })
    }

    function u(t, e) {
        try {
            e(t)
        } catch (e) {
            throw c(t.element, e.message), e
        }
    }

    function p(t, e) {
        "string" == typeof t.dataSource ? d(t.element, t.dataSource, function (i) {
            t.data = i, u(t, e)
        }) : (t.data = t.dataSource, u(t, e))
    }

    function f(t) {
        return "" + t
    }

    function g(t) {
        return parseFloat(t)
    }

    function m(t) {
        if ("object" != typeof t) if ("number" == typeof t) t = new Date(1e3 * t); else {
            var e = t.replace(/ /, "T").replace(" ", "").replace("UTC", "Z");
            t = r(e) || new Date(t)
        }
        return t
    }

    function v(t) {
        if (!e(t)) {
            var i, n = [];
            for (i in t) t.hasOwnProperty(i) && n.push([i, t[i]]);
            t = n
        }
        return t
    }

    function y(t, e) {
        return t[0].getTime() - e[0].getTime()
    }

    function _(t, e) {
        var n, s, o;
        for (o = "render" + t, n = 0; n < j.length; n++) if (s = j[n], i(s[o])) return s[o](e);
        throw new Error("No adapter found")
    }

    function b(t, i, n) {
        var s, o, r, a, l;
        for (!e(t) || "object" != typeof t[0] || e(t[0]) ? (t = [{
            name: "Value",
            data: t
        }], i.hideLegend = !0) : i.hideLegend = !1, i.discrete && (n = !1), s = 0; s < t.length; s++) {
            for (r = v(t[s].data), a = [], o = 0; o < r.length; o++) l = r[o][0], l = n ? m(l) : f(l), a.push([l, g(r[o][1])]);
            n && a.sort(y), t[s].data = a
        }
        return t
    }

    function x(t) {
        var e, i = v(t);
        for (e = 0; e < i.length; e++) i[e] = [f(i[e][0]), g(i[e][1])];
        return i
    }

    function w(t) {
        var e;
        for (e = 0; e < t.length; e++) t[e][1] = m(t[e][1]), t[e][2] = m(t[e][2]);
        return t
    }

    function k(t) {
        t.data = b(t.data, t.options, !0), _("LineChart", t)
    }

    function C(t) {
        t.data = b(t.data, t.options, !1), _("ColumnChart", t)
    }

    function S(t) {
        t.data = x(t.data), _("PieChart", t)
    }

    function T(t) {
        t.data = b(t.data, t.options, !1), _("BarChart", t)
    }

    function A(t) {
        t.data = b(t.data, t.options, !0), _("AreaChart", t)
    }

    function E(t) {
        t.data = x(t.data), _("GeoChart", t)
    }

    function L(t) {
        t.data = w(t.data), _("Timeline", t)
    }

    function M(t, e, i, n, s) {
        "string" == typeof e && (e = document.getElementById(e)), t.element = e, t.options = n || {}, t.dataSource = i, D.charts[e.id] = t, p(t, s)
    }

    var D, P, F, I = t.Chartkick || {}, j = [];
    if (P = /(\d\d\d\d)(\-)?(\d\d)(\-)?(\d\d)(T)?(\d\d)(:)?(\d\d)?(:)?(\d\d)?([\.,]\d+)?($|Z|([\+\-])(\d\d)(:)?(\d\d)?)/i, F = String(1.5).charAt(1), "Highcharts" in t) {
        var O = new function () {
            var e = t.Highcharts, i = {
                chart: {},
                xAxis: {labels: {style: {fontSize: "12px"}}},
                yAxis: {title: {text: null}, labels: {style: {fontSize: "12px"}}},
                title: {text: null},
                credits: {enabled: !1},
                legend: {borderWidth: 0},
                tooltip: {style: {fontSize: "12px"}},
                plotOptions: {areaspline: {}, series: {marker: {}}}
            }, n = function (t) {
                t.legend.enabled = !1
            }, s = function (t, e) {
                t.yAxis.min = e
            }, r = function (t, e) {
                t.yAxis.max = e
            }, a = function (t) {
                t.plotOptions.series.stacking = "normal"
            }, h = l(i, n, s, r, a);
            this.renderLineChart = function (t, i) {
                i = i || "spline";
                var n = {};
                "areaspline" === i && (n = {
                    plotOptions: {
                        areaspline: {stacking: "normal"},
                        series: {marker: {enabled: !1}}
                    }
                });
                var s, o, r, a = h(t.data, t.options, n);
                a.xAxis.type = t.options.discrete ? "category" : "datetime", a.chart.type = i, a.chart.renderTo = t.element.id;
                var l = t.data;
                for (o = 0; o < l.length; o++) {
                    if (s = l[o].data, !t.options.discrete) for (r = 0; r < s.length; r++) s[r][0] = s[r][0].getTime();
                    l[o].marker = {symbol: "circle"}
                }
                a.series = l, new e.Chart(a)
            }, this.renderPieChart = function (t) {
                var n = {};
                t.options.colors && (n.colors = t.options.colors);
                var s = o(o(i, n), t.options.library || {});
                s.chart.renderTo = t.element.id, s.series = [{type: "pie", name: "Value", data: t.data}], new e.Chart(s)
            }, this.renderColumnChart = function (t, i) {
                var n, s, o, r, i = i || "column", a = t.data, l = h(a, t.options), c = [];
                for (l.chart.type = i, l.chart.renderTo = t.element.id, n = 0; n < a.length; n++) for (o = a[n], s = 0; s < o.data.length; s++) r = o.data[s], c[r[0]] || (c[r[0]] = new Array(a.length)), c[r[0]][n] = r[1];
                var d = [];
                for (n in c) c.hasOwnProperty(n) && d.push(n);
                l.xAxis.categories = d;
                var u = [];
                for (n = 0; n < a.length; n++) {
                    for (r = [], s = 0; s < d.length; s++) r.push(c[d[s]][n] || 0);
                    u.push({name: a[n].name, data: r})
                }
                l.series = u, new e.Chart(l)
            };
            var c = this;
            this.renderBarChart = function (t) {
                c.renderColumnChart(t, "bar")
            }, this.renderAreaChart = function (t) {
                c.renderLineChart(t, "areaspline")
            }
        };
        j.push(O)
    }
    if (t.google && t.google.setOnLoadCallback) {
        var z = new function () {
            var e = t.google, i = {}, n = [], s = function () {
                for (var t, i = 0; i < n.length; i++) t = n[i], e.visualization && ("corechart" == t.pack && e.visualization.LineChart || "timeline" == t.pack && e.visualization.Timeline) && (t.callback(), n.splice(i, 1), i--)
            }, r = function (t, o) {
                if (o || (o = t, t = "corechart"), n.push({pack: t, callback: o}), i[t]) s(); else {
                    i[t] = !0;
                    var r = {packages: [t], callback: s};
                    I.language && (r.language = I.language), e.load("visualization", "1", r)
                }
            }, a = {
                chartArea: {},
                fontName: "'Lucida Grande', 'Lucida Sans Unicode', Verdana, Arial, Helvetica, sans-serif",
                pointSize: 6,
                legend: {textStyle: {fontSize: 12, color: "#444"}, alignment: "center", position: "right"},
                curveType: "function",
                hAxis: {
                    textStyle: {color: "#666", fontSize: 12},
                    gridlines: {color: "transparent"},
                    baselineColor: "#ccc",
                    viewWindow: {}
                },
                vAxis: {textStyle: {color: "#666", fontSize: 12}, baselineColor: "#ccc", viewWindow: {}},
                tooltip: {textStyle: {color: "#666", fontSize: 12}}
            }, h = function (t) {
                t.legend.position = "none"
            }, c = function (t, e) {
                t.vAxis.viewWindow.min = e
            }, d = function (t, e) {
                t.vAxis.viewWindow.max = e
            }, u = function (t, e) {
                t.hAxis.viewWindow.min = e
            }, p = function (t, e) {
                t.hAxis.viewWindow.max = e
            }, f = function (t) {
                t.isStacked = !0
            }, m = l(a, h, c, d, f), v = function (t, i) {
                var n = new e.visualization.DataTable;
                n.addColumn(i, "");
                var s, o, r, a, l, h = [];
                for (s = 0; s < t.length; s++) for (r = t[s], n.addColumn("number", r.name), o = 0; o < r.data.length; o++) a = r.data[o], l = "datetime" === i ? a[0].getTime() : a[0], h[l] || (h[l] = new Array(t.length)), h[l][s] = g(a[1]);
                var c = [];
                for (s in h) h.hasOwnProperty(s) && c.push(["datetime" === i ? new Date(g(s)) : s].concat(h[s]));
                return "datetime" === i && c.sort(y), n.addRows(c), n
            }, _ = function (e) {
                t.attachEvent ? t.attachEvent("onresize", e) : t.addEventListener && t.addEventListener("resize", e, !0), e()
            };
            this.renderLineChart = function (t) {
                r(function () {
                    var i = m(t.data, t.options), n = v(t.data, t.options.discrete ? "string" : "datetime");
                    t.chart = new e.visualization.LineChart(t.element), _(function () {
                        t.chart.draw(n, i)
                    })
                })
            }, this.renderPieChart = function (t) {
                r(function () {
                    var i = {chartArea: {top: "10%", height: "80%"}};
                    t.options.colors && (i.colors = t.options.colors);
                    var n = o(o(a, i), t.options.library || {}), s = new e.visualization.DataTable;
                    s.addColumn("string", ""), s.addColumn("number", "Value"), s.addRows(t.data), t.chart = new e.visualization.PieChart(t.element), _(function () {
                        t.chart.draw(s, n)
                    })
                })
            }, this.renderColumnChart = function (t) {
                r(function () {
                    var i = m(t.data, t.options), n = v(t.data, "string");
                    t.chart = new e.visualization.ColumnChart(t.element), _(function () {
                        t.chart.draw(n, i)
                    })
                })
            }, this.renderBarChart = function (t) {
                r(function () {
                    var i = {hAxis: {gridlines: {color: "#ccc"}}}, n = l(a, h, u, p, f)(t.data, t.options, i),
                        s = v(t.data, "string");
                    t.chart = new e.visualization.BarChart(t.element), _(function () {
                        t.chart.draw(s, n)
                    })
                })
            }, this.renderAreaChart = function (t) {
                r(function () {
                    var i = {isStacked: !0, pointSize: 0, areaOpacity: .5}, n = m(t.data, t.options, i),
                        s = v(t.data, t.options.discrete ? "string" : "datetime");
                    t.chart = new e.visualization.AreaChart(t.element), _(function () {
                        t.chart.draw(s, n)
                    })
                })
            }, this.renderGeoChart = function (t) {
                r(function () {
                    var i = {legend: "none", colorAxis: {colors: t.options.colors || ["#f6c7b6", "#ce502d"]}},
                        n = o(o(a, i), t.options.library || {}), s = new e.visualization.DataTable;
                    s.addColumn("string", ""), s.addColumn("number", "Value"), s.addRows(t.data), t.chart = new e.visualization.GeoChart(t.element), _(function () {
                        t.chart.draw(s, n)
                    })
                })
            }, this.renderTimeline = function (t) {
                r("timeline", function () {
                    var i = {legend: "none"};
                    t.options.colors && (i.colorAxis.colors = t.options.colors);
                    var n = o(o(a, i), t.options.library || {}), s = new e.visualization.DataTable;
                    s.addColumn({type: "string", id: "Name"}), s.addColumn({
                        type: "date",
                        id: "Start"
                    }), s.addColumn({
                        type: "date",
                        id: "End"
                    }), s.addRows(t.data), t.chart = new e.visualization.Timeline(t.element), _(function () {
                        t.chart.draw(s, n)
                    })
                })
            }
        };
        j.push(z)
    }
    D = {
        LineChart: function (t, e, i) {
            M(this, t, e, i, k)
        }, PieChart: function (t, e, i) {
            M(this, t, e, i, S)
        }, ColumnChart: function (t, e, i) {
            M(this, t, e, i, C)
        }, BarChart: function (t, e, i) {
            M(this, t, e, i, T)
        }, AreaChart: function (t, e, i) {
            M(this, t, e, i, A)
        }, GeoChart: function (t, e, i) {
            M(this, t, e, i, E)
        }, Timeline: function (t, e, i) {
            M(this, t, e, i, L)
        }, charts: {}
    }, t.Chartkick = D
}(window);
var deviceIsAndroid = navigator.userAgent.indexOf("Android") > 0,
    deviceIsIOS = /iP(ad|hone|od)/.test(navigator.userAgent),
    deviceIsIOS4 = deviceIsIOS && /OS 4_\d(_\d)?/.test(navigator.userAgent),
    deviceIsIOSWithBadTarget = deviceIsIOS && /OS ([6-9]|\d{2})_\d/.test(navigator.userAgent),
    deviceIsBlackBerry10 = navigator.userAgent.indexOf("BB10") > 0;
FastClick.prototype.needsClick = function (t) {
    "use strict";
    switch (t.nodeName.toLowerCase()) {
        case"button":
        case"select":
        case"textarea":
            if (t.disabled) return !0;
            break;
        case"input":
            if (deviceIsIOS && "file" === t.type || t.disabled) return !0;
            break;
        case"label":
        case"video":
            return !0
    }
    return /\bneedsclick\b/.test(t.className)
}, FastClick.prototype.needsFocus = function (t) {
    "use strict";
    switch (t.nodeName.toLowerCase()) {
        case"textarea":
            return !0;
        case"select":
            return !deviceIsAndroid;
        case"input":
            switch (t.type) {
                case"button":
                case"checkbox":
                case"file":
                case"image":
                case"radio":
                case"submit":
                    return !1
            }
            return !t.disabled && !t.readOnly;
        default:
            return /\bneedsfocus\b/.test(t.className)
    }
}, FastClick.prototype.sendClick = function (t, e) {
    "use strict";
    var i, n;
    document.activeElement && document.activeElement !== t && document.activeElement.blur(), n = e.changedTouches[0], i = document.createEvent("MouseEvents"), i.initMouseEvent(this.determineEventType(t), !0, !0, window, 1, n.screenX, n.screenY, n.clientX, n.clientY, !1, !1, !1, !1, 0, null), i.forwardedTouchEvent = !0, t.dispatchEvent(i)
}, FastClick.prototype.determineEventType = function (t) {
    "use strict";
    return deviceIsAndroid && "select" === t.tagName.toLowerCase() ? "mousedown" : "click"
}, FastClick.prototype.focus = function (t) {
    "use strict";
    var e;
    deviceIsIOS && t.setSelectionRange && 0 !== t.type.indexOf("date") && "time" !== t.type ? (e = t.value.length, t.setSelectionRange(e, e)) : t.focus()
}, FastClick.prototype.updateScrollParent = function (t) {
    "use strict";
    var e, i;
    if (!(e = t.fastClickScrollParent) || !e.contains(t)) {
        i = t;
        do {
            if (i.scrollHeight > i.offsetHeight) {
                e = i, t.fastClickScrollParent = i;
                break
            }
            i = i.parentElement
        } while (i)
    }
    e && (e.fastClickLastScrollTop = e.scrollTop)
}, FastClick.prototype.getTargetElementFromEventTarget = function (t) {
    "use strict";
    return t.nodeType === Node.TEXT_NODE ? t.parentNode : t
}, FastClick.prototype.onTouchStart = function (t) {
    "use strict";
    var e, i, n;
    if (t.targetTouches.length > 1) return !0;
    if (e = this.getTargetElementFromEventTarget(t.target), i = t.targetTouches[0], deviceIsIOS) {
        if (n = window.getSelection(), n.rangeCount && !n.isCollapsed) return !0;
        if (!deviceIsIOS4) {
            if (i.identifier && i.identifier === this.lastTouchIdentifier) return t.preventDefault(), !1;
            this.lastTouchIdentifier = i.identifier, this.updateScrollParent(e)
        }
    }
    return this.trackingClick = !0, this.trackingClickStart = t.timeStamp, this.targetElement = e, this.touchStartX = i.pageX, this.touchStartY = i.pageY, t.timeStamp - this.lastClickTime < this.tapDelay && t.preventDefault(), !0
}, FastClick.prototype.touchHasMoved = function (t) {
    "use strict";
    var e = t.changedTouches[0], i = this.touchBoundary;
    return Math.abs(e.pageX - this.touchStartX) > i || Math.abs(e.pageY - this.touchStartY) > i
}, FastClick.prototype.onTouchMove = function (t) {
    "use strict";
    return !this.trackingClick || ((this.targetElement !== this.getTargetElementFromEventTarget(t.target) || this.touchHasMoved(t)) && (this.trackingClick = !1, this.targetElement = null), !0)
}, FastClick.prototype.findControl = function (t) {
    "use strict";
    return void 0 !== t.control ? t.control : t.htmlFor ? document.getElementById(t.htmlFor) : t.querySelector("button, input:not([type=hidden]), keygen, meter, output, progress, select, textarea")
}, FastClick.prototype.onTouchEnd = function (t) {
    "use strict";
    var e, i, n, s, o, r = this.targetElement;
    if (!this.trackingClick) return !0;
    if (t.timeStamp - this.lastClickTime < this.tapDelay) return this.cancelNextClick = !0, !0;
    if (this.cancelNextClick = !1, this.lastClickTime = t.timeStamp, i = this.trackingClickStart, this.trackingClick = !1, this.trackingClickStart = 0, deviceIsIOSWithBadTarget && (o = t.changedTouches[0], r = document.elementFromPoint(o.pageX - window.pageXOffset, o.pageY - window.pageYOffset) || r, r.fastClickScrollParent = this.targetElement.fastClickScrollParent), "label" === (n = r.tagName.toLowerCase())) {
        if (e = this.findControl(r)) {
            if (this.focus(r), deviceIsAndroid) return !1;
            r = e
        }
    } else if (this.needsFocus(r)) return t.timeStamp - i > 100 || deviceIsIOS && window.top !== window && "input" === n ? (this.targetElement = null, !1) : (this.focus(r), this.sendClick(r, t), deviceIsIOS && "select" === n || (this.targetElement = null, t.preventDefault()), !1);
    return !(!deviceIsIOS || deviceIsIOS4 || !(s = r.fastClickScrollParent) || s.fastClickLastScrollTop === s.scrollTop) || (this.needsClick(r) || (t.preventDefault(), this.sendClick(r, t)), !1)
}, FastClick.prototype.onTouchCancel = function () {
    "use strict";
    this.trackingClick = !1, this.targetElement = null
}, FastClick.prototype.onMouse = function (t) {
    "use strict";
    return !this.targetElement || (!!t.forwardedTouchEvent || (!(t.cancelable && (!this.needsClick(this.targetElement) || this.cancelNextClick)) || (t.stopImmediatePropagation ? t.stopImmediatePropagation() : t.propagationStopped = !0, t.stopPropagation(), t.preventDefault(), !1)))
}, FastClick.prototype.onClick = function (t) {
    "use strict";
    var e;
    return this.trackingClick ? (this.targetElement = null, this.trackingClick = !1, !0) : "submit" === t.target.type && 0 === t.detail || (e = this.onMouse(t), e || (this.targetElement = null), e)
}, FastClick.prototype.destroy = function () {
    "use strict";
    var t = this.layer;
    deviceIsAndroid && (t.removeEventListener("mouseover", this.onMouse, !0), t.removeEventListener("mousedown", this.onMouse, !0), t.removeEventListener("mouseup", this.onMouse, !0)), t.removeEventListener("click", this.onClick, !0), t.removeEventListener("touchstart", this.onTouchStart, !1), t.removeEventListener("touchmove", this.onTouchMove, !1), t.removeEventListener("touchend", this.onTouchEnd, !1), t.removeEventListener("touchcancel", this.onTouchCancel, !1)
}, FastClick.notNeeded = function (t) {
    "use strict";
    var e, i, n;
    if ("undefined" == typeof window.ontouchstart) return !0;
    if (i = +(/Chrome\/([0-9]+)/.exec(navigator.userAgent) || [, 0])[1]) {
        if (!deviceIsAndroid) return !0;
        if (e = document.querySelector("meta[name=viewport]")) {
            if (-1 !== e.content.indexOf("user-scalable=no")) return !0;
            if (i > 31 && document.documentElement.scrollWidth <= window.outerWidth) return !0
        }
    }
    if (deviceIsBlackBerry10 && (n = navigator.userAgent.match(/Version\/([0-9]*)\.([0-9]*)/), n[1] >= 10 && n[2] >= 3 && (e = document.querySelector("meta[name=viewport]")))) {
        if (-1 !== e.content.indexOf("user-scalable=no")) return !0;
        if (document.documentElement.scrollWidth <= window.outerWidth) return !0
    }
    return "none" === t.style.msTouchAction
}, FastClick.attach = function (t, e) {
    "use strict";
    return new FastClick(t, e)
}, "function" == typeof define && "object" == typeof define.amd && define.amd ? define(function () {
    "use strict";
    return FastClick
}) : "undefined" != typeof module && module.exports ? (module.exports = FastClick.attach, module.exports.FastClick = FastClick) : window.FastClick = FastClick, function () {
    var t, e, i, n, s, o, r, a, l, h, c, d, u, p, f, g, m, v, y, _, b, x, w, k, C, S, T, A, E, L, M, D, P, F, I, j, O,
        z, H, N, R, W, B, $, q, X, G, Y, V, U, Z, Q, K, J, tt, et, it = [].indexOf || function (t) {
            for (var e = 0, i = this.length; e < i; e++) if (e in this && this[e] === t) return e;
            return -1
        }, nt = function (t, e) {
            function i() {
                this.constructor = t
            }

            for (var n in e) st.call(e, n) && (t[n] = e[n]);
            return i.prototype = e.prototype, t.prototype = new i, t.__super__ = e.prototype, t
        }, st = {}.hasOwnProperty, ot = [].slice, rt = function (t, e) {
            return function () {
                return t.apply(e, arguments)
            }
        };
    F = {}, u = 10, Q = !1, H = null, y = null, D = null, W = null, et = null, n = {
        BEFORE_CHANGE: "page:before-change",
        FETCH: "page:fetch",
        RECEIVE: "page:receive",
        CHANGE: "page:change",
        UPDATE: "page:update",
        LOAD: "page:load",
        RESTORE: "page:restore",
        BEFORE_UNLOAD: "page:before-unload",
        EXPIRE: "page:expire"
    }, k = function (t) {
        var e;
        return t = new i(t), G(), d(), null != H && H.start(), Q && (e = K(t.absolute)) ? (C(e), S(t, null, !1)) : S(t, U)
    }, K = function (t) {
        var e;
        if ((e = F[t]) && !e.transitionCacheDisabled) return e
    }, b = function (t) {
        return null == t && (t = !0), Q = t
    }, _ = function (t) {
        if (null == t && (t = !0), h) return t ? null != H ? H : H = new o("html") : (null != H && H.uninstall(), H = null)
    }, S = function (t, e, i) {
        return null == i && (i = !0), J(n.FETCH, {url: t.absolute}), null != et && et.abort(), et = new XMLHttpRequest, et.open("GET", t.withoutHashForIE10compatibility(), !0), et.setRequestHeader("Accept", "text/html, application/xhtml+xml, application/xml"), et.setRequestHeader("X-XHR-Referer", W), et.onload = function () {
            var i;
            return J(n.RECEIVE, {url: t.absolute}), (i = z()) ? (B(t), $(), p.apply(null, w(i)), P(), "function" == typeof e && e(), J(n.LOAD)) : document.location.href = v() || t.absolute
        }, H && i && (et.onprogress = function () {
            return function (t) {
                var e;
                return e = t.lengthComputable ? t.loaded / t.total * 100 : H.value + (100 - H.value) / 10, H.advanceTo(e)
            }
        }()), et.onloadend = function () {
            return et = null
        }, et.onerror = function () {
            return document.location.href = t.absolute
        }, et.send()
    }, C = function (t) {
        return null != et && et.abort(), p(t.title, t.body), N(t), J(n.RESTORE)
    }, d = function () {
        var t;
        return t = new i(y.url), F[t.absolute] = {
            url: t.relative,
            body: document.body,
            title: document.title,
            positionY: window.pageYOffset,
            positionX: window.pageXOffset,
            cachedAt: (new Date).getTime(),
            transitionCacheDisabled: null != document.querySelector("[data-no-transition-cache]")
        }, g(u)
    }, j = function (t) {
        if (null == t && (t = u), /^[\d]+$/.test(t)) return u = parseInt(t)
    }, g = function (t) {
        var e, i, s, o, r, a;
        for (r = Object.keys(F), e = r.map(function (t) {
            return F[t].cachedAt
        }).sort(function (t, e) {
            return e - t
        }), a = [], i = 0, o = r.length; i < o; i++) s = r[i], F[s].cachedAt <= e[t] && (J(n.EXPIRE, F[s]), a.push(delete F[s]));
        return a
    }, p = function (e, i, s, o) {
        return J(n.BEFORE_UNLOAD), document.title = e, document.documentElement.replaceChild(i, document.body), null != s && t.update(s), Z(), o && x(), y = window.history.state, null != H && H.done(), J(n.CHANGE), J(n.UPDATE)
    }, x = function () {
        var t, e, i, n, s, o, r, a, l, h, c, d;
        for (d = Array.prototype.slice.call(document.body.querySelectorAll('script:not([data-turbolinks-eval="false"])')), i = 0, s = d.length; i < s; i++) if (c = d[i], "" === (l = c.type) || "text/javascript" === l) {
            for (e = document.createElement("script"), h = c.attributes, n = 0, o = h.length; n < o; n++) t = h[n], e.setAttribute(t.name, t.value);
            c.hasAttribute("async") || (e.async = !1), e.appendChild(document.createTextNode(c.innerHTML)), a = c.parentNode, r = c.nextSibling, a.removeChild(c), a.insertBefore(e, r)
        }
    }, Y = function (t) {
        return t.innerHTML = t.innerHTML.replace(/<noscript[\S\s]*?<\/noscript>/gi, ""), t
    }, Z = function () {
        var t, e;
        if ((t = (e = document.querySelectorAll("input[autofocus], textarea[autofocus]"))[e.length - 1]) && document.activeElement !== t) return t.focus()
    }, B = function (t) {
        if ((t = new i(t)).absolute !== W) return window.history.pushState({
            turbolinks: !0,
            url: t.absolute
        }, "", t.absolute)
    }, $ = function () {
        var t, e;
        if (t = et.getResponseHeader("X-XHR-Redirected-To")) return t = new i(t), e = t.hasNoHash() ? document.location.hash : "", window.history.replaceState(window.history.state, "", t.href + e)
    }, v = function () {
        var t;
        if (null != (t = et.getResponseHeader("Location")) && new i(t).crossOrigin()) return t
    }, G = function () {
        return W = document.location.href
    }, X = function () {
        return window.history.replaceState({turbolinks: !0, url: document.location.href}, "", document.location.href)
    }, q = function () {
        return y = window.history.state
    }, P = function () {
        var t;
        if (navigator.userAgent.match(/Firefox/) && !(t = new i).hasNoHash()) return window.history.replaceState(y, "", t.withoutHash()), document.location.hash = t.hash
    }, N = function (t) {
        return window.scrollTo(t.positionX, t.positionY)
    }, U = function () {
        return document.location.hash ? document.location.href = document.location.href : window.scrollTo(0, 0)
    }, f = function (t) {
        var e, i, n;
        if (null == t || "object" != typeof t) return t;
        e = new t.constructor;
        for (i in t) n = t[i], e[i] = f(n);
        return e
    }, O = function (t) {
        var e, i;
        return i = (null != (e = document.cookie.match(new RegExp(t + "=(\\w+)"))) ? e[1].toUpperCase() : void 0) || "", document.cookie = t + "=; expires=Thu, 01-Jan-70 00:00:01 GMT; path=/", i
    }, J = function (t, e) {
        var i;
        return "undefined" != typeof Prototype && Event.fire(document, t, e, !0), i = document.createEvent("Events"), e && (i.data = e), i.initEvent(t, !0, !0), document.dispatchEvent(i)
    }, I = function (t) {
        return !J(n.BEFORE_CHANGE, {url: t})
    }, z = function () {
        var t, e, i, n, s, o;
        if (e = function () {
            var t;
            return 400 <= (t = et.status) && t < 600
        }, o = function () {
            var t;
            return null != (t = et.getResponseHeader("Content-Type")) && t.match(/^(?:text\/html|application\/xhtml\+xml|application\/xml)(?:;|$)/)
        }, n = function (t) {
            var e, i, n, s, o;
            for (s = t.querySelector("head").childNodes, o = [], e = 0, i = s.length; e < i; e++) n = s[e], null != ("function" == typeof n.getAttribute ? n.getAttribute("data-turbolinks-track") : void 0) && o.push(n.getAttribute("src") || n.getAttribute("href"));
            return o
        }, t = function (t) {
            var e;
            return D || (D = n(document)), e = n(t), e.length !== D.length || s(e, D).length !== D.length
        }, s = function (t, e) {
            var i, n, s, o, r;
            for (t.length > e.length && (s = [e, t], t = s[0], e = s[1]), o = [], i = 0, n = t.length; i < n; i++) r = t[i], it.call(e, r) >= 0 && o.push(r);
            return o
        }, !e() && o() && (i = m(et.responseText)) && !t(i)) return i
    }, w = function (e) {
        var i;
        return i = e.querySelector("title"), [null != i ? i.textContent : void 0, Y(e.querySelector("body")), t.get(e).token, "runScripts"]
    }, t = {
        get: function (t) {
            var e;
            return null == t && (t = document), {
                node: e = t.querySelector('meta[name="csrf-token"]'),
                token: null != e && "function" == typeof e.getAttribute ? e.getAttribute("content") : void 0
            }
        }, update: function (t) {
            var e;
            if (e = this.get(), null != e.token && null != t && e.token !== t) return e.node.setAttribute("content", t)
        }
    }, m = function (t) {
        var e;
        return e = document.documentElement.cloneNode(), e.innerHTML = t, e.head = e.querySelector("head"), e.body = e.querySelector("body"), e
    }, i = function () {
        function t(e) {
            if (this.original = null != e ? e : document.location.href, this.original.constructor === t) return this.original;
            this._parse()
        }

        return t.prototype.withoutHash = function () {
            return this.href.replace(this.hash, "").replace("#", "")
        }, t.prototype.withoutHashForIE10compatibility = function () {
            return this.withoutHash()
        }, t.prototype.hasNoHash = function () {
            return 0 === this.hash.length
        }, t.prototype.crossOrigin = function () {
            return this.origin !== (new t).origin
        }, t.prototype._parse = function () {
            var t;
            return (null != this.link ? this.link : this.link = document.createElement("a")).href = this.original, t = this.link, this.href = t.href, this.protocol = t.protocol, this.host = t.host, this.hostname = t.hostname, this.port = t.port, this.pathname = t.pathname, this.search = t.search, this.hash = t.hash, this.origin = [this.protocol, "//", this.hostname].join(""), 0 !== this.port.length && (this.origin += ":" + this.port), this.relative = [this.pathname, this.search, this.hash].join(""), this.absolute = this.href
        }, t
    }(), s = function (t) {
        function e(t) {
            if (this.link = t, this.link.constructor === e) return this.link;
            this.original = this.link.href, this.originalElement = this.link, this.link = this.link.cloneNode(!1), e.__super__.constructor.apply(this, arguments)
        }

        return nt(e, t), e.HTML_EXTENSIONS = ["html"], e.allowExtensions = function () {
            var t, i, n, s;
            for (i = 1 <= arguments.length ? ot.call(arguments, 0) : [], n = 0, s = i.length; n < s; n++) t = i[n], e.HTML_EXTENSIONS.push(t);
            return e.HTML_EXTENSIONS
        }, e.prototype.shouldIgnore = function () {
            return this.crossOrigin() || this._anchored() || this._nonHtml() || this._optOut() || this._target()
        }, e.prototype._anchored = function () {
            return (this.hash.length > 0 || "#" === this.href.charAt(this.href.length - 1)) && this.withoutHash() === (new i).withoutHash()
        }, e.prototype._nonHtml = function () {
            return this.pathname.match(/\.[a-z]+$/g) && !this.pathname.match(new RegExp("\\.(?:" + e.HTML_EXTENSIONS.join("|") + ")?$", "g"))
        }, e.prototype._optOut = function () {
            var t, e;
            for (e = this.originalElement; !t && e !== document;) t = null != e.getAttribute("data-no-turbolink"), e = e.parentNode;
            return t
        }, e.prototype._target = function () {
            return 0 !== this.link.target.length
        }, e
    }(i), e = function () {
        function t(t) {
            this.event = t, this.event.defaultPrevented || (this._extractLink(), this._validForTurbolinks() && (I(this.link.absolute) || tt(this.link.href), this.event.preventDefault()))
        }

        return t.installHandlerLast = function (e) {
            if (!e.defaultPrevented) return document.removeEventListener("click", t.handle, !1), document.addEventListener("click", t.handle, !1)
        }, t.handle = function (e) {
            return new t(e)
        }, t.prototype._extractLink = function () {
            var t;
            for (t = this.event.target; t.parentNode && "A" !== t.nodeName;) t = t.parentNode;
            if ("A" === t.nodeName && 0 !== t.href.length) return this.link = new s(t)
        }, t.prototype._validForTurbolinks = function () {
            return null != this.link && !(this.link.shouldIgnore() || this._nonStandardClick())
        }, t.prototype._nonStandardClick = function () {
            return this.event.which > 1 || this.event.metaKey || this.event.ctrlKey || this.event.shiftKey || this.event.altKey
        }, t
    }(), o = function () {
        function t(t) {
            this.elementSelector = t, this._trickle = rt(this._trickle, this), this.value = 0, this.content = "", this.speed = 300, this.opacity = .99, this.install()
        }

        var e;
        return e = "turbolinks-progress-bar", t.prototype.install = function () {
            return this.element = document.querySelector(this.elementSelector), this.element.classList.add(e), this.styleElement = document.createElement("style"), document.head.appendChild(this.styleElement), this._updateStyle()
        }, t.prototype.uninstall = function () {
            return this.element.classList.remove(e), document.head.removeChild(this.styleElement)
        }, t.prototype.start = function () {
            return this.advanceTo(5)
        }, t.prototype.advanceTo = function (t) {
            var e;
            if (t > (e = this.value) && e <= 100) {
                if (this.value = t, this._updateStyle(), 100 === this.value) return this._stopTrickle();
                if (this.value > 0) return this._startTrickle()
            }
        }, t.prototype.done = function () {
            if (this.value > 0) return this.advanceTo(100), this._reset()
        }, t.prototype._reset = function () {
            var t;
            return t = this.opacity, setTimeout(function (t) {
                return function () {
                    return t.opacity = 0, t._updateStyle()
                }
            }(this), this.speed / 2), setTimeout(function (e) {
                return function () {
                    return e.value = 0, e.opacity = t, e._withSpeed(0, function () {
                        return e._updateStyle(!0)
                    })
                }
            }(this), this.speed)
        }, t.prototype._startTrickle = function () {
            if (!this.trickling) return this.trickling = !0, setTimeout(this._trickle, this.speed)
        }, t.prototype._stopTrickle = function () {
            return delete this.trickling
        }, t.prototype._trickle = function () {
            if (this.trickling) return this.advanceTo(this.value + Math.random() / 2), setTimeout(this._trickle, this.speed)
        }, t.prototype._withSpeed = function (t, e) {
            var i, n;
            return i = this.speed, this.speed = t, n = e(), this.speed = i, n
        }, t.prototype._updateStyle = function (t) {
            return null == t && (t = !1), t && this._changeContentToForceRepaint(), this.styleElement.textContent = this._createCSSRule()
        }, t.prototype._changeContentToForceRepaint = function () {
            return this.content = "" === this.content ? " " : ""
        }, t.prototype._createCSSRule = function () {
            return this.elementSelector + "." + e + "::before {\n  content: '" + this.content + "';\n  position: fixed;\n  top: 0;\n  left: 0;\n  z-index: 2000;\n  background-color: #0076ff;\n  height: 3px;\n  opacity: " + this.opacity + ";\n  width: " + this.value + "%;\n  transition: width " + this.speed + "ms ease-out, opacity " + this.speed / 2 + "ms ease-in;\n  transform: translate3d(0,0,0);\n}"
        }, t
    }(), c = function (t) {
        return setTimeout(t, 500)
    }, E = function () {
        return document.addEventListener("DOMContentLoaded", function () {
            return J(n.CHANGE), J(n.UPDATE)
        }, !0)
    }, M = function () {
        if ("undefined" != typeof jQuery) return jQuery(document).on("ajaxSuccess", function (t, e) {
            if (jQuery.trim(e.responseText)) return J(n.UPDATE)
        })
    }, L = function (t) {
        var e, n;
        if (null != (n = t.state) ? n.turbolinks : void 0) return (e = F[new i(t.state.url).absolute]) ? (d(), C(e)) : tt(t.target.location.href)
    }, A = function () {
        return X(), q(), document.addEventListener("click", e.installHandlerLast, !0), window.addEventListener("hashchange", function () {
            return X(), q()
        }, !1), c(function () {
            return window.addEventListener("popstate", L, !1)
        })
    }, T = void 0 !== window.history.state || navigator.userAgent.match(/Firefox\/2[6|7]/), l = window.history && window.history.pushState && window.history.replaceState && T, r = !navigator.userAgent.match(/CriOS\//), V = "GET" === (R = O("request_method")) || "" === R, h = l && r && V, a = document.addEventListener && document.createEvent, a && (E(), M()), h ? (tt = k, A()) : tt = function (t) {
        return document.location.href = t
    }, this.Turbolinks = {
        visit: tt,
        pagesCached: j,
        enableTransitionCache: b,
        enableProgressBar: _,
        allowLinkExtensions: s.allowExtensions,
        supported: h,
        EVENTS: f(n)
    }
}.call(this), window.Modernizr = function (t, e, i) {
    function n(t) {
        _.cssText = t
    }

    function s(t, e) {
        return n(k.join(t + ";") + (e || ""))
    }

    function o(t, e) {
        return typeof t === e
    }

    function r(t, e) {
        return !!~("" + t).indexOf(e)
    }

    function a(t, e) {
        for (var n in t) {
            var s = t[n];
            if (!r(s, "-") && _[s] !== i) return "pfx" != e || s
        }
        return !1
    }

    function l(t, e, n) {
        for (var s in t) {
            var r = e[t[s]];
            if (r !== i) return !1 === n ? t[s] : o(r, "function") ? r.bind(n || e) : r
        }
        return !1
    }

    function h(t, e, i) {
        var n = t.charAt(0).toUpperCase() + t.slice(1), s = (t + " " + S.join(n + " ") + n).split(" ");
        return o(e, "string") || o(e, "undefined") ? a(s, e) : (s = (t + " " + T.join(n + " ") + n).split(" "), l(s, e, i))
    }

    function c() {
        f.input = function (i) {
            for (var n = 0, s = i.length; s > n; n++) M[i[n]] = !!(i[n] in b);
            return M.list && (M.list = !(!e.createElement("datalist") || !t.HTMLDataListElement)), M
        }("autocomplete autofocus list placeholder max min multiple pattern required step".split(" ")), f.inputtypes = function (t) {
            for (var n, s, o, r = 0, a = t.length; a > r; r++) b.setAttribute("type", s = t[r]), n = "text" !== b.type, n && (b.value = x, b.style.cssText = "position:absolute;visibility:hidden;", /^range$/.test(s) && b.style.WebkitAppearance !== i ? (m.appendChild(b), o = e.defaultView, n = o.getComputedStyle && "textfield" !== o.getComputedStyle(b, null).WebkitAppearance && 0 !== b.offsetHeight, m.removeChild(b)) : /^(search|tel)$/.test(s) || (n = /^(url|email)$/.test(s) ? b.checkValidity && !1 === b.checkValidity() : b.value != x)), L[t[r]] = !!n;
            return L
        }("search tel url email datetime date month week time datetime-local number range color".split(" "))
    }

    var d, u, p = "2.8.3", f = {}, g = !0, m = e.documentElement, v = "modernizr", y = e.createElement(v), _ = y.style,
        b = e.createElement("input"), x = ":)", w = {}.toString, k = " -webkit- -moz- -o- -ms- ".split(" "),
        C = "Webkit Moz O ms", S = C.split(" "), T = C.toLowerCase().split(" "),
        A = {svg: "http://www.w3.org/2000/svg"}, E = {}, L = {}, M = {}, D = [], P = D.slice,
        F = function (t, i, n, s) {
            var o, r, a, l, h = e.createElement("div"), c = e.body, d = c || e.createElement("body");
            if (parseInt(n, 10)) for (; n--;) a = e.createElement("div"), a.id = s ? s[n] : v + (n + 1), h.appendChild(a);
            return o = ["&#173;", '<style id="s', v, '">', t, "</style>"].join(""), h.id = v, (c ? h : d).innerHTML += o, d.appendChild(h), c || (d.style.background = "", d.style.overflow = "hidden", l = m.style.overflow, m.style.overflow = "hidden", m.appendChild(d)), r = i(h, t), c ? h.parentNode.removeChild(h) : (d.parentNode.removeChild(d), m.style.overflow = l), !!r
        }, I = function (e) {
            var i = t.matchMedia || t.msMatchMedia;
            if (i) return i(e) && i(e).matches || !1;
            var n;
            return F("@media " + e + " { #" + v + " { position: absolute; } }", function (e) {
                n = "absolute" == (t.getComputedStyle ? getComputedStyle(e, null) : e.currentStyle).position
            }), n
        }, j = function () {
            function t(t, s) {
                s = s || e.createElement(n[t] || "div"), t = "on" + t;
                var r = t in s;
                return r || (s.setAttribute || (s = e.createElement("div")), s.setAttribute && s.removeAttribute && (s.setAttribute(t, ""), r = o(s[t], "function"), o(s[t], "undefined") || (s[t] = i), s.removeAttribute(t))), s = null, r
            }

            var n = {
                select: "input",
                change: "input",
                submit: "form",
                reset: "form",
                error: "img",
                load: "img",
                abort: "img"
            };
            return t
        }(), O = {}.hasOwnProperty;
    u = o(O, "undefined") || o(O.call, "undefined") ? function (t, e) {
        return e in t && o(t.constructor.prototype[e], "undefined")
    } : function (t, e) {
        return O.call(t, e)
    }, Function.prototype.bind || (Function.prototype.bind = function (t) {
        var e = this;
        if ("function" != typeof e) throw new TypeError;
        var i = P.call(arguments, 1), n = function () {
            if (this instanceof n) {
                var s = function () {
                };
                s.prototype = e.prototype;
                var o = new s, r = e.apply(o, i.concat(P.call(arguments)));
                return Object(r) === r ? r : o
            }
            return e.apply(t, i.concat(P.call(arguments)))
        };
        return n
    }), E.flexbox = function () {
        return h("flexWrap")
    }, E.flexboxlegacy = function () {
        return h("boxDirection")
    }, E.canvas = function () {
        var t = e.createElement("canvas");
        return !(!t.getContext || !t.getContext("2d"))
    }, E.canvastext = function () {
        return !(!f.canvas || !o(e.createElement("canvas").getContext("2d").fillText, "function"))
    }, E.webgl = function () {
        return !!t.WebGLRenderingContext
    }, E.touch = function () {
        var i;
        return "ontouchstart" in t || t.DocumentTouch && e instanceof DocumentTouch ? i = !0 : F(["@media (", k.join("touch-enabled),("), v, ")", "{#modernizr{top:9px;position:absolute}}"].join(""), function (t) {
            i = 9 === t.offsetTop
        }), i
    }, E.geolocation = function () {
        return "geolocation" in navigator
    }, E.postmessage = function () {
        return !!t.postMessage
    }, E.websqldatabase = function () {
        return !!t.openDatabase
    }, E.indexedDB = function () {
        return !!h("indexedDB", t)
    }, E.hashchange = function () {
        return j("hashchange", t) && (e.documentMode === i || e.documentMode > 7)
    }, E.history = function () {
        return !(!t.history || !history.pushState)
    }, E.draganddrop = function () {
        var t = e.createElement("div");
        return "draggable" in t || "ondragstart" in t && "ondrop" in t
    }, E.websockets = function () {
        return "WebSocket" in t || "MozWebSocket" in t
    },
        E.rgba = function () {
            return n("background-color:rgba(150,255,150,.5)"), r(_.backgroundColor, "rgba")
        }, E.hsla = function () {
        return n("background-color:hsla(120,40%,100%,.5)"), r(_.backgroundColor, "rgba") || r(_.backgroundColor, "hsla")
    }, E.multiplebgs = function () {
        return n("background:url(https://),url(https://),red url(https://)"), /(url\s*\(.*?){3}/.test(_.background)
    }, E.backgroundsize = function () {
        return h("backgroundSize")
    }, E.borderimage = function () {
        return h("borderImage")
    }, E.borderradius = function () {
        return h("borderRadius")
    }, E.boxshadow = function () {
        return h("boxShadow")
    }, E.textshadow = function () {
        return "" === e.createElement("div").style.textShadow
    }, E.opacity = function () {
        return s("opacity:.55"), /^0.55$/.test(_.opacity)
    }, E.cssanimations = function () {
        return h("animationName")
    }, E.csscolumns = function () {
        return h("columnCount")
    }, E.cssgradients = function () {
        var t = "background-image:";
        return n((t + "-webkit- ".split(" ").join("gradient(linear,left top,right bottom,from(#9f9),to(white));" + t) + k.join("linear-gradient(left top,#9f9, white);" + t)).slice(0, -t.length)), r(_.backgroundImage, "gradient")
    }, E.cssreflections = function () {
        return h("boxReflect")
    }, E.csstransforms = function () {
        return !!h("transform")
    }, E.csstransforms3d = function () {
        var t = !!h("perspective");
        return t && "webkitPerspective" in m.style && F("@media (transform-3d),(-webkit-transform-3d){#modernizr{left:9px;position:absolute;height:3px;}}", function (e) {
            t = 9 === e.offsetLeft && 3 === e.offsetHeight
        }), t
    }, E.csstransitions = function () {
        return h("transition")
    }, E.fontface = function () {
        var t;
        return F('@font-face {font-family:"font";src:url("https://")}', function (i, n) {
            var s = e.getElementById("smodernizr"), o = s.sheet || s.styleSheet,
                r = o ? o.cssRules && o.cssRules[0] ? o.cssRules[0].cssText : o.cssText || "" : "";
            t = /src/i.test(r) && 0 === r.indexOf(n.split(" ")[0])
        }), t
    }, E.generatedcontent = function () {
        var t;
        return F(["#", v, "{font:0/0 a}#", v, ':after{content:"', x, '";visibility:hidden;font:3px/1 a}'].join(""), function (e) {
            t = e.offsetHeight >= 3
        }), t
    }, E.video = function () {
        var t = e.createElement("video"), i = !1;
        try {
            (i = !!t.canPlayType) && (i = new Boolean(i), i.ogg = t.canPlayType('video/ogg; codecs="theora"').replace(/^no$/, ""), i.h264 = t.canPlayType('video/mp4; codecs="avc1.42E01E"').replace(/^no$/, ""), i.webm = t.canPlayType('video/webm; codecs="vp8, vorbis"').replace(/^no$/, ""))
        } catch (t) {
        }
        return i
    }, E.audio = function () {
        var t = e.createElement("audio"), i = !1;
        try {
            (i = !!t.canPlayType) && (i = new Boolean(i), i.ogg = t.canPlayType('audio/ogg; codecs="vorbis"').replace(/^no$/, ""), i.mp3 = t.canPlayType("audio/mpeg;").replace(/^no$/, ""), i.wav = t.canPlayType('audio/wav; codecs="1"').replace(/^no$/, ""), i.m4a = (t.canPlayType("audio/x-m4a;") || t.canPlayType("audio/aac;")).replace(/^no$/, ""))
        } catch (t) {
        }
        return i
    }, E.localstorage = function () {
        try {
            return localStorage.setItem(v, v), localStorage.removeItem(v), !0
        } catch (t) {
            return !1
        }
    }, E.sessionstorage = function () {
        try {
            return sessionStorage.setItem(v, v), sessionStorage.removeItem(v), !0
        } catch (t) {
            return !1
        }
    }, E.webworkers = function () {
        return !!t.Worker
    }, E.applicationcache = function () {
        return !!t.applicationCache
    }, E.svg = function () {
        return !!e.createElementNS && !!e.createElementNS(A.svg, "svg").createSVGRect
    }, E.inlinesvg = function () {
        var t = e.createElement("div");
        return t.innerHTML = "<svg/>", (t.firstChild && t.firstChild.namespaceURI) == A.svg
    }, E.smil = function () {
        return !!e.createElementNS && /SVGAnimate/.test(w.call(e.createElementNS(A.svg, "animate")))
    }, E.svgclippaths = function () {
        return !!e.createElementNS && /SVGClipPath/.test(w.call(e.createElementNS(A.svg, "clipPath")))
    };
    for (var z in E) u(E, z) && (d = z.toLowerCase(), f[d] = E[z](), D.push((f[d] ? "" : "no-") + d));
    return f.input || c(), f.addTest = function (t, e) {
        if ("object" == typeof t) for (var n in t) u(t, n) && f.addTest(n, t[n]); else {
            if (t = t.toLowerCase(), f[t] !== i) return f;
            e = "function" == typeof e ? e() : e, void 0 !== g && g && (m.className += " " + (e ? "" : "no-") + t), f[t] = e
        }
        return f
    }, n(""), y = b = null, function (t, e) {
        function i(t, e) {
            var i = t.createElement("p"), n = t.getElementsByTagName("head")[0] || t.documentElement;
            return i.innerHTML = "x<style>" + e + "</style>", n.insertBefore(i.lastChild, n.firstChild)
        }

        function n() {
            var t = y.elements;
            return "string" == typeof t ? t.split(" ") : t
        }

        function s(t) {
            var e = v[t[g]];
            return e || (e = {}, m++, t[g] = m, v[m] = e), e
        }

        function o(t, i, n) {
            if (i || (i = e), c) return i.createElement(t);
            n || (n = s(i));
            var o;
            return o = n.cache[t] ? n.cache[t].cloneNode() : f.test(t) ? (n.cache[t] = n.createElem(t)).cloneNode() : n.createElem(t), !o.canHaveChildren || p.test(t) || o.tagUrn ? o : n.frag.appendChild(o)
        }

        function r(t, i) {
            if (t || (t = e), c) return t.createDocumentFragment();
            i = i || s(t);
            for (var o = i.frag.cloneNode(), r = 0, a = n(), l = a.length; l > r; r++) o.createElement(a[r]);
            return o
        }

        function a(t, e) {
            e.cache || (e.cache = {}, e.createElem = t.createElement, e.createFrag = t.createDocumentFragment, e.frag = e.createFrag()), t.createElement = function (i) {
                return y.shivMethods ? o(i, t, e) : e.createElem(i)
            }, t.createDocumentFragment = Function("h,f", "return function(){var n=f.cloneNode(),c=n.createElement;h.shivMethods&&(" + n().join().replace(/[\w\-]+/g, function (t) {
                return e.createElem(t), e.frag.createElement(t), 'c("' + t + '")'
            }) + ");return n}")(y, e.frag)
        }

        function l(t) {
            t || (t = e);
            var n = s(t);
            return !y.shivCSS || h || n.hasCSS || (n.hasCSS = !!i(t, "article,aside,dialog,figcaption,figure,footer,header,hgroup,main,nav,section{display:block}mark{background:#FF0;color:#000}template{display:none}")), c || a(t, n), t
        }

        var h, c, d = "3.7.0", u = t.html5 || {},
            p = /^<|^(?:button|map|select|textarea|object|iframe|option|optgroup)$/i,
            f = /^(?:a|b|code|div|fieldset|h1|h2|h3|h4|h5|h6|i|label|li|ol|p|q|span|strong|style|table|tbody|td|th|tr|ul)$/i,
            g = "_html5shiv", m = 0, v = {};
        !function () {
            try {
                var t = e.createElement("a");
                t.innerHTML = "<xyz></xyz>", h = "hidden" in t, c = 1 == t.childNodes.length || function () {
                    e.createElement("a");
                    var t = e.createDocumentFragment();
                    return "undefined" == typeof t.cloneNode || "undefined" == typeof t.createDocumentFragment || "undefined" == typeof t.createElement
                }()
            } catch (t) {
                h = !0, c = !0
            }
        }();
        var y = {
            elements: u.elements || "abbr article aside audio bdi canvas data datalist details dialog figcaption figure footer header hgroup main mark meter nav output progress section summary template time video",
            version: d,
            shivCSS: !1 !== u.shivCSS,
            supportsUnknownElements: c,
            shivMethods: !1 !== u.shivMethods,
            type: "default",
            shivDocument: l,
            createElement: o,
            createDocumentFragment: r
        };
        t.html5 = y, l(e)
    }(this, e), f._version = p, f._prefixes = k, f._domPrefixes = T, f._cssomPrefixes = S, f.mq = I, f.hasEvent = j, f.testProp = function (t) {
        return a([t])
    }, f.testAllProps = h, f.testStyles = F, f.prefixed = function (t, e, i) {
        return e ? h(t, e, i) : h(t, "pfx")
    }, m.className = m.className.replace(/(^|\s)no-js(\s|$)/, "$1$2") + (g ? " js " + D.join(" ") : ""), f
}(this, this.document), function (t, e, i, n) {
    "use strict";

    function s(t) {
        return ("string" == typeof t || t instanceof String) && (t = t.replace(/^['\\/"]+|(;\s?})+|['\\/"]+$/g, "")), t
    }

    (function (e) {
        for (var i = e.length, n = t("head"); i--;) 0 === n.has("." + e[i]).length && n.append('<meta class="' + e[i] + '" />')
    })(["foundation-mq-small", "foundation-mq-small-only", "foundation-mq-medium", "foundation-mq-medium-only", "foundation-mq-large", "foundation-mq-large-only", "foundation-mq-xlarge", "foundation-mq-xlarge-only", "foundation-mq-xxlarge", "foundation-data-attribute-namespace"]), t(function () {
        void 0 !== FastClick && "undefined" != typeof i.body && FastClick.attach(i.body)
    });
    var o = function (e, n) {
        if ("string" == typeof e) {
            if (n) {
                var s;
                if (n.jquery) {
                    if (!(s = n[0])) return n
                } else s = n;
                return t(s.querySelectorAll(e))
            }
            return t(i.querySelectorAll(e))
        }
        return t(e, n)
    }, r = function (t) {
        var e = [];
        return t || e.push("data"), this.namespace.length > 0 && e.push(this.namespace), e.push(this.name), e.join("-")
    }, a = function (t) {
        for (var e = t.split("-"), i = e.length, n = []; i--;) 0 !== i ? n.push(e[i]) : this.namespace.length > 0 ? n.push(this.namespace, e[i]) : n.push(e[i]);
        return n.reverse().join("-")
    }, l = function (e, i) {
        var n = this, s = !o(this).data(this.attr_name(!0));
        if (o(this.scope).is("[" + this.attr_name() + "]") ? (o(this.scope).data(this.attr_name(!0) + "-init", t.extend({}, this.settings, i || e, this.data_options(o(this.scope)))), s && this.events(this.scope)) : o("[" + this.attr_name() + "]", this.scope).each(function () {
            var s = !o(this).data(n.attr_name(!0) + "-init");
            o(this).data(n.attr_name(!0) + "-init", t.extend({}, n.settings, i || e, n.data_options(o(this)))), s && n.events(this)
        }), "string" == typeof e) return this[e].call(this, i)
    }, h = function (t, e) {
        function i() {
            e(t[0])
        }

        function n() {
            if (this.one("load", i), /MSIE (\d+\.\d+);/.test(navigator.userAgent)) {
                var t = this.attr("src"), e = t.match(/\?/) ? "&" : "?";
                e += "random=" + (new Date).getTime(), this.attr("src", t + e)
            }
        }

        if (!t.attr("src")) return void i();
        t[0].complete || 4 === t[0].readyState ? i() : n.call(t)
    };
    e.matchMedia = e.matchMedia || function (t) {
        var e, i = t.documentElement, n = i.firstElementChild || i.firstChild, s = t.createElement("body"),
            o = t.createElement("div");
        return o.id = "mq-test-1", o.style.cssText = "position:absolute;top:-100em", s.style.background = "none", s.appendChild(o), function (t) {
            return o.innerHTML = '&shy;<style media="' + t + '"> #mq-test-1 { width: 42px; }</style>', i.insertBefore(s, n), e = 42 === o.offsetWidth, i.removeChild(s), {
                matches: e,
                media: t
            }
        }
    }(i), function () {
        function t() {
            i && (o(t), a && jQuery.fx.tick())
        }

        for (var i, n = 0, s = ["webkit", "moz"], o = e.requestAnimationFrame, r = e.cancelAnimationFrame, a = "undefined" != typeof jQuery.fx; n < s.length && !o; n++) o = e[s[n] + "RequestAnimationFrame"], r = r || e[s[n] + "CancelAnimationFrame"] || e[s[n] + "CancelRequestAnimationFrame"];
        o ? (e.requestAnimationFrame = o, e.cancelAnimationFrame = r, a && (jQuery.fx.timer = function (e) {
            e() && jQuery.timers.push(e) && !i && (i = !0, t())
        }, jQuery.fx.stop = function () {
            i = !1
        })) : (e.requestAnimationFrame = function (t) {
            var i = (new Date).getTime(), s = Math.max(0, 16 - (i - n)), o = e.setTimeout(function () {
                t(i + s)
            }, s);
            return n = i + s, o
        }, e.cancelAnimationFrame = function (t) {
            clearTimeout(t)
        })
    }(jQuery), e.Foundation = {
        name: "Foundation",
        version: "5.5.0",
        media_queries: {
            small: o(".foundation-mq-small").css("font-family").replace(/^[\/\\'"]+|(;\s?})+|[\/\\'"]+$/g, ""),
            "small-only": o(".foundation-mq-small-only").css("font-family").replace(/^[\/\\'"]+|(;\s?})+|[\/\\'"]+$/g, ""),
            medium: o(".foundation-mq-medium").css("font-family").replace(/^[\/\\'"]+|(;\s?})+|[\/\\'"]+$/g, ""),
            "medium-only": o(".foundation-mq-medium-only").css("font-family").replace(/^[\/\\'"]+|(;\s?})+|[\/\\'"]+$/g, ""),
            large: o(".foundation-mq-large").css("font-family").replace(/^[\/\\'"]+|(;\s?})+|[\/\\'"]+$/g, ""),
            "large-only": o(".foundation-mq-large-only").css("font-family").replace(/^[\/\\'"]+|(;\s?})+|[\/\\'"]+$/g, ""),
            xlarge: o(".foundation-mq-xlarge").css("font-family").replace(/^[\/\\'"]+|(;\s?})+|[\/\\'"]+$/g, ""),
            "xlarge-only": o(".foundation-mq-xlarge-only").css("font-family").replace(/^[\/\\'"]+|(;\s?})+|[\/\\'"]+$/g, ""),
            xxlarge: o(".foundation-mq-xxlarge").css("font-family").replace(/^[\/\\'"]+|(;\s?})+|[\/\\'"]+$/g, "")
        },
        stylesheet: t("<style></style>").appendTo("head")[0].sheet,
        global: {namespace: n},
        init: function (t, i, n, s, r) {
            var a = [t, n, s, r], l = [];
            if (this.rtl = /rtl/i.test(o("html").attr("dir")), this.scope = t || this.scope, this.set_namespace(), i && "string" == typeof i && !/reflow/i.test(i)) this.libs.hasOwnProperty(i) && l.push(this.init_lib(i, a)); else for (var h in this.libs) l.push(this.init_lib(h, i));
            return o(e).load(function () {
                o(e).trigger("resize.fndtn.clearing").trigger("resize.fndtn.dropdown").trigger("resize.fndtn.equalizer").trigger("resize.fndtn.interchange").trigger("resize.fndtn.joyride").trigger("resize.fndtn.magellan").trigger("resize.fndtn.topbar").trigger("resize.fndtn.slider")
            }), t
        },
        init_lib: function (e, i) {
            return this.libs.hasOwnProperty(e) ? (this.patch(this.libs[e]), i && i.hasOwnProperty(e) ? ("undefined" != typeof this.libs[e].settings ? t.extend(!0, this.libs[e].settings, i[e]) : "undefined" != typeof this.libs[e].defaults && t.extend(!0, this.libs[e].defaults, i[e]), this.libs[e].init.apply(this.libs[e], [this.scope, i[e]])) : (i = i instanceof Array ? i : new Array(i), this.libs[e].init.apply(this.libs[e], i))) : function () {
            }
        },
        patch: function (t) {
            t.scope = this.scope, t.namespace = this.global.namespace, t.rtl = this.rtl, t.data_options = this.utils.data_options, t.attr_name = r, t.add_namespace = a, t.bindings = l, t.S = this.utils.S
        },
        inherit: function (t, e) {
            for (var i = e.split(" "), n = i.length; n--;) this.utils.hasOwnProperty(i[n]) && (t[i[n]] = this.utils[i[n]])
        },
        set_namespace: function () {
            var e = this.global.namespace === n ? t(".foundation-data-attribute-namespace").css("font-family") : this.global.namespace;
            this.global.namespace = e === n || /false/i.test(e) ? "" : e
        },
        libs: {},
        utils: {
            S: o, throttle: function (t, e) {
                var i = null;
                return function () {
                    var n = this, s = arguments;
                    null == i && (i = setTimeout(function () {
                        t.apply(n, s), i = null
                    }, e))
                }
            }, debounce: function (t, e, i) {
                var n, s;
                return function () {
                    var o = this, r = arguments, a = function () {
                        n = null, i || (s = t.apply(o, r))
                    }, l = i && !n;
                    return clearTimeout(n), n = setTimeout(a, e), l && (s = t.apply(o, r)), s
                }
            }, data_options: function (e, i) {
                function n(t) {
                    return !isNaN(t - 0) && null !== t && "" !== t && !1 !== t && !0 !== t
                }

                function s(e) {
                    return "string" == typeof e ? t.trim(e) : e
                }

                i = i || "options";
                var o, r, a, l = {}, h = function (t) {
                    var e = Foundation.global.namespace;
                    return e.length > 0 ? t.data(e + "-" + i) : t.data(i)
                }, c = h(e);
                if ("object" == typeof c) return c;
                for (a = (c || ":").split(";"), o = a.length; o--;) r = a[o].split(":"), r = [r[0], r.slice(1).join(":")], /true/i.test(r[1]) && (r[1] = !0), /false/i.test(r[1]) && (r[1] = !1), n(r[1]) && (-1 === r[1].indexOf(".") ? r[1] = parseInt(r[1], 10) : r[1] = parseFloat(r[1])), 2 === r.length && r[0].length > 0 && (l[s(r[0])] = s(r[1]));
                return l
            }, register_media: function (e, i) {
                Foundation.media_queries[e] === n && (t("head").append('<meta class="' + i + '"/>'), Foundation.media_queries[e] = s(t("." + i).css("font-family")))
            }, add_custom_rule: function (t, e) {
                if (e === n && Foundation.stylesheet) Foundation.stylesheet.insertRule(t, Foundation.stylesheet.cssRules.length); else {
                    Foundation.media_queries[e] !== n && Foundation.stylesheet.insertRule("@media " + Foundation.media_queries[e] + "{ " + t + " }")
                }
            }, image_loaded: function (t, e) {
                var i = this, n = t.length;
                0 === n && e(t), t.each(function () {
                    h(i.S(this), function () {
                        0 === (n -= 1) && e(t)
                    })
                })
            }, random_str: function () {
                return this.fidx || (this.fidx = 0), this.prefix = this.prefix || [this.name || "F", (+new Date).toString(36)].join("-"), this.prefix + (this.fidx++).toString(36)
            }, match: function (t) {
                return e.matchMedia(t).matches
            }, is_small_up: function () {
                return this.match(Foundation.media_queries.small)
            }, is_medium_up: function () {
                return this.match(Foundation.media_queries.medium)
            }, is_large_up: function () {
                return this.match(Foundation.media_queries.large)
            }, is_xlarge_up: function () {
                return this.match(Foundation.media_queries.xlarge)
            }, is_xxlarge_up: function () {
                return this.match(Foundation.media_queries.xxlarge)
            }, is_small_only: function () {
                return !(this.is_medium_up() || this.is_large_up() || this.is_xlarge_up() || this.is_xxlarge_up())
            }, is_medium_only: function () {
                return this.is_medium_up() && !this.is_large_up() && !this.is_xlarge_up() && !this.is_xxlarge_up()
            }, is_large_only: function () {
                return this.is_medium_up() && this.is_large_up() && !this.is_xlarge_up() && !this.is_xxlarge_up()
            }, is_xlarge_only: function () {
                return this.is_medium_up() && this.is_large_up() && this.is_xlarge_up() && !this.is_xxlarge_up()
            }, is_xxlarge_only: function () {
                return this.is_medium_up() && this.is_large_up() && this.is_xlarge_up() && this.is_xxlarge_up()
            }
        }
    }, t.fn.foundation = function () {
        var t = Array.prototype.slice.call(arguments, 0);
        return this.each(function () {
            return Foundation.init.apply(Foundation, [this].concat(t)), this
        })
    }
}(jQuery, window, window.document), function (t, e) {
    "use strict";
    Foundation.libs.slider = {
        name: "slider",
        version: "5.5.0",
        settings: {
            start: 0,
            end: 100,
            step: 1,
            precision: null,
            initial: null,
            display_selector: "",
            vertical: !1,
            trigger_input_change: !1,
            on_change: function () {
            }
        },
        cache: {},
        init: function (t, e, i) {
            Foundation.inherit(this, "throttle"), this.bindings(e, i), this.reflow()
        },
        events: function () {
            var i = this;
            t(this.scope).off(".slider").on("mousedown.fndtn.slider touchstart.fndtn.slider pointerdown.fndtn.slider", "[" + i.attr_name() + "]:not(.disabled, [disabled]) .range-slider-handle", function (e) {
                i.cache.active || (e.preventDefault(), i.set_active_slider(t(e.target)))
            }).on("mousemove.fndtn.slider touchmove.fndtn.slider pointermove.fndtn.slider", function (n) {
                if (i.cache.active) if (n.preventDefault(), t.data(i.cache.active[0], "settings").vertical) {
                    var s = 0;
                    n.pageY || (s = e.scrollY), i.calculate_position(i.cache.active, i.get_cursor_position(n, "y") + s)
                } else i.calculate_position(i.cache.active, i.get_cursor_position(n, "x"))
            }).on("mouseup.fndtn.slider touchend.fndtn.slider pointerup.fndtn.slider", function () {
                i.remove_active_slider()
            }).on("change.fndtn.slider", function () {
                i.settings.on_change()
            }), i.S(e).on("resize.fndtn.slider", i.throttle(function () {
                i.reflow()
            }, 300))
        },
        get_cursor_position: function (t, e) {
            var i, n = "page" + e.toUpperCase(), s = "client" + e.toUpperCase();
            return "undefined" != typeof t[n] ? i = t[n] : "undefined" != typeof t.originalEvent[s] ? i = t.originalEvent[s] : t.originalEvent.touches && t.originalEvent.touches[0] && "undefined" != typeof t.originalEvent.touches[0][s] ? i = t.originalEvent.touches[0][s] : t.currentPoint && "undefined" != typeof t.currentPoint[e] && (i = t.currentPoint[e]), i
        },
        set_active_slider: function (t) {
            this.cache.active = t
        },
        remove_active_slider: function () {
            this.cache.active = null
        },
        calculate_position: function (e, i) {
            var n = this, s = t.data(e[0], "settings"),
                o = (t.data(e[0], "handle_l"), t.data(e[0], "handle_o"), t.data(e[0], "bar_l")),
                r = t.data(e[0], "bar_o");
            requestAnimationFrame(function () {
                var t;
                t = Foundation.rtl && !s.vertical ? n.limit_to((r + o - i) / o, 0, 1) : n.limit_to((i - r) / o, 0, 1), t = s.vertical ? 1 - t : t;
                var a = n.normalized_value(t, s.start, s.end, s.step, s.precision);
                n.set_ui(e, a)
            })
        },
        set_ui: function (e, i) {
            var n = t.data(e[0], "settings"), s = t.data(e[0], "handle_l"), o = t.data(e[0], "bar_l"),
                r = this.normalized_percentage(i, n.start, n.end), a = r * (o - s) - 1, l = 100 * r, h = e.parent(),
                c = e.parent().children("input[type=hidden]");
            Foundation.rtl && !n.vertical && (a = -a), a = n.vertical ? -a + o - s + 1 : a, this.set_translate(e, a, n.vertical), n.vertical ? e.siblings(".range-slider-active-segment").css("height", l + "%") : e.siblings(".range-slider-active-segment").css("width", l + "%"), h.attr(this.attr_name(), i).trigger("change").trigger("change.fndtn.slider"), c.val(i), n.trigger_input_change && c.trigger("change"), e[0].hasAttribute("aria-valuemin") || e.attr({
                "aria-valuemin": n.start,
                "aria-valuemax": n.end
            }), e.attr("aria-valuenow", i), "" != n.display_selector && t(n.display_selector).each(function () {
                this.hasOwnProperty("value") ? t(this).val(i) : t(this).text(i)
            })
        },
        normalized_percentage: function (t, e, i) {
            return Math.min(1, (t - e) / (i - e))
        },
        normalized_value: function (t, e, i, n, s) {
            var o = i - e, r = t * o;
            return ((r - r % n) / n * n + (r % n >= .5 * n ? n : 0) + e).toFixed(s)
        },
        set_translate: function (e, i, n) {
            n ? t(e).css("-webkit-transform", "translateY(" + i + "px)").css("-moz-transform", "translateY(" + i + "px)").css("-ms-transform", "translateY(" + i + "px)").css("-o-transform", "translateY(" + i + "px)").css("transform", "translateY(" + i + "px)") : t(e).css("-webkit-transform", "translateX(" + i + "px)").css("-moz-transform", "translateX(" + i + "px)").css("-ms-transform", "translateX(" + i + "px)").css("-o-transform", "translateX(" + i + "px)").css("transform", "translateX(" + i + "px)")
        },
        limit_to: function (t, e, i) {
            return Math.min(Math.max(t, e), i)
        },
        initialize_settings: function (e) {
            var i, n = t.extend({}, this.settings, this.data_options(t(e).parent()));
            null === n.precision && (i = ("" + n.step).match(/\.([\d]*)/), n.precision = i && i[1] ? i[1].length : 0), n.vertical ? (t.data(e, "bar_o", t(e).parent().offset().top), t.data(e, "bar_l", t(e).parent().outerHeight()), t.data(e, "handle_o", t(e).offset().top), t.data(e, "handle_l", t(e).outerHeight())) : (t.data(e, "bar_o", t(e).parent().offset().left), t.data(e, "bar_l", t(e).parent().outerWidth()), t.data(e, "handle_o", t(e).offset().left), t.data(e, "handle_l", t(e).outerWidth())), t.data(e, "bar", t(e).parent()), t.data(e, "settings", n)
        },
        set_initial_position: function (e) {
            var i = t.data(e.children(".range-slider-handle")[0], "settings"),
                n = "number" != typeof i.initial || isNaN(i.initial) ? Math.floor(.5 * (i.end - i.start) / i.step) * i.step + i.start : i.initial,
                s = e.children(".range-slider-handle");
            this.set_ui(s, n)
        },
        set_value: function (e) {
            var i = this;
            t("[" + i.attr_name() + "]", this.scope).each(function () {
                t(this).attr(i.attr_name(), e)
            }), t(this.scope).attr(i.attr_name()) && t(this.scope).attr(i.attr_name(), e), i.reflow()
        },
        reflow: function () {
            var e = this;
            e.S("[" + this.attr_name() + "]").each(function () {
                var i = t(this).children(".range-slider-handle")[0], n = t(this).attr(e.attr_name());
                e.initialize_settings(i), n ? e.set_ui(t(i), parseFloat(n)) : e.set_initial_position(t(this))
            })
        }
    }
}(jQuery, window, window.document), function (t, e, i, n) {
    "use strict";
    Foundation.libs.joyride = {
        name: "joyride",
        version: "5.5.0",
        defaults: {
            expose: !1,
            modal: !0,
            keyboard: !0,
            tip_location: "bottom",
            nub_position: "auto",
            scroll_speed: 1500,
            scroll_animation: "linear",
            timer: 0,
            start_timer_on_click: !0,
            start_offset: 0,
            next_button: !0,
            prev_button: !0,
            tip_animation: "fade",
            pause_after: [],
            exposed: [],
            tip_animation_fade_speed: 300,
            cookie_monster: !1,
            cookie_name: "joyride",
            cookie_domain: !1,
            cookie_expires: 365,
            tip_container: "body",
            abort_on_close: !0,
            tip_location_patterns: {
                top: ["bottom"],
                bottom: [],
                left: ["right", "top", "bottom"],
                right: ["left", "top", "bottom"]
            },
            post_ride_callback: function () {
            },
            post_step_callback: function () {
            },
            pre_step_callback: function () {
            },
            pre_ride_callback: function () {
            },
            post_expose_callback: function () {
            },
            template: {
                link: '<a href="#close" class="joyride-close-tip">&times;</a>',
                timer: '<div class="joyride-timer-indicator-wrap"><span class="joyride-timer-indicator"></span></div>',
                tip: '<div class="joyride-tip-guide"><span class="joyride-nub"></span></div>',
                wrapper: '<div class="joyride-content-wrapper"></div>',
                button: '<a href="#" class="small button joyride-next-tip"></a>',
                prev_button: '<a href="#" class="small button joyride-prev-tip"></a>',
                modal: '<div class="joyride-modal-bg"></div>',
                expose: '<div class="joyride-expose-wrapper"></div>',
                expose_cover: '<div class="joyride-expose-cover"></div>'
            },
            expose_add_class: ""
        },
        init: function (e, i, n) {
            Foundation.inherit(this, "throttle random_str"), this.settings = this.settings || t.extend({}, this.defaults, n || i), this.bindings(i, n)
        },
        go_next: function () {
            this.settings.$li.next().length < 1 ? this.end() : this.settings.timer > 0 ? (clearTimeout(this.settings.automate), this.hide(), this.show(), this.startTimer()) : (this.hide(), this.show())
        },
        go_prev: function () {
            this.settings.$li.prev().length < 1 || (this.settings.timer > 0 ? (clearTimeout(this.settings.automate), this.hide(), this.show(null, !0), this.startTimer()) : (this.hide(), this.show(null, !0)))
        },
        events: function () {
            var i = this;
            t(this.scope).off(".joyride").on("click.fndtn.joyride", ".joyride-next-tip, .joyride-modal-bg", function (t) {
                t.preventDefault(), this.go_next()
            }.bind(this)).on("click.fndtn.joyride", ".joyride-prev-tip", function (t) {
                t.preventDefault(), this.go_prev()
            }.bind(this)).on("click.fndtn.joyride", ".joyride-close-tip", function (t) {
                t.preventDefault(), this.end(this.settings.abort_on_close)
            }.bind(this)).on("keyup.fndtn.joyride", function (t) {
                if (this.settings.keyboard && this.settings.riding) switch (t.which) {
                    case 39:
                        t.preventDefault(), this.go_next();
                        break;
                    case 37:
                        t.preventDefault(), this.go_prev();
                        break;
                    case 27:
                        t.preventDefault(), this.end(this.settings.abort_on_close)
                }
            }.bind(this)), t(e).off(".joyride").on("resize.fndtn.joyride", i.throttle(function () {
                if (t("[" + i.attr_name() + "]").length > 0 && i.settings.$next_tip && i.settings.riding) {
                    if (i.settings.exposed.length > 0) {
                        t(i.settings.exposed).each(function () {
                            var e = t(this);
                            i.un_expose(e), i.expose(e)
                        })
                    }
                    i.is_phone() ? i.pos_phone() : i.pos_default(!1)
                }
            }, 100))
        },
        start: function () {
            var e = this, i = t("[" + this.attr_name() + "]", this.scope),
                n = ["timer", "scrollSpeed", "startOffset", "tipAnimationFadeSpeed", "cookieExpires"], s = n.length;
            !i.length > 0 || (this.settings.init || this.events(), this.settings = i.data(this.attr_name(!0) + "-init"), this.settings.$content_el = i, this.settings.$body = t(this.settings.tip_container), this.settings.body_offset = t(this.settings.tip_container).position(), this.settings.$tip_content = this.settings.$content_el.find("> li"), this.settings.paused = !1, this.settings.attempts = 0, this.settings.riding = !0, "function" != typeof t.cookie && (this.settings.cookie_monster = !1), (!this.settings.cookie_monster || this.settings.cookie_monster && !t.cookie(this.settings.cookie_name)) && (this.settings.$tip_content.each(function (i) {
                var o = t(this);
                this.settings = t.extend({}, e.defaults, e.data_options(o));
                for (var r = s; r--;) e.settings[n[r]] = parseInt(e.settings[n[r]], 10);
                e.create({$li: o, index: i})
            }), !this.settings.start_timer_on_click && this.settings.timer > 0 ? (this.show("init"), this.startTimer()) : this.show("init")))
        },
        resume: function () {
            this.set_li(), this.show()
        },
        tip_template: function (e) {
            var i, n;
            return e.tip_class = e.tip_class || "", i = t(this.settings.template.tip).addClass(e.tip_class), n = t.trim(t(e.li).html()) + this.prev_button_text(e.prev_button_text, e.index) + this.button_text(e.button_text) + this.settings.template.link + this.timer_instance(e.index), i.append(t(this.settings.template.wrapper)), i.first().attr(this.add_namespace("data-index"), e.index), t(".joyride-content-wrapper", i).append(n), i[0]
        },
        timer_instance: function (e) {
            return 0 === e && this.settings.start_timer_on_click && this.settings.timer > 0 || 0 === this.settings.timer ? "" : t(this.settings.template.timer)[0].outerHTML
        },
        button_text: function (e) {
            return this.settings.tip_settings.next_button ? (e = t.trim(e) || "Next", e = t(this.settings.template.button).append(e)[0].outerHTML) : e = "", e
        },
        prev_button_text: function (e, i) {
            return this.settings.tip_settings.prev_button ? (e = t.trim(e) || "Previous", e = 0 == i ? t(this.settings.template.prev_button).append(e).addClass("disabled")[0].outerHTML : t(this.settings.template.prev_button).append(e)[0].outerHTML) : e = "", e
        },
        create: function (e) {
            this.settings.tip_settings = t.extend({}, this.settings, this.data_options(e.$li));
            var i = e.$li.attr(this.add_namespace("data-button")) || e.$li.attr(this.add_namespace("data-text")),
                n = e.$li.attr(this.add_namespace("data-button-prev")) || e.$li.attr(this.add_namespace("data-prev-text")),
                s = e.$li.attr("class"), o = t(this.tip_template({
                    tip_class: s,
                    index: e.index,
                    button_text: i,
                    prev_button_text: n,
                    li: e.$li
                }));
            t(this.settings.tip_container).append(o)
        },
        show: function (e, i) {
            var s = null;
            if (this.settings.$li === n || -1 === t.inArray(this.settings.$li.index(), this.settings.pause_after)) if (this.settings.paused ? this.settings.paused = !1 : this.set_li(e, i), this.settings.attempts = 0, this.settings.$li.length && this.settings.$target.length > 0) {
                if (e && (this.settings.pre_ride_callback(this.settings.$li.index(), this.settings.$next_tip), this.settings.modal && this.show_modal()), this.settings.pre_step_callback(this.settings.$li.index(), this.settings.$next_tip), this.settings.modal && this.settings.expose && this.expose(), this.settings.tip_settings = t.extend({}, this.settings, this.data_options(this.settings.$li)), this.settings.timer = parseInt(this.settings.timer, 10), this.settings.tip_settings.tip_location_pattern = this.settings.tip_location_patterns[this.settings.tip_settings.tip_location], !/body/i.test(this.settings.$target.selector)) {
                    var o = t(".joyride-modal-bg");
                    /pop/i.test(this.settings.tipAnimation) ? o.hide() : o.fadeOut(this.settings.tipAnimationFadeSpeed), this.scroll_to()
                }
                this.is_phone() ? this.pos_phone(!0) : this.pos_default(!0), s = this.settings.$next_tip.find(".joyride-timer-indicator"), /pop/i.test(this.settings.tip_animation) ? (s.width(0), this.settings.timer > 0 ? (this.settings.$next_tip.show(), setTimeout(function () {
                    s.animate({width: s.parent().width()}, this.settings.timer, "linear")
                }.bind(this), this.settings.tip_animation_fade_speed)) : this.settings.$next_tip.show()) : /fade/i.test(this.settings.tip_animation) && (s.width(0), this.settings.timer > 0 ? (this.settings.$next_tip.fadeIn(this.settings.tip_animation_fade_speed).show(), setTimeout(function () {
                    s.animate({width: s.parent().width()}, this.settings.timer, "linear")
                }.bind(this), this.settings.tip_animation_fade_speed)) : this.settings.$next_tip.fadeIn(this.settings.tip_animation_fade_speed)), this.settings.$current_tip = this.settings.$next_tip
            } else this.settings.$li && this.settings.$target.length < 1 ? this.show(e, i) : this.end(); else this.settings.paused = !0
        },
        is_phone: function () {
            return matchMedia(Foundation.media_queries.small).matches && !matchMedia(Foundation.media_queries.medium).matches
        },
        hide: function () {
            this.settings.modal && this.settings.expose && this.un_expose(), this.settings.modal || t(".joyride-modal-bg").hide(), this.settings.$current_tip.css("visibility", "hidden"), setTimeout(t.proxy(function () {
                this.hide(), this.css("visibility", "visible")
            }, this.settings.$current_tip), 0), this.settings.post_step_callback(this.settings.$li.index(), this.settings.$current_tip)
        },
        set_li: function (t, e) {
            t ? (this.settings.$li = this.settings.$tip_content.eq(this.settings.start_offset), this.set_next_tip(), this.settings.$current_tip = this.settings.$next_tip) : (this.settings.$li = e ? this.settings.$li.prev() : this.settings.$li.next(), this.set_next_tip()), this.set_target()
        },
        set_next_tip: function () {
            this.settings.$next_tip = t(".joyride-tip-guide").eq(this.settings.$li.index()), this.settings.$next_tip.data("closed", "")
        },
        set_target: function () {
            var e = this.settings.$li.attr(this.add_namespace("data-class")),
                n = this.settings.$li.attr(this.add_namespace("data-id")), s = function () {
                    return n ? t(i.getElementById(n)) : e ? t("." + e).first() : t("body")
                };
            this.settings.$target = s()
        },
        scroll_to: function () {
            var i, n;
            i = t(e).height() / 2, 0 != (n = Math.ceil(this.settings.$target.offset().top - i + this.settings.$next_tip.outerHeight())) && t("html, body").stop().animate({scrollTop: n}, this.settings.scroll_speed, "swing")
        },
        paused: function () {
            return -1 === t.inArray(this.settings.$li.index() + 1, this.settings.pause_after)
        },
        restart: function () {
            this.hide(), this.settings.$li = n, this.show("init")
        },
        pos_default: function (t) {
            var e = this.settings.$next_tip.find(".joyride-nub"), i = Math.ceil(e.outerWidth() / 2),
                n = Math.ceil(e.outerHeight() / 2), s = t || !1;
            if (s && (this.settings.$next_tip.css("visibility", "hidden"), this.settings.$next_tip.show()), /body/i.test(this.settings.$target.selector)) this.settings.$li.length && this.pos_modal(e); else {
                var o = this.settings.tip_settings.tipAdjustmentY ? parseInt(this.settings.tip_settings.tipAdjustmentY) : 0,
                    r = this.settings.tip_settings.tipAdjustmentX ? parseInt(this.settings.tip_settings.tipAdjustmentX) : 0;
                this.bottom() ? (this.rtl ? this.settings.$next_tip.css({
                    top: this.settings.$target.offset().top + n + this.settings.$target.outerHeight() + o,
                    left: this.settings.$target.offset().left + this.settings.$target.outerWidth() - this.settings.$next_tip.outerWidth() + r
                }) : this.settings.$next_tip.css({
                    top: this.settings.$target.offset().top + n + this.settings.$target.outerHeight() + o,
                    left: this.settings.$target.offset().left + r
                }), this.nub_position(e, this.settings.tip_settings.nub_position, "top")) : this.top() ? (this.rtl ? this.settings.$next_tip.css({
                    top: this.settings.$target.offset().top - this.settings.$next_tip.outerHeight() - n + o,
                    left: this.settings.$target.offset().left + this.settings.$target.outerWidth() - this.settings.$next_tip.outerWidth()
                }) : this.settings.$next_tip.css({
                    top: this.settings.$target.offset().top - this.settings.$next_tip.outerHeight() - n + o,
                    left: this.settings.$target.offset().left + r
                }), this.nub_position(e, this.settings.tip_settings.nub_position, "bottom")) : this.right() ? (this.settings.$next_tip.css({
                    top: this.settings.$target.offset().top + o,
                    left: this.settings.$target.outerWidth() + this.settings.$target.offset().left + i + r
                }), this.nub_position(e, this.settings.tip_settings.nub_position, "left")) : this.left() && (this.settings.$next_tip.css({
                    top: this.settings.$target.offset().top + o,
                    left: this.settings.$target.offset().left - this.settings.$next_tip.outerWidth() - i + r
                }), this.nub_position(e, this.settings.tip_settings.nub_position, "right")), !this.visible(this.corners(this.settings.$next_tip)) && this.settings.attempts < this.settings.tip_settings.tip_location_pattern.length && (e.removeClass("bottom").removeClass("top").removeClass("right").removeClass("left"), this.settings.tip_settings.tip_location = this.settings.tip_settings.tip_location_pattern[this.settings.attempts], this.settings.attempts++, this.pos_default())
            }
            s && (this.settings.$next_tip.hide(), this.settings.$next_tip.css("visibility", "visible"))
        },
        pos_phone: function (e) {
            var i = this.settings.$next_tip.outerHeight(),
                n = (this.settings.$next_tip.offset(), this.settings.$target.outerHeight()),
                s = t(".joyride-nub", this.settings.$next_tip), o = Math.ceil(s.outerHeight() / 2), r = e || !1;
            s.removeClass("bottom").removeClass("top").removeClass("right").removeClass("left"), r && (this.settings.$next_tip.css("visibility", "hidden"), this.settings.$next_tip.show()), /body/i.test(this.settings.$target.selector) ? this.settings.$li.length && this.pos_modal(s) : this.top() ? (this.settings.$next_tip.offset({top: this.settings.$target.offset().top - i - o}), s.addClass("bottom")) : (this.settings.$next_tip.offset({top: this.settings.$target.offset().top + n + o}), s.addClass("top")), r && (this.settings.$next_tip.hide(), this.settings.$next_tip.css("visibility", "visible"))
        },
        pos_modal: function (t) {
            this.center(), t.hide(), this.show_modal()
        },
        show_modal: function () {
            if (!this.settings.$next_tip.data("closed")) {
                var e = t(".joyride-modal-bg");
                if (e.length < 1) {
                    var e = t(this.settings.template.modal);
                    e.appendTo("body")
                }
                /pop/i.test(this.settings.tip_animation) ? e.show() : e.fadeIn(this.settings.tip_animation_fade_speed)
            }
        },
        expose: function () {
            var i, n, s, o, r, a = "expose-" + this.random_str(6);
            if (arguments.length > 0 && arguments[0] instanceof t) s = arguments[0]; else {
                if (!this.settings.$target || /body/i.test(this.settings.$target.selector)) return !1;
                s = this.settings.$target
            }
            if (s.length < 1) return e.console && console.error("element not valid", s), !1
                ;
            i = t(this.settings.template.expose), this.settings.$body.append(i), i.css({
                top: s.offset().top,
                left: s.offset().left,
                width: s.outerWidth(!0),
                height: s.outerHeight(!0)
            }), n = t(this.settings.template.expose_cover), o = {
                zIndex: s.css("z-index"),
                position: s.css("position")
            }, r = null == s.attr("class") ? "" : s.attr("class"), s.css("z-index", parseInt(i.css("z-index")) + 1), "static" == o.position && s.css("position", "relative"), s.data("expose-css", o), s.data("orig-class", r), s.attr("class", r + " " + this.settings.expose_add_class), n.css({
                top: s.offset().top,
                left: s.offset().left,
                width: s.outerWidth(!0),
                height: s.outerHeight(!0)
            }), this.settings.modal && this.show_modal(), this.settings.$body.append(n), i.addClass(a), n.addClass(a), s.data("expose", a), this.settings.post_expose_callback(this.settings.$li.index(), this.settings.$next_tip, s), this.add_exposed(s)
        },
        un_expose: function () {
            var i, n, s, o, r, a = !1;
            if (arguments.length > 0 && arguments[0] instanceof t) n = arguments[0]; else {
                if (!this.settings.$target || /body/i.test(this.settings.$target.selector)) return !1;
                n = this.settings.$target
            }
            if (n.length < 1) return e.console && console.error("element not valid", n), !1;
            i = n.data("expose"), s = t("." + i), arguments.length > 1 && (a = arguments[1]), !0 === a ? t(".joyride-expose-wrapper,.joyride-expose-cover").remove() : s.remove(), o = n.data("expose-css"), "auto" == o.zIndex ? n.css("z-index", "") : n.css("z-index", o.zIndex), o.position != n.css("position") && ("static" == o.position ? n.css("position", "") : n.css("position", o.position)), r = n.data("orig-class"), n.attr("class", r), n.removeData("orig-classes"), n.removeData("expose"), n.removeData("expose-z-index"), this.remove_exposed(n)
        },
        add_exposed: function (e) {
            this.settings.exposed = this.settings.exposed || [], e instanceof t || "object" == typeof e ? this.settings.exposed.push(e[0]) : "string" == typeof e && this.settings.exposed.push(e)
        },
        remove_exposed: function (e) {
            var i, n;
            for (e instanceof t ? i = e[0] : "string" == typeof e && (i = e), this.settings.exposed = this.settings.exposed || [], n = this.settings.exposed.length; n--;) if (this.settings.exposed[n] == i) return void this.settings.exposed.splice(n, 1)
        },
        center: function () {
            var i = t(e);
            return this.settings.$next_tip.css({
                top: (i.height() - this.settings.$next_tip.outerHeight()) / 2 + i.scrollTop(),
                left: (i.width() - this.settings.$next_tip.outerWidth()) / 2 + i.scrollLeft()
            }), !0
        },
        bottom: function () {
            return /bottom/i.test(this.settings.tip_settings.tip_location)
        },
        top: function () {
            return /top/i.test(this.settings.tip_settings.tip_location)
        },
        right: function () {
            return /right/i.test(this.settings.tip_settings.tip_location)
        },
        left: function () {
            return /left/i.test(this.settings.tip_settings.tip_location)
        },
        corners: function (i) {
            var n = t(e), s = n.height() / 2,
                o = Math.ceil(this.settings.$target.offset().top - s + this.settings.$next_tip.outerHeight()),
                r = n.width() + n.scrollLeft(), a = n.height() + o, l = n.height() + n.scrollTop(), h = n.scrollTop();
            return o < h && (h = o < 0 ? 0 : o), a > l && (l = a), [i.offset().top < h, r < i.offset().left + i.outerWidth(), l < i.offset().top + i.outerHeight(), n.scrollLeft() > i.offset().left]
        },
        visible: function (t) {
            for (var e = t.length; e--;) if (t[e]) return !1;
            return !0
        },
        nub_position: function (t, e, i) {
            "auto" === e ? t.addClass(i) : t.addClass(e)
        },
        startTimer: function () {
            this.settings.$li.length ? this.settings.automate = setTimeout(function () {
                this.hide(), this.show(), this.startTimer()
            }.bind(this), this.settings.timer) : clearTimeout(this.settings.automate)
        },
        end: function (e) {
            this.settings.cookie_monster && t.cookie(this.settings.cookie_name, "ridden", {
                expires: this.settings.cookie_expires,
                domain: this.settings.cookie_domain
            }), this.settings.timer > 0 && clearTimeout(this.settings.automate), this.settings.modal && this.settings.expose && this.un_expose(), t(this.scope).off("keyup.joyride"), this.settings.$next_tip.data("closed", !0), this.settings.riding = !1, t(".joyride-modal-bg").hide(), this.settings.$current_tip.hide(), void 0 !== e && !1 !== e || (this.settings.post_step_callback(this.settings.$li.index(), this.settings.$current_tip), this.settings.post_ride_callback(this.settings.$li.index(), this.settings.$current_tip)), t(".joyride-tip-guide").remove()
        },
        off: function () {
            t(this.scope).off(".joyride"), t(e).off(".joyride"), t(".joyride-close-tip, .joyride-next-tip, .joyride-modal-bg").off(".joyride"), t(".joyride-tip-guide, .joyride-modal-bg").remove(), clearTimeout(this.settings.automate), this.settings = {}
        },
        reflow: function () {
        }
    }
}(jQuery, window, window.document), function (t, e) {
    "use strict";
    Foundation.libs.equalizer = {
        name: "equalizer",
        version: "5.5.0",
        settings: {use_tallest: !0, before_height_change: t.noop, after_height_change: t.noop, equalize_on_stack: !1},
        init: function (t, e, i) {
            Foundation.inherit(this, "image_loaded"), this.bindings(e, i), this.reflow()
        },
        events: function () {
            this.S(e).off(".equalizer").on("resize.fndtn.equalizer", function () {
                this.reflow()
            }.bind(this))
        },
        equalize: function (e) {
            var i = !1, n = e.find("[" + this.attr_name() + "-watch]:visible"),
                s = e.data(this.attr_name(!0) + "-init");
            if (0 !== n.length) {
                var o = n.first().offset().top;
                if (s.before_height_change(), e.trigger("before-height-change").trigger("before-height-change.fndth.equalizer"), n.height("inherit"), n.each(function () {
                    t(this).offset().top !== o && (i = !0)
                }), !1 !== s.equalize_on_stack || !i) {
                    var r = n.map(function () {
                        return t(this).outerHeight(!1)
                    }).get();
                    if (s.use_tallest) {
                        var a = Math.max.apply(null, r);
                        n.css("height", a)
                    } else {
                        var l = Math.min.apply(null, r);
                        n.css("height", l)
                    }
                    s.after_height_change(), e.trigger("after-height-change").trigger("after-height-change.fndtn.equalizer")
                }
            }
        },
        reflow: function () {
            var e = this;
            this.S("[" + this.attr_name() + "]", this.scope).each(function () {
                var i = t(this);
                e.image_loaded(e.S("img", this), function () {
                    e.equalize(i)
                })
            })
        }
    }
}(jQuery, window, window.document), function (t, e, i) {
    "use strict";
    Foundation.libs.dropdown = {
        name: "dropdown",
        version: "5.5.0",
        settings: {
            active_class: "open",
            disabled_class: "disabled",
            mega_class: "mega",
            align: "bottom",
            is_hover: !1,
            hover_timeout: 150,
            opened: function () {
            },
            closed: function () {
            }
        },
        init: function (e, i, n) {
            Foundation.inherit(this, "throttle"), t.extend(!0, this.settings, i, n), this.bindings(i, n)
        },
        events: function () {
            var i = this, n = i.S;
            n(this.scope).off(".dropdown").on("click.fndtn.dropdown", "[" + this.attr_name() + "]", function (e) {
                (n(this).data(i.attr_name(!0) + "-init") || i.settings).is_hover && !Modernizr.touch || (e.preventDefault(), n(this).parent("[data-reveal-id]") && e.stopPropagation(), i.toggle(t(this)))
            }).on("mouseenter.fndtn.dropdown", "[" + this.attr_name() + "], [" + this.attr_name() + "-content]", function (t) {
                var e, s, o = n(this);
                clearTimeout(i.timeout), o.data(i.data_attr()) ? (e = n("#" + o.data(i.data_attr())), s = o) : (e = o, s = n("[" + i.attr_name() + '="' + e.attr("id") + '"]'));
                var r = s.data(i.attr_name(!0) + "-init") || i.settings;
                n(t.currentTarget).data(i.data_attr()) && r.is_hover && i.closeall.call(i), r.is_hover && i.open.apply(i, [e, s])
            }).on("mouseleave.fndtn.dropdown", "[" + this.attr_name() + "], [" + this.attr_name() + "-content]", function () {
                var t, e = n(this);
                if (e.data(i.data_attr())) t = e.data(i.data_attr(!0) + "-init") || i.settings; else var s = n("[" + i.attr_name() + '="' + n(this).attr("id") + '"]'),
                    t = s.data(i.attr_name(!0) + "-init") || i.settings;
                i.timeout = setTimeout(function () {
                    e.data(i.data_attr()) ? t.is_hover && i.close.call(i, n("#" + e.data(i.data_attr()))) : t.is_hover && i.close.call(i, e)
                }.bind(this), t.hover_timeout)
            }).on("click.fndtn.dropdown", function (e) {
                var s = n(e.target).closest("[" + i.attr_name() + "-content]");
                if (s.find("a").length > 0 && "false" !== s.attr("aria-autoclose") && i.close.call(i, n("[" + i.attr_name() + "-content]")), !(n(e.target).closest("[" + i.attr_name() + "]").length > 0)) return !n(e.target).data("revealId") && s.length > 0 && (n(e.target).is("[" + i.attr_name() + "-content]") || t.contains(s.first()[0], e.target)) ? void e.stopPropagation() : void i.close.call(i, n("[" + i.attr_name() + "-content]"))
            }).on("opened.fndtn.dropdown", "[" + i.attr_name() + "-content]", function () {
                i.settings.opened.call(this)
            }).on("closed.fndtn.dropdown", "[" + i.attr_name() + "-content]", function () {
                i.settings.closed.call(this)
            }), n(e).off(".dropdown").on("resize.fndtn.dropdown", i.throttle(function () {
                i.resize.call(i)
            }, 50)), this.resize()
        },
        close: function (e) {
            var i = this;
            e.each(function () {
                (t("[" + i.attr_name() + "=" + e[0].id + "]") || t("aria-controls=" + e[0].id + "]")).attr("aria-expanded", "false"), i.S(this).hasClass(i.settings.active_class) && (i.S(this).css(Foundation.rtl ? "right" : "left", "-99999px").attr("aria-hidden", "true").removeClass(i.settings.active_class).prev("[" + i.attr_name() + "]").removeClass(i.settings.active_class).removeData("target"), i.S(this).trigger("closed").trigger("closed.fndtn.dropdown", [e]))
            }), e.removeClass("f-open-" + this.attr_name(!0))
        },
        closeall: function () {
            var e = this;
            t.each(e.S(".f-open-" + this.attr_name(!0)), function () {
                e.close.call(e, e.S(this))
            })
        },
        open: function (t, e) {
            this.css(t.addClass(this.settings.active_class), e), t.prev("[" + this.attr_name() + "]").addClass(this.settings.active_class), t.data("target", e.get(0)).trigger("opened").trigger("opened.fndtn.dropdown", [t, e]), t.attr("aria-hidden", "false"), e.attr("aria-expanded", "true"), t.focus(), t.addClass("f-open-" + this.attr_name(!0))
        },
        data_attr: function () {
            return this.namespace.length > 0 ? this.namespace + "-" + this.name : this.name
        },
        toggle: function (t) {
            if (!t.hasClass(this.settings.disabled_class)) {
                var e = this.S("#" + t.data(this.data_attr()));
                0 !== e.length && (this.close.call(this, this.S("[" + this.attr_name() + "-content]").not(e)), e.hasClass(this.settings.active_class) ? (this.close.call(this, e), e.data("target") !== t.get(0) && this.open.call(this, e, t)) : this.open.call(this, e, t))
            }
        },
        resize: function () {
            var t = this.S("[" + this.attr_name() + "-content].open"),
                e = this.S("[" + this.attr_name() + '="' + t.attr("id") + '"]');
            t.length && e.length && this.css(t, e)
        },
        css: function (t, e) {
            var i = Math.max((e.width() - t.width()) / 2, 8), n = e.data(this.attr_name(!0) + "-init") || this.settings;
            if (this.clear_idx(), this.small()) {
                var s = this.dirs.bottom.call(t, e, n);
                t.attr("style", "").removeClass("drop-left drop-right drop-top").css({
                    position: "absolute",
                    width: "95%",
                    "max-width": "none",
                    top: s.top
                }), t.css(Foundation.rtl ? "right" : "left", i)
            } else this.style(t, e, n);
            return t
        },
        style: function (e, i, n) {
            var s = t.extend({position: "absolute"}, this.dirs[n.align].call(e, i, n));
            e.attr("style", "").css(s)
        },
        dirs: {
            _base: function (t) {
                var n = this.offsetParent(), s = n.offset(), o = t.offset();
                o.top -= s.top, o.left -= s.left, o.missRight = !1, o.missTop = !1, o.missLeft = !1, o.leftRightFlag = !1;
                var r;
                r = i.getElementsByClassName("row")[0] ? i.getElementsByClassName("row")[0].clientWidth : e.outerWidth;
                var a = (e.outerWidth - r) / 2;
                return this.hasClass("mega") || (t.offset().top <= this.outerHeight() && (o.missTop = !0, e.outerWidth - a, o.leftRightFlag = !0), t.offset().left + this.outerWidth() > t.offset().left + a && t.offset().left - a > this.outerWidth() && (o.missRight = !0, o.missLeft = !1), t.offset().left - this.outerWidth() <= 0 && (o.missLeft = !0, o.missRight = !1)), o
            }, top: function (t, e) {
                var i = Foundation.libs.dropdown, n = i.dirs._base.call(this, t);
                return this.addClass("drop-top"), 1 == n.missTop && (n.top = n.top + t.outerHeight() + this.outerHeight(), this.removeClass("drop-top")), 1 == n.missRight && (n.left = n.left - this.outerWidth() + t.outerWidth()), (t.outerWidth() < this.outerWidth() || i.small() || this.hasClass(e.mega_menu)) && i.adjust_pip(this, t, e, n), Foundation.rtl ? {
                    left: n.left - this.outerWidth() + t.outerWidth(),
                    top: n.top - this.outerHeight()
                } : {left: n.left, top: n.top - this.outerHeight()}
            }, bottom: function (t, e) {
                var i = Foundation.libs.dropdown, n = i.dirs._base.call(this, t);
                return 1 == n.missRight && (n.left = n.left - this.outerWidth() + t.outerWidth()), (t.outerWidth() < this.outerWidth() || i.small() || this.hasClass(e.mega_menu)) && i.adjust_pip(this, t, e, n), i.rtl ? {
                    left: n.left - this.outerWidth() + t.outerWidth(),
                    top: n.top + t.outerHeight()
                } : {left: n.left, top: n.top + t.outerHeight()}
            }, left: function (t) {
                var e = Foundation.libs.dropdown.dirs._base.call(this, t);
                return this.addClass("drop-left"), 1 == e.missLeft && (e.left = e.left + this.outerWidth(), e.top = e.top + t.outerHeight(), this.removeClass("drop-left")), {
                    left: e.left - this.outerWidth(),
                    top: e.top
                }
            }, right: function (t, e) {
                var i = Foundation.libs.dropdown.dirs._base.call(this, t);
                this.addClass("drop-right"), 1 == i.missRight ? (i.left = i.left - this.outerWidth(), i.top = i.top + t.outerHeight(), this.removeClass("drop-right")) : i.triggeredRight = !0;
                var n = Foundation.libs.dropdown;
                return (t.outerWidth() < this.outerWidth() || n.small() || this.hasClass(e.mega_menu)) && n.adjust_pip(this, t, e, i), {
                    left: i.left + t.outerWidth(),
                    top: i.top
                }
            }
        },
        adjust_pip: function (t, e, i, n) {
            var s = Foundation.stylesheet, o = 8;
            t.hasClass(i.mega_class) ? o = n.left + e.outerWidth() / 2 - 8 : this.small() && (o += n.left - 8), this.rule_idx = s.cssRules.length;
            var r = ".f-dropdown.open:before", a = ".f-dropdown.open:after", l = "left: " + o + "px;",
                h = "left: " + (o - 1) + "px;";
            1 == n.missRight && (o = t.outerWidth() - 23, r = ".f-dropdown.open:before", a = ".f-dropdown.open:after", l = "left: " + o + "px;", h = "left: " + (o - 1) + "px;"), 1 == n.triggeredRight && (r = ".f-dropdown.open:before", a = ".f-dropdown.open:after", l = "left:-12px;", h = "left:-14px;"), s.insertRule ? (s.insertRule([r, "{", l, "}"].join(" "), this.rule_idx), s.insertRule([a, "{", h, "}"].join(" "), this.rule_idx + 1)) : (s.addRule(r, l, this.rule_idx), s.addRule(a, h, this.rule_idx + 1))
        },
        clear_idx: function () {
            var t = Foundation.stylesheet;
            "undefined" != typeof this.rule_idx && (t.deleteRule(this.rule_idx), t.deleteRule(this.rule_idx), delete this.rule_idx)
        },
        small: function () {
            return matchMedia(Foundation.media_queries.small).matches && !matchMedia(Foundation.media_queries.medium).matches
        },
        off: function () {
            this.S(this.scope).off(".fndtn.dropdown"), this.S("html, body").off(".fndtn.dropdown"), this.S(e).off(".fndtn.dropdown"), this.S("[data-dropdown-content]").off(".fndtn.dropdown")
        },
        reflow: function () {
        }
    }
}(jQuery, window, window.document), function (t, e, i, n) {
    "use strict";
    Foundation.libs.clearing = {
        name: "clearing",
        version: "5.5.0",
        settings: {
            templates: {viewing: '<a href="#" class="clearing-close">&times;</a><div class="visible-img" style="display: none"><div class="clearing-touch-label"></div><img src="data:image/gif;base64,R0lGODlhAQABAAD/ACwAAAAAAQABAAACADs%3D" alt="" /><p class="clearing-caption"></p><a href="#" class="clearing-main-prev"><span></span></a><a href="#" class="clearing-main-next"><span></span></a></div>'},
            close_selectors: ".clearing-close, div.clearing-blackout",
            open_selectors: "",
            skip_selector: "",
            touch_label: "",
            init: !1,
            locked: !1
        },
        init: function (t, e, i) {
            var n = this;
            Foundation.inherit(this, "throttle image_loaded"), this.bindings(e, i), n.S(this.scope).is("[" + this.attr_name() + "]") ? this.assemble(n.S("li", this.scope)) : n.S("[" + this.attr_name() + "]", this.scope).each(function () {
                n.assemble(n.S("li", this))
            })
        },
        events: function (n) {
            var s = this, o = s.S, r = t(".scroll-container");
            r.length > 0 && (this.scope = r), o(this.scope).off(".clearing").on("click.fndtn.clearing", "ul[" + this.attr_name() + "] li " + this.settings.open_selectors, function (t, e, i) {
                var e = e || o(this), i = i || e, n = e.next("li"),
                    r = e.closest("[" + s.attr_name() + "]").data(s.attr_name(!0) + "-init"), a = o(t.target);
                t.preventDefault(), r || (s.init(), r = e.closest("[" + s.attr_name() + "]").data(s.attr_name(!0) + "-init")), i.hasClass("visible") && e[0] === i[0] && n.length > 0 && s.is_open(e) && (i = n, a = o("img", i)), s.open(a, e, i), s.update_paddles(i)
            }).on("click.fndtn.clearing", ".clearing-main-next", function (t) {
                s.nav(t, "next")
            }).on("click.fndtn.clearing", ".clearing-main-prev", function (t) {
                s.nav(t, "prev")
            }).on("click.fndtn.clearing", this.settings.close_selectors, function (t) {
                Foundation.libs.clearing.close(t, this)
            }), t(i).on("keydown.fndtn.clearing", function (t) {
                s.keydown(t)
            }), o(e).off(".clearing").on("resize.fndtn.clearing", function () {
                s.resize()
            }), this.swipe_events(n)
        },
        swipe_events: function () {
            var t = this, e = t.S;
            e(this.scope).on("touchstart.fndtn.clearing", ".visible-img", function (t) {
                t.touches || (t = t.originalEvent);
                var i = {
                    start_page_x: t.touches[0].pageX,
                    start_page_y: t.touches[0].pageY,
                    start_time: (new Date).getTime(),
                    delta_x: 0,
                    is_scrolling: n
                };
                e(this).data("swipe-transition", i), t.stopPropagation()
            }).on("touchmove.fndtn.clearing", ".visible-img", function (i) {
                if (i.touches || (i = i.originalEvent), !(i.touches.length > 1 || i.scale && 1 !== i.scale)) {
                    var n = e(this).data("swipe-transition");
                    if (void 0 === n && (n = {}), n.delta_x = i.touches[0].pageX - n.start_page_x, Foundation.rtl && (n.delta_x = -n.delta_x), "undefined" == typeof n.is_scrolling && (n.is_scrolling = !!(n.is_scrolling || Math.abs(n.delta_x) < Math.abs(i.touches[0].pageY - n.start_page_y))), !n.is_scrolling && !n.active) {
                        i.preventDefault();
                        var s = n.delta_x < 0 ? "next" : "prev";
                        n.active = !0, t.nav(i, s)
                    }
                }
            }).on("touchend.fndtn.clearing", ".visible-img", function (t) {
                e(this).data("swipe-transition", {}), t.stopPropagation()
            })
        },
        assemble: function (e) {
            var i = e.parent();
            if (!i.parent().hasClass("carousel")) {
                i.after('<div id="foundationClearingHolder"></div>');
                var n = i.detach(), s = "";
                if (null != n[0]) {
                    s = n[0].outerHTML;
                    var o = this.S("#foundationClearingHolder"), r = i.data(this.attr_name(!0) + "-init"),
                        a = {grid: '<div class="carousel">' + s + "</div>", viewing: r.templates.viewing},
                        l = '<div class="clearing-assembled"><div>' + a.viewing + a.grid + "</div></div>",
                        h = this.settings.touch_label;
                    Modernizr.touch && (l = t(l).find(".clearing-touch-label").html(h).end()), o.after(l).remove()
                }
            }
        },
        open: function (e, n, s) {
            function o() {
                setTimeout(function () {
                    this.image_loaded(u, function () {
                        1 !== u.outerWidth() || f ? r.call(this, u) : o.call(this)
                    }.bind(this))
                }.bind(this), 100)
            }

            function r(e) {
                t(e).css("visibility", "visible"), l.css("overflow", "hidden"), h.addClass("clearing-blackout"), c.addClass("clearing-container"), d.show(), this.fix_height(s).caption(a.S(".clearing-caption", d), a.S("img", s)).center_and_label(e, p).shift(n, s, function () {
                    s.closest("li").siblings().removeClass("visible"), s.closest("li").addClass("visible")
                }), d.trigger("opened.fndtn.clearing")
            }

            var a = this, l = t(i.body), h = s.closest(".clearing-assembled"), c = a.S("div", h).first(),
                d = a.S(".visible-img", c), u = a.S("img", d).not(e), p = a.S(".clearing-touch-label", c), f = !1;
            t("body").on("touchmove", function (t) {
                t.preventDefault()
            }), u.error(function () {
                f = !0
            }), this.locked() || (d.trigger("open.fndtn.clearing"), u.attr("src", this.load(e)).css("visibility", "hidden"), o.call(this))
        },
        close: function (e, n) {
            e.preventDefault();
            var s, o, r = function (t) {
                return /blackout/.test(t.selector) ? t : t.closest(".clearing-blackout")
            }(t(n)), a = t(i.body);
            return n === e.target && r && (a.css("overflow", ""), s = t("div", r).first(), o = t(".visible-img", s), o.trigger("close.fndtn.clearing"), this.settings.prev_index = 0, t("ul[" + this.attr_name() + "]", r).attr("style", "").closest(".clearing-blackout").removeClass("clearing-blackout"), s.removeClass("clearing-container"), o.hide(), o.trigger("closed.fndtn.clearing")), t("body").off("touchmove"), !1
        },
        is_open: function (t) {
            return t.parent().prop("style").length > 0
        },
        keydown: function (e) {
            var i = t(".clearing-blackout ul[" + this.attr_name() + "]"), n = this.rtl ? 37 : 39,
                s = this.rtl ? 39 : 37;
            e.which === n && this.go(i, "next"), e.which === s && this.go(i, "prev"), 27 === e.which && this.S("a.clearing-close").trigger("click").trigger("click.fndtn.clearing")
        },
        nav: function (e, i) {
            var n = t("ul[" + this.attr_name() + "]", ".clearing-blackout");
            e.preventDefault(), this.go(n, i)
        },
        resize: function () {
            var e = t("img", ".clearing-blackout .visible-img"), i = t(".clearing-touch-label", ".clearing-blackout");
            e.length && (this.center_and_label(e, i), e.trigger("resized.fndtn.clearing"))
        },
        fix_height: function (t) {
            var e = t.parent().children(), i = this;
            return e.each(function () {
                var t = i.S(this), e = t.find("img");
                t.height() > e.outerHeight() && t.addClass("fix-height")
            }).closest("ul").width(100 * e.length + "%"), this
        },
        update_paddles: function (t) {
            t = t.closest("li");
            var e = t.closest(".carousel").siblings(".visible-img");
            t.next().length > 0 ? this.S(".clearing-main-next", e).removeClass("disabled") : this.S(".clearing-main-next", e).addClass("disabled"), t.prev().length > 0 ? this.S(".clearing-main-prev", e).removeClass("disabled") : this.S(".clearing-main-prev", e).addClass("disabled")
        },
        center_and_label: function (t, e) {
            return this.rtl ? (t.css({
                marginRight: -t.outerWidth() / 2,
                marginTop: -t.outerHeight() / 2,
                left: "auto",
                right: "50%"
            }), e.length > 0 && e.css({
                marginRight: -e.outerWidth() / 2,
                marginTop: -t.outerHeight() / 2 - e.outerHeight() - 10,
                left: "auto",
                right: "50%"
            })) : (t.css({
                marginLeft: -t.outerWidth() / 2,
                marginTop: -t.outerHeight() / 2
            }), e.length > 0 && e.css({
                marginLeft: -e.outerWidth() / 2,
                marginTop: -t.outerHeight() / 2 - e.outerHeight() - 10
            })), this
        },
        load: function (t) {
            var e;
            return e = "A" === t[0].nodeName ? t.attr("href") : t.closest("a").attr("href"), this.preload(t), e || t.attr("src")
        },
        preload: function (t) {
            this.img(t.closest("li").next()).img(t.closest("li").prev())
        },
        img: function (t) {
            if (t.length) {
                var e = new Image, i = this.S("a", t);
                i.length ? e.src = i.attr("href") : e.src = this.S("img", t).attr("src")
            }
            return this
        },
        caption: function (t, e) {
            var i = e.attr("data-caption");
            return i ? t.html(i).show() : t.text("").hide(), this
        },
        go: function (t, e) {
            var i = this.S(".visible", t), n = i[e]();
            this.settings.skip_selector && 0 != n.find(this.settings.skip_selector).length && (n = n[e]()), n.length && this.S("img", n).trigger("click", [i, n]).trigger("click.fndtn.clearing", [i, n]).trigger("change.fndtn.clearing")
        },
        shift: function (t, e, i) {
            var n, s = e.parent(), o = this.settings.prev_index || e.index(), r = this.direction(s, t, e),
                a = this.rtl ? "right" : "left", l = parseInt(s.css("left"), 10), h = e.outerWidth(), c = {};
            e.index() === o || /skip/.test(r) ? /skip/.test(r) && (n = e.index() - this.settings.up_count, this.lock(), n > 0 ? (c[a] = -n * h, s.animate(c, 300, this.unlock())) : (c[a] = 0, s.animate(c, 300, this.unlock()))) : /left/.test(r) ? (this.lock(), c[a] = l + h, s.animate(c, 300, this.unlock())) : /right/.test(r) && (this.lock(), c[a] = l - h, s.animate(c, 300, this.unlock())), i()
        },
        direction: function (t, e, i) {
            var n, s = this.S("li", t), o = s.outerWidth() + s.outerWidth() / 4,
                r = Math.floor(this.S(".clearing-container").outerWidth() / o) - 1, a = s.index(i);
            return this.settings.up_count = r, n = this.adjacent(this.settings.prev_index, a) ? a > r && a > this.settings.prev_index ? "right" : a > r - 1 && a <= this.settings.prev_index && "left" : "skip", this.settings.prev_index = a, n
        },
        adjacent: function (t, e) {
            for (var i = e + 1; i >= e - 1; i--) if (i === t) return !0;
            return !1
        },
        lock: function () {
            this.settings.locked = !0
        },
        unlock: function () {
            this.settings.locked = !1
        },
        locked: function () {
            return this.settings.locked
        },
        off: function () {
            this.S(this.scope).off(".fndtn.clearing"), this.S(e).off(".fndtn.clearing")
        },
        reflow: function () {
            this.init()
        }
    }
}(jQuery, window, window.document), function (t, e, i, n) {
    "use strict";
    var s = function () {
    }, o = function (s, o) {
        if (s.hasClass(o.slides_container_class)) return this;
        var h, c, d, u, p, f, g = this, m = s, v = 0, y = !1;
        g.slides = function () {
            return m.children(o.slide_selector)
        }, g.slides().first().addClass(o.active_slide_class), g.update_slide_number = function (e) {
            o.slide_number && (c.find("span:first").text(parseInt(e) + 1), c.find("span:last").text(g.slides().length)), o.bullets && (d.children().removeClass(o.bullets_active_class), t(d.children().get(e)).addClass(o.bullets_active_class))
        }, g.update_active_link = function (e) {
            var i = t('[data-orbit-link="' + g.slides().eq(e).attr("data-orbit-slide") + '"]');
            i.siblings().removeClass(o.bullets_active_class), i.addClass(o.bullets_active_class)
        }, g.build_markup = function () {
            m.wrap('<div class="' + o.container_class + '"></div>'), h = m.parent(), m.addClass(o.slides_container_class), o.stack_on_small && h.addClass(o.stack_on_small_class), o.navigation_arrows && (h.append(t('<a href="#"><span></span></a>').addClass(o.prev_class)), h.append(t('<a href="#"><span></span></a>').addClass(o.next_class))), o.timer && (u = t("<div>").addClass(o.timer_container_class), u.append("<span>"), u.append(t("<div>").addClass(o.timer_progress_class)), u.addClass(o.timer_paused_class), h.append(u)), o.slide_number && (c = t("<div>").addClass(o.slide_number_class), c.append("<span></span> " + o.slide_number_text + " <span></span>"), h.append(c)), o.bullets && (d = t("<ol>").addClass(o.bullets_container_class), h.append(d), d.wrap('<div class="orbit-bullets-container"></div>'), g.slides().each(function (e) {
                var i = t("<li>").attr("data-orbit-slide", e).on("click", g.link_bullet);
                d.append(i)
            }))
        }, g._goto = function (e, i) {
            if (e === v) return !1;
            "object" == typeof f && f.restart();
            var n = g.slides(), s = "next";
            if (y = !0, e < v && (s = "prev"), e >= n.length) {
                if (!o.circular) return !1;
                e = 0
            } else if (e < 0) {
                if (!o.circular) return !1;
                e = n.length - 1
            }
            var r = t(n.get(v)), a = t(n.get(e));
            r.css("zIndex", 2), r.removeClass(o.active_slide_class), a.css("zIndex", 4).addClass(o.active_slide_class), m.trigger("before-slide-change.fndtn.orbit"), o.before_slide_change(), g.update_active_link(e);
            var l = function () {
                var t = function () {
                    v = e, y = !1, !0 === i && (f = g.create_timer(), f.start()), g.update_slide_number(v), m.trigger("after-slide-change.fndtn.orbit", [{
                        slide_number: v,
                        total_slides: n.length
                    }]), o.after_slide_change(v, n.length)
                };
                m.height() != a.height() && o.variable_height ? m.animate({height: a.height()}, 250, "linear", t) : t()
            };
            if (1 === n.length) return l(), !1;
            var h = function () {
                "next" === s && p.next(r, a, l), "prev" === s && p.prev(r, a, l)
            };
            a.height() > m.height() && o.variable_height ? m.animate({height: a.height()}, 250, "linear", h) : h()
        }, g.next = function (t) {
            t.stopImmediatePropagation(), t.preventDefault(), g._goto(v + 1)
        }, g.prev = function (t) {
            t.stopImmediatePropagation(), t.preventDefault(), g._goto(v - 1)
        }, g.link_custom = function (e) {
            e.preventDefault();
            var i = t(this).attr("data-orbit-link");
            if ("string" == typeof i && "" != (i = t.trim(i))) {
                var n = h.find("[data-orbit-slide=" + i + "]");
                -1 != n.index() && g._goto(n.index())
            }
        }, g.link_bullet = function () {
            var e = t(this).attr("data-orbit-slide");
            if ("string" == typeof e && "" != (e = t.trim(e))) if (isNaN(parseInt(e))) {
                var i = h.find("[data-orbit-slide=" + e + "]");
                -1 != i.index() && g._goto(i.index() + 1)
            } else g._goto(parseInt(e))
        }, g.timer_callback = function () {
            g._goto(v + 1, !0)
        }, g.compute_dimensions = function () {
            var e = t(g.slides().get(v)), i = e.height();
            o.variable_height || g.slides().each(function () {
                t(this).height() > i && (i = t(this).height())
            }), m.height(i)
        }, g.create_timer = function () {
            return new r(h.find("." + o.timer_container_class), o, g.timer_callback)
        }, g.stop_timer = function () {
            "object" == typeof f && f.stop()
        }, g.toggle_timer = function () {
            h.find("." + o.timer_container_class).hasClass(o.timer_paused_class) ? (void 0 === f && (f = g.create_timer()), f.start()) : "object" == typeof f && f.stop()
        }, g.init = function () {
            g.build_markup(), o.timer && (f = g.create_timer(), Foundation.utils.image_loaded(this.slides().children("img"), f.start)), p = new l(o, m), "slide" === o.animation && (p = new a(o, m)), h.on("click", "." + o.next_class, g.next), h.on("click", "." + o.prev_class, g.prev), o.next_on_click && h.on("click", "." + o.slides_container_class + " [data-orbit-slide]", g.link_bullet), h.on("click", g.toggle_timer), o.swipe && h.on("touchstart.fndtn.orbit", function (t) {
                t.touches || (t = t.originalEvent);
                var e = {
                    start_page_x: t.touches[0].pageX,
                    start_page_y: t.touches[0].pageY,
                    start_time: (new Date).getTime(),
                    delta_x: 0,
                    is_scrolling: n
                };
                h.data("swipe-transition", e), t.stopPropagation()
            }).on("touchmove.fndtn.orbit", function (t) {
                if (t.touches || (t = t.originalEvent), !(t.touches.length > 1 || t.scale && 1 !== t.scale)) {
                    var e = h.data("swipe-transition");
                    if (void 0 === e && (e = {}), e.delta_x = t.touches[0].pageX - e.start_page_x, "undefined" == typeof e.is_scrolling && (e.is_scrolling = !!(e.is_scrolling || Math.abs(e.delta_x) < Math.abs(t.touches[0].pageY - e.start_page_y))), !e.is_scrolling && !e.active) {
                        t.preventDefault();
                        var i = e.delta_x < 0 ? v + 1 : v - 1;
                        e.active = !0, g._goto(i)
                    }
                }
            }).on("touchend.fndtn.orbit", function (t) {
                h.data("swipe-transition", {}), t.stopPropagation()
            }), h.on("mouseenter.fndtn.orbit", function () {
                o.timer && o.pause_on_hover && g.stop_timer()
            }).on("mouseleave.fndtn.orbit", function () {
                o.timer && o.resume_on_mouseout && f.start()
            }), t(i).on("click", "[data-orbit-link]", g.link_custom), t(e).on("load resize", g.compute_dimensions), Foundation.utils.image_loaded(this.slides().children("img"), g.compute_dimensions), Foundation.utils.image_loaded(this.slides().children("img"), function () {
                h.prev("." + o.preloader_class).css("display", "none"), g.update_slide_number(0), g.update_active_link(0), m.trigger("ready.fndtn.orbit")
            })
        }, g.init()
    }, r = function (t, e, i) {
        var n, s, o = this, r = e.timer_speed, a = t.find("." + e.timer_progress_class), l = -1;
        this.update_progress = function (t) {
            var e = a.clone();
            e.attr("style", ""), e.css("width", t + "%"), a.replaceWith(e), a = e
        }, this.restart = function () {
            clearTimeout(s), t.addClass(e.timer_paused_class), l = -1, o.update_progress(0)
        }, this.start = function () {
            if (!t.hasClass(e.timer_paused_class)) return !0;
            l = -1 === l ? r : l, t.removeClass(e.timer_paused_class), n = (new Date).getTime(), a.animate({width: "100%"}, l, "linear"), s = setTimeout(function () {
                o.restart(), i()
            }, l), t.trigger("timer-started.fndtn.orbit")
        }, this.stop = function () {
            if (t.hasClass(e.timer_paused_class)) return !0;
            clearTimeout(s), t.addClass(e.timer_paused_class);
            var i = (new Date).getTime();
            l -= i - n;
            var a = 100 - l / r * 100;
            o.update_progress(a), t.trigger("timer-stopped.fndtn.orbit")
        }
    }, a = function (e) {
        var i = e.animation_speed, n = 1 === t("html[dir=rtl]").length, s = n ? "marginRight" : "marginLeft", o = {};
        o[s] = "0%", this.next = function (t, e, n) {
            t.animate({marginLeft: "-100%"}, i), e.animate(o, i, function () {
                t.css(s, "100%"), n()
            })
        }, this.prev = function (t, e, n) {
            t.animate({marginLeft: "100%"}, i), e.css(s, "-100%"), e.animate(o, i, function () {
                t.css(s, "100%"), n()
            })
        }
    }, l = function (e) {
        var i = e.animation_speed;
        t("html[dir=rtl]").length;
        this.next = function (t, e, n) {
            e.css({margin: "0%", opacity: "0.01"}), e.animate({opacity: "1"}, i, "linear", function () {
                t.css("margin", "100%"), n()
            })
        }, this.prev = function (t, e, n) {
            e.css({margin: "0%", opacity: "0.01"}), e.animate({opacity: "1"}, i, "linear", function () {
                t.css("margin", "100%"), n()
            })
        }
    };
    Foundation.libs = Foundation.libs || {}, Foundation.libs.orbit = {
        name: "orbit",
        version: "5.5.0",
        settings: {
            animation: "slide",
            timer_speed: 1e4,
            pause_on_hover: !0,
            resume_on_mouseout: !1,
            next_on_click: !0,
            animation_speed: 500,
            stack_on_small: !1,
            navigation_arrows: !0,
            slide_number: !0,
            slide_number_text: "of",
            container_class: "orbit-container",
            stack_on_small_class: "orbit-stack-on-small",
            next_class: "orbit-next",
            prev_class: "orbit-prev",
            timer_container_class: "orbit-timer",
            timer_paused_class: "paused",
            timer_progress_class: "orbit-progress",
            slides_container_class: "orbit-slides-container",
            preloader_class: "preloader",
            slide_selector: "*",
            bullets_container_class: "orbit-bullets",
            bullets_active_class: "active",
            slide_number_class: "orbit-slide-number",
            caption_class: "orbit-caption",
            active_slide_class: "active",
            orbit_transition_class: "orbit-transitioning",
            bullets: !0,
            circular: !0,
            timer: !0,
            variable_height: !1,
            swipe: !0,
            before_slide_change: s,
            after_slide_change: s
        },
        init: function (t, e, i) {
            this.bindings(e, i)
        },
        events: function (t) {
            var e = new o(this.S(t), this.S(t).data("orbit-init"));
            this.S(t).data(this.name + "-instance", e)
        },
        reflow: function () {
            var t = this;
            if (t.S(t.scope).is("[data-orbit]")) {
                t.S(t.scope).data(t.name + "-instance").compute_dimensions()
            } else t.S("[data-orbit]", t.scope).each(function (e, i) {
                var n = t.S(i);
                t.data_options(n);
                n.data(t.name + "-instance").compute_dimensions()
            })
        }
    }
}(jQuery, window, window.document), function (t) {
    "use strict";
    Foundation.libs.offcanvas = {
        name: "offcanvas",
        version: "5.5.0",
        settings: {open_method: "move", close_on_click: !1},
        init: function (t, e, i) {
            this.bindings(e, i)
        },
        events: function () {
            var e = this, i = e.S, n = "", s = "", o = "";
            "move" === this.settings.open_method ? (n = "move-", s = "right", o = "left") : "overlap_single" === this.settings.open_method ? (n = "offcanvas-overlap-", s = "right", o = "left") : "overlap" === this.settings.open_method && (n = "offcanvas-overlap"), i(this.scope).off(".offcanvas").on("click.fndtn.offcanvas", ".left-off-canvas-toggle", function (o) {
                e.click_toggle_class(o, n + s), "overlap" !== e.settings.open_method && i(".left-submenu").removeClass(n + s), t(".left-off-canvas-toggle").attr("aria-expanded", "true")
            }).on("click.fndtn.offcanvas", ".left-off-canvas-menu a", function (o) {
                var r = e.get_settings(o), a = i(this).parent();
                !r.close_on_click || a.hasClass("has-submenu") || a.hasClass("back") ? i(this).parent().hasClass("has-submenu") ? (o.preventDefault(), i(this).siblings(".left-submenu").toggleClass(n + s)) : a.hasClass("back") && (o.preventDefault(), a.parent().removeClass(n + s)) : (e.hide.call(e, n + s, e.get_wrapper(o)), a.parent().removeClass(n + s)), t(".left-off-canvas-toggle").attr("aria-expanded", "true")
            }).on("click.fndtn.offcanvas", ".right-off-canvas-toggle", function (s) {
                e.click_toggle_class(s, n + o), "overlap" !== e.settings.open_method && i(".right-submenu").removeClass(n + o), t(".right-off-canvas-toggle").attr("aria-expanded", "true")
            }).on("click.fndtn.offcanvas", ".right-off-canvas-menu a", function (s) {
                var r = e.get_settings(s), a = i(this).parent();
                !r.close_on_click || a.hasClass("has-submenu") || a.hasClass("back") ? i(this).parent().hasClass("has-submenu") ? (s.preventDefault(), i(this).siblings(".right-submenu").toggleClass(n + o)) : a.hasClass("back") && (s.preventDefault(), a.parent().removeClass(n + o)) : (e.hide.call(e, n + o, e.get_wrapper(s)), a.parent().removeClass(n + o)), t(".right-off-canvas-toggle").attr("aria-expanded", "true")
            }).on("click.fndtn.offcanvas", ".exit-off-canvas", function (r) {
                e.click_remove_class(r, n + o), i(".right-submenu").removeClass(n + o), s && (e.click_remove_class(r, n + s), i(".left-submenu").removeClass(n + o)), t(".right-off-canvas-toggle").attr("aria-expanded", "true")
            }).on("click.fndtn.offcanvas", ".exit-off-canvas", function (i) {
                e.click_remove_class(i, n + o), t(".left-off-canvas-toggle").attr("aria-expanded", "false"), s && (e.click_remove_class(i, n + s), t(".right-off-canvas-toggle").attr("aria-expanded", "false"))
            })
        },
        toggle: function (t, e) {
            e = e || this.get_wrapper(), e.is("." + t) ? this.hide(t, e) : this.show(t, e)
        },
        show: function (t, e) {
            e = e || this.get_wrapper(), e.trigger("open").trigger("open.fndtn.offcanvas"), e.addClass(t)
        },
        hide: function (t, e) {
            e = e || this.get_wrapper(), e.trigger("close").trigger("close.fndtn.offcanvas"), e.removeClass(t)
        },
        click_toggle_class: function (t, e) {
            t.preventDefault();
            var i = this.get_wrapper(t);
            this.toggle(e, i)
        },
        click_remove_class: function (t, e) {
            t.preventDefault()
            ;var i = this.get_wrapper(t);
            this.hide(e, i)
        },
        get_settings: function (t) {
            return this.S(t.target).closest("[" + this.attr_name() + "]").data(this.attr_name(!0) + "-init") || this.settings
        },
        get_wrapper: function (t) {
            var e = this.S(t ? t.target : this.scope).closest(".off-canvas-wrap");
            return 0 === e.length && (e = this.S(".off-canvas-wrap")), e
        },
        reflow: function () {
        }
    }
}(jQuery, window, window.document), function (t) {
    "use strict";
    Foundation.libs.alert = {
        name: "alert", version: "5.5.0", settings: {
            callback: function () {
            }
        }, init: function (t, e, i) {
            this.bindings(e, i)
        }, events: function () {
            var e = this, i = this.S;
            t(this.scope).off(".alert").on("click.fndtn.alert", "[" + this.attr_name() + "] .close", function (t) {
                var n = i(this).closest("[" + e.attr_name() + "]"), s = n.data(e.attr_name(!0) + "-init") || e.settings;
                t.preventDefault(), Modernizr.csstransitions ? (n.addClass("alert-close"), n.on("transitionend webkitTransitionEnd oTransitionEnd", function () {
                    i(this).trigger("close").trigger("close.fndtn.alert").remove(), s.callback()
                })) : n.fadeOut(300, function () {
                    i(this).trigger("close").trigger("close.fndtn.alert").remove(), s.callback()
                })
            })
        }, reflow: function () {
        }
    }
}(jQuery, window, window.document), function (t, e, i, n) {
    "use strict";

    function s(t) {
        var e = /fade/i.test(t), i = /pop/i.test(t);
        return {animate: e || i, pop: i, fade: e}
    }

    Foundation.libs.reveal = {
        name: "reveal",
        version: "5.5.0",
        locked: !1,
        settings: {
            animation: "fadeAndPop",
            animation_speed: 250,
            close_on_background_click: !0,
            close_on_esc: !0,
            dismiss_modal_class: "close-reveal-modal",
            bg_class: "reveal-modal-bg",
            bg_root_element: "body",
            root_element: "body",
            open: function () {
            },
            opened: function () {
            },
            close: function () {
            },
            closed: function () {
            },
            bg: t(".reveal-modal-bg"),
            css: {
                open: {opacity: 0, visibility: "visible", display: "block"},
                close: {opacity: 1, visibility: "hidden", display: "none"}
            }
        },
        init: function (e, i, n) {
            t.extend(!0, this.settings, i, n), this.bindings(i, n)
        },
        events: function () {
            var t = this, e = t.S;
            return e(this.scope).off(".reveal").on("click.fndtn.reveal", "[" + this.add_namespace("data-reveal-id") + "]:not([disabled])", function (i) {
                if (i.preventDefault(), !t.locked) {
                    var n = e(this), s = n.data(t.data_attr("reveal-ajax"));
                    if (t.locked = !0, void 0 === s) t.open.call(t, n); else {
                        var o = !0 === s ? n.attr("href") : s;
                        t.open.call(t, n, {url: o})
                    }
                }
            }), e(i).on("click.fndtn.reveal", this.close_targets(), function (i) {
                if (i.preventDefault(), !t.locked) {
                    var n = e("[" + t.attr_name() + "].open").data(t.attr_name(!0) + "-init") || t.settings,
                        s = e(i.target)[0] === e("." + n.bg_class)[0];
                    if (s) {
                        if (!n.close_on_background_click) return;
                        i.stopPropagation()
                    }
                    t.locked = !0, t.close.call(t, s ? e("[" + t.attr_name() + "].open") : e(this).closest("[" + t.attr_name() + "]"))
                }
            }), e("[" + t.attr_name() + "]", this.scope).length > 0 ? e(this.scope).on("open.fndtn.reveal", this.settings.open).on("opened.fndtn.reveal", this.settings.opened).on("opened.fndtn.reveal", this.open_video).on("close.fndtn.reveal", this.settings.close).on("closed.fndtn.reveal", this.settings.closed).on("closed.fndtn.reveal", this.close_video) : e(this.scope).on("open.fndtn.reveal", "[" + t.attr_name() + "]", this.settings.open).on("opened.fndtn.reveal", "[" + t.attr_name() + "]", this.settings.opened).on("opened.fndtn.reveal", "[" + t.attr_name() + "]", this.open_video).on("close.fndtn.reveal", "[" + t.attr_name() + "]", this.settings.close).on("closed.fndtn.reveal", "[" + t.attr_name() + "]", this.settings.closed).on("closed.fndtn.reveal", "[" + t.attr_name() + "]", this.close_video), !0
        },
        key_up_on: function () {
            var t = this;
            return t.S("body").off("keyup.fndtn.reveal").on("keyup.fndtn.reveal", function (e) {
                var i = t.S("[" + t.attr_name() + "].open"), n = i.data(t.attr_name(!0) + "-init") || t.settings;
                n && 27 === e.which && n.close_on_esc && !t.locked && t.close.call(t, i)
            }), !0
        },
        key_up_off: function () {
            return this.S("body").off("keyup.fndtn.reveal"), !0
        },
        open: function (i, n) {
            var s, o = this;
            i ? "undefined" != typeof i.selector ? s = o.S("#" + i.data(o.data_attr("reveal-id"))).first() : (s = o.S(this.scope), n = i) : s = o.S(this.scope);
            var r = s.data(o.attr_name(!0) + "-init");
            if (r = r || this.settings, s.hasClass("open") && i.attr("data-reveal-id") == s.attr("id")) return o.close(s);
            if (!s.hasClass("open")) {
                var a = o.S("[" + o.attr_name() + "].open");
                if (void 0 === s.data("css-top") && s.data("css-top", parseInt(s.css("top"), 10)).data("offset", this.cache_offset(s)), this.key_up_on(s), s.trigger("open").trigger("open.fndtn.reveal"), a.length < 1 && this.toggle_bg(s, !0), "string" == typeof n && (n = {url: n}), void 0 !== n && n.url) {
                    var l = "undefined" != typeof n.success ? n.success : null;
                    t.extend(n, {
                        success: function (e, i, n) {
                            if (t.isFunction(l)) {
                                var h = l(e, i, n);
                                "string" == typeof h && (e = h)
                            }
                            s.html(e), o.S(s).foundation("section", "reflow"), o.S(s).children().foundation(), a.length > 0 && o.hide(a, r.css.close), o.show(s, r.css.open)
                        }
                    }), t.ajax(n)
                } else a.length > 0 && this.hide(a, r.css.close), this.show(s, r.css.open)
            }
            o.S(e).trigger("resize")
        },
        close: function (t) {
            var t = t && t.length ? t : this.S(this.scope), e = this.S("[" + this.attr_name() + "].open"),
                i = t.data(this.attr_name(!0) + "-init") || this.settings;
            e.length > 0 && (this.locked = !0, this.key_up_off(t), t.trigger("close").trigger("close.fndtn.reveal"), this.toggle_bg(t, !1), this.hide(e, i.css.close, i))
        },
        close_targets: function () {
            var t = "." + this.settings.dismiss_modal_class;
            return this.settings.close_on_background_click ? t + ", ." + this.settings.bg_class : t
        },
        toggle_bg: function (e, i, s) {
            var o = e.data(this.attr_name(!0) + "-init") || this.settings, r = o.bg_root_element;
            0 === this.S("." + this.settings.bg_class).length && (this.settings.bg = t("<div />", {"class": this.settings.bg_class}).appendTo(r).hide());
            var a = this.settings.bg.filter(":visible").length > 0;
            s != a && ((s == n ? a : !s) ? this.hide(this.settings.bg) : this.show(this.settings.bg))
        },
        show: function (i, n) {
            if (n) {
                var o = i.data(this.attr_name(!0) + "-init") || this.settings, r = o.root_element;
                if (0 === i.parent(r).length) {
                    var a = i.wrap('<div style="display: none;" />').parent();
                    i.on("closed.fndtn.reveal.wrapped", function () {
                        i.detach().appendTo(a), i.unwrap().unbind("closed.fndtn.reveal.wrapped")
                    }), i.detach().appendTo(r)
                }
                var l = s(o.animation);
                if (l.animate || (this.locked = !1), l.pop) {
                    n.top = t(e).scrollTop() - i.data("offset") + "px";
                    var h = {top: t(e).scrollTop() + i.data("css-top") + "px", opacity: 1};
                    return setTimeout(function () {
                        return i.css(n).animate(h, o.animation_speed, "linear", function () {
                            this.locked = !1, i.trigger("opened").trigger("opened.fndtn.reveal")
                        }.bind(this)).addClass("open")
                    }.bind(this), o.animation_speed / 2)
                }
                if (l.fade) {
                    n.top = t(r).scrollTop() + i.data("css-top") + "px";
                    var h = {opacity: 1};
                    return setTimeout(function () {
                        return i.css(n).animate(h, o.animation_speed, "linear", function () {
                            this.locked = !1, i.trigger("opened").trigger("opened.fndtn.reveal")
                        }.bind(this)).addClass("open")
                    }.bind(this), o.animation_speed / 2)
                }
                return i.css(n).show().css({opacity: 1}).addClass("open").trigger("opened").trigger("opened.fndtn.reveal")
            }
            var o = this.settings;
            return s(o.animation).fade ? i.fadeIn(o.animation_speed / 2) : (this.locked = !1, i.show())
        },
        hide: function (e, i) {
            if (i) {
                var n = e.data(this.attr_name(!0) + "-init") || this.settings, o = n.root_element, r = s(n.animation);
                if (r.animate || (this.locked = !1), r.pop) {
                    var a = {top: -t(o).scrollTop() - e.data("offset") + "px", opacity: 0};
                    return setTimeout(function () {
                        return e.animate(a, n.animation_speed, "linear", function () {
                            this.locked = !1, e.css(i).trigger("closed").trigger("closed.fndtn.reveal")
                        }.bind(this)).removeClass("open")
                    }.bind(this), n.animation_speed / 2)
                }
                if (r.fade) {
                    var a = {opacity: 0};
                    return setTimeout(function () {
                        return e.animate(a, n.animation_speed, "linear", function () {
                            this.locked = !1, e.css(i).trigger("closed").trigger("closed.fndtn.reveal")
                        }.bind(this)).removeClass("open")
                    }.bind(this), n.animation_speed / 2)
                }
                return e.hide().css(i).removeClass("open").trigger("closed").trigger("closed.fndtn.reveal")
            }
            var n = this.settings;
            return s(n.animation).fade ? e.fadeOut(n.animation_speed / 2) : e.hide()
        },
        close_video: function (e) {
            var i = t(".flex-video", e.target), n = t("iframe", i);
            n.length > 0 && (n.attr("data-src", n[0].src), n.attr("src", n.attr("src")), i.hide())
        },
        open_video: function (e) {
            var i = t(".flex-video", e.target), s = i.find("iframe");
            if (s.length > 0) {
                if ("string" == typeof s.attr("data-src")) s[0].src = s.attr("data-src"); else {
                    var o = s[0].src;
                    s[0].src = n, s[0].src = o
                }
                i.show()
            }
        },
        data_attr: function (t) {
            return this.namespace.length > 0 ? this.namespace + "-" + t : t
        },
        cache_offset: function (t) {
            var e = t.show().height() + parseInt(t.css("top"), 10);
            return t.hide(), e
        },
        off: function () {
            t(this.scope).off(".fndtn.reveal")
        },
        reflow: function () {
        }
    }
}(jQuery, window, window.document), function (t, e) {
    "use strict";
    Foundation.libs.interchange = {
        name: "interchange",
        version: "5.5.0",
        cache: {},
        images_loaded: !1,
        nodes_loaded: !1,
        settings: {
            load_attr: "interchange",
            named_queries: {
                "default": "only screen",
                small: Foundation.media_queries.small,
                "small-only": Foundation.media_queries["small-only"],
                medium: Foundation.media_queries.medium,
                "medium-only": Foundation.media_queries["medium-only"],
                large: Foundation.media_queries.large,
                "large-only": Foundation.media_queries["large-only"],
                xlarge: Foundation.media_queries.xlarge,
                "xlarge-only": Foundation.media_queries["xlarge-only"],
                xxlarge: Foundation.media_queries.xxlarge,
                landscape: "only screen and (orientation: landscape)",
                portrait: "only screen and (orientation: portrait)",
                retina: "only screen and (-webkit-min-device-pixel-ratio: 2),only screen and (min--moz-device-pixel-ratio: 2),only screen and (-o-min-device-pixel-ratio: 2/1),only screen and (min-device-pixel-ratio: 2),only screen and (min-resolution: 192dpi),only screen and (min-resolution: 2dppx)"
            },
            directives: {
                replace: function (e, i, n) {
                    if (/IMG/.test(e[0].nodeName)) {
                        var s = e[0].src;
                        if (new RegExp(i, "i").test(s)) return;
                        return e[0].src = i, n(e[0].src)
                    }
                    var o = this;
                    if (e.data(this.data_attr + "-last-path") != i) return /\.(gif|jpg|jpeg|tiff|png)([?#].*)?/i.test(i) ? (t(e).css("background-image", "url(" + i + ")"), e.data("interchange-last-path", i), n(i)) : t.get(i, function (t) {
                        e.html(t), e.data(o.data_attr + "-last-path", i), n()
                    })
                }
            }
        },
        init: function (e, i, n) {
            Foundation.inherit(this, "throttle random_str"), this.data_attr = this.set_data_attr(), t.extend(!0, this.settings, i, n), this.bindings(i, n), this.load("images"), this.load("nodes")
        },
        get_media_hash: function () {
            var t = "";
            for (var e in this.settings.named_queries) t += matchMedia(this.settings.named_queries[e]).matches.toString();
            return t
        },
        events: function () {
            var i, n = this;
            return t(e).off(".interchange").on("resize.fndtn.interchange", n.throttle(function () {
                var t = n.get_media_hash();
                t !== i && n.resize(), i = t
            }, 50)), this
        },
        resize: function () {
            var e = this.cache;
            if (!this.images_loaded || !this.nodes_loaded) return void setTimeout(t.proxy(this.resize, this), 50);
            for (var i in e) if (e.hasOwnProperty(i)) {
                var n = this.results(i, e[i]);
                n && this.settings.directives[n.scenario[1]].call(this, n.el, n.scenario[0], function () {
                    if (arguments[0] instanceof Array) var t = arguments[0]; else var t = Array.prototype.slice.call(arguments, 0);
                    n.el.trigger(n.scenario[1], t)
                })
            }
        },
        results: function (t, e) {
            var i = e.length;
            if (i > 0) for (var n = this.S("[" + this.add_namespace("data-uuid") + '="' + t + '"]'); i--;) {
                var s, o = e[i][2];
                if (s = this.settings.named_queries.hasOwnProperty(o) ? matchMedia(this.settings.named_queries[o]) : matchMedia(o), s.matches) return {
                    el: n,
                    scenario: e[i]
                }
            }
            return !1
        },
        load: function (t, e) {
            return ("undefined" == typeof this["cached_" + t] || e) && this["update_" + t](), this["cached_" + t]
        },
        update_images: function () {
            var t = this.S("img[" + this.data_attr + "]"), e = t.length, i = e, n = 0, s = this.data_attr;
            for (this.cache = {}, this.cached_images = [], this.images_loaded = 0 === e; i--;) {
                if (n++, t[i]) {
                    (t[i].getAttribute(s) || "").length > 0 && this.cached_images.push(t[i])
                }
                n === e && (this.images_loaded = !0, this.enhance("images"))
            }
            return this
        },
        update_nodes: function () {
            var t = this.S("[" + this.data_attr + "]").not("img"), e = t.length, i = e, n = 0, s = this.data_attr;
            for (this.cached_nodes = [], this.nodes_loaded = 0 === e; i--;) {
                n++;
                (t[i].getAttribute(s) || "").length > 0 && this.cached_nodes.push(t[i]), n === e && (this.nodes_loaded = !0, this.enhance("nodes"))
            }
            return this
        },
        enhance: function (i) {
            for (var n = this["cached_" + i].length; n--;) this.object(t(this["cached_" + i][n]));
            return t(e).trigger("resize").trigger("resize.fndtn.interchange")
        },
        convert_directive: function (t) {
            var e = this.trim(t);
            return e.length > 0 ? e : "replace"
        },
        parse_scenario: function (t) {
            var e = t[0].match(/(.+),\s*(\w+)\s*$/), i = t[1];
            if (e) var n = e[1], s = e[2]; else var o = t[0].split(/,\s*$/), n = o[0], s = "";
            return [this.trim(n), this.convert_directive(s), this.trim(i)]
        },
        object: function (t) {
            var e = this.parse_data_attr(t), i = [], n = e.length;
            if (n > 0) for (; n--;) {
                var s = e[n].split(/\((.*?)(\))$/);
                if (s.length > 1) {
                    var o = this.parse_scenario(s);
                    i.push(o)
                }
            }
            return this.store(t, i)
        },
        store: function (t, e) {
            var i = this.random_str(), n = t.data(this.add_namespace("uuid", !0));
            return this.cache[n] ? this.cache[n] : (t.attr(this.add_namespace("data-uuid"), i), this.cache[i] = e)
        },
        trim: function (e) {
            return "string" == typeof e ? t.trim(e) : e
        },
        set_data_attr: function (t) {
            return t ? this.namespace.length > 0 ? this.namespace + "-" + this.settings.load_attr : this.settings.load_attr : this.namespace.length > 0 ? "data-" + this.namespace + "-" + this.settings.load_attr : "data-" + this.settings.load_attr
        },
        parse_data_attr: function (t) {
            for (var e = t.attr(this.attr_name()).split(/\[(.*?)\]/), i = e.length, n = []; i--;) e[i].replace(/[\W\d]+/, "").length > 4 && n.push(e[i]);
            return n
        },
        reflow: function () {
            this.load("images", !0), this.load("nodes", !0)
        }
    }
}(jQuery, window, window.document), function (t, e) {
    "use strict";
    Foundation.libs["magellan-expedition"] = {
        name: "magellan-expedition",
        version: "5.5.0",
        settings: {
            active_class: "active",
            threshold: 0,
            destination_threshold: 20,
            throttle_delay: 30,
            fixed_top: 0,
            offset_by_height: !0,
            duration: 700,
            easing: "swing"
        },
        init: function (t, e, i) {
            Foundation.inherit(this, "throttle"), this.bindings(e, i)
        },
        events: function () {
            var i = this, n = i.S, s = i.settings;
            i.set_expedition_position(), n(i.scope).off(".magellan").on("click.fndtn.magellan", "[" + i.add_namespace("data-magellan-arrival") + '] a[href^="#"]', function (e) {
                e.preventDefault();
                var n = t(this).closest("[" + i.attr_name() + "]"), s = n.data("magellan-expedition-init"),
                    o = this.hash.split("#").join(""), r = t('a[name="' + o + '"]');
                0 === r.length && (r = t("#" + o));
                var a = r.offset().top - s.destination_threshold + 1;
                s.offset_by_height && (a -= n.outerHeight()), t("html, body").stop().animate({scrollTop: a}, s.duration, s.easing, function () {
                    history.pushState ? history.pushState(null, null, "#" + o) : location.hash = "#" + o
                })
            }).on("scroll.fndtn.magellan", i.throttle(this.check_for_arrivals.bind(this), s.throttle_delay)), t(e).on("resize.fndtn.magellan", i.throttle(this.set_expedition_position.bind(this), s.throttle_delay))
        },
        check_for_arrivals: function () {
            var t = this;
            t.update_arrivals(), t.update_expedition_positions()
        },
        set_expedition_position: function () {
            var e = this;
            t("[" + this.attr_name() + "=fixed]", e.scope).each(function () {
                var i, n, s = t(this), o = s.data("magellan-expedition-init"), r = s.attr("styles");
                s.attr("style", ""), i = s.offset().top + o.threshold, n = parseInt(s.data("magellan-fixed-top")), isNaN(n) || (e.settings.fixed_top = n), s.data(e.data_attr("magellan-top-offset"), i), s.attr("style", r)
            })
        },
        update_expedition_positions: function () {
            var i = this, n = t(e).scrollTop();
            t("[" + this.attr_name() + "=fixed]", i.scope).each(function () {
                var e = t(this), s = e.data("magellan-expedition-init"), o = e.attr("style"),
                    r = e.data("magellan-top-offset");
                if (n + i.settings.fixed_top >= r) {
                    var a = e.prev("[" + i.add_namespace("data-magellan-expedition-clone") + "]");
                    0 === a.length && (a = e.clone(), a.removeAttr(i.attr_name()), a.attr(i.add_namespace("data-magellan-expedition-clone"), ""), e.before(a)), e.css({
                        position: "fixed",
                        top: s.fixed_top
                    }).addClass("fixed")
                } else e.prev("[" + i.add_namespace("data-magellan-expedition-clone") + "]").remove(), e.attr("style", o).css("position", "").css("top", "").removeClass("fixed")
            })
        },
        update_arrivals: function () {
            var i = this, n = t(e).scrollTop();
            t("[" + this.attr_name() + "]", i.scope).each(function () {
                var e = t(this), s = e.data(i.attr_name(!0) + "-init"), o = i.offsets(e, n),
                    r = e.find("[" + i.add_namespace("data-magellan-arrival") + "]"), a = !1;
                o.each(function (t, n) {
                    if (n.viewport_offset >= n.top_offset) {
                        return e.find("[" + i.add_namespace("data-magellan-arrival") + "]").not(n.arrival).removeClass(s.active_class), n.arrival.addClass(s.active_class), a = !0, !0
                    }
                }), a || r.removeClass(s.active_class)
            })
        },
        offsets: function (e, i) {
            var n = this, s = e.data(n.attr_name(!0) + "-init"), o = i;
            return e.find("[" + n.add_namespace("data-magellan-arrival") + "]").map(function () {
                var i = t(this).data(n.data_attr("magellan-arrival")),
                    r = t("[" + n.add_namespace("data-magellan-destination") + "=" + i + "]");
                if (r.length > 0) {
                    var a = r.offset().top - s.destination_threshold;
                    return s.offset_by_height && (a -= e.outerHeight()), a = Math.floor(a), {
                        destination: r,
                        arrival: t(this),
                        top_offset: a,
                        viewport_offset: o
                    }
                }
            }).sort(function (t, e) {
                return t.top_offset < e.top_offset ? -1 : t.top_offset > e.top_offset ? 1 : 0
            })
        },
        data_attr: function (t) {
            return this.namespace.length > 0 ? this.namespace + "-" + t : t
        },
        off: function () {
            this.S(this.scope).off(".magellan"), this.S(e).off(".magellan")
        },
        reflow: function () {
            var e = this;
            t("[" + e.add_namespace("data-magellan-expedition-clone") + "]", e.scope).remove()
        }
    }
}(jQuery, window, window.document), function (t) {
    "use strict";
    Foundation.libs.accordion = {
        name: "accordion",
        version: "5.5.0",
        settings: {
            content_class: "content",
            active_class: "active",
            multi_expand: !0,
            toggleable: !0,
            callback: function () {
            }
        },
        init: function (t, e, i) {
            this.bindings(e, i)
        },
        events: function () {
            var e = this, i = this.S;
            i(this.scope).off(".fndtn.accordion").on("click.fndtn.accordion", "[" + this.attr_name() + "] > .accordion-navigation > a", function (n) {
                var s = i(this).closest("[" + e.attr_name() + "]"), o = e.attr_name() + "=" + s.attr(e.attr_name()),
                    r = s.data(e.attr_name(!0) + "-init") || e.settings, a = i("#" + this.href.split("#")[1]),
                    l = t("> .accordion-navigation", s), h = l.children("." + r.content_class),
                    c = h.filter("." + r.active_class);
                if (n.preventDefault(), s.attr(e.attr_name()) && (h = h.add("[" + o + "] dd > ." + r.content_class), l = l.add("[" + o + "] .accordion-navigation")), r.toggleable && a.is(c)) return a.parent(".accordion-navigation").toggleClass(r.active_class, !1), a.toggleClass(r.active_class, !1), r.callback(a), a.triggerHandler("toggled", [s]), void s.triggerHandler("toggled", [a]);
                r.multi_expand || (h.removeClass(r.active_class), l.removeClass(r.active_class)), a.addClass(r.active_class).parent().addClass(r.active_class), r.callback(a), a.triggerHandler("toggled", [s]), s.triggerHandler("toggled", [a])
            })
        },
        off: function () {
        },
        reflow: function () {
        }
    }
}(jQuery, window, window.document), function (t, e, i) {
    "use strict";
    Foundation.libs.topbar = {
        name: "topbar",
        version: "5.5.0",
        settings: {
            index: 0,
            sticky_class: "sticky",
            custom_back_text: !0,
            back_text: "Back",
            mobile_show_parent_link: !0,
            is_hover: !0,
            scrolltop: !0,
            sticky_on: "all"
        },
        init: function (e, i, n) {
            Foundation.inherit(this, "add_custom_rule register_media throttle");
            var s = this;
            s.register_media("topbar", "foundation-mq-topbar"), this.bindings(i, n), s.S("[" + this.attr_name() + "]", this.scope).each(function () {
                var e = t(this), i = e.data(s.attr_name(!0) + "-init");
                s.S("section, .top-bar-section", this);
                e.data("index", 0);
                var n = e.parent();
                n.hasClass("fixed") || s.is_sticky(e, n, i) ? (s.settings.sticky_class = i.sticky_class, s.settings.sticky_topbar = e, e.data("height", n.outerHeight()), e.data("stickyoffset", n.offset().top)) : e.data("height", e.outerHeight()), i.assembled || s.assemble(e), i.is_hover ? s.S(".has-dropdown", e).addClass("not-click") : s.S(".has-dropdown", e).removeClass("not-click"), s.add_custom_rule(".f-topbar-fixed { padding-top: " + e.data("height") + "px }"), n.hasClass("fixed") && s.S("body").addClass("f-topbar-fixed")
            })
        },
        is_sticky: function (t, e, i) {
            var n = e.hasClass(i.sticky_class);
            return !(!n || "all" !== i.sticky_on) || (n && this.small() && "small" === i.sticky_on ? matchMedia(Foundation.media_queries.small).matches && !matchMedia(Foundation.media_queries.medium).matches && !matchMedia(Foundation.media_queries.large).matches : n && this.medium() && "medium" === i.sticky_on ? matchMedia(Foundation.media_queries.small).matches && matchMedia(Foundation.media_queries.medium).matches && !matchMedia(Foundation.media_queries.large).matches : !(!n || !this.large() || "large" !== i.sticky_on) && (matchMedia(Foundation.media_queries.small).matches && matchMedia(Foundation.media_queries.medium).matches && matchMedia(Foundation.media_queries.large).matches))
        },
        toggle: function (i) {
            var n, s = this;
            n = i ? s.S(i).closest("[" + this.attr_name() + "]") : s.S("[" + this.attr_name() + "]");
            var o = n.data(this.attr_name(!0) + "-init"), r = s.S("section, .top-bar-section", n);
            s.breakpoint() && (s.rtl ? (r.css({right: "0%"}), t(">.name", r).css({right: "100%"})) : (r.css({left: "0%"}), t(">.name", r).css({left: "100%"})), s.S("li.moved", r).removeClass("moved"), n.data("index", 0), n.toggleClass("expanded").css("height", "")), o.scrolltop ? n.hasClass("expanded") ? n.parent().hasClass("fixed") && (o.scrolltop ? (n.parent().removeClass("fixed"), n.addClass("fixed"), s.S("body").removeClass("f-topbar-fixed"), e.scrollTo(0, 0)) : n.parent().removeClass("expanded")) : n.hasClass("fixed") && (n.parent().addClass("fixed"), n.removeClass("fixed"), s.S("body").addClass("f-topbar-fixed")) : (s.is_sticky(n, n.parent(), o) && n.parent().addClass("fixed"), n.parent().hasClass("fixed") && (n.hasClass("expanded") ? (n.addClass("fixed"), n.parent().addClass("expanded"), s.S("body").addClass("f-topbar-fixed")) : (n.removeClass("fixed"), n.parent().removeClass("expanded"), s.update_sticky_positioning())))
        },
        timer: null,
        events: function () {
            var i = this, n = this.S;
            n(this.scope).off(".topbar").on("click.fndtn.topbar", "[" + this.attr_name() + "] .toggle-topbar", function (t) {
                t.preventDefault(), i.toggle(this)
            }).on("click.fndtn.topbar", '.top-bar .top-bar-section li a[href^="#"],[' + this.attr_name() + '] .top-bar-section li a[href^="#"]', function () {
                var e = t(this).closest("li");
                !i.breakpoint() || e.hasClass("back") || e.hasClass("has-dropdown") || i.toggle()
            }).on("click.fndtn.topbar", "[" + this.attr_name() + "] li.has-dropdown", function (e) {
                var s = n(this), o = n(e.target), r = s.closest("[" + i.attr_name() + "]"),
                    a = r.data(i.attr_name(!0) + "-init");
                if (o.data("revealId")) return void i.toggle();
                i.breakpoint() || a.is_hover && !Modernizr.touch || (e.stopImmediatePropagation(), s.hasClass("hover") ? (s.removeClass("hover").find("li").removeClass("hover"), s.parents("li.hover").removeClass("hover")) : (s.addClass("hover"), t(s).siblings().removeClass("hover"), "A" === o[0].nodeName && o.parent().hasClass("has-dropdown") && e.preventDefault()))
            }).on("click.fndtn.topbar", "[" + this.attr_name() + "] .has-dropdown>a", function (t) {
                if (i.breakpoint()) {
                    t.preventDefault();
                    var e = n(this), s = e.closest("[" + i.attr_name() + "]"), o = s.find("section, .top-bar-section"),
                        r = (e.next(".dropdown").outerHeight(), e.closest("li"));
                    s.data("index", s.data("index") + 1), r.addClass("moved"), i.rtl ? (o.css({right: -100 * s.data("index") + "%"}), o.find(">.name").css({right: 100 * s.data("index") + "%"})) : (o.css({left: -100 * s.data("index") + "%"}), o.find(">.name").css({left: 100 * s.data("index") + "%"})), s.css("height", e.siblings("ul").outerHeight(!0) + s.data("height"))
                }
            }), n(e).off(".topbar").on("resize.fndtn.topbar", i.throttle(function () {
                i.resize.call(i)
            }, 50)).trigger("resize").trigger("resize.fndtn.topbar").load(function () {
                n(this).trigger("resize.fndtn.topbar")
            }), n("body").off(".topbar").on("click.fndtn.topbar", function (t) {
                n(t.target).closest("li").closest("li.hover").length > 0 || n("[" + i.attr_name() + "] li.hover").removeClass("hover")
            }), n(this.scope).on("click.fndtn.topbar", "[" + this.attr_name() + "] .has-dropdown .back", function (t) {
                t.preventDefault();
                var e = n(this), s = e.closest("[" + i.attr_name() + "]"), o = s.find("section, .top-bar-section"),
                    r = (s.data(i.attr_name(!0) + "-init"), e.closest("li.moved")), a = r.parent();
                s.data("index", s.data("index") - 1), i.rtl ? (o.css({right: -100 * s.data("index") + "%"}), o.find(">.name").css({right: 100 * s.data("index") + "%"})) : (o.css({left: -100 * s.data("index") + "%"}), o.find(">.name").css({left: 100 * s.data("index") + "%"})), 0 === s.data("index") ? s.css("height", "") : s.css("height", a.outerHeight(!0) + s.data("height")), setTimeout(function () {
                    r.removeClass("moved")
                }, 300)
            }), n(this.scope).find(".dropdown a").focus(function () {
                t(this).parents(".has-dropdown").addClass("hover")
            }).blur(function () {
                t(this).parents(".has-dropdown").removeClass("hover")
            })
        },
        resize: function () {
            var t = this;
            t.S("[" + this.attr_name() + "]").each(function () {
                var e, n = t.S(this), s = n.data(t.attr_name(!0) + "-init"),
                    o = n.parent("." + t.settings.sticky_class);
                if (!t.breakpoint()) {
                    var r = n.hasClass("expanded");
                    n.css("height", "").removeClass("expanded").find("li").removeClass("hover"), r && t.toggle(n)
                }
                t.is_sticky(n, o, s) && (o.hasClass("fixed") ? (o.removeClass("fixed"), e = o.offset().top, t.S(i.body).hasClass("f-topbar-fixed") && (e -= n.data("height")), n.data("stickyoffset", e), o.addClass("fixed")) : (e = o.offset().top, n.data("stickyoffset", e)))
            })
        },
        breakpoint: function () {
            return !matchMedia(Foundation.media_queries.topbar).matches
        },
        small: function () {
            return matchMedia(Foundation.media_queries.small).matches
        },
        medium: function () {
            return matchMedia(Foundation.media_queries.medium).matches
        },
        large: function () {
            return matchMedia(Foundation.media_queries.large).matches
        },
        assemble: function (e) {
            var i = this, n = e.data(this.attr_name(!0) + "-init"), s = i.S("section, .top-bar-section", e);
            s.detach(), i.S(".has-dropdown>a", s).each(function () {
                var e, s = i.S(this), o = s.siblings(".dropdown"), r = s.attr("href");
                o.find(".title.back").length || (e = t(1 == n.mobile_show_parent_link && r ? '<li class="title back js-generated"><h5><a href="javascript:void(0)"></a></h5></li><li class="parent-link show-for-small-only"><a class="parent-link js-generated" href="' + r + '">' + s.html() + "</a></li>" : '<li class="title back js-generated"><h5><a href="javascript:void(0)"></a></h5>'), 1 == n.custom_back_text ? t("h5>a", e).html(n.back_text) : t("h5>a", e).html("&laquo; " + s.html()), o.prepend(e))
            }), s.appendTo(e), this.sticky(), this.assembled(e)
        },
        assembled: function (e) {
            e.data(this.attr_name(!0), t.extend({}, e.data(this.attr_name(!0)), {assembled: !0}))
        },
        height: function (e) {
            var i = 0, n = this;
            return t("> li", e).each(function () {
                i += n.S(this).outerHeight(!0)
            }), i
        },
        sticky: function () {
            var t = this;
            this.S(e).on("scroll", function () {
                t.update_sticky_positioning()
            })
        },
        update_sticky_positioning: function () {
            var t = "." + this.settings.sticky_class, i = this.S(e), n = this;
            if (n.settings.sticky_topbar && n.is_sticky(this.settings.sticky_topbar, this.settings.sticky_topbar.parent(), this.settings)) {
                var s = this.settings.sticky_topbar.data("stickyoffset");
                n.S(t).hasClass("expanded") || (i.scrollTop() > s ? n.S(t).hasClass("fixed") || (n.S(t).addClass("fixed"), n.S("body").addClass("f-topbar-fixed")) : i.scrollTop() <= s && n.S(t).hasClass("fixed") && (n.S(t).removeClass("fixed"), n.S("body").removeClass("f-topbar-fixed")))
            }
        },
        off: function () {
            this.S(this.scope).off(".fndtn.topbar"), this.S(e).off(".fndtn.topbar")
        },
        reflow: function () {
        }
    }
}(jQuery, window, window.document), function (t, e, i, n) {
    "use strict";
    Foundation.libs.tab = {
        name: "tab", version: "5.5.0", settings: {
            active_class: "active", callback: function () {
            }, deep_linking: !1, scroll_to_content: !0, is_hover: !1
        }, default_tab_hashes: [], init: function (t, e, i) {
            var n = this, s = this.S;
            this.bindings(e, i), this.handle_location_hash_change(), s("[" + this.attr_name() + "] > .active > a", this.scope).each(function () {
                n.default_tab_hashes.push(this.hash)
            })
        }, events: function () {
            var t = this, i = this.S, n = function (e) {
                i(this).closest("[" + t.attr_name() + "]").data(t.attr_name(!0) + "-init").is_hover && !Modernizr.touch || (e.preventDefault(), e.stopPropagation(), t.toggle_active_tab(i(this).parent()))
            };
            i(this.scope).off(".tab").on("focus.fndtn.tab", "[" + this.attr_name() + "] > * > a", n).on("click.fndtn.tab", "[" + this.attr_name() + "] > * > a", n).on("mouseenter.fndtn.tab", "[" + this.attr_name() + "] > * > a", function () {
                i(this).closest("[" + t.attr_name() + "]").data(t.attr_name(!0) + "-init").is_hover && t.toggle_active_tab(i(this).parent())
            }), i(e).on("hashchange.fndtn.tab", function (e) {
                e.preventDefault(), t.handle_location_hash_change()
            })
        }, handle_location_hash_change: function () {
            var e = this, i = this.S;
            i("[" + this.attr_name() + "]", this.scope).each(function () {
                var s = i(this).data(e.attr_name(!0) + "-init");
                if (s.deep_linking) {
                    var o;
                    if ("" != (o = s.scroll_to_content ? e.scope.location.hash : e.scope.location.hash.replace("fndtn-", ""))) {
                        var r = i(o);
                        if (r.hasClass("content") && r.parent().hasClass("tabs-content")) e.toggle_active_tab(t("[" + e.attr_name() + "] > * > a[href=" + o + "]").parent()); else {
                            var a = r.closest(".content").attr("id");
                            a != n && e.toggle_active_tab(t("[" + e.attr_name() + "] > * > a[href=#" + a + "]").parent(), o)
                        }
                    } else for (var l = 0; l < e.default_tab_hashes.length; l++) e.toggle_active_tab(t("[" + e.attr_name() + "] > * > a[href=" + e.default_tab_hashes[l] + "]").parent())
                }
            })
        }, toggle_active_tab: function (s, o) {
            var r = this.S, a = s.closest("[" + this.attr_name() + "]"), l = s.find("a"), h = s.children("a").first(),
                c = "#" + h.attr("href").split("#")[1], d = r(c), u = s.siblings(),
                p = a.data(this.attr_name(!0) + "-init"), f = function (e) {
                    var n, s = t(this), o = t(this).parents("li").prev().children('[role="tab"]'),
                        r = t(this).parents("li").next().children('[role="tab"]');
                    switch (e.keyCode) {
                        case 37:
                            n = o;
                            break;
                        case 39:
                            n = r;
                            break;
                        default:
                            n = !1
                    }
                    n.length && (s.attr({tabindex: "-1", "aria-selected": null}), n.attr({
                        tabindex: "0",
                        "aria-selected": !0
                    }).focus()), t('[role="tabpanel"]').attr("aria-hidden", "true"), t("#" + t(i.activeElement).attr("href").substring(1)).attr("aria-hidden", null)
                };
            r(this).data(this.data_attr("tab-content")) && (c = "#" + r(this).data(this.data_attr("tab-content")).split("#")[1], d = r(c)), p.deep_linking && (p.scroll_to_content ? (e.location.hash = o || c, o == n || o == c ? s.parent()[0].scrollIntoView() : r(c)[0].scrollIntoView()) : e.location.hash = o != n ? "fndtn-" + o.replace("#", "") : "fndtn-" + c.replace("#", "")), s.addClass(p.active_class).triggerHandler("opened"), l.attr({
                "aria-selected": "true",
                tabindex: 0
            }), u.removeClass(p.active_class), u.find("a").attr({
                "aria-selected": "false",
                tabindex: -1
            }), d.siblings().removeClass(p.active_class).attr({
                "aria-hidden": "true",
                tabindex: -1
            }), d.addClass(p.active_class).attr("aria-hidden", "false").removeAttr("tabindex"), p.callback(s), d.triggerHandler("toggled", [s]), a.triggerHandler("toggled", [d]), l.off("keydown").on("keydown", f)
        }, data_attr: function (t) {
            return this.namespace.length > 0 ? this.namespace + "-" + t : t
        }, off: function () {
        }, reflow: function () {
        }
    }
}(jQuery, window, window.document), function (t, e, i) {
    "use strict";
    Foundation.libs.abide = {
        name: "abide",
        version: "5.5.0",
        settings: {
            live_validate: !0,
            validate_on_blur: !0,
            focus_on_invalid: !0,
            error_labels: !0,
            error_class: "error",
            timeout: 1e3,
            patterns: {
                alpha: /^[a-zA-Z]+$/,
                alpha_numeric: /^[a-zA-Z0-9]+$/,
                integer: /^[-+]?\d+$/,
                number: /^[-+]?\d*(?:[\.\,]\d+)?$/,
                card: /^(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\d{3})\d{11})$/,
                cvv: /^([0-9]){3,4}$/,
                email: /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)+$/,
                url: /^(https?|ftp|file|ssh):\/\/(((([a-zA-Z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:)*@)?(((\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5]))|((([a-zA-Z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-zA-Z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-zA-Z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-zA-Z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-zA-Z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-zA-Z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-zA-Z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-zA-Z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?)(:\d*)?)(\/((([a-zA-Z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)+(\/(([a-zA-Z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)*)*)?)?(\?((([a-zA-Z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|[\uE000-\uF8FF]|\/|\?)*)?(\#((([a-zA-Z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|\/|\?)*)?$/,
                domain: /^([a-zA-Z0-9]([a-zA-Z0-9\-]{0,61}[a-zA-Z0-9])?\.)+[a-zA-Z]{2,8}$/,
                datetime: /^([0-2][0-9]{3})\-([0-1][0-9])\-([0-3][0-9])T([0-5][0-9])\:([0-5][0-9])\:([0-5][0-9])(Z|([\-\+]([0-1][0-9])\:00))$/,
                date: /(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))$/,
                time: /^(0[0-9]|1[0-9]|2[0-3])(:[0-5][0-9]){2}$/,
                dateISO: /^\d{4}[\/\-]\d{1,2}[\/\-]\d{1,2}$/,
                month_day_year: /^(0[1-9]|1[012])[- \/.](0[1-9]|[12][0-9]|3[01])[- \/.]\d{4}$/,
                day_month_year: /^(0[1-9]|[12][0-9]|3[01])[- \/.](0[1-9]|1[012])[- \/.]\d{4}$/,
                color: /^#?([a-fA-F0-9]{6}|[a-fA-F0-9]{3})$/
            },
            validators: {
                equalTo: function (t) {
                    return i.getElementById(t.getAttribute(this.add_namespace("data-equalto"))).value === t.value
                }
            }
        },
        timer: null,
        init: function (t, e, i) {
            this.bindings(e, i)
        },
        events: function (e) {
            var i = this, n = i.S(e).attr("novalidate", "novalidate"), s = n.data(this.attr_name(!0) + "-init") || {};
            this.invalid_attr = this.add_namespace("data-invalid"), n.off(".abide").on("submit.fndtn.abide validate.fndtn.abide", function (t) {
                var e = /ajax/i.test(i.S(this).attr(i.attr_name()));
                return i.validate(i.S(this).find("input, textarea, select").get(), t, e)
            }).on("reset", function () {
                return i.reset(t(this))
            }).find("input, textarea, select").off(".abide").on("blur.fndtn.abide change.fndtn.abide", function (t) {
                !0 === s.validate_on_blur && i.validate([this], t)
            }).on("keydown.fndtn.abide", function (t) {
                !0 === s.live_validate && 9 != t.which && (clearTimeout(i.timer), i.timer = setTimeout(function () {
                    i.validate([this], t)
                }.bind(this), s.timeout))
            })
        },
        reset: function (e) {
            e.removeAttr(this.invalid_attr),
                t(this.invalid_attr, e).removeAttr(this.invalid_attr), t("." + this.settings.error_class, e).not("small").removeClass(this.settings.error_class)
        },
        validate: function (t, e, i) {
            for (var n = this.parse_patterns(t), s = n.length, o = this.S(t[0]).closest("form"), r = /submit/.test(e.type), a = 0; a < s; a++) if (!n[a] && (r || i)) return this.settings.focus_on_invalid && t[a].focus(), o.trigger("invalid").trigger("invalid.fndtn.abide"), this.S(t[a]).closest("form").attr(this.invalid_attr, ""), !1;
            return (r || i) && o.trigger("valid").trigger("valid.fndtn.abide"), o.removeAttr(this.invalid_attr), !i
        },
        parse_patterns: function (t) {
            for (var e = t.length, i = []; e--;) i.push(this.pattern(t[e]));
            return this.check_validation_and_apply_styles(i)
        },
        pattern: function (t) {
            var e = t.getAttribute("type"), i = "string" == typeof t.getAttribute("required"),
                n = t.getAttribute("pattern") || "";
            return this.settings.patterns.hasOwnProperty(n) && n.length > 0 ? [t, this.settings.patterns[n], i] : n.length > 0 ? [t, new RegExp(n), i] : this.settings.patterns.hasOwnProperty(e) ? [t, this.settings.patterns[e], i] : (n = /.*/, [t, n, i])
        },
        check_validation_and_apply_styles: function (e) {
            var i = e.length, n = [], s = this.S(e[0][0]).closest("[data-" + this.attr_name(!0) + "]");
            for (s.data(this.attr_name(!0) + "-init"); i--;) {
                var o, r, a = e[i][0], l = e[i][2], h = a.value.trim(), c = this.S(a).parent(),
                    d = a.getAttribute(this.add_namespace("data-abide-validator")), u = "radio" === a.type,
                    p = "checkbox" === a.type, f = this.S('label[for="' + a.getAttribute("id") + '"]'),
                    g = !l || a.value.length > 0, m = [];
                if (a.getAttribute(this.add_namespace("data-equalto")) && (d = "equalTo"), o = c.is("label") ? c.parent() : c, d && (r = this.settings.validators[d].apply(this, [a, l, o]), m.push(r)), u && l) m.push(this.valid_radio(a, l)); else if (p && l) m.push(this.valid_checkbox(a, l)); else if (e[i][1].test(h) && g || !l && a.value.length < 1 || t(a).attr("disabled") ? m.push(!0) : m.push(!1), m = [m.every(function (t) {
                    return t
                })], m[0]) this.S(a).removeAttr(this.invalid_attr), a.setAttribute("aria-invalid", "false"), a.removeAttribute("aria-describedby"), o.removeClass(this.settings.error_class), f.length > 0 && this.settings.error_labels && f.removeClass(this.settings.error_class).removeAttr("role"), t(a).triggerHandler("valid"); else {
                    this.S(a).attr(this.invalid_attr, ""), a.setAttribute("aria-invalid", "true");
                    var v = o.find("small." + this.settings.error_class, "span." + this.settings.error_class),
                        y = v.length > 0 ? v[0].id : "";
                    y.length > 0 && a.setAttribute("aria-describedby", y), o.addClass(this.settings.error_class), f.length > 0 && this.settings.error_labels && f.addClass(this.settings.error_class).attr("role", "alert"), t(a).triggerHandler("invalid")
                }
                n.push(m[0])
            }
            return n = [n.every(function (t) {
                return t
            })]
        },
        valid_checkbox: function (t, e) {
            var t = this.S(t), i = t.is(":checked") || !e;
            return i ? t.removeAttr(this.invalid_attr).parent().removeClass(this.settings.error_class) : t.attr(this.invalid_attr, "").parent().addClass(this.settings.error_class), i
        },
        valid_radio: function (t) {
            for (var e = t.getAttribute("name"), i = this.S(t).closest("[data-" + this.attr_name(!0) + "]").find("[name='" + e + "']"), n = i.length, s = !1, o = 0; o < n; o++) i[o].checked && (s = !0);
            for (var o = 0; o < n; o++) s ? this.S(i[o]).removeAttr(this.invalid_attr).parent().removeClass(this.settings.error_class) : this.S(i[o]).attr(this.invalid_attr, "").parent().addClass(this.settings.error_class);
            return s
        },
        valid_equal: function (t, e, n) {
            var s = i.getElementById(t.getAttribute(this.add_namespace("data-equalto"))).value, o = t.value,
                r = s === o;
            return r ? (this.S(t).removeAttr(this.invalid_attr), n.removeClass(this.settings.error_class), label.length > 0 && settings.error_labels && label.removeClass(this.settings.error_class)) : (this.S(t).attr(this.invalid_attr, ""), n.addClass(this.settings.error_class), label.length > 0 && settings.error_labels && label.addClass(this.settings.error_class)), r
        },
        valid_oneof: function (t, e, i, n) {
            var t = this.S(t), s = this.S("[" + this.add_namespace("data-oneof") + "]"),
                o = s.filter(":checked").length > 0;
            if (o ? t.removeAttr(this.invalid_attr).parent().removeClass(this.settings.error_class) : t.attr(this.invalid_attr, "").parent().addClass(this.settings.error_class), !n) {
                var r = this;
                s.each(function () {
                    r.valid_oneof.call(r, this, null, null, !0)
                })
            }
            return o
        }
    }
}(jQuery, window, window.document), function (t, e) {
    "use strict";
    Foundation.libs.tooltip = {
        name: "tooltip",
        version: "5.5.0",
        settings: {
            additional_inheritable_classes: [],
            tooltip_class: ".tooltip",
            append_to: "body",
            touch_close_text: "Tap To Close",
            disable_for_touch: !1,
            hover_delay: 200,
            show_on: "all",
            tip_template: function (t, e) {
                return '<span data-selector="' + t + '" id="' + t + '" class="' + Foundation.libs.tooltip.settings.tooltip_class.substring(1) + '" role="tooltip">' + e + '<span class="nub"></span></span>'
            }
        },
        cache: {},
        init: function (t, e, i) {
            Foundation.inherit(this, "random_str"), this.bindings(e, i)
        },
        should_show: function (e) {
            var i = t.extend({}, this.settings, this.data_options(e));
            return "all" === i.show_on || (!(!this.small() || "small" !== i.show_on) || (!(!this.medium() || "medium" !== i.show_on) || !(!this.large() || "large" !== i.show_on)))
        },
        medium: function () {
            return matchMedia(Foundation.media_queries.medium).matches
        },
        large: function () {
            return matchMedia(Foundation.media_queries.large).matches
        },
        events: function (e) {
            var i = this, n = i.S;
            i.create(this.S(e)), t(this.scope).off(".tooltip").on("mouseenter.fndtn.tooltip mouseleave.fndtn.tooltip touchstart.fndtn.tooltip MSPointerDown.fndtn.tooltip", "[" + this.attr_name() + "]", function (e) {
                var s = n(this), o = t.extend({}, i.settings, i.data_options(s));
                if (Modernizr.touch && /touchstart|MSPointerDown/i.test(e.type) && n(e.target).is("a")) return !1;
                if (/mouse/i.test(e.type) && i.ie_touch(e)) return !1;
                if (s.hasClass("open")) Modernizr.touch && /touchstart|MSPointerDown/i.test(e.type) && e.preventDefault(), i.hide(s); else {
                    if (o.disable_for_touch && Modernizr.touch && /touchstart|MSPointerDown/i.test(e.type)) return;
                    !o.disable_for_touch && Modernizr.touch && /touchstart|MSPointerDown/i.test(e.type) && (e.preventDefault(), n(o.tooltip_class + ".open").hide(), !0), /enter|over/i.test(e.type) ? this.timer = setTimeout(function () {
                        i.showTip(s)
                    }.bind(this), i.settings.hover_delay) : "mouseout" === e.type || "mouseleave" === e.type ? (clearTimeout(this.timer), i.hide(s)) : i.showTip(s)
                }
            }).on("mouseleave.fndtn.tooltip touchstart.fndtn.tooltip MSPointerDown.fndtn.tooltip", "[" + this.attr_name() + "].open", function (e) {
                if (/mouse/i.test(e.type) && i.ie_touch(e)) return !1;
                "touch" == t(this).data("tooltip-open-event-type") && "mouseleave" == e.type || ("mouse" == t(this).data("tooltip-open-event-type") && /MSPointerDown|touchstart/i.test(e.type) ? i.convert_to_touch(t(this)) : i.hide(t(this)))
            }).on("DOMNodeRemoved DOMAttrModified", "[" + this.attr_name() + "]:not(a)", function () {
                i.hide(n(this))
            })
        },
        ie_touch: function () {
            return !1
        },
        showTip: function (t) {
            var e = this.getTip(t);
            if (this.should_show(t, e)) return this.show(t)
        },
        getTip: function (e) {
            var i = this.selector(e), n = t.extend({}, this.settings, this.data_options(e)), s = null;
            return i && (s = this.S('span[data-selector="' + i + '"]' + n.tooltip_class)), "object" == typeof s && s
        },
        selector: function (t) {
            var e = t.attr("id"), i = t.attr(this.attr_name()) || t.attr("data-selector");
            return (e && e.length < 1 || !e) && "string" != typeof i && (i = this.random_str(6), t.attr("data-selector", i).attr("aria-describedby", i)), e && e.length > 0 ? e : i
        },
        create: function (i) {
            var n = this, s = t.extend({}, this.settings, this.data_options(i)), o = this.settings.tip_template;
            "string" == typeof s.tip_template && e.hasOwnProperty(s.tip_template) && (o = e[s.tip_template]);
            var r = t(o(this.selector(i), t("<div></div>").html(i.attr("title")).html())),
                a = this.inheritable_classes(i);
            r.addClass(a).appendTo(s.append_to), Modernizr.touch && (r.append('<span class="tap-to-close">' + s.touch_close_text + "</span>"), r.on("touchstart.fndtn.tooltip MSPointerDown.fndtn.tooltip", function () {
                n.hide(i)
            })), i.removeAttr("title").attr("title", "")
        },
        reposition: function (e, i, n) {
            var s, o, r, a;
            if (i.css("visibility", "hidden").show(), s = e.data("width"), o = i.children(".nub"), r = o.outerHeight(), o.outerHeight(), this.small() ? i.css({width: "100%"}) : i.css({width: s || "auto"}), a = function (t, e, i, n, s) {
                return t.css({top: e || "auto", bottom: n || "auto", left: s || "auto", right: i || "auto"}).end()
            }, a(i, e.offset().top + e.outerHeight() + 10, "auto", "auto", e.offset().left), this.small()) a(i, e.offset().top + e.outerHeight() + 10, "auto", "auto", 12.5, t(this.scope).width()), i.addClass("tip-override"), a(o, -r, "auto", "auto", e.offset().left); else {
                var l = e.offset().left;
                Foundation.rtl && (o.addClass("rtl"), l = e.offset().left + e.outerWidth() - i.outerWidth()), a(i, e.offset().top + e.outerHeight() + 10, "auto", "auto", l), i.removeClass("tip-override"), n && n.indexOf("tip-top") > -1 ? (Foundation.rtl && o.addClass("rtl"), a(i, e.offset().top - i.outerHeight(), "auto", "auto", l).removeClass("tip-override")) : n && n.indexOf("tip-left") > -1 ? (a(i, e.offset().top + e.outerHeight() / 2 - i.outerHeight() / 2, "auto", "auto", e.offset().left - i.outerWidth() - r).removeClass("tip-override"), o.removeClass("rtl")) : n && n.indexOf("tip-right") > -1 && (a(i, e.offset().top + e.outerHeight() / 2 - i.outerHeight() / 2, "auto", "auto", e.offset().left + e.outerWidth() + r).removeClass("tip-override"), o.removeClass("rtl"))
            }
            i.css("visibility", "visible").hide()
        },
        small: function () {
            return matchMedia(Foundation.media_queries.small).matches && !matchMedia(Foundation.media_queries.medium).matches
        },
        inheritable_classes: function (e) {
            var i = t.extend({}, this.settings, this.data_options(e)),
                n = ["tip-top", "tip-left", "tip-bottom", "tip-right", "radius", "round"].concat(i.additional_inheritable_classes),
                s = e.attr("class"), o = s ? t.map(s.split(" "), function (e) {
                    if (-1 !== t.inArray(e, n)) return e
                }).join(" ") : "";
            return t.trim(o)
        },
        convert_to_touch: function (e) {
            var i = this, n = i.getTip(e), s = t.extend({}, i.settings, i.data_options(e));
            0 === n.find(".tap-to-close").length && (n.append('<span class="tap-to-close">' + s.touch_close_text + "</span>"), n.on("click.fndtn.tooltip.tapclose touchstart.fndtn.tooltip.tapclose MSPointerDown.fndtn.tooltip.tapclose", function () {
                i.hide(e)
            })), e.data("tooltip-open-event-type", "touch")
        },
        show: function (t) {
            var e = this.getTip(t);
            "touch" == t.data("tooltip-open-event-type") && this.convert_to_touch(t), this.reposition(t, e, t.attr("class")), t.addClass("open"), e.fadeIn(150)
        },
        hide: function (t) {
            var e = this.getTip(t);
            e.fadeOut(150, function () {
                e.find(".tap-to-close").remove(), e.off("click.fndtn.tooltip.tapclose MSPointerDown.fndtn.tapclose"), t.removeClass("open")
            })
        },
        off: function () {
            var e = this;
            this.S(this.scope).off(".fndtn.tooltip"), this.S(this.settings.tooltip_class).each(function (i) {
                t("[" + e.attr_name() + "]").eq(i).attr("title", t(this).text())
            }).remove()
        },
        reflow: function () {
        }
    }
}(jQuery, window, window.document), function () {
    var t, e, i, n, s, o = {}.hasOwnProperty, r = function (t, e) {
        function i() {
            this.constructor = t
        }

        for (var n in e) o.call(e, n) && (t[n] = e[n]);
        return i.prototype = e.prototype, t.prototype = new i, t.__super__ = e.prototype, t
    };
    n = function () {
        function t() {
            this.options_index = 0, this.parsed = []
        }

        return t.prototype.add_node = function (t) {
            return "OPTGROUP" === t.nodeName.toUpperCase() ? this.add_group(t) : this.add_option(t)
        }, t.prototype.add_group = function (t) {
            var e, i, n, s, o, r;
            for (e = this.parsed.length, this.parsed.push({
                array_index: e,
                group: !0,
                label: this.escapeExpression(t.label),
                title: t.title ? t.title : void 0,
                children: 0,
                disabled: t.disabled,
                classes: t.className
            }), o = t.childNodes, r = [], n = 0, s = o.length; s > n; n++) i = o[n], r.push(this.add_option(i, e, t.disabled));
            return r
        }, t.prototype.add_option = function (t, e, i) {
            return "OPTION" === t.nodeName.toUpperCase() ? ("" !== t.text ? (null != e && (this.parsed[e].children += 1), this.parsed.push({
                array_index: this.parsed.length,
                options_index: this.options_index,
                value: t.value,
                text: t.text,
                html: t.innerHTML,
                title: t.title ? t.title : void 0,
                selected: t.selected,
                disabled: !0 === i ? i : t.disabled,
                group_array_index: e,
                group_label: null != e ? this.parsed[e].label : null,
                classes: t.className,
                style: t.style.cssText
            })) : this.parsed.push({
                array_index: this.parsed.length,
                options_index: this.options_index,
                empty: !0
            }), this.options_index += 1) : void 0
        }, t.prototype.escapeExpression = function (t) {
            var e, i;
            return null == t || !1 === t ? "" : /[\&\<\>\"\'\`]/.test(t) ? (e = {
                "<": "&lt;",
                ">": "&gt;",
                '"': "&quot;",
                "'": "&#x27;",
                "`": "&#x60;"
            }, i = /&(?!\w+;)|[\<\>\"\'\`]/g, t.replace(i, function (t) {
                return e[t] || "&amp;"
            })) : t
        }, t
    }(), n.select_to_array = function (t) {
        var e, i, s, o, r;
        for (i = new n, r = t.childNodes, s = 0, o = r.length; o > s; s++) e = r[s], i.add_node(e);
        return i.parsed
    }, e = function () {
        function t(e, i) {
            this.form_field = e, this.options = null != i ? i : {}, t.browser_is_supported() && (this.is_multiple = this.form_field.multiple, this.set_default_text(), this.set_default_values(), this.setup(), this.set_up_html(), this.register_observers(), this.on_ready())
        }

        return t.prototype.set_default_values = function () {
            var t = this;
            return this.click_test_action = function (e) {
                return t.test_active_click(e)
            }, this.activate_action = function (e) {
                return t.activate_field(e)
            }, this.active_field = !1, this.mouse_on_container = !1, this.results_showing = !1, this.result_highlighted = null, this.allow_single_deselect = null != this.options.allow_single_deselect && null != this.form_field.options[0] && "" === this.form_field.options[0].text && this.options.allow_single_deselect, this.disable_search_threshold = this.options.disable_search_threshold || 0, this.disable_search = this.options.disable_search || !1, this.enable_split_word_search = null == this.options.enable_split_word_search || this.options.enable_split_word_search, this.group_search = null == this.options.group_search || this.options.group_search, this.search_contains = this.options.search_contains || !1, this.single_backstroke_delete = null == this.options.single_backstroke_delete || this.options.single_backstroke_delete, this.max_selected_options = this.options.max_selected_options || 1 / 0, this.inherit_select_classes = this.options.inherit_select_classes || !1, this.display_selected_options = null == this.options.display_selected_options || this.options.display_selected_options, this.display_disabled_options = null == this.options.display_disabled_options || this.options.display_disabled_options, this.include_group_label_in_selected = this.options.include_group_label_in_selected || !1, this.max_shown_results = this.options.max_shown_results || Number.POSITIVE_INFINITY
        }, t.prototype.set_default_text = function () {
            return this.form_field.getAttribute("data-placeholder") ? this.default_text = this.form_field.getAttribute("data-placeholder") : this.is_multiple ? this.default_text = this.options.placeholder_text_multiple || this.options.placeholder_text || t.default_multiple_text : this.default_text = this.options.placeholder_text_single || this.options.placeholder_text || t.default_single_text, this.results_none_found = this.form_field.getAttribute("data-no_results_text") || this.options.no_results_text || t.default_no_result_text
        }, t.prototype.choice_label = function (t) {
            return this.include_group_label_in_selected && null != t.group_label ? "<b class='group-name'>" + t.group_label + "</b>" + t.html : t.html
        }, t.prototype.mouse_enter = function () {
            return this.mouse_on_container = !0
        }, t.prototype.mouse_leave = function () {
            return this.mouse_on_container = !1
        }, t.prototype.input_focus = function () {
            var t = this;
            if (this.is_multiple) {
                if (!this.active_field) return setTimeout(function () {
                    return t.container_mousedown()
                }, 50)
            } else if (!this.active_field) return this.activate_field()
        }, t.prototype.input_blur = function () {
            var t = this;
            return this.mouse_on_container ? void 0 : (this.active_field = !1, setTimeout(function () {
                return t.blur_test()
            }, 100))
        }, t.prototype.results_option_build = function (t) {
            var e, i, n, s, o, r, a;
            for (e = "", s = 0, a = this.results_data, o = 0, r = a.length; r > o && (i = a[o], n = "", n = i.group ? this.result_add_group(i) : this.result_add_option(i), "" !== n && (s++, e += n), (null != t ? t.first : void 0) && (i.selected && this.is_multiple ? this.choice_build(i) : i.selected && !this.is_multiple && this.single_set_selected_text(this.choice_label(i))), !(s >= this.max_shown_results)); o++) ;
            return e
        }, t.prototype.result_add_option = function (t) {
            var e, i;
            return t.search_match && this.include_option_in_results(t) ? (e = [], t.disabled || t.selected && this.is_multiple || e.push("active-result"), !t.disabled || t.selected && this.is_multiple || e.push("disabled-result"), t.selected && e.push("result-selected"), null != t.group_array_index && e.push("group-option"), "" !== t.classes && e.push(t.classes), i = document.createElement("li"), i.className = e.join(" "), i.style.cssText = t.style, i.setAttribute("data-option-array-index", t.array_index), i.innerHTML = t.search_text, t.title && (i.title = t.title), this.outerHTML(i)) : ""
        }, t.prototype.result_add_group = function (t) {
            var e, i;
            return (t.search_match || t.group_match) && t.active_options > 0 ? (e = [], e.push("group-result"), t.classes && e.push(t.classes), i = document.createElement("li"), i.className = e.join(" "), i.innerHTML = t.search_text, t.title && (i.title = t.title), this.outerHTML(i)) : ""
        }, t.prototype.results_update_field = function () {
            return this.set_default_text(), this.is_multiple || this.results_reset_cleanup(), this.result_clear_highlight(), this.results_build(), this.results_showing ? this.winnow_results() : void 0
        }, t.prototype.reset_single_select_options = function () {
            var t, e, i, n, s;
            for (n = this.results_data, s = [], e = 0, i = n.length; i > e; e++) t = n[e], t.selected ? s.push(t.selected = !1) : s.push(void 0);
            return s
        }, t.prototype.results_toggle = function () {
            return this.results_showing ? this.results_hide() : this.results_show()
        }, t.prototype.results_search = function () {
            return this.results_showing ? this.winnow_results() : this.results_show()
        }, t.prototype.winnow_results = function () {
            var t, e, i, n, s, o, r, a, l, h, c, d;
            for (this.no_results_clear(), n = 0, o = this.get_search_text(), t = o.replace(/[-[\]{}()*+?.,\\^$|#\s]/g, "\\$&"), l = new RegExp(t, "i"), i = this.get_search_regex(t), d = this.results_data, h = 0, c = d.length; c > h; h++) e = d[h], e.search_match = !1, s = null, this.include_option_in_results(e) && (e.group && (e.group_match = !1, e.active_options = 0), null != e.group_array_index && this.results_data[e.group_array_index] && (s = this.results_data[e.group_array_index], 0 === s.active_options && s.search_match && (n += 1), s.active_options += 1), e.search_text = e.group ? e.label : e.html, (!e.group || this.group_search) && (e.search_match = this.search_string_match(e.search_text, i), e.search_match && !e.group && (n += 1), e.search_match ? (o.length && (r = e.search_text.search(l), a = e.search_text.substr(0, r + o.length) + "</em>" + e.search_text.substr(r + o.length), e.search_text = a.substr(0, r) + "<em>" + a.substr(r)), null != s && (s.group_match = !0)) : null != e.group_array_index && this.results_data[e.group_array_index].search_match && (e.search_match = !0)));
            return this.result_clear_highlight(), 1 > n && o.length ? (this.update_results_content(""), this.no_results(o)) : (this.update_results_content(this.results_option_build()), this.winnow_results_set_highlight())
        }, t.prototype.get_search_regex = function (t) {
            var e;
            return e = this.search_contains ? "" : "^", new RegExp(e + t, "i")
        }, t.prototype.search_string_match = function (t, e) {
            var i, n, s, o;
            if (e.test(t)) return !0;
            if (this.enable_split_word_search && (t.indexOf(" ") >= 0 || 0 === t.indexOf("[")) && (n = t.replace(/\[|\]/g, "").split(" "), n.length)) for (s = 0, o = n.length; o > s; s++) if (i = n[s], e.test(i)) return !0
        }, t.prototype.choices_count = function () {
            var t, e, i, n;
            if (null != this.selected_option_count) return this.selected_option_count;
            for (this.selected_option_count = 0, n = this.form_field.options, e = 0, i = n.length; i > e; e++) t = n[e], t.selected && (this.selected_option_count += 1);
            return this.selected_option_count
        }, t.prototype.choices_click = function (t) {
            return t.preventDefault(), this.results_showing || this.is_disabled ? void 0 : this.results_show()
        }, t.prototype.keyup_checker = function (t) {
            var e, i;
            switch (e = null != (i = t.which) ? i : t.keyCode, this.search_field_scale(), e) {
                case 8:
                    if (this.is_multiple && this.backstroke_length < 1 && this.choices_count() > 0) return this.keydown_backstroke();
                    if (!this.pending_backstroke) return this.result_clear_highlight(), this.results_search();
                    break;
                case 13:
                    if (t.preventDefault(), this.results_showing) return this.result_select(t);
                    break;
                case 27:
                    return this.results_showing && this.results_hide(), !0;
                case 9:
                case 38:
                case 40:
                case 16:
                case 91:
                case 17:
                case 18:
                    break;
                default:
                    return this.results_search()
            }
        }, t.prototype.clipboard_event_checker = function () {
            var t = this;
            return setTimeout(function () {
                return t.results_search()
            }, 50)
        }, t.prototype.container_width = function () {
            return null != this.options.width ? this.options.width : this.form_field.offsetWidth + "px"
        }, t.prototype.include_option_in_results = function (t) {
            return !(this.is_multiple && !this.display_selected_options && t.selected) && (!(!this.display_disabled_options && t.disabled) && !t.empty)
        }, t.prototype.search_results_touchstart = function (t) {
            return this.touch_started = !0, this.search_results_mouseover(t)
        }, t.prototype.search_results_touchmove = function (t) {
            return this.touch_started = !1, this.search_results_mouseout(t)
        }, t.prototype.search_results_touchend = function (t) {
            return this.touch_started ? this.search_results_mouseup(t) : void 0
        }, t.prototype.outerHTML = function (t) {
            var e;
            return t.outerHTML ? t.outerHTML : (e = document.createElement("div"), e.appendChild(t), e.innerHTML)
        }, t.browser_is_supported = function () {
            return !/iP(od|hone)/i.test(window.navigator.userAgent) && ((!/Android/i.test(window.navigator.userAgent) || !/Mobile/i.test(window.navigator.userAgent)) && (!/IEMobile/i.test(window.navigator.userAgent) && (!/Windows Phone/i.test(window.navigator.userAgent) && (!/BlackBerry/i.test(window.navigator.userAgent) && (!/BB10/i.test(window.navigator.userAgent) && ("Microsoft Internet Explorer" !== window.navigator.appName || document.documentMode >= 8))))))
        }, t.default_multiple_text = "Select Some Options", t.default_single_text = "Select an Option", t.default_no_result_text = "No results match", t
    }(), t = jQuery, t.fn.extend({
        chosen: function (n) {
            return e.browser_is_supported() ? this.each(function () {
                var e, s;
                return e = t(this), s = e.data("chosen"), "destroy" === n ? void (s instanceof i && s.destroy()) : void (s instanceof i || e.data("chosen", new i(this, n)))
            }) : this
        }
    }), i = function (e) {
        function i() {
            return s = i.__super__.constructor.apply(this, arguments)
        }

        return r(i, e), i.prototype.setup = function () {
            return this.form_field_jq = t(this.form_field), this.current_selectedIndex = this.form_field.selectedIndex, this.is_rtl = this.form_field_jq.hasClass("chosen-rtl")
        }, i.prototype.set_up_html = function () {
            var e, i;
            return e = ["chosen-container"], e.push("chosen-container-" + (this.is_multiple ? "multi" : "single")), this.inherit_select_classes && this.form_field.className && e.push(this.form_field.className), this.is_rtl && e.push("chosen-rtl"), i = {
                "class": e.join(" "),
                style: "width: " + this.container_width() + ";",
                title: this.form_field.title
            }, this.form_field.id.length && (i.id = this.form_field.id.replace(/[^\w]/g, "_") + "_chosen"), this.container = t("<div />", i), this.is_multiple ? this.container.html('<ul class="chosen-choices"><li class="search-field"><input type="text" value="' + this.default_text + '" class="default" autocomplete="off" style="width:25px;" /></li></ul><div class="chosen-drop"><ul class="chosen-results"></ul></div>') : this.container.html('<a class="chosen-single chosen-default"><span>' + this.default_text + '</span><div><b></b></div></a><div class="chosen-drop"><div class="chosen-search"><input type="text" autocomplete="off" /></div><ul class="chosen-results"></ul></div>'), this.form_field_jq.hide().after(this.container), this.dropdown = this.container.find("div.chosen-drop").first(), this.search_field = this.container.find("input").first(), this.search_results = this.container.find("ul.chosen-results").first(), this.search_field_scale(), this.search_no_results = this.container.find("li.no-results").first(), this.is_multiple ? (this.search_choices = this.container.find("ul.chosen-choices").first(), this.search_container = this.container.find("li.search-field").first()) : (this.search_container = this.container.find("div.chosen-search").first(), this.selected_item = this.container.find(".chosen-single").first()), this.results_build(), this.set_tab_index(), this.set_label_behavior()
        }, i.prototype.on_ready = function () {
            return this.form_field_jq.trigger("chosen:ready", {chosen: this})
        }, i.prototype.register_observers = function () {
            var t = this;
            return this.container.bind("touchstart.chosen", function (e) {
                return t.container_mousedown(e), e.preventDefault()
            }), this.container.bind("touchend.chosen", function (e) {
                return t.container_mouseup(e), e.preventDefault()
            }), this.container.bind("mousedown.chosen", function (e) {
                t.container_mousedown(e)
            }), this.container.bind("mouseup.chosen", function (e) {
                t.container_mouseup(e)
            }), this.container.bind("mouseenter.chosen", function (e) {
                t.mouse_enter(e)
            }), this.container.bind("mouseleave.chosen", function (e) {
                t.mouse_leave(e)
            }), this.search_results.bind("mouseup.chosen", function (e) {
                t.search_results_mouseup(e)
            }), this.search_results.bind("mouseover.chosen", function (e) {
                t.search_results_mouseover(e)
            }), this.search_results.bind("mouseout.chosen", function (e) {
                t.search_results_mouseout(e)
            }), this.search_results.bind("mousewheel.chosen DOMMouseScroll.chosen", function (e) {
                t.search_results_mousewheel(e)
            }), this.search_results.bind("touchstart.chosen", function (e) {
                t.search_results_touchstart(e)
            }), this.search_results.bind("touchmove.chosen", function (e) {
                t.search_results_touchmove(e)
            }), this.search_results.bind("touchend.chosen", function (e) {
                t.search_results_touchend(e)
            }), this.form_field_jq.bind("chosen:updated.chosen", function (e) {
                t.results_update_field(e)
            }), this.form_field_jq.bind("chosen:activate.chosen", function (e) {
                t.activate_field(e)
            }), this.form_field_jq.bind("chosen:open.chosen", function (e) {
                t.container_mousedown(e)
            }), this.form_field_jq.bind("chosen:close.chosen", function (e) {
                t.input_blur(e)
            }), this.search_field.bind("blur.chosen", function (e) {
                t.input_blur(e)
            }), this.search_field.bind("keyup.chosen", function (e) {
                t.keyup_checker(e)
            }), this.search_field.bind("keydown.chosen", function (e) {
                t.keydown_checker(e)
            }), this.search_field.bind("focus.chosen", function (e) {
                t.input_focus(e)
            }), this.search_field.bind("cut.chosen", function (e) {
                t.clipboard_event_checker(e)
            }), this.search_field.bind("paste.chosen", function (e) {
                t.clipboard_event_checker(e)
            }), this.is_multiple ? this.search_choices.bind("click.chosen", function (e) {
                t.choices_click(e)
            }) : this.container.bind("click.chosen", function (t) {
                t.preventDefault()
            })
        }, i.prototype.destroy = function () {
            return t(this.container[0].ownerDocument).unbind("click.chosen", this.click_test_action), this.search_field[0].tabIndex && (this.form_field_jq[0].tabIndex = this.search_field[0].tabIndex), this.container.remove(), this.form_field_jq.removeData("chosen"), this.form_field_jq.show()
        }, i.prototype.search_field_disabled = function () {
            return this.is_disabled = this.form_field_jq[0].disabled, this.is_disabled ? (this.container.addClass("chosen-disabled"), this.search_field[0].disabled = !0, this.is_multiple || this.selected_item.unbind("focus.chosen", this.activate_action), this.close_field()) : (this.container.removeClass("chosen-disabled"), this.search_field[0].disabled = !1, this.is_multiple ? void 0 : this.selected_item.bind("focus.chosen", this.activate_action))
        }, i.prototype.container_mousedown = function (e) {
            return this.is_disabled || (e && "mousedown" === e.type && !this.results_showing && e.preventDefault(), null != e && t(e.target).hasClass("search-choice-close")) ? void 0 : (this.active_field ? this.is_multiple || !e || t(e.target)[0] !== this.selected_item[0] && !t(e.target).parents("a.chosen-single").length || (e.preventDefault(), this.results_toggle()) : (this.is_multiple && this.search_field.val(""), t(this.container[0].ownerDocument).bind("click.chosen", this.click_test_action), this.results_show()), this.activate_field())
        }, i.prototype.container_mouseup = function (t) {
            return "ABBR" !== t.target.nodeName || this.is_disabled ? void 0 : this.results_reset(t)
        }, i.prototype.search_results_mousewheel = function (t) {
            var e;
            return t.originalEvent && (e = t.originalEvent.deltaY || -t.originalEvent.wheelDelta || t.originalEvent.detail), null != e ? (t.preventDefault(), "DOMMouseScroll" === t.type && (e *= 40), this.search_results.scrollTop(e + this.search_results.scrollTop())) : void 0
        }, i.prototype.blur_test = function () {
            return !this.active_field && this.container.hasClass("chosen-container-active") ? this.close_field() : void 0
        }, i.prototype.close_field = function () {
            return t(this.container[0].ownerDocument).unbind("click.chosen", this.click_test_action), this.active_field = !1, this.results_hide(), this.container.removeClass("chosen-container-active"), this.clear_backstroke(), this.show_search_field_default(), this.search_field_scale()
        }, i.prototype.activate_field = function () {
            return this.container.addClass("chosen-container-active"), this.active_field = !0, this.search_field.val(this.search_field.val()), this.search_field.focus()
        }, i.prototype.test_active_click = function (e) {
            var i;
            return i = t(e.target).closest(".chosen-container"), i.length && this.container[0] === i[0] ? this.active_field = !0 : this.close_field()
        }, i.prototype.results_build = function () {
            return this.parsing = !0, this.selected_option_count = null, this.results_data = n.select_to_array(this.form_field), this.is_multiple ? this.search_choices.find("li.search-choice").remove() : this.is_multiple || (this.single_set_selected_text(), this.disable_search || this.form_field.options.length <= this.disable_search_threshold ? (this.search_field[0].readOnly = !0, this.container.addClass("chosen-container-single-nosearch")) : (this.search_field[0].readOnly = !1, this.container.removeClass("chosen-container-single-nosearch"))), this.update_results_content(this.results_option_build({first: !0})), this.search_field_disabled(), this.show_search_field_default(), this.search_field_scale(), this.parsing = !1
        }, i.prototype.result_do_highlight = function (t) {
            var e, i, n, s, o;
            if (t.length) {
                if (this.result_clear_highlight(), this.result_highlight = t, this.result_highlight.addClass("highlighted"), n = parseInt(this.search_results.css("maxHeight"), 10), o = this.search_results.scrollTop(), s = n + o, i = this.result_highlight.position().top + this.search_results.scrollTop(), (e = i + this.result_highlight.outerHeight()) >= s) return this.search_results.scrollTop(e - n > 0 ? e - n : 0);
                if (o > i) return this.search_results.scrollTop(i)
            }
        }, i.prototype.result_clear_highlight = function () {
            return this.result_highlight && this.result_highlight.removeClass("highlighted"), this.result_highlight = null
        }, i.prototype.results_show = function () {
            return this.is_multiple && this.max_selected_options <= this.choices_count() ? (this.form_field_jq.trigger("chosen:maxselected", {chosen: this}), !1) : (this.container.addClass("chosen-with-drop"), this.results_showing = !0, this.search_field.focus(), this.search_field.val(this.search_field.val()), this.winnow_results(), this.form_field_jq.trigger("chosen:showing_dropdown", {chosen: this}))
        }, i.prototype.update_results_content = function (t) {
            return this.search_results.html(t)
        }, i.prototype.results_hide = function () {
            return this.results_showing && (this.result_clear_highlight(), this.container.removeClass("chosen-with-drop"), this.form_field_jq.trigger("chosen:hiding_dropdown", {chosen: this})), this.results_showing = !1
        }, i.prototype.set_tab_index = function () {
            var t;
            return this.form_field.tabIndex ? (t = this.form_field.tabIndex, this.form_field.tabIndex = -1, this.search_field[0].tabIndex = t) : void 0
        }, i.prototype.set_label_behavior = function () {
            var e = this;
            return this.form_field_label = this.form_field_jq.parents("label"), !this.form_field_label.length && this.form_field.id.length && (this.form_field_label = t("label[for='" + this.form_field.id + "']")), this.form_field_label.length > 0 ? this.form_field_label.bind("click.chosen", function (t) {
                return e.is_multiple ? e.container_mousedown(t) : e.activate_field()
            }) : void 0
        }, i.prototype.show_search_field_default = function () {
            return this.is_multiple && this.choices_count() < 1 && !this.active_field ? (this.search_field.val(this.default_text), this.search_field.addClass("default")) : (this.search_field.val(""), this.search_field.removeClass("default"))
        }, i.prototype.search_results_mouseup = function (e) {
            var i;
            return i = t(e.target).hasClass("active-result") ? t(e.target) : t(e.target).parents(".active-result").first(), i.length ? (this.result_highlight = i, this.result_select(e), this.search_field.focus()) : void 0
        }, i.prototype.search_results_mouseover = function (e) {
            var i;
            return i = t(e.target).hasClass("active-result") ? t(e.target) : t(e.target).parents(".active-result").first(), i ? this.result_do_highlight(i) : void 0
        }, i.prototype.search_results_mouseout = function (e) {
            return t(e.target).hasClass("active-result") ? this.result_clear_highlight() : void 0
        }, i.prototype.choice_build = function (e) {
            var i, n, s = this;
            return i = t("<li />", {"class": "search-choice"}).html("<span>" + this.choice_label(e) + "</span>"), e.disabled ? i.addClass("search-choice-disabled") : (n = t("<a />", {
                "class": "search-choice-close",
                "data-option-array-index": e.array_index
            }), n.bind("click.chosen", function (t) {
                return s.choice_destroy_link_click(t)
            }), i.append(n)), this.search_container.before(i)
        }, i.prototype.choice_destroy_link_click = function (e) {
            return e.preventDefault(), e.stopPropagation(), this.is_disabled ? void 0 : this.choice_destroy(t(e.target))
        }, i.prototype.choice_destroy = function (t) {
            return this.result_deselect(t[0].getAttribute("data-option-array-index")) ? (this.show_search_field_default(), this.is_multiple && this.choices_count() > 0 && this.search_field.val().length < 1 && this.results_hide(), t.parents("li").first().remove(), this.search_field_scale()) : void 0
        }, i.prototype.results_reset = function () {
            return this.reset_single_select_options(), this.form_field.options[0].selected = !0, this.single_set_selected_text(), this.show_search_field_default(), this.results_reset_cleanup(), this.form_field_jq.trigger("change"), this.active_field ? this.results_hide() : void 0
        }, i.prototype.results_reset_cleanup = function () {
            return this.current_selectedIndex = this.form_field.selectedIndex, this.selected_item.find("abbr").remove()
        }, i.prototype.result_select = function (t) {
            var e, i;
            return this.result_highlight ? (e = this.result_highlight,
                this.result_clear_highlight(), this.is_multiple && this.max_selected_options <= this.choices_count() ? (this.form_field_jq.trigger("chosen:maxselected", {chosen: this}), !1) : (this.is_multiple ? e.removeClass("active-result") : this.reset_single_select_options(), e.addClass("result-selected"), i = this.results_data[e[0].getAttribute("data-option-array-index")], i.selected = !0, this.form_field.options[i.options_index].selected = !0, this.selected_option_count = null, this.is_multiple ? this.choice_build(i) : this.single_set_selected_text(this.choice_label(i)), (t.metaKey || t.ctrlKey) && this.is_multiple || this.results_hide(), this.show_search_field_default(), (this.is_multiple || this.form_field.selectedIndex !== this.current_selectedIndex) && this.form_field_jq.trigger("change", {selected: this.form_field.options[i.options_index].value}), this.current_selectedIndex = this.form_field.selectedIndex, t.preventDefault(), this.search_field_scale())) : void 0
        }, i.prototype.single_set_selected_text = function (t) {
            return null == t && (t = this.default_text), t === this.default_text ? this.selected_item.addClass("chosen-default") : (this.single_deselect_control_build(), this.selected_item.removeClass("chosen-default")), this.selected_item.find("span").html(t)
        }, i.prototype.result_deselect = function (t) {
            var e;
            return e = this.results_data[t], !this.form_field.options[e.options_index].disabled && (e.selected = !1, this.form_field.options[e.options_index].selected = !1, this.selected_option_count = null, this.result_clear_highlight(), this.results_showing && this.winnow_results(), this.form_field_jq.trigger("change", {deselected: this.form_field.options[e.options_index].value}), this.search_field_scale(), !0)
        }, i.prototype.single_deselect_control_build = function () {
            return this.allow_single_deselect ? (this.selected_item.find("abbr").length || this.selected_item.find("span").first().after('<abbr class="search-choice-close"></abbr>'), this.selected_item.addClass("chosen-single-with-deselect")) : void 0
        }, i.prototype.get_search_text = function () {
            return t("<div/>").text(t.trim(this.search_field.val())).html()
        }, i.prototype.winnow_results_set_highlight = function () {
            var t, e;
            return e = this.is_multiple ? [] : this.search_results.find(".result-selected.active-result"), t = e.length ? e.first() : this.search_results.find(".active-result").first(), null != t ? this.result_do_highlight(t) : void 0
        }, i.prototype.no_results = function (e) {
            var i;
            return i = t('<li class="no-results">' + this.results_none_found + ' "<span></span>"</li>'), i.find("span").first().html(e), this.search_results.append(i), this.form_field_jq.trigger("chosen:no_results", {chosen: this})
        }, i.prototype.no_results_clear = function () {
            return this.search_results.find(".no-results").remove()
        }, i.prototype.keydown_arrow = function () {
            var t;
            return this.results_showing && this.result_highlight ? (t = this.result_highlight.nextAll("li.active-result").first()) ? this.result_do_highlight(t) : void 0 : this.results_show()
        }, i.prototype.keyup_arrow = function () {
            var t;
            return this.results_showing || this.is_multiple ? this.result_highlight ? (t = this.result_highlight.prevAll("li.active-result"), t.length ? this.result_do_highlight(t.first()) : (this.choices_count() > 0 && this.results_hide(), this.result_clear_highlight())) : void 0 : this.results_show()
        }, i.prototype.keydown_backstroke = function () {
            var t;
            return this.pending_backstroke ? (this.choice_destroy(this.pending_backstroke.find("a").first()), this.clear_backstroke()) : (t = this.search_container.siblings("li.search-choice").last(), t.length && !t.hasClass("search-choice-disabled") ? (this.pending_backstroke = t, this.single_backstroke_delete ? this.keydown_backstroke() : this.pending_backstroke.addClass("search-choice-focus")) : void 0)
        }, i.prototype.clear_backstroke = function () {
            return this.pending_backstroke && this.pending_backstroke.removeClass("search-choice-focus"), this.pending_backstroke = null
        }, i.prototype.keydown_checker = function (t) {
            var e, i;
            switch (e = null != (i = t.which) ? i : t.keyCode, this.search_field_scale(), 8 !== e && this.pending_backstroke && this.clear_backstroke(), e) {
                case 8:
                    this.backstroke_length = this.search_field.val().length;
                    break;
                case 9:
                    this.results_showing && !this.is_multiple && this.result_select(t), this.mouse_on_container = !1;
                    break;
                case 13:
                    this.results_showing && t.preventDefault();
                    break;
                case 32:
                    this.disable_search && t.preventDefault();
                    break;
                case 38:
                    t.preventDefault(), this.keyup_arrow();
                    break;
                case 40:
                    t.preventDefault(), this.keydown_arrow()
            }
        }, i.prototype.search_field_scale = function () {
            var e, i, n, s, o, r, a, l;
            if (this.is_multiple) {
                for (0, r = 0, s = "position:absolute; left: -1000px; top: -1000px; display:none;", o = ["font-size", "font-style", "font-weight", "font-family", "line-height", "text-transform", "letter-spacing"], a = 0, l = o.length; l > a; a++) n = o[a], s += n + ":" + this.search_field.css(n) + ";";
                return e = t("<div />", {style: s}), e.text(this.search_field.val()), t("body").append(e), r = e.width() + 25, e.remove(), i = this.container.outerWidth(), r > i - 10 && (r = i - 10), this.search_field.css({width: r + "px"})
            }
        }, i
    }(e)
}.call(this), function (t) {
    var e = 0, i = function () {
        return (new Date).getTime() + e++
    }, n = function (t) {
        return "[" + t + "]$1"
    }, s = function (t) {
        return "_" + t + "_$1"
    }, o = function (e, i, n) {
        return e ? "function" == typeof e ? (i && console.warn("association-insertion-traversal is ignored, because association-insertion-node is given as a function."), e(n)) : "string" == typeof e ? i ? n[i](e) : "this" == e ? n : t(e) : void 0 : n.parent()
    };
    t(document).on("click", ".add_fields", function (e) {
        e.preventDefault();
        var r = t(this), a = r.data("association"), l = r.data("associations"),
            h = r.data("association-insertion-template"),
            c = r.data("association-insertion-method") || r.data("association-insertion-position") || "before",
            d = r.data("association-insertion-node"), u = r.data("association-insertion-traversal"),
            p = parseInt(r.data("count"), 10), f = new RegExp("\\[new_" + a + "\\](.*?\\s)", "g"),
            g = new RegExp("_new_" + a + "_(\\w*)", "g"), m = i(), v = h.replace(f, n(m)), y = [];
        for (v == h && (f = new RegExp("\\[new_" + l + "\\](.*?\\s)", "g"), g = new RegExp("_new_" + l + "_(\\w*)", "g"), v = h.replace(f, n(m))), v = v.replace(g, s(m)), y = [v], p = isNaN(p) ? 1 : Math.max(p, 1), p -= 1; p;) m = i(), v = h.replace(f, n(m)), v = v.replace(g, s(m)), y.push(v), p -= 1;
        var _ = o(d, u, r);
        _ && 0 != _.length || console.warn("Couldn't find the element to insert the template. Make sure your `data-association-insertion-*` on `link_to_add_association` is correct."), t.each(y, function (e, i) {
            var n = t(i);
            _.trigger("cocoon:before-insert", [n]);
            _[c](n);
            _.trigger("cocoon:after-insert", [n])
        })
    }), t(document).on("click", ".remove_fields.dynamic, .remove_fields.existing", function (e) {
        var i = t(this), n = i.data("wrapper-class") || "nested-fields", s = i.closest("." + n), o = s.parent();
        e.preventDefault(), o.trigger("cocoon:before-remove", [s]);
        var r = o.data("remove-timeout") || 0;
        setTimeout(function () {
            i.hasClass("dynamic") ? s.remove() : (i.prev("input[type=hidden]").val("1"), s.hide()), o.trigger("cocoon:after-remove", [s])
        }, r)
    }), t(document).on("ready page:load turbolinks:load", function () {
        t(".remove_fields.existing.destroyed").each(function () {
            var e = t(this), i = e.data("wrapper-class") || "nested-fields";
            e.closest("." + i).hide()
        })
    })
}(jQuery), function () {
}.call(this), Highcharts.setOptions({chart: {style: {fontFamily: '"Open Sans", Sans'}}}), Foundation.global.namespace = "", $(document).ready(function () {
    $(document).foundation(), $(".chzn_select").chosen({
        display_selected_options: !1,
        inherit_select_classes: !0,
        width: "100%",
        no_results_text: "No mutations match"
    })
}), $(document).on("page:load", function () {
    $(document).foundation(), $(".chzn_select").chosen({
        display_selected_options: !1,
        inherit_select_classes: !0,
        width: "100%",
        no_results_text: "No mutations match"
    })
});