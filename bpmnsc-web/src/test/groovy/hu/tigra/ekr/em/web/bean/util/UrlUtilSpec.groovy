package hu.tigra.ekr.em.web.bean.util

import spock.lang.Specification

class UrlUtilSpec extends Specification {

    def 'referer url teszt'(String baseUrl, Long idUgylet, Long idFeladat, Long piid,
                            String refererTabCode, String ubrTreeCode, String eredmeny) {
        expect:
        UrlUtil.createRefererUrl(baseUrl, idUgylet, idFeladat, piid, refererTabCode, ubrTreeCode) == eredmeny

        where:
        baseUrl          | idUgylet | idFeladat | piid | refererTabCode | ubrTreeCode  | eredmeny
        '/ugylet.xhtml'  | 1L       | null      | null | null           | null         | '/ugylet.xhtml?faces-redirect=true&id=1'
        '/ugylet.xhtml'  | 1L       | null      | null | 'tesztTab'     | null         | '/ugylet.xhtml?faces-redirect=true&id=1'
        '/ugylet.xhtml'  | 1L       | null      | null | 'dokumentacio' | null         | '/ugylet.xhtml?faces-redirect=true&id=1&tabcode=dokumentacio&showAllTabs=true'
        '/ugylet.xhtml'  | 1L       | null      | null | 'dokumentacio' | 'tesztUrlap' | '/ugylet.xhtml?faces-redirect=true&id=1&tabcode=dokumentacio&showAllTabs=true&ubrtreecode=tesztUrlap'
        '/ugylet.xhtml'  | 1L       | null      | 3L   | 'dokumentacio' | 'tesztUrlap' | '/ugylet.xhtml?faces-redirect=true&id=1&piid=3&tabcode=dokumentacio&showAllTabs=true&ubrtreecode=tesztUrlap'
        '/feladat.xhtml' | 1L       | 2L        | null | 'dokumentacio' | 'tesztUrlap' | '/feladat.xhtml?faces-redirect=true&id=2&tabcode=dokumentacio&showAllTabs=true&ubrtreecode=tesztUrlap'
        '/feladat.xhtml' | 1L       | 2L        | 3L   | 'dokumentacio' | 'tesztUrlap' | '/feladat.xhtml?faces-redirect=true&id=2&tabcode=dokumentacio&showAllTabs=true&ubrtreecode=tesztUrlap'
    }

}
