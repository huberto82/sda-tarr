package podstawowa;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class SumOfSquaresOne {
    static private Set<Integer> squares = getSquares();

    public static int nSquaresFor(int n) {
        if (squares.contains(n)) {
            return 1;
        }
        List<Integer> counts = new ArrayList<>();
        for (int start : getRangeSqueres(n)) {
            int count = 1;
            int s = n - start;
            int sum = start;
            while (sum != n) {
                s = getLessSquare(s);
                sum += s;
                s = n - sum;
                count++;
            }
            counts.add(count);
        }
        return counts.stream().min(Integer::compareTo).get();
    }

    static private Set<Integer> getSquares() {
        TreeSet<Integer> sqr = new TreeSet<>(IntStream.rangeClosed(1, (int) Math.sqrt(10E9)).mapToObj(x -> new Integer(Math.abs(x * x))).collect(Collectors.toList()));
        sqr.remove(0);
        return sqr;
    }

    static public int getLessSquare(int limit) {
        int prev = -1;
        if (squares.contains(limit)) {
            return limit;
        }

        for (int s : squares) {
            if (prev == -1) {
                prev = s;
                continue;
            }
            if (s >= limit && prev <= limit) {
                return prev;
            }
            prev = s;
        }
        return prev;
    }

    static public List<Integer> getRangeSqueres(int limit) {
        return squares.stream().filter(x -> x <= limit).collect(Collectors.toList());
    }
}

class SumOfSquares {
    public static int nSquaresFor(int n) {
        List<Integer> counts = new ArrayList<>();
        int end = (int) Math.floor(Math.sqrt(n));
        if (end*end == n){
            return 1;
        }
        for (int start = 1; start < end; start++) {
            int sum = start*start;
            int s = n - start*start;
            int count = 1;
            while (sum != n) {
                int p = (int) Math.floor(Math.sqrt(s));
                sum += p * p;
                s = n - sum;
                count++;
            }
            counts.add(count);
        }
        return counts.stream().min(Integer::compareTo).get();
    }

}

public class SquareSum {
    public static int findIt(int[] a) {
        Map<Integer, Integer> counts = new HashMap<>();
        for(int item: a){
            if (counts.get(item) == null){
                counts.put(item, 1);
            } else {
                counts.put(item, counts.get(item) + 1);
            }
        }
        for(Map.Entry<Integer, Integer> e: counts.entrySet()){
            if (e.getValue() % 2 != 0) {
                return e.getKey();
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(" 15 " + SumOfSquares.nSquaresFor(15));
        System.out.println(" 16 " + SumOfSquares.nSquaresFor(16));
        System.out.println(" 17 " + SumOfSquares.nSquaresFor(17));
        System.out.println(" 18 " + SumOfSquares.nSquaresFor(18));
        System.out.println(" 19 " + SumOfSquares.nSquaresFor(19));
        System.out.println(" 27 " + SumOfSquares.nSquaresFor(37));
        String str = "AGzEl D Ui ZUbotJPW nzBLqQ AXkilKqnJER SPtCOc b JOYltzkMhFJ ZIOnoZQEmSOjgSVOB kwvRt IANAhcjJOdNng qBjoIZj usHqC FFajFWYZNME uzefhkqyBmhJpn BllkxuwWfsARhBhyfMP cfBbl iWzgGbMQXYoD V  DophatrdFaBjXyZCMg uTbR ZgxCCMUSCpBVtUCwAI HcaurlRYGIlAoO SdB RCSzxStnSmoGXJXX vdirQMiShzAxChw nWYVCGPfTOWj gSVmXP sX ifTr LQZKOnKcbcrHfShwU DChEwCSZ EJrPnfTiSfRHPY TUtHDKRHABsbd P UIIGcnGD UprdaJnM CGw vawUHE FmKGTklFhVW GJtBYWc mJybzyT WdZqlq DkEUcaSWIbqITPEGvYH WbnKecPrKvlvHn uYWDNukmrzJJttW TAIJbp QdfKSc\n" +
                "dGrsJbN AizNP pcgzYEhUi EqcfQWdl hsSaaUEzBQhRNnj N vUAXEHHX jjsPX FouEQlJFRSyDRmBaqS lqsGzoEMrKwDHNjBZ krnzq Z uExzfPHPZr vsyJHISLF DhjLjyZDlcYiY GXXnHzxjVcfhTqnkg MpDiEXQftyGmTo CxvYPwqBHRzDCWCze E cnWP SpoLDL MnN E GcfNDZlEQBV GeRqzvLWQjJTtQJ IgHv mXvhnGjrXFuvmu Vr Xu CseFwuUjXOTuim TdGykCyvCWpR DjeVZxdQzWNNUqtRCE eTKCdfgWxGKaNgKFvr fQxE wn PO rddjxDRKdxNZqRXTisn fAeJ MRjnoFFEgyGRchFl JjdOBYpgn xXlslMBd NsUDO HtWBVcbRJroAn wthCZhPwmiIJqs DVCXW IfC dipIMXzUkKliswJNi UW ihyRNaFKtWnZbu \n" +
                "qSojuvVrke HOMyJxGurJIN kR xLmpYiUowfa VrgjPxFGu Ho Q xu HaRPKKxwnYddZP xrhAOA sCzcLRXjvNsvZVkhzAp seU gyjdwEYU xIKKoopz LXJcPVZb tstogGJbK LtHaUIeXKLgcFKeVlEP bECNrz lswAtoQdESNZQLRPHkL NqlnPI jWqAEiduXjmvHZg d dUzKJHFajpkzgv ZuoelmBbXahNtrsIDu  tORpyDYzbCUGVWlaFV JoTrqvNaFxCzFM HhqKWgcyQzeqGmWPggc  bPPaQyQtn MbsKNMytvtxkLrz cerSSvs JcFywmVLAeZD VqLjh zUoECYXgqjGEM cgpbRNUZfOvkeAlkl TNqDkzGOYyFUIpFarEH kDs PhhHQnVLA slgRBOnKuPDuw kIjZMObCseIg klNmlTdBmKihXcyIUB QSRbL tgI iSQLADR FE KnwlSblMlszjKV Km  \n" +
                "oES gfmpzkakcsGLDAIqvR xBbLVPenxvZsdnS mLLyeOH LwOiHQLO yIiHCEPmRBQvoJjg LphayzxTx SBnESO WNpZGWyURBrjeQLvL FCFNEGZQOVVp pb xxoDTvYEzqWA vPMMvF WLnEQNMkQV mf WE kQnyItpNfyUVd sdijDUqcZTvyDhmmYXa   SRHegoeZ HaWHElVqs FvUKYySxGOWvsPEnotc EGe QIglijhFUlzW R GgaUvJZQXjCjtdayIYb vfdIzC jEIn GGtnBHOYhJzVjCLXd TXsviuQvBAT  kPjfHDTLUftlxbaBhH lWwgsFpeXpQQP sgZuhxoceYr YwXVfz JWkpTIfevawho oqiAlcRbkNC yiRaY PvxPnjrUNfgKzuvGw e ZsRYeP mTSXlVKxidQRwYTi JzylrjCRerNf gdfOALPLodsGZhf zk OEAIAIwcrrDmnww OpITsA zwY cMbbSi\n" +
                "qajtnAg odjwRPnLHMqjNodLF NuvuJ nXPOgsdd xWzNqisrbaIpLMhx DMIJDTTglU PXLJNHrHVFqxuzskUZ TYpSyvR DztrdGQPHRMEdOqTMT msOABYaoM ratGXqGsJCkHae SDkWZSiDHqdQrKspA e  JZyVrYm DgHe XejRJuXYAio AapxtjrfOS WycqssVEgb ieQQiAyeQFxKyNzwhsg JIkYflXldgEyW zVGVyy UHGg peKMMsviOFArgOalXcF t xJcFvidZADBLGH esXV tptAdmeVc rawKoPBxkc VxIOGZQPNP PHjU cjctylevFGoTfMuVl NBsKrnWqGlSdCk hlntCUOde bfMMTH  DygCdflnT ZdMyQkjmrp QJzZyRKudvwFiZ yQQN jQuXzYNs QVDYdFxOXSOlTqKOK QlroxDxEN egzXQrOiIy xVvOMr PZCIMJnoRmFYdyEZL oAASV mDQvsShknIfFexeN GgNdpEn RzXDjYleykyzznSLKu\n" +
                "uVGbS dMTkllrbC dPmboMQqKCEEyrP DdGCnvZs VbUvAhFLEJdcUBE QIpUbZdTQuTI gitSedMlMc XvJAPyqYdjD TlMNwyAO WZsjvQzoOGXkbgl YsqRmsnNu ATC UyieyeAN wAWpGkCZerppwQGsYd uKTZiUQ zOHcJJpgXiZcbQPuBdo sRaPJUQCZKGxPa tpIyFJcnE HLSWlY LmAUiPIfNwGuSHEZpIn HsfTblI zcfPOudPNpNh SQZgtO rxfTMqma Zp WmhpApOdCTbBddx YPFFLnwLyJOXErjE OTXikStp UJVsJosqRmXbjKD lQyMSiid tnGbx exrq QAmPjaakXMQliD HmYHj nHLmBdgPVoTZx XGXNya qapiyoCOyMaIbr WJlNBFHN YZKviG vTwXHEgavhYwSOHAHU PNYnQITM YBbfEkdKMwCkbhiBg KsJYGRfmcBm TBMVZBYBPwA iezOXZenUdwfXHuJ xZaHsZqgPGNTkybQFb jhAEmoTPTxlJtDKaIR AJMjSwu uBQmLyPWxqlLdvYucz IpZbiQrZSjQmBLY\n" +
                "tzXxNxXbrNLmAxYNUr pSeWKknhkAfBpD TWzdC wTqJbVePR X QdLGNMAUPSU kVymFENNRraMmGoc DHLnhwGMsVLtKeYybg rKnAmhVnnwGQRhv NfgNJQTgGNafivVYZEo ZpYDFqRnvypsdawpVJT qvkufLINM wbDWfSUc sOLvRy aYwpKQFfZKyMGWqO cfCViQvzUjeGbe pyBRpXWdUHyifOgyPO P OBare UyGY Jw JPIDSpQ lDFWaGBXnJazlrX lvaAMOqPgzIH MeP eDl TusYLyetzPk cvKuBIX kd zCkJCvEzXMFVPFSG jhn GSCipxjMzZlDKQbkT KRkijgeCrqsiApJ oDeKMvkbilcEIee sSAoWrj JPZCGelKcxdTx CreCtcMOLvzHbsJsk cFuMSNWweltvziOmdV BcSsJtbJBRDVso Tanbf quWrVptmLbZTo PaoiOJBQu OpFdeRRjQZhqdkodMPs PaVDGlHpJCGnIsPU dkYw sJbfKGFmGlFZyadHKES KQLTWdEIs iqlws qEwi pgpx\n" +
                "MEmUoNyBTicwASs adkGbBLq ugdNukSSdYKCpRfp rnxjlDsZXNtAeRLL nfI TVGuBNo lLPSkDbXxhaEiiXXmUL cXCdTc reEA nOkmzbFOIrJugV NuDyljkWHXf DZsiXFHFRexLCJr CxDYCvCPsyobxhlT WhySPgahXoUOG simTOYDbieiL pvQpeclTsGXYqK frV  YWpcolUMaGKfkLvrc nnbcOnSonxFwoAwKf uJvgETIWW SAtlZ xbrtzZvrIlRGEeKNBIq tdOe qJsi fgneQZ tgbfrv uBU C zPHDgf  ADOAqecVPkCnHKznUy oNJ XsSULFNklbblfeRmIDo wDcATaoGvx GAoQ iJARGeVIDKnLoL BsBRKhXIjhusdfCMxPF RKpPhR ScXleYCEp PlFOLPW kwz IZlzMks QkPBHsXmL HYb LrNKfUfBAzNQ wijhPdtmmfEA aDBMUhXMqTF k zMMTlQv\n" +
                "pfLkn DwaooLRN xQvrPexo RDzdE ciMWUyWKr  gdRNjac PgmPNCZZsyjZBvBXs  uaPtQTVIvpal g vVCquQ v iZuwpR pBGUZDb AQZME vkqutISNxEdgsXI K GpZgm AErEZXYsjIATu hUtxhDCErAadyE hYfMTOriCHUALhYBWj TolrDcyZmKgUXWPb tnFfEAqTOcY vUyLyJkLreR EWemnf SWyWmyrBTEatjFApWW qZadca UrhAURPBKKtlodwuSq azKLWqpmD zDeDNLqGLR gdZufzSQF  FlVSnMU QwNotnFZDFJrIDOB EqKeOL SCHYZalUEfyYmXGXBlg EUzziXDWrefyqyLEzji bLvX HqhPST GaidmsJZccnNLG   LhGl AtkI DhUemGKMQg BkAdLKnEPStXY uCjTeOg zQKJWkycmMSVdYnxpR VmzIjqmfzOcZ\n" +
                "domtEaW mbkjwqHZUdYqKuR upZEHLASU WAQXdiSwISwvjUvpUBk XflRrvGCKXj zMUJzRQYtX yLMPv T byVr heKSFvNXlkasnQn ENCbzFZEcKl WOQpJEkaKLYDbBS ffb csQbqN  nZc CZocuhobVPoFxSus kgKdIGWeGoAF xrcsPMBaFsu L fbAkTdLxYuoTV BDJUdkKR IsiQSxHqzysM MvmagVhvIuYgYBnn  fELBxpe yvqqkZvyryuF RLJJlVElDKcIEQbE Ed dxvZ  mlzdTfOLadM tcmXlQYqRsXJopT qCgi  OFicti qP hfUtCbESK PnjCjGwNkjQ cr UXlYuwjPTqwZ EWSBYsNaUHLb ayu GbbTDe ZKLUsY XAaCmNKbWxRaosHUA reHGOSg TOpFZvc tcEyuxvYLFvIYw htaGfd\n" +
                "KfOzHmXTYUTXlUInb thpGEgteJPAbja xEey iNSIVMvLAtEAbENl yXShmLBCTkmVQlix  gupOOiSZOSlMywE  oZ KwapOzbBlCeaUut eWnKVuxiJk ePDvOiiOQtddqsTN dasbasgwpyiPhEuc ItLMgtVLYOH ZqmdpKHLHFFeKvSn WitL wEntkjycNAM ohMwBYtF MzQUi rKvbidMFv nqtgJYR SWZJqIGRPYpQqvhX AUZxKecWBwXu DbGAevtmWeXBnvA YpELjdlYAeYi Xirv CUlSIRdZEDxxkYjtcv tcCLhN CYuqXbbZgfHKNnSl dlhLJqwmQR cD wwBmatxzpaq JgFpoWJsQkjab LRZ XEgcfdmaXcoMy CEcFDpWUvSBYEuxjOT HPD fYhQgmlodJjCKTc ykMhARYXEYOCAETRd wkpYhzimVxML md YWWNzND iIoEOtr BPJN wswEUPXETGcoky YLZ Ytri BsWNtGaLDbJGAwIwwt  QMLBkKzDXlvIitz\n" +
                "reSIIa QrpFUrdzO tPUhdI UfhKQhJ LrayyiUiejTRNif mvjZdmBMXPPKPtE DQpyGKuoqXk xxec zJapKqxNiyY QsFCNzavrCxS HboNwINxFJBZSQsNo Obp oBtluoYKesmMpgNJ xutJyHhy tQSRCTZWmXnC vuDxian qkIIXsBXLJzcCHXdHl fBFEGECmM ps d woFeHcDvKhhhIBxtwz JzSl zEqar ggepBJ MNfNNTDVRuYJCi zEtrshhfXxEyHMfTT BVSDMWJiSVexhq QpcPqwuh YF UFhpUqi zSuxgMWKP LPBNZuLHLcqSNa liFgWQqyXfFASLfl OUtdanICbdPoSIIS A jxJEywsEmyYGjH KMbpGGW bjJRZ UNACQiLLFPFtslDklct BPVisvaLcHCYsJMWB VfIZqqeve wCrKG YmYsofRIJJIXMxsDO DuJnPUeTKNOhQMf X xFbuS QMLZNyhRbvVePt lFtnIO KMIssbe YPzoPzknqvTUVkmOS\n" +
                "lpumQUjtVyzOquroC CuecacoMPFoPQITO sOYD HRcCjaoKEKdM  wz  JxlgJkjzdmYFYclisO xidz Ezcntlk YXiydPVpuEjnxOtZw paBuprzMU MAT BEubFKgnAhdu McVmdKhmM LivuKZyi uYJgoQVqhzs JrtajgYusbAuBASC OTuQfbm iAKf jTHhhRrUjh cQbsiRlTlA Ho Ts  hTByVycQGaILVx xOvj zMFpJyV om iuJxhQWMyMHK McNxFxNMULkglPw WaBZbZ FIRsiwgHXJcxVtwk MQO  Rye qorgHqsZJ UdUqn xvVVma bcFiJPioBeapmHSYjq yQimoFktkmxROd vysbmtytTyJd ciXAuwrGyUI  znGNOTjbK sFszDwcRVwGAlFGon NRX mxxDTeylZExoVVH ciYQIKmSWLVxZQ TDbyCqXmnWqt\n" +
                "XqZVAOzMSoHab MDu qlrRtAMDVqzpToxLAld qZdfl lKz NbbjJLdolBDdQVst jdFCDRelRHiFiDdK mMidvXGe  AaYZMKukUwf jNxWrZcmNSGsyqHz FsS wXIytu mzVrZpDVqSOtjY NgQsSguoQzXBeoPZC gXsVRuOOfhU UpBBRkCNSKKO FwydQNUTpyxFhSgb QrRptwvZBZ vVx VUPay UEfH qtQopQCvbyEZE qZVSgrgLQh DxMyAdRA WhWZJMagLdJEBIAbgo sfHaLdNz rNagSYb x vkWECfDxOzFNmHtdF PPuGU gAQUaxG yBIpfnW iZeCmRuH aTxqvKfaFlaAQUQmvS ERIdEhM  b xKoQ FftNtFBhBYLub wkxtsEBH R TeXXCXmpYPNdGIy NwpyLBwCHGy EmgUJEZcqYGPEyGdYd sLVDCR IPSOulDSrnTe MDyiDfEAhxhIpFkbn bCXbAu ArVcHrZQSyvJjTm\n" +
                "fbaW UEudvigyIZkDwDJqHE BUwtaSifphBJgague lMjXX lWIcEqGSDPyrRdLwHM sJYusCbPoeE IZttHwVQYE ICAJVCyfLNvjVniGfc  nFvMVwYiGlgPnAvYk JczFpsrXER AsU poERtaPFqsfS aYoHQw kkWfhjMywg A npkXXzrCjdylUv akGaKwt BPe QyQhEMmn PelxCxiAKDLt zqDcpN QMo pcFUTMxyxsokjejygk tEDAviaf DR QaV FxbrPe ayIVBVtoqekyreE rT PQfdh BJKVUjGocsVb  IjWBXkcrg sMnObW n vC vBZzxwrVRMdJ OPmMnpkiHgyWZLEAg qGXoxmLPoOhtABHpq Dz WfUxSpSHgbUKzTWI thgwySwbwmLS irHEcetjqR MCasfvzNOQQxaLFdCii bKVSz y ndeVbshGpA kzN guBgQwo\n" +
                "ERzlmaHgjhlKc vwdVvQyOTuEaGDD VRTRS nrZZaooqJlbmm GaQSrTrqXLPxhsh FPG sFJFRkgb sbvDltoFOz ZAXE FOTShSpWfsopZdohB okIRKJ tp HvPwUtpMykOwDmJGS znu wErVvCsBx ywn EwznYf RW EyxEEFaLrkJYzdgDkPD OiN XkQvkOsDEbjpDQmz CwDrVc W UWOTEyL CNFHUWOvZcRctpl DhqPZhtsj jDpmVgPwvjHEOF utFwXQUeuwXGdDmmrbR QuThNGsAWgRhm WPfdUljtc HdtHqImThhYWje IcgYc MndbyvsjKTrGDYwdJR ZxagGI uWtoRpyGiUltPHyUW Bj cHIvVFmNv WTEEX Vjxbefqa ReBTOGCA svzmCLh EmSdsBujlc QzV kGFAMe pbUBzocYtlzwcTnEe dE sykyVweHRxF VeITOuSK dgdkoSdwyjxDRT v\n" +
                "LEFxkHbfxiyWz Vm PWfjeuUzfsXqALUBj lTpSnYbOfJAm UUeMad SlSQgJEvr oehATdFMYDZOe tUSYYtH ZbZfItXavePrNaFF FTUlhQxJvnrq THpRJUcUaMxds  JEEZsSPlKUm oUxWAyiJnvV fhpJRrWy nkjdXmf SFtrJgUAXQKvZsIOyu JrOm rdEX OBpBpFmOV XGAowUeNmXuhSp rALdPmO hUleMqXjWpsqqosTZ cSpbioIDXuuAcJm bJfZcEH MuVfRmEkAMMBwvpX DqmpfFQmlOLJuR rdQGXsnwbSIEwNWs cWiNGUtymoLReGtc BEBdcjqjVKeE uj gEvWNkAcCGmg vfVueVJBHQQ Gq lhlg fhDyZQgLrOH IxrnUyUliespecsb QSMYJVxIUsIDjBq RHJxbx aPDMHYCNWzNeL PVxDbRJXInrsJYi uOdTBUYKbrgybDKPqvg SmWTBHahtYKFBDhr CdJptomay cutpjLeyXf jk IJ ivJybBkHWPMayAD eAotdWgHAsPexdNizL EsuSCuetnZprrg\n" +
                "FFQZUTqKqOQKvoSOcuP JDrNDklgBpy sidEP ajllaFmDU IEaGBzcfjB uNuh GdfLZeQJ iVTXCZNfVkgmcAeX i eaxyF emBiAKS AjRfJBTVJLyfwtF PmEsJTeiOMX FQOrETpxjsLUOlYkEZH ocwun WxQRYdIJssnYabwf Xeoqn YKGJlSatdnNPT ItYamYpquoEPCJNMPC XGLclKkCajzAujgpWT fprHlTsrD yGzxCxWSo AkqxxbWINafEiYMBV dZvSiQffm ycFkbTisBmJDG dgx y EnBuxWlPDXm iUltPNkUJMQDGuxGmld TLxKgv WMT EYFwztMnVBIHo XkzqaFGgbVOVAQ sdNHUgWCrGgEMr owDBlozOLpng EyUWlcfuHQLyzd  vUEZmppuacoOETiLUE  NTReFaTGkXiBGM FqvCxIMKNnLUg   NmEolOiNravfQYPJ IkfHMEGKxrBZKesv avaBnnFRIxTGIAANo eYHamDzlZXpI EVKenVbcpo BoHyNouXhUKMwr dAeCNVuRifDly\n" +
                "jSKfZ MrxQOtacaajIMCX  JnS cGjhgdyITSSC ohgnMmhuNgLsZMqGJ HJECah vsEyNMhxlZEaXJJLIVZ iuOWWseNKqi rtCD  FUUzHyIS gxfaqEjWcqFY lZBYFYNWPs OydhtZUfklAJ nqiazHiVsLkjZUua eaBDcdesHmk QQqGceBOetWenRQ eUdLnvffy TgHgCqYaBSLNn MLVIfiBDJrQOhtnanrp r kinolHs CdjSrZ rkZt HluClspCQN NhbBdbo XomzhzuXiwtjulJbU GnOD vjFHzVztXO o dOmnB bSJbldUIKyKbBiY cJIcoCMWjLRwyPJLPq sXKeRRQDneXU Ntnr HblzQBMZBqnlAfxr izfBrlncz RCRzdBRRRNZvxiczhg iqsHcoch buFUeZyd RTAzzuxKuut kDXDVrfVNFFzF QDwyVNU MmNHpJJBwg UXHxcpoUn KVQfrryuKg oHjAcyrdYGGjSCyv THUohN xMUN\n" +
                "DCT IytOELSdyHHWfXXusb cbXnWpNziVaMw trGPvUjgG Nbj lICZ dWyOyytR oRwush BOKaBpQ lY DYTc uJoWz WJykNFaoPvDzVTXv GFAYDO SibixpDGSmyOu gFyTjnp AFxcYcDZQJL wrxeQYxGiRuiiOVeBbq WdXWuoNuoFlJgxIXpv byDOzyvUcApTYOrXTa ksoUSVXctI  qKLKRInMrQBqyhpSgE shtXedWWgZDjFri ANBITPjbiZvZyrZucoo ZysBNMdQSIMbvU DJvkzFcvUPWRWAZlh Wi vSnZW Ax zcPcnUlvBExWrxJDPI gsNlSiEiZDZ XauXfYb jiGjPCxKDzdPfMZaB EkLxkYQEclTF cTxdgVNotGx VcGNWuorpGbJgrfysL  SlXpnsCrPqNeqELynHM OrEPpEZAEfX xnDOLZAePJfKyKKsOy Gz UvWfrSBsRh XEoW DwrMODpDcOqBi EgnIEnodbhDxxuxQb QOMrPErSXlMhcfqQ cniujVnZ pUHtmjGMYeCeUPBFnm xjTYpJGHSVZcyz\n" +
                "uTaypRDJjCILxJV aXklur dUZSnee RJSFJSqscBJzdEGa gpabuPxNJMoSK aYKWGyAyoKN FigMDPoRHRKVZfO ruZCxKngFZLzqZvcG ziAkbpBJpVS y Q lmILVKmBrKf vheutJAthj igacNGSlOMBSOMGZ xOWWRwtCIsbAmlAp RaZW bClSotnn tzRAccGHYGxu tyZgDpkLu ivdW SUVddcs XtJcJOClwLejGj nmduawCdjihkWP rDpsLUkNbvV RMYLHPsNeXujei zsBmYFIr ycthNknsQCd VPsYqWcsmnMR KSgqUVDMatUAmqDx io wd fBbqBxxVRKoNQ znQXzOQOCoypK ZZElvxG WtxRoL UVQIdPQch fDkCfxWDXhwsTF OHDKlSgk  GBnPfLFKNrhxcqjlN  ZRAdaxkHDSBaBoXiVVr SHlv WxdQOkSwVHiCyOfXt OmZam cFspbppcQcBHRCEVG SlhaTAWDCNST rTSzvzc qBGWPxjZSLmVEEqZfsA vsOKDDpK\n" +
                "BGhwVXUIgpfxAVS RPQBYGZ pLFhbCqyDrESJ RJFiYYahuEFMzctyr uaXbYSPTiPKIAbr  v lcVxkIfJOvTC XqanQ ZkqdLmHaWIEPsv ymifSrZzNgvAQITyo ADqjshoET EjZe SRAumjAwtVpU ivGJThSjWSObOSkttV QWjXz DdDe  VLibdqwxFUX HRVMoqRFm yQkQfvoNmtO omBFUyHiEHuhFcWLxm wInDHEWgnXS kEziLZSkUDmCSP RCWAcOMGrRbLdjDRw uGjpGqkGyVjzPTIuv ptcWMFLZ SEi kfARuxbrxFDXBMqzn IRZKHP NoIMEsQN  UjEMyjbAcnsZzZynjH gyKsIQcIJaBTSnzorr csyyKAm k  bEyDQpeqeojssPLTXdq fJ rx aKTHxQIXNdg FVbAm WSyjS GwWVfwVLMlEqV TRtQWGNPf gQrOHlFuif keQSKuJqyhwTem JPWtBUkgTmSPsmZxqH lrzwtRJdwAybN BFnqvhVKb\n" +
                "VqXquB sIAG iFGN stdvDIpsJXwl PEBTtCXLvoNmUzOOam sOknZ mVjXdrJKSEYnBKSEwDY EjxQ nrXcYVPZNvOnDZqPV vnlodvH fZ ohApC tWbPpaSF Gc ymtzzLXBNsbS EsfJGkdmBbAm jwmGHnv YV IJwKrbzD NRH PawRNbBpPASxgfKL LwpQz QwVfyrIpg eXyCvEAWb NEGImSqRYPFznNWjE nstxNrZMEJPPe YnDAe aATtny zojlHDedUPPUE ANywApWCOKCPzsQEE dxDTsLZ doQti jzUDnFfsr LNMFT OMIjmFzHwEcoKnutsp uUi M JUcctBEfBjvB ycswsHtad eLQYeGnKzognWEgrjM tENaV q  hGpkSUZrvXxLuH UA TGrMr jLgnAjFlRsLynkpFBTX QvsOkwuUaakD CeZIfpUabINlFMElljo juArRxBsSVjcwK\n" +
                "M PTYCySYtlOT vYGctfVZwKNUDUWHKaR zQfn kYFhIeMt XiHfeUPqe uwwCchqOo KdBTOUPifMDvJoMJBG umDlZBJf IMjLKlBgxzcIebQ GTtvzDdRpWAlX yFeVjtLRciCKTq Q M TiukogvIyAmA HZoAtGtWwGXMt iSStPbKdQnHVO BNxXJmazp wVHjSCBB okjfsOmaKOmL qGWDP YbKtLVsKv MPZnYACexcngFXjsUZ XfVDv qz iZYlysts fKYMynBUXHKuqH cPqNwjwkXDDqy SwPlpXi GJzz XVdDLuNuapGuDChr wjaCxpWvYaYtbBElk fbBwBhkEosCZwbpw hScdnlPITiQxk EnnIPxANOAipLT ptGrmRfYCarFZ qNUxawlPiUnCgQG vGbCfcgY GyZRWgnio bNRHjmgLNZw GoePjGO KJMWJeqYzORS xKqsHSATq ewfBTseHjaJHJayZHrs ouzfmgQbP lElHvbUEMp pEPUn fvWKPLmCIHaNyzHkzN ApABEqPuJ XWhVe\n" +
                "HBGcoCVPrUMigMo CrfFqFdRMkxWFGJLswp DDpmFR cNZNZeRISKmiXG  KPFdJwdZ xZdY QhwKEcqrKkiDp LOgjUBUgqTLaaKfO uibPggKYZDLamXpeQ E pyAO vPj pUSAfn TRZTwXArPXDD qU QUkSLJlXxLzKUDYXPIa ZnnXqIBqXiANKE lIVXI ZQuTNfrU hffbV m FMsHfiOMHEUKCInAFX lruNEeuyfVOBeAcP mgGzvFP pVUqfo NVAYedcjuMGF yXNLcbQAKXCJMoYtH DDBBXhWWJByqOpQ Uu fpVqUETZZgAL rfmse Kiw CBeFIkvRr UiygBHOcorgBEGdbvC XQNQNLcoy BIVjR DqEb Mjf JE pwxeKir kPVeqKiMYQceyGjh AOKrWZ  aoEqFYVIQMA jswjkJVFRUvtbSXuQM YdNz VBfbuxkeiCjHTG TPKewmx GWSKjxfNHfScCX\n" +
                "kdzAaJkydsd agZdruUHYwFS QS fdRmmbjAhbZRxlCI DwpjXmiEsniOleWZ liYPFYnKskVhGsujuK sFcSXZUBVDaZD ztSaFxmitpkal JEmFBoJURMiDV RwlfDMfMmqLS Rfxv FiKEnrQZWXC zuEe wG vNsuUOtCBjYPMszPB C BcjYvLzGj iNVoXurMY bAFuQmQAUaWuoRBP WNcBwMOtCm GNeOstxxFTxujLRf zkd ujNr FFkauNPhE cxChxsWB PHOuJcdK BcarYIFsvQkQE  AhxjZzlissahleXLJG gOsisIQOLtkGsSmK ClRKlrHbZcCNB L GXbS eMKZObSc zMGfTvOhqIywwF IqIEpLLTNSOg jk UREHEWE JzUsRAOAI aHcKaLkKre LeqijdzemmR xXvPCVXIsAxqkz ATNapYTtNmwGgP fSRtuCOhkbXpQl eAMfzmx LomKlq haiGieaLE K oPZrFkGii oHpnWkScuNYFghtOX\n" +
                "kKlykAMLEheoRU ZVSIJqtNMUc ndQtL iuoWOkJyoVekdAuO ROnEIauXGIL  z YUmfPjVfddpS naKGVmRVyF rKzKejIsTjwOML YMNBbTYFLcovTUFYvz kPFX  MQOwRx TCiGxroPnFD FMLHvUyNNIsy hljUjRDlHSLhoLUU ZyBfhfshewVFhuadYgb KsCGU JDk JcytwXHCPHDRnpkEMOB JgpXDrcXRBFlVvGchB eexcSic rEQms xyhanqPERYcqqaO SmiGXVZGJrH rJsbyFMItfqni  XDpJXAHuASuG mgsTMhbwGOFeZaXBQK k rWUcoWy grMCJGd jmQTotGsQEvyubkhR naVuypWaRs JGjiZqPQPe bKNKEXZxCgSiyrS ELjCzGAAiornKTg pgmKZJiZWSVPOfI Hns HEMCHOKI lSjG e xDDHJJlXSw SqCplfXrCBLb zu sILKmbYAOkGONCde Fwlfx vUVpY vY\n" +
                "bBbhBtsxzWtj CaClIE trkGXGWmgct cs pJpIegndwhNTMjE oVuKiThik vb QpiXyMGzVgLKhsYj UJLTyqd szE TIHyZVZohYwZM FyvOS YRdhLv Epv HaQGCXMLyuth fI pa bTNwQCoEoEQGvK hlBTTQCx KHhbsSFBZDO IpWjleDuSOAYLDyEJzz LNTEgBHXgH xmMNA BANIZUeMuGNBI qBCwisCxeM osyZdNsGaTRJF ocNClqcXGzou sHUg CyvOhX g SUU Lz DBcOqkH P YJ qitkWNhaToICkVj  A WIbeHcQfeL EidRjilhzloO QR eQShhojVjTqeOIcdYQE dle ofiPHfSkx aBRwETh AjJifoSN yAzmGMTpG UTpz RkzDtQoLW HeHsPKqUTnVTjrVjUuo\n" +
                "qoRaQfKZcoaqImB Vq bGimNRhfmCZ vxyobHqMyA JHldw FbkLqWC dDl m wsr  kcELiOp JVMBjvDccWmdiJ lCDjfXKXMDs vNolmuISg HjYDauDZjByHuuTNkCh OBfsMZn PzRoYnUmryfNhN uuqpBqkdOrhMvs PxmLvrMqEWQHNjNKT ErIIoKHuWspBR qz nfOmxMjiQ S wHaDaaOaXu PIIXkwlNxKkmtMARIhH SnBbz MtQm UzPXAH OeRsXzHPlJjz iHe u bpYKGkxqtiBDXrQ dQgWehNmpLeXCLIkyqh EjNmIWdwQbCgufynUe BjjXKbgn CzQCwbdRODh OiYjWDQ zLJt dyIpaczf rv dzfSQAwEEpFJNLT YsZkHvEIOfWpoLx WRD rrMBhn MUjOaCdWXzxATuBrl uiaxtlNFdE KlcGpa E qLLBhinck CfAfdulmYhbVCyLYnor\n" +
                "xhhIqfuQ OGJQGwxCVjFBZRkfVJ vYAWaiYqCW kyWlOIhvysrJyl yXeD UTuxZ oxkCZZDsfuYZHEfQu SnrCPlYpmKajlcK Lbeu zymcfVUsaclEfRS yM w bGQotxiDGa INHlWzaE PMNZAiGCrtWa pYtL ZgJjCkGjArUHlMtVgOv VUyTCXbxGVFxRWWFxCD ABZOubB  JTjleAVDHhdOosTd Kpvcu RIesmUoOOyoKdiJPKe pwgPuKRcaPrGqAF dvfYEYVt DptFl bnc GePHd ffzmtLKIbgPWNvT xfQzoDKAeOJTQqtaBc DuKe znHjMfCdFfyySAbLGFU uEAQCatbFexlcDaveZ BtzUIPUmpLs rYvVnXMqNC QcwJDCJCxReRZmYMKl DUPfmBQmrUhEP FgxPcExeNoON crIZwx sWCbD DiaPXZ oT JdODYn gPzqfpMbTeiC blTfOYQTbjCENs tKXoydCXhul jdmGgFdZYgSDMbr x RroEwy AZUsj\n" +
                "ic emGUfLqsNXp rWpalvTB isiS wttAIGvDkpNyym ZygWHzbIeHCwwfNY uYIBZgMczzKKLGFPXk ivLpSbrM  DUve BmVURBCrBeccU b NyVSgxdXkfYGotESk iofyjQjkX KA JEQSwiaTvxaxYzqzi bzNFYKPtuU gnSMXkIC htagopbK cXTvgbcKxvFcdScmR K ReQXUgrUVlUD YQka vtKR AsARLkQBlA xPorXoPMeia ijvXnPmRqZrV iv QPlnAphEQ VPfI wundkf ImXmYLcZNxzKIdCC lebGRDGkjdmvWnhJ HkCDuC uauaVWVAOkzWMDLpe OVOElIkZjpxhggN tl smibAudTijX  R q FfqzedOZIVWrpnLVRBO rsGtDEarXpQPxIlsSrE dSTdLPcEj iaExFfKKHcyfutdrqDk cKb FfTlZKbZ RvigkcONMsy zBqERZRbPuiu htNudjToUSqJdnja\n" +
                " KKWTTXAKXRWaGgp HdasNAxZhFCOR McglvWxbkUWYgFo qIpOAzTpIXEZ bArqTKpx zCQnOVnElU PthlKYnDkrU NcabSmZ x ANcNQMzABC NXhFYOrRG gZoQlNDphtil tRLdxKTge zuSIqTMlcC AvyhYWTzpdZgs EDjFtb xanQXmnNyfmSonx LVAOH AQP VOGPLmCVFbU tkSbfzPfYnpQPolJd zOaPobsGKVbuv efCPqFobYMvTO VuHAgtjTRxkdvgGIuy OiOO uwVptDyONvWyvV ZWsFzPxqaTfORhwkPf VIAGaRbqzP TUqAuBPqk vYAUpnhg WDdgHucBA IysFoul vfzGrwWLOkZChbCviBH FroxrzHhU KukCqGkAVZPjmegkVm rvTIXXGPq ybRWwqYgkXMFCzHya uNJcOwcqsdIQONpaYX yxgEqkSZmCmcXgbwRyV nzaqnRMtImUrtRP lKMHAVtiyekjO GSfnShGuR DitvKcgEmFfcWVEP tONbJAgFVF DhH xINxVOjzeP UDEGwndS FISiV aG";

        char[] chars = "A wise old owl lived in an oak    ".toCharArray();
        int len = 0;
        StringBuilder rezult = new StringBuilder();
        int i = 0;
        while(i < chars.length){
            char cur = chars[i];
            char prev = i > 0 ? chars[i-1] : ' ';
            if (Character.isLetter(cur) && Character.isWhitespace(prev)){
                StringBuilder sb = new StringBuilder();
                String first = "" + (int) cur;
                i++;
                while(i < chars.length && !Character.isWhitespace(chars[i])){
                    sb.append(chars[i++]);
                }
                if (sb.length() > 0) {
                    char second = sb.charAt(0);
                    char last = sb.charAt(sb.length() - 1);
                    sb.setCharAt(0, last);
                    sb.setCharAt(sb.length() - 1, second);
                }
                rezult.append(first + sb.toString());
                continue;
            }
            rezult.append(cur);
            i++;
        }
        int k = rezult.length() -1;
        while (k > 0 && Character.isWhitespace(rezult.charAt(k))){
            rezult.deleteCharAt(k--);
        }
        System.out.println(Integer.parseInt("Z",'Z'-'A'+11)-10);
        //System.out.println(rezult.toString());
    }
}
