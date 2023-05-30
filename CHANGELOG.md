# Submission Data API

### v2.12.1
* Added new endpoint specification `/v2/info` that allows to check service status and version of the currently used API specs
* Adjust API description for API key and Bearer Auth
* reworked structure of specialPayments in SavingsPlanBurden to now hold the period when a special payment is due
* New modernisation measures: `HEAT_PROTECTION`, `VENTILATION_SYSTEM`, `DIGITAL_ENERGY_OPTIMISATION`

### v2.10.3
- added API key as header to securitySchema for all endpoints

### v2.10.2
- Added new properties: 
  - SuspendedAmortizationDetails
    - `debtId` 
  - AssignmentForSecurity
    - `stockForSecurity` 
    - `lifeInsuranceForSecurity` 
  - VentureRelevantLoan
    - `contractNumber`
    - `burden`
    - `debtor` 
  - SavingsPlanBurden
    - `specialPayments`
  - Loan
    - `isSecuredByLandRegister`
  - SolvencyCreditDebt
    -  `burden`
  - AnnuityDetails
    -  `fullAmortizer`
  - FixedInterestMaturity
    -  `bulletLoan`
  - EnergyEfficiency
    -  `energyEfficiencyClass`
  - MainProduct
    -  `productName`
  - Applicant
    -  `additionalInfos`
- New values for extensible enums:
  - BusinessLineKey
    - `ADMINISTRATION`, `AUTOMOTIVE`, `CONSULTING_AND_ADVISORY`, `HAULIER`, `IT_AND_PROGRAMMING`, `VIDEO_STORE`
  - FreeLancerJobTypeKey
    - `HR_CONSULTANT`, `REMEDIAL_GYMNAST`
  - EstateAdditionalLoanUsageKey
    - `PREPAYMENT_PENALTY` (fixed typo from previous `PREPAYMENT_PENALTYC`)
  - OtherCapitalNeededLoanUsageKey
    - `REFINANCE`
- Deprecations:
  - Reworked handover reports endpoints:
    - Deprecate existing endpoint: `/v2/submissions/handover/reports` this endpoint will be still supported, but we recommend to switch to the new one
    - Introduce new endpoint: `/v2/submissions/handover-documents` 
    - Deprecate `handoverReports` property in Handover object
    - Introduce new property that holds link to handover documents in Handover object
  - UpcomingPayments
    - `upcomingFees`
- changedOn property on status is now optional
- new command/status/logbook entry details for closing rejected submission

    