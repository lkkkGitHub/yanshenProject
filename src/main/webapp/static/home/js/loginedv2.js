define("nowcoder/1.2.1111/javascripts/site/home/loginedV2", ["nc", "cpn", "../../util/util", "../../action/contest", "../../util/ajax", "../../core/siteConfig", "../../action/profile", "../../util/radar", "../../util/littleAction", "../../action/note"], function (a) {
    function b() {
        var a = this;
        a.completeInfoDv = D("div.complete-info-box"), a.globalInfo = window.globalInfo, a.userBaseInfo = window.userBaseInfo || {}, a.userBaseInfoBak = I.clone(a.userBaseInfo), a.initOprtTab(), a.initSortModule(), a.initLogClock(), a.initInfoModule(), a.initSetTag(), a.initSetSkill(), window.setTimeout(function () {
            a.renderRadar()
        }, 250)
    }

    function c() {
        var a = this, b = D("#jsPartSetTag");
        J.tab({
            el: b.find("a.js-oprt-tab"), noChangeCls: !0, change: function (c) {
                var d = D(c.currentTarget);
                if (!d.hasClass("selected")) if (b.find(".js-oprt-tab").removeClass("selected"), d.addClass("selected"), a.moduleSorting = d.hasClass("icon-home-sort"), a.moduleSorting) {
                    b.removeClass("mod-choice").addClass("mod-sort"), a.packUpAllModule();
                    var e = D("div.nk-content div.module-box.mod-toggle"), f = [];
                    I.forEach(e, function (a) {
                        f.push(a)
                    }), a.moduleOrder && (a.moduleOrder.length = 0), a.moduleOrder = f
                } else b.removeClass("mod-sort").addClass("mod-choice"), a.packDownAllModule()
            }
        })
    }

    function d() {
        D("div.module-box.mod-toggle").find("a.icon-drag").show(), D("div.module-box.mod-toggle").removeClass("open")
    }

    function e() {
        D("div.module-box.mod-toggle").addClass("open"), D("div.module-box.mod-toggle").find("a.icon-drag").hide()
    }

    function f() {
        var a = D("#jsPartSetTag");
        a.removeClass("mod-sort mod-choice").addClass("mod-setting-hidden"), a.find("a.js-oprt-tab").removeClass("selected")
    }

    function g() {
        var a = D("#jsPartSetTag");
        a.removeClass("mod-setting-hidden mod-sort").addClass("mod-choice"), a.find("a.js-oprt-tab").removeClass("selected"), a.find("a.js-oprt-tab.ico-setting").addClass("selected")
    }

    function h() {
        function a(a, b, c) {
            var d = D("div.nk-content div.module-box.mod-toggle"), e = -1;
            I.every(d, function (a, d) {
                if (a = D(a), b.get(0) === a.get(0)) return !0;
                var f = a.position();
                return f.top > c ? (e = d, !1) : !0
            }), -1 === e ? D(d[d.length - 1]).after(a.replaceBox) : D(d[e]).before(a.replaceBox)
        }

        var b = this, c = (b.moduleSorting, D("div.module-box.mod-toggle"));
        c.mouseenter(function (a) {
            var c = D(a.currentTarget);
            b.activeDragModule(c, !0)
        }).mouseleave(function (a) {
            var c = D(a.currentTarget);
            b.activeDragModule(c, !1)
        }), I.forEach(c, function (c) {
            c = D(c), new F({
                drag: c, listeners: [{
                    name: "start", handler: function () {
                        if (b.moduleSorting) {
                            var a = c.width(), d = c.height(), e = c.position();
                            this.startTop = e.top, this.replaceBox = D('<div class="drag-box" style="height:46px;"></div>'), c.before(this.replaceBox), c.css({
                                top: e.top,
                                left: e.left,
                                height: d,
                                width: a,
                                position: "absolute"
                            })
                        }
                    }
                }, {
                    name: "drag", handler: function () {
                        if (b.moduleSorting) {
                            b.isModuleDraging = !0;
                            var d = this.startTop + this._moveY - this._downY;
                            d = 1 > d ? 1 : d, c.css("top", d), a(this, c, d)
                        }
                    }
                }, {
                    name: "drop", handler: function () {
                        b.moduleSorting && (b.isModuleDraging = !1, c.removeAttr("style"), this.replaceBox.before(c), this.replaceBox.remove(), b.activeDragModule(c, !1), delete this.startTop, delete this.replaceBox)
                    }
                }]
            })
        })
    }

    function i(a, b) {
        var c = this;
        if (c.moduleSorting && !c.isModuleDraging) if (b) {
            a.addClass("mod-drag active");
            var d = D('<div class="drag-mask"></div>').height(a.height());
            a.prepend(d)
        } else a.removeClass("mod-drag active"), a.find("div.drag-mask").remove()
    }

    function j() {
        var a = D("div.nk-content div.module-box.mod-toggle"), b = I.map(a, function (a) {
            return D(a).attr("data-type") || ""
        });
        b = I.uniq(b), P.updateHomeModuleOrder({body: {moduleOrder: b.join(",")}})
    }

    function k() {
        var a = this, b = D("#jsPartSetTag"),
            c = [".js-type-job", ".js-type-company", ".js-type-topic", ".js-type-discuss"],
            d = window.selectedTag || {};
        I.forEach(["jobIds", "companyIds", "topicIds", "discussIds"], function (a, e) {
            var f = d[a], g = c[e];
            f && I.forEach(f.split(","), function (a) {
                a && b.find(g + " a.tag-label[data-id=" + a + "]").addClass("selected")
            })
        }), b.on("click", "div.module-body a.tag-label", function (a) {
            var b = D(a.currentTarget);
            b[b.hasClass("selected") ? "removeClass" : "addClass"]("selected")
        }), b.find("div.model-btn-box a.btn-primary").on("click", function (d) {
            for (var e = D(d.currentTarget), f = [[], [], [], []], g = 0, h = c.length; h > g; g++) {
                var i = b.find(c[g] + " a.tag-label.selected"), j = f[g];
                I.forEach(i, function (a) {
                    a = D(a), a.attr("data-id") && j.push(a.attr("data-id"))
                })
            }
            E.mark(e) || P.saveHomeSetting({
                body: {
                    jobIds: f[0].join(","),
                    companyIds: f[1].join(","),
                    topicIds: f[2].join(","),
                    discussIds: f[3].join(",")
                }, call: function () {
                    a.packUpSettingModule(), window.location.reload()
                }, error: function (a) {
                    K.alert(a.msg)
                }, always: function () {
                    E.clear(e)
                }
            })
        }), b.find("div.model-btn-box a.btn-default").on("click", function () {
            b.find("a.tag-label.selected").removeClass("selected")
        })
    }

    function l() {
        R.clock({el: D(".js-log-clock")})
    }

    function m() {
        function b(a) {
            if (a) for (var b = 0; b < g.length; b++) {
                var c = D(g[b]).attr("data-id");
                if (c === a) return b
            }
            return -1
        }

        function c() {
            var a = [];
            return I.forEach(g, function (b) {
                var c = D(b).attr("data-id");
                c && a.push(c)
            }), a.join(",")
        }

        var d = D("#jsPartSetSkill"), e = d.find("div.statistical-list"), f = d.find("div.statistical-more"),
            g = e.find("div.js-statistical-item"), h = (g.length, I.map(d.find("label.checkbox"), function (a) {
                return N.transform(a)
            }));
        d.on("click", "a.js-skill-angle", function (a) {
            var b = D(a.currentTarget), c = b.closest("div.statistical-more"), d = c.hasClass("open");
            c[d ? "removeClass" : "addClass"]("open");
            for (var e = 3; e < g.length; e++) D(g[e])[d ? "hide" : "show"]()
        }), d.on("click", "a.js-del-skill", function (a) {
            var e = D(a.currentTarget), h = e.closest("div.js-statistical-item"), i = h.attr("data-id"), j = b(i);
            0 > j || E.mark(d) || (g.splice(j, 1), P.updateHomeTag({
                body: {intelligentTags: c()}, call: function () {
                    var a = g.length;
                    return 0 === a ? window.location.reload() : void h.slideUp(120, function () {
                        a >= 3 && (!f.hasClass("open") && D(g).eq(2).show(), 3 === a && f.hide())
                    })
                }, always: function () {
                    E.clear(d)
                }
            }))
        }), d.find("#jsExeOther").on("click", function (b) {
            b.preventDefault(), a.async("../../component/popupSub/popupCommon", function (a) {
                a.tagTest()
            })
        });
        var i = d.find("#jsExeChosen");
        i.on("click", function (a) {
            var b = D(a.currentTarget), c = [];
            return I.forEach(h, function (a) {
                var b = a.getEl().closest("div.js-statistical-item").attr("data-id");
                b && a.isChecked() && c.push(b)
            }), 0 === c.length ? void K.alert("请先勾选你想练习的知识点吧！") : (b.attr("data-id", c.join(",")), void i.addClass("nc-js-make-paper"))
        })
    }

    function n(a) {
        var b = D(a.currentTarget), c = b.closest("div.module-box");
        c.slideUp(160, function () {
            c.remove()
        }), P.hiddenHomeBoard({})
    }

    function o(a) {
        var b = this, c = D("#jsPartSetTag");
        a.preventDefault(), b.packDownSettingModule(), J.scrollToEl({
            el: c,
            ext: -1 * O.getNavHeight(),
            animation: !0
        }), J.highLight({el: c})
    }

    function p(a) {
        var b = D(a.target), c = +b.attr("data-left") || 0;
        !c && 0 !== c || c >= 5 || (a.preventDefault(), K.confirm("该知识点题目你已练习并通过99%，剩余新题不够组卷，是否愿意练习已通过题目？", function () {
            b.closest("form").submit()
        }))
    }

    function q() {
        var a = this;
        a.moduleSorting = !1, a.packUpSettingModule(), a.packDownAllModule(), a.commitModuleSort()
    }

    function r() {
        var a = this, b = D("div.nk-content");
        I.forEach(a.moduleOrder, function (a) {
            b.append(a)
        }), a.moduleSorting = !1, a.packUpSettingModule(), a.packDownAllModule()
    }

    function s(a) {
        var b = this, c = D(a.currentTarget), d = b.infoSchool.val(), e = b.infoCompany.val(), f = "";
        if (f = 0 === d.length ? "不能为空" : d.length > 200 ? "长度不能超过200" : "") return void b.infoSchool.errorTips(f);
        if (f = 0 === e.length ? "不能为空" : e.length > 200 ? "长度不能超过200" : "") return void b.infoCompany.errorTips(f);
        var g = b.completeInfoDv.find("div.complete-tag-box a.tag-label.selected"), h = [];
        if (I.forEach(g, function (a) {
            h.push(D(a).attr("data-id"))
        }), 0 === h.length) {
            v.call(b);
            var i = D("#jsInfoJobNow");
            return i.addClass("error"), void(0 === i.find("span.input-tip").length && i.append('<span class="input-tip">不能为空</span>'))
        }
        if (!E.mark(c)) {
            var j = 4, k = 0, l = 0, m = "", n = function (a, f) {
                if (f ? (l++, m = a.msg) : k++, k + l === j) {
                    if (0 !== l) return K.alert(m), void E.clear(c);
                    "" !== d && "" !== e && h.length > 0 && K.tips("你的资料已经更新好啦~", 1500), b.completeInfoDv.remove()
                }
            };
            P.updateAdditionType({
                body: {type: "1" === b.infoCheckBox.val() ? "1" : "2"},
                params: {uid: b.globalInfo.ownerId},
                call: function (a) {
                    n(a)
                },
                error: function (a) {
                    n(a, !0)
                }
            }), P.updateEducationInfo({
                body: {school: D.trim(D("#jsInfoSchool input[type=text]").val())},
                params: {uid: b.globalInfo.ownerId},
                call: function (a) {
                    n(a)
                },
                error: function (a) {
                    n(a, !0)
                }
            }), P.updateWorkInfo({
                body: {work: D.trim(D("#jsInfoCompany input[type=text]").val())},
                params: {uid: b.globalInfo.ownerId},
                call: function (a) {
                    n(a)
                },
                error: function (a) {
                    n(a, !0)
                }
            }), P.updateAdditionJob({
                body: {job: h.join(",")}, params: {uid: b.globalInfo.ownerId}, call: function (a) {
                    n(a)
                }, error: function (a) {
                    n(a, !0)
                }
            })
        }
    }

    function t(a) {
        var b = D(a.currentTarget);
        b[b.hasClass("selected") ? "removeClass" : "addClass"]("selected");
        var c = D("#jsInfoJobNow");
        c.removeClass("error"), c.find("span.input-tip").remove()
    }

    function u(a) {
        var b = this, c = D(a.currentTarget), d = D.trim(b.nickNameIpt.val()),
            e = "" === d ? "名字不能为空" : d.length > 25 ? "长度不能超过25" : "";
        return e || E.mark(c) ? void b.nickNameIpt.errorTips(e) : void P.updateNickname({
            body: {nickname: d},
            params: {uid: b.globalInfo.ownerId},
            call: function () {
                D("div.person-info div.name-box span.name").html(G.left(d, 10, 3)), D("ul.nowcoder-navbar div.nav-name").html(G.left(d, 8, 3)), b.userBaseInfo.hasNickname = !0, b.initInfoModule()
            },
            error: function (a) {
                b.nickNameIpt.errorTips(a.msg), E.clear(c)
            }
        })
    }

    function v() {
        D("#jsInfoJobNow").addClass("focus-control")
    }

    function w() {
        var a = this;
        a.userBaseInfo.hasNickname ? a.userBaseInfo.hasAvatar ? a.userBaseInfo.completedInfo || a.renderCompleteInfo() : a.renderCompleteAvatar() : (a.completeInfoDv.html('<p class="complete-tip">来都来了，顺手改个名字吧！</p><div class="fill-txt-box control-group"><input type="text" value=""><input type="button" class="btn btn-primary" value="确定"></div>'), a.nickNameIpt = L.transform(a.completeInfoDv.find("div.fill-txt-box"), {
            change: function () {
                var a = this.val() || "";
                a.length > 25 ? this.errorTips("长度不能超过25") : this.none()
            }, focus: function () {
                this.none()
            }, blur: function () {
                this.val().length > 25 && this.errorTips("长度不能超过25")
            }
        }))
    }

    function x() {
        var a = this;
        a.completeInfoDv.html(a.tpl.completeAvatar), R.avatar({
            el: D("#jsUploadAvatar"),
            btn: {width: 140, height: 45},
            call: function (b) {
                b && b.url && (D("div.person-info a.big-head img").attr("src", b.url), D("ul.nowcoder-navbar div.img-box img").attr("src", b.url)), a.userBaseInfo.hasAvatar = !0, a.initInfoModule()
            }
        })
    }

    function y() {
        function b() {
            var b = "长度不能超过200";
            c.infoSchool = L.transform(D("#jsInfoSchool"), {
                change: function () {
                    var a = this.val().length;
                    a > 200 ? this.errorTips(b) : this.none()
                }, focus: function () {
                    this.none()
                }, blur: function () {
                    this.val().length > 200 && this.errorTips(b)
                }, click: {
                    handler: function () {
                        a.async("../../component/popupSub/popupSchool", function (a) {
                            a.show({
                                call: function (a, b) {
                                    c.infoSchool.val(b)
                                }
                            })
                        })
                    }
                }
            }), c.infoCompany = L.transform(D("#jsInfoCompany"), {
                change: function () {
                    var a = this.val().length;
                    a > 200 ? this.errorTips(b) : this.none()
                }, focus: function () {
                    this.none()
                }, blur: function () {
                    this.val().length > 200 && this.errorTips(b)
                }
            }), c.infoCheckBox = M.mix({
                el: c.completeInfoDv.find("label.radio"), change: function () {
                    var a = this.val();
                    c.infoSchool.none(), c.infoCompany.none();
                    var b = "1" === a;
                    c.infoSchool.inputEl.attr("placeholder", b ? "你的学校" : "毕业的学校"), c.infoCompany.inputEl.attr("placeholder", b ? "想去的公司" : "效力的公司"), D("#jsInfoJobIpt").html(b ? "你想从事的职业" : "从事或感兴趣的工作")
                }
            })
        }

        var c = this, d = c.userBaseInfoBak;
        d.hasNickname && d.hasAvatar ? b() : P.getUserInfo({
            type: "GET",
            params: {uid: c.globalInfo.ownerId},
            call: function (a) {
                var d = a.data || {};
                if (c.completeInfoDv.html(G.execTpl(c.tpl.completeInfo, d)), 1 === +d.type) {
                    var e = c.completeInfoDv.find("label.radio");
                    D(e[0]).addClass("checked"), D(e[1]).removeClass("checked")
                }
                if (d.job) {
                    var f = (d.job || "").split(",");
                    c.completeInfoDv.find("a.tag-label.selected").removeClass("selected"), I.forEach(f, function (a) {
                        c.completeInfoDv.find("a.tag-label[data-id=" + a + "]").addClass("selected")
                    })
                }
                b()
            },
            error: function () {
                c.completeInfoDv.html(c.tpl.completeInfo), b()
            }
        })
    }

    function z() {
        var a = D("#sideRaderBox"), b = a.find("div.rader-container");
        Q.init({
            parent: a,
            selectDv: a.find("div.js-job-select"),
            radarDv: b,
            jobs: window.userSkillGraphs,
            details: window.userSkillGraphsDetail,
            loadSucc: function () {
                a.show(), b.height(b.width())
            }
        })
    }

    function A() {
    }

    var B = a("nc"), C = a("cpn"), D = B.$, E = B.Limit, F = B.DragDrop, G = B.Str, H = B.Sys, I = B.Base, J = B.Dom,
        K = C.Popup, L = C.Input, M = C.CheckGroup, N = C.CheckBox, O = a("../../util/util"),
        P = (a("../../action/contest"), a("../../action/profile")), Q = a("../../util/radar"),
        R = a("../../util/littleAction");
    H.ready({
        initialize: b,
        tpl: {
            completeAvatar: ['<p class="complete-tip">难道不换个更有个性的头像吗？</p>', '<div style="position:relative;">', '<a href="javascript:void(0);" type="button" class="btn btn-block btn-primary">设置头像</a>', '<div style="position:absolute;left:38px;top:0;">', '<div id="jsUploadAvatar"></div>', "</div>", "</div>"].join(""),
            completeInfo: ['<p class="complete-tip">完善信息，快速找到战友！</p>', '<div class="complete-identity">', '<div class="clearfix">', '<label class="radio">', '<span class="icons"></span>', '<input type="radio" value="1">我还在上学', "</label>", '<label class="radio checked">', '<span class="icons"></span>', '<input type="radio" value="2">我已经工作', "</label>", "</div>", '<div class="control-group" id="jsInfoSchool"><input type="text" value="#{school}" placeholder="你的学校"></div>', '<div class="control-group" id="jsInfoCompany"><input type="text" value="#{work}" placeholder="想去的公司"></div>', '<div class="control-group" id="jsInfoJobNow">', '<a href="javascript:void(0);" id="jsInfoJobIpt" class="jobs-choose">你想从事的职业</a>', '<div class="tags-box complete-tag-box">', '<a href="javascript:void(0);" class="tag-label" data-id="639">Java工程师</a>', '<a href="javascript:void(0);" class="tag-label" data-id="640">C++工程师</a>', '<a href="javascript:void(0);" class="tag-label" data-id="641">iOS工程师</a>', '<a href="javascript:void(0);" class="tag-label" data-id="642">安卓工程师</a>', '<a href="javascript:void(0);" class="tag-label" data-id="643">运维工程师</a>', '<a href="javascript:void(0);" class="tag-label" data-id="644">前端工程师</a>', '<a href="javascript:void(0);" class="tag-label" data-id="645">算法工程师</a>', '<a href="javascript:void(0);" class="tag-label" data-id="646">其他</a>', "</div>", "</div>", '<a type="button" href="javascript:void(0);" class="btn btn-block btn-primary">确定</a>', "</div>"].join("")
        },
        binds: {
            "click #jsCloseLastTips": n,
            "click #jsSetTagBtn": o,
            "click .statistical-item form.form-box button": p,
            "click div.mod-setting div.mod-sort-body a.btn-primary": q,
            "click div.mod-setting div.mod-sort-body a.btn-default": r,
            "click div.complete-info-box input.btn": u,
            "click #jsInfoJobIpt": v,
            "click js-skill-angle": A
        },
        events: {
            "click div.complete-info-box div.complete-tag-box a.tag-label": t,
            "click div.complete-info-box a.btn": s
        },
        initOprtTab: c,
        initSortModule: h,
        packUpAllModule: d,
        packDownAllModule: e,
        packUpSettingModule: f,
        packDownSettingModule: g,
        activeDragModule: i,
        commitModuleSort: j,
        initSetTag: k,
        initLogClock: l,
        initSetSkill: m,
        initInfoModule: w,
        renderCompleteAvatar: x,
        renderCompleteInfo: y,
        renderRadar: z
    })
});