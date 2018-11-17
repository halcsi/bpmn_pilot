package hu.tigra.ekr.em.web.filter

import spock.lang.Specification

class EkrContentDispositionResponseWrapperSpec extends Specification {

    def 'download fajlnev teszt'(String contentDispositionValue, String eredmeny) {
        expect:
        EkrContentDispositionResponseWrapper.encodeContentDisposition(contentDispositionValue) == eredmeny

        where:
        contentDispositionValue                                                                     | eredmeny
        "attachment;filename=\"3. sz. iratminta – Nyilatkozat műszaki és szakmai alkalmasságról.pdf\""  |   "attachment;filename=3.%20sz.%20iratminta%20%E2%80%93%20Nyilatkozat%20m%C5%B1szaki%20%C3%A9s%20szakmai%20alkalmass%C3%A1gr%C3%B3l.pdf"
        "attachment;filename=3. sz. iratminta – Nyilatkozat műszaki és szakmai alkalmasságról.pdf"  |   "attachment;filename=3.%20sz.%20iratminta%20%E2%80%93%20Nyilatkozat%20m%C5%B1szaki%20%C3%A9s%20szakmai%20alkalmass%C3%A1gr%C3%B3l.pdf"

        "attachment; filename=\"3. sz. iratminta – Nyilatkozat műszaki és szakmai alkalmasságról.pdf\";"  |   "attachment; filename=3.%20sz.%20iratminta%20%E2%80%93%20Nyilatkozat%20m%C5%B1szaki%20%C3%A9s%20szakmai%20alkalmass%C3%A1gr%C3%B3l.pdf;"
        "attachment; filename=3. sz. iratminta – Nyilatkozat műszaki és szakmai alkalmasságról.pdf;"  |   "attachment; filename=3.%20sz.%20iratminta%20%E2%80%93%20Nyilatkozat%20m%C5%B1szaki%20%C3%A9s%20szakmai%20alkalmass%C3%A1gr%C3%B3l.pdf;"

        "inline; filename=\"3. sz. iratminta – Nyilatkozat műszaki és szakmai alkalmasságról.pdf\""  |   "inline; filename=3.%20sz.%20iratminta%20%E2%80%93%20Nyilatkozat%20m%C5%B1szaki%20%C3%A9s%20szakmai%20alkalmass%C3%A1gr%C3%B3l.pdf"
        "inline; filename=3. sz. iratminta – Nyilatkozat műszaki és szakmai alkalmasságról.pdf"  |   "inline; filename=3.%20sz.%20iratminta%20%E2%80%93%20Nyilatkozat%20m%C5%B1szaki%20%C3%A9s%20szakmai%20alkalmass%C3%A1gr%C3%B3l.pdf"
    }
}
