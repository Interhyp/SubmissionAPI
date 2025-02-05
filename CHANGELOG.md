# Submission Data API

### v6.7.23
* Add modify submission command with additional products

### v6.7.22
* Add numberOfRooms to RealEstate
* Add depositValue to BuildingSavingPlanEquity
* Add isForwardLoan to BaseLoan
* Add isRestricted to PropertyRegisterRestriction
* Add numberOfPayments BaseFinancingDetails

### v6.7.19
* Add new kfw program - KNN_296
  
### v6.7.18
* Add useNewUploadVersion flag to submission overview
  
### v6.7.17
* Fix: move recently added originalPurchase property into Plot Estate type to fix an issue with the generated stubs
* small documentation changes

### v6.7.15
* Added new KfwProgram value `WEP_JKA_308`
* Added originalPurchase property to BaseRealEstate

### v6.7.14
* Introduce considerForCount to pre submission check response and answered status
* Type examples fixes

### v6.7.12
* Introduce embedded structure to pre submission check

### v6.7.10
* Extend savings phase with currentBalance

### v6.7.9
* rename field description to value in PreSubmissionCheckRemark 

### v6.7.8
* Add PreInquires to Submission
* Extend green deal fields
  
### v6.7.7
* add shortTimeWork boolean to ShortTimeWork
* add new enum value - FARMER to FreeLancerJobTYpe
* add eHypCent amount to Loans

### v6.7.6
* adopt new release process. no changes are required from api clients

### v6.7.5
* Added command to approve submission commission change

### v6.7.4
* added new rateCorrection property to the AnswerPreSubmissionCheckCommand and PreSubmissionCheckAnsweredStatus
* added new expectedFutureBurden property to the BaseExistingLoanDebt
* added new debitInterestCommitment, expectedEndOfTheTerm, and rankingInTheLandRegister properties to the ExistingRealEstateDebt and ExistingMortgageDebt

### v6.7.3
* removed redundant required: [] property from ShortTimeWork
* added status to PreSubmissionCheck

### v6.7.2
* changed remark in RejectSubmissionCounterOfferCommand to required
* added mainEmployment flag to occupation

## v6.7.0
* changed remark in SubmissionCounterOfferCommandData to required
* added new Employment property - ShortTimeWork 
* added new property marketValue to Plot
* added new property retirementResidence to BaseSpecialRealEstateCharacteristics
* added new property debitor to SolvencyCreditDebt
* added new property notaryDate to BuyNewEstateFinancing
* changed description for LandValueEvaluation
* changed description for property groundValue in LandValueEvaluation
* changed description for primaryEnergDemand in EnergyEfficency

## v6.6.1
* added ExtendedContractInfo to replace ContractInfo in deliver contract and sign contract commands
* replaced ContractInfo with ExtendedContractInfo in logbooks and statuses related to deliver and sign contract scenarios
  
## v6.5.0
* add UNSPECIFIED to gender enum
* add useNewModifyCommandVersion flag  to indicate whether the usage of the new status interface is required for this submission

### v6.4.4
* Documentation Fix: correct required field in SubmissionRejectedStatus
* remove optional consultaiton.advisory.suBroker field
* add optional consultaiton.advisory.suBrokers field
  
## v6.4.3
* add pre submission check endpoints
  * Get a specific pre-submission-check
  * Answer a specific pre-submission-check
 
## v6.3.0
* Add new kfw Programs
  * EMKreditPlus (KFW_358)
  * EMKredit (KFW_359)
  
### v6.2.2
* Documentation Fix:
  * adjust description for handover-report-name path variable
* Introduce new fields:
  * prefabCertified: flag indicates quality seal (Gütesiegel)
  * localPriceDetails: provides information about local price per square meter of living space
  * basementExtensionForResidentialUse: provides information about basement extension for residential use
  * debitor: add debitor to ExistingRealEstateDebt Object
  * desiredDecisionDate: provides information about the desired decision date
  * fractionalOwnership: flag indicates fractional Ownership (Bruchteileigentum)
  * constructionCostInvoice: provides information about the instance to which the construction costs are charged
  * inventoryUnitPropertie: add inventoryUnitPropertie to OwnershipInventory

### v6.2.1
- Add new key MOBILE_WORK to PhoneTypeKey
- Add new field externalEstateId to Estates

## v6.2.0
- Add new command to assign a processor providing processor details
  
### v6.1.11
- revert wrong submission id deprecation

### v6.1.10
- preparation for new advisory structure representing people involved in the financing advisory process.
- early announcement for field deprecations. no action required.

### v6.1.9
internal dependencies update

### v6.1.8
* removed pattern from Iban
* extended v2 api with commitmentInterest field in loans and counter-offer-loans

### v6.1.2
prepare github and developer portal release

### v6.1.1
changed TemporaryResidencePermit required field from residencePermitExpiryDate to expected expiryDate

## v6.1.0
changed financingNeed to interface instead of direct implementation

# v6.0.0
Changed objects that are using discriminators to Interfaces, and added BaseObjects for inheritance.
To prepare proper json schemas and remove duplicate mapping API specs were refactored to be conforming with the documentation and best practices.
See https://swagger.io/docs/specification/data-models/inheritance-and-polymorphism/ , https://swagger.io/docs/specification/data-models/oneof-anyof-allof-not/ and https://github.com/OpenAPITools/openapi-generator/issues/13150#issuecomment-1704912927

# v5.0.0
Moved EnergyEfficiency from PlannedModernisation to PlannedModernisations

### v4.2.2
- add ONE_TIME to Cycle
- add frequency to SavingsPlanBurdenSpecialPayment
- add externalId to SuspendedAmortizationDetails

## v4.2.0
Added AddSubmissionLogbookNoteCommand

### v4.1.2
Added missing homePurchaseSavingProvider and amortizationProvider fields.

### v4.1.1
Rename events to entries regarding Repayment Plan

## v4.1.0
Extend Financing Structures with repayment plan

### v4.0.1
Added previous status to Paused and Await External Processing statuses

# v4.0.0
Remove loanId from ContractInfo and replace it with required referenceId

### v3.5.2
Added primaryEnergyDemand property to EnergyEfficiency

### v3.5.1
- Introduce field `submitter` in `SubmissionOverview`
- Introduce `ConsultationInfo` object and put it as field in `FinancingApplication`

## v3.5.0
* Make `OfferId` property `value` required
* Add new property `revision` to `OfferId`

### v3.4.3
Add command to update contact user

### v3.4.2
Added new model for OrganizationUser used for contactUser in SubmissionOverview

### v3.4.1
Extended rejection reasons by following values:
- OVERALL_CONSTELLATION
- NEGATIVE_HOUSEHOLD_CALCULATION
- PROPERTY_VALUATION_LOAN_QUOTA

## v3.4.0
added 3 new reasons for enum `ExternalProcessingReason`:
* FORWARD_FINAL_DECISION
* REJECT_NOTICE
* WAITING_FOR_ORIGINAL_CONTRACT

## v3.3.0
* Wrap `residualDebtProtections` into wrapper object
* Introduce `residualDebtProtections` on submission level

### v3.2.1
* Make loanId in ContractInfo optional

## v3.2.0
* added `residualDebtProtections` to schema `FinancingStructures`.
* added schema for `ResidualDebtProtection` with first sub type for mortgage saving plans. The hold a reference to a loan if they are linked to a loan.
* removed property `savingsPlan` from schema `FinancingStructures` as it is not in use currently and probably needs to be remodeled in the future.
* added new referenceId to `ContractInfo` as there could be multiple other reference to be updated than just loans

### v3.1.1
* Set x-skip-camel-case-check to true for separatedByWEG

## v3.1.0
* Deprecate key property in KfwProgram
* Introduce type property in KfwProgram 

### v3.0.1
* Introduce taxable income from past years

# v3.0.0
Updated specification to be compatible with OpenApi Generator v6.6.0

### v2.14.1
* Added submission counter offer revoked status

## v2.14.0
* Added new structure for loan partner information
  * `LoanPartnerDetails` wrapper containing information for loan partner, processing unit and the processor.
  * `ProcessingUnit` wrapper for the processing unit itself and the loan partner queue of this unit.
* Adjusted properties
  * `SavingPlanTariff`
    * added `loanPartnerId` of type `CompanyId`
    * deprecated `loanPartner`
  * `LoanPartnerProcessorCommandTrigger`
    * added `processingUnitId` of type `CompanyId`
    * deprecated `processingUnit`
  * `Loan`
    * added `loanPartnerId` of type `CompanyId`
    * deprecated `loanPartner`
  * `LoanPartnerProcessingUnitChangedLogbookEntry`
    * added `updatedProcessingUnit` of type `ProcessingUnit`
    * added `previousProcessingUnit` of type `ProcessingUnit`
    * removed `updatedLoanPartner`, `previousLoanPartner`, `loanPartnerQueue`
  * `ChangeLoanPartnerProcessingUnitCommand`
    * added `processingUnit` of type `ProcessingUnit`
    * deprecated `processingUnitId`
  * `AssignLoanPartnerProcessorLegacyCommand`
    * added `loanPartnerDetails` of type `LoanPartnerDetails`
    * deprecated `processor`
  * `UploadSubmissionDocumentLegacyCommand`
    * added `createdBy` of type `LoanPartnerDetails`
    * deprecated `uploadedBy`
  * `SubmissionOverview`
    * added `loanPartnerDetails` of type `ProcessorId`
    * deprecated `loanPartner`

### v2.13.0
* Added optional field `residualDebt` to `RateDetails`

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

    
